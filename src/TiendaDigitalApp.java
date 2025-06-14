import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TiendaDigitalApp {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        String archivo = "productos.csv";
        Map<String, List<Producto>> mapaProducto = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                Producto producto = null;
                String tipoProducto = partes[0];
                String[] parteEtiquetas = partes[partes.length - 1].split("=");
                String[] etiquetas = parteEtiquetas[parteEtiquetas.length - 1].split(",");

                switch (tipoProducto) {
                    case "Libro":
                        Libro libro = new Libro();
                        libro.setAutor(partes[4]);
                        libro.setNumPaginas(Integer.parseInt(partes[5]));
                        crearProducto(libro, partes[1], partes[2], Double.parseDouble(partes[3]));

                        for(int i = 0; i < etiquetas.length; i++){
                            libro.aniadirEtiqueta(etiquetas[i]);
                        }
                        
                        producto = libro;
                        break;

                    case "Revista":
                        Revista revista = new Revista();
                        revista.setNumero(Integer.parseInt(partes[4]));
                        revista.setMes(partes[5]);
                        crearProducto(revista, partes[1], partes[2], Double.parseDouble(partes[3]));

                        for(int i = 0; i < etiquetas.length; i++){
                            revista.aniadirEtiqueta(etiquetas[i]);
                        }
                        producto = revista;
                        break;

                    case "Ebook":
                        Ebook ebook = new Ebook();
                        ebook.setTamanioMB(Double.parseDouble(partes[4]));
                        crearProducto(ebook, partes[1], partes[2], Double.parseDouble(partes[3]));

                        for(int i = 0; i < etiquetas.length; i++){
                            ebook.aniadirEtiqueta(etiquetas[i]);
                        }
                        
                        producto = ebook;
                        break;

                }

                if (!mapaProducto.containsKey(tipoProducto)) {
                    mapaProducto.put(tipoProducto, new ArrayList<>());
                }
                mapaProducto.get(tipoProducto).add(producto);
            }

        }

        for (String tipoProducto : mapaProducto.keySet()) {
            List<Producto> lista = mapaProducto.get(tipoProducto);
            System.out.println("Tipo: " + tipoProducto);
            System.out.println("Total: " + lista.size());

            double precioMedio = 0;
            double sumaPrecios = 0;
            for (Producto precioProducto : lista) {
                sumaPrecios += precioProducto.calcularPrecioFinal();
                precioMedio = sumaPrecios / lista.size();
            }

            System.out.println("El precio medio es de: " + precioMedio);

            Producto masCaro = lista.get(0);
            Producto masBarato = lista.get(0);
            for (Producto precioProducto : lista) {

                if (precioProducto.calcularPrecioFinal() > masCaro.calcularPrecioFinal()) {
                    masCaro = precioProducto;
                }

                if (precioProducto.calcularPrecioFinal() < masBarato.calcularPrecioFinal()) {
                    masBarato = precioProducto;
                }

            }

            System.out.println("Producto mas caro: " + masCaro.toString());
            System.out.println("Producto mas barato: " + masBarato.toString());
        }

    }

    private static void crearProducto(Producto producto, String codigo, String titulo, double precioBase) {
        producto.setCodigo(codigo);
        producto.setTitulo(titulo);
        producto.setPrecioBase(precioBase);
    }
}

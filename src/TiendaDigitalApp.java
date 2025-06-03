import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TiendaDigitalApp {
    
    public static void main(String[] args) throws FileNotFoundException, IOException{
    
    String archivo = "productos.csv";
    Map<String, List<Producto>> mapaProducto = new HashMap<>();

    try (BufferedReader br = new BufferedReader(new FileReader(archivo))){
        String linea;
        while((linea = br.readLine()) != null){
            String[] partes = linea.split(";");
            Producto producto = null;
            String tipoProducto = partes[0];


            producto.setCodigo(partes[1]);
            producto.setTitulo(partes[2]);
            producto.setPrecioBase(Double.parseDouble(partes[3]));

               switch (tipoProducto) {
                case "Libro":
                    Libro libro = new Libro();
                    libro.setAutor(partes[4]);
                    libro.setNumPaginas(Integer.parseInt(partes[5]));
                    producto = libro;
                    break;

                case "Revista":
                    Revista revista = new Revista();
                    revista.setNumero(Integer.parseInt(partes[4]));
                    revista.setMes(partes[5]);
                    producto = revista;
                    break;

                case "Ebook":
                    Ebook ebook = new Ebook();
                    ebook.setTamanioMB(Double.parseDouble(partes[4]));
                    producto = ebook;
                    break;

                }
                mapaProducto.computeIfAbsent(tipoProducto, k -> new ArrayList<>()).add(producto);
        }
        

    }

    for(String tipoProducto : mapaProducto.keySet()){
        List<Producto> lista = mapaProducto.get(tipoProducto);
        System.out.println("Tipo: " + tipoProducto);
        System.out.println("Total: " + lista.size());

        lista.stream().max(Comparator.comparingDouble(Producto::calcularPrecioFinal));
        lista.stream().min(Comparator.comparingDouble(Producto::calcularPrecioFinal));
    }
    }
}




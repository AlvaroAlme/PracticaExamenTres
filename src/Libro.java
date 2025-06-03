import java.util.ArrayList;

public class Libro extends Producto {

    private String autor;
    private int numPaginas;

    public Libro(){
        super();
    }
    
    public Libro(String autor, int numPaginas){
        super();
        this.autor = autor;
        this.numPaginas = numPaginas;
    }

    

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    @Override
    public double calcularPrecioFinal() {
        double precioFinal = getPrecioBase();

        if( numPaginas > 600 && tieneEtiqueta("premium") ){
            precioFinal = getPrecioBase() * 0.10;
        }
        return precioFinal;
    }

    
}

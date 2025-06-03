import java.util.List;

public abstract class Producto {

    private String codigo;
    private String titulo;
    private double precioBase;
    private List<String> etiquetas;

    public Producto(){
        super();
    }

    public Producto(String codigo, String titulo, double precioBase){
        this.codigo =  codigo;
        this.titulo = titulo;
        this.precioBase = precioBase;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public abstract double calcularPrecioFinal();
    
    public boolean tieneEtiqueta(String etiqueta){
        return etiquetas.contains(etiqueta);
    }

    
}

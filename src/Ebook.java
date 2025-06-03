public class Ebook extends Producto implements Descargable {
    
    private double tamanioMB;

    public Ebook(){
        super();
    }

    public Ebook(double tamanioMB){
        super();
        this.tamanioMB = tamanioMB;
    }

    public double getTamanioMB() {
        return tamanioMB;
    }

    public void setTamanioMB(double tamanioMB) {
        this.tamanioMB = tamanioMB;
    }

    public double calcularPrecioFinal(){

        double precioFinal = getPrecioBase();

        if(tieneEtiqueta("nuevo")){
            precioFinal = precioFinal - (getPrecioBase() * 0.10);
        } else {
            precioFinal = precioFinal - (getPrecioBase() * 0.25);
        }

        return precioFinal;
    }

    @Override
    public void descargar() {
        System.out.println("Descargando eBook: " + getTitulo() + " (" + tamanioMB + "MB)");
    }

}

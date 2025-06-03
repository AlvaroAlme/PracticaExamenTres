public class Revista extends Producto {

    private int numero;
    private String mes;

    public Revista(){
        super();
    }
    
    public Revista (int numero, String mes){
        super();
        this.numero = numero;
        this.mes = mes;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public double calcularPrecioFinal(){
        double precioFinal = getPrecioBase();
        if(tieneEtiqueta("oferta")){
            precioFinal = getPrecioBase() - (getPrecioBase() * 0.85);
        }
        return precioFinal;
    }

    @Override
    public String toString() {
        return "Revista [numero=" + numero + ", mes=" + mes + ", toString()=" + super.toString() + "]";
    }
    
}

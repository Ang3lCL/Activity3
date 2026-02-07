package actividad_3;

public class Producto {


    private String nombre;
    private double costo;
    private double impuesto; 

    public Producto(String nombre, double costo, double impuesto) {
        this.nombre = nombre;
        this.costo = costo;
        this.impuesto = impuesto;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public double calcularPrecio(double utilidad) {
        double subtotal = costo + utilidad;
        double montoImpuesto = subtotal * (impuesto / 100);
        return subtotal + montoImpuesto;
    }
}

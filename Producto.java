package actividad_3;

public class Producto {

    private String nombr;
    private String descripcion;   // NUEVO
    private double costo;
    private double impuesto; // porcentaje

    public Producto(String nombre, String descripcion, double costo, double impuesto) {
        this.nombr = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.impuesto = impuesto;
    }

    public String getNombre() {
        return nombr;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public double calcularPrecio(double utilidad) {
        double subtotal = costo + utilidad;
        double montoImpuesto = subtotal * (impuesto / 100.0);
        return subtotal + montoImpuesto;
    }
}

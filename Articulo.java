package actividad_3;

public class Articulo {
    private String codigo;
    private String descripcion;
    private double precio;
    private int existencia;


    public Articulo(String codigo, String descripcion, double precio, int existencia) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.existencia = existencia;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }


    public void mostrar() {
        System.out.println("Código: " + codigo +
                ", Descripción: " + descripcion +
                ", Precio: " + precio +
                ", Existencia: " + existencia);
    }


    public boolean actualizarExistencia(int cantidad) {
        if (existencia + cantidad < 0) {
            System.out.println("No hay suficiente existencia para realizar la operación.");
            return false;
        }
        existencia += cantidad;
        return true;
    }
}



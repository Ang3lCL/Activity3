package actividad_3;

public class Libro {
    
    private String titulo;
    private String autor;
    private String genero;
    private int año;
    private int totalCopias;
    private int copiasPrestadas;

    public Libro(String titulo, String autor, String genero, int año, int totalCopias) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.año = año;
        this.totalCopias = totalCopias;
        this.copiasPrestadas = 0;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getCopiasDisponibles() {
        return totalCopias - copiasPrestadas;
    }

    public boolean prestar() {
        if (getCopiasDisponibles() > 0) {
            copiasPrestadas++;
            return true;
        }
        return false;
    }

    public boolean devolver() {
        if (copiasPrestadas > 0) {
            copiasPrestadas--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Título: " + titulo +
                "\nAutor: " + autor +
                "\nGénero: " + genero +
                "\nAño: " + año +
                "\nCopias totales: " + totalCopias +
                "\nPrestadas: " + copiasPrestadas +
                "\nDisponibles: " + getCopiasDisponibles();
    }
}


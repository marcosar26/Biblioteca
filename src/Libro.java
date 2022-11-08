import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Libro {
    private final String titulo;
    private final String autor;
    private final int numPaginas;
    private Estado estado;
    private String fechaPrestamo;

    public Libro(String titulo, String autor, int numPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
        this.estado = Estado.NO_PRESTADO;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(System.lineSeparator());

        sb.append("-----LIBRO-----").append(System.lineSeparator());
        sb.append("Título: ").append(this.getTitulo()).append(System.lineSeparator());
        sb.append("Autor: ").append(this.getAutor()).append(System.lineSeparator());
        sb.append("Número de páginas: ").append(this.getNumPaginas()).append(System.lineSeparator());

        String estado = this.estaPrestado() ? "Prestado" : "No prestado";
        sb.append("Estado: ").append(estado).append(System.lineSeparator());

        if (this.estaPrestado()) {
            sb.append("Fecha de préstamo: ").append(this.getFechaPrestamo()).append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String obtenerFechaPrestamo() {
        LocalDate hoy = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");

        return hoy.format(formatter);
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public boolean estaPrestado() {
        return this.estado.equals(Estado.PRESTADO);
    }

    public void prestar() {
        this.estado = Estado.PRESTADO;
        this.setFechaPrestamo(this.obtenerFechaPrestamo());
    }

    public void devolver() {
        this.estado = Estado.NO_PRESTADO;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    enum Estado {PRESTADO, NO_PRESTADO}
}

import java.util.ArrayList;
import java.util.List;

public class Libreria {
    private final String nombre;
    private final ArrayList<Libro> libros = new ArrayList<>();

    public Libreria(String nombre) {
        this.nombre = nombre;
    }

    public void prestarLibro(String titulo) {
        Libro libro = null;

        for (Libro libro1 : this.libros) {
            if (titulo.equalsIgnoreCase(libro1.getTitulo())) {
                libro = libro1;
            }
        }

        if (libro == null) {
            System.out.println("No hay ningún libro con ese título");
            return;
        }

        System.out.println(libro);

        if (libro.estaPrestado()) {
            System.out.println("El libro ya está prestado.");
        } else {
            libro.prestar();
            System.out.println("Se ha prestado el libro");
        }
    }

    public String obtenerLibrosPrestados() {
        StringBuilder sb = new StringBuilder();

        this.libros.forEach(libro -> {
            if (libro.getEstado().equals(Libro.Estado.PRESTADO)) {
                sb.append(libro).append(System.lineSeparator());
            }
        });

        return sb.toString();
    }

    public void eliminarLibro(String autor) {
        List<Libro> librosEliminar = new ArrayList<>();

        this.libros.forEach(libro -> {
            if (autor.equalsIgnoreCase(libro.getAutor())) {
                librosEliminar.add(libro);
            }
        });

        librosEliminar.forEach(this.libros::remove);

        librosEliminar.clear();
    }

    public void comprobarLibrosAutor(String autor) {
        int librosEncontrados = 0;

        for (Libro libro : this.libros) {
            if (autor.equalsIgnoreCase(libro.getAutor())) librosEncontrados++;
        }

        if (librosEncontrados == 0) {
            System.out.println("No se ha encontrado ningún libro de dicho autor o no existe.");
            return;
        }

        System.out.println("Se han encontrado " + librosEncontrados + " libros de dicho autor.");
    }

    public void devolverLibro(String titulo) {
        Libro libro = null;

        for (Libro lib : this.libros) {
            if (titulo.equalsIgnoreCase(lib.getTitulo())) {
                libro = lib;
                break;
            }
        }

        if (libro == null) {
            System.out.println("No se ha encontrado ningún libro.");
            return;
        }

        libro.devolver();
        System.out.println("Se ha devuelto este libro:" + libro);
    }

    public void addLibro(Libro libro) {
        libros.add(libro);
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumLibros() {
        return libros.size();
    }

    public void verTodosLosLibros() {
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }
}

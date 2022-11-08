public class Main {
    public static void main(String[] args) {
        Libreria libreria = new Libreria("Librería de Marcos");

        Libro libro1 = new Libro("Comecocos", "Pepito", 100);
        Libro libro2 = new Libro("Héroes", "Manolito", 204);
        Libro libro3 = new Libro("Mein Kampf", "Hitler", 720);
        Libro libro4 = new Libro("La vida de Francisco", "Santiago", 241);
        Libro libro5 = new Libro("El Chepas", "Santiago", 28);
        Libro libro6 = new Libro("Manifiesto Feminista", "Irene", 9999);

        libreria.addLibro(libro1);
        libreria.addLibro(libro2);
        libreria.addLibro(libro3);
        libreria.addLibro(libro4);
        libreria.addLibro(libro5);
        libreria.addLibro(libro6);

        System.out.println(libreria.getNombre());
        System.out.println(libreria.getNumLibros());
        libreria.devolverLibro("Héroes");
        libreria.comprobarLibrosAutor("Santiago");

        libreria.eliminarLibro("Santiago");
        System.out.println(libreria.obtenerLibrosPrestados());

        libreria.prestarLibro("Mein Kampf");
        System.out.println();
        libreria.prestarLibro("dfswdgfvswd");
        System.out.println();
        libreria.prestarLibro("Mein Kampf");
    }
}

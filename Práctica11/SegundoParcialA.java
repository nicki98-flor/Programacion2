class Anuncio {
    int numero;
    double precio;

    public Anuncio(int numero, double precio) {
        this.numero = numero;
        this.precio = precio;
    }
}

class Artista {
    String nombre;
    String ci;
    int añosExperiencia;

    public Artista(String nombre, String ci, int añosExperiencia) {
        this.nombre = nombre;
        this.ci = ci;
        this.añosExperiencia = añosExperiencia;
    }
}

class Obra {
    String titulo;
    String material;
    Artista a1, a2;
    Anuncio anuncio;

    public Obra(String titulo, String material, Artista a1, Artista a2, Anuncio anuncio) {
        this.titulo = titulo;
        this.material = material;
        this.a1 = a1;
        this.a2 = a2;
        this.anuncio = anuncio;
    }

    public void agregarAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }

    public double obtenerPrecio() {
        return anuncio != null ? anuncio.precio : 0;
    }

    public Artista artistaMasExperto() {
        return (a1.añosExperiencia > a2.añosExperiencia) ? a1 : a2;
    }
}

class Pintura extends Obra {
    String genero;

    public Pintura(String titulo, String material, Artista a1, Artista a2, Anuncio anuncio, String genero) {
        super(titulo, material, a1, a2, anuncio);
        this.genero = genero;
    }
}

public class Principal {
    public static void main(String[] args) {
        Artista art1 = new Artista("Ana", "123", 5);
        Artista art2 = new Artista("Luis", "456", 10);
        Artista art3 = new Artista("Carla", "789", 7);
        Artista art4 = new Artista("Mario", "012", 12);

        Anuncio anuncio1 = new Anuncio(1, 1000);

        Pintura pintura1 = new Pintura("Pintura 1", "Oleo", art1, art2, anuncio1, "Abstracto");
        Pintura pintura2 = new Pintura("Pintura 2", "Acrilico", art3, art4, null, "Realismo");
        Artista experto1 = pintura1.artistaMasExperto();
        Artista experto2 = pintura2.artistaMasExperto();

        Artista masExperto = (experto1.añosExperiencia > experto2.añosExperiencia) ? experto1 : experto2;
        System.out.println("Artista con más experiencia: " + masExperto.nombre);

        Anuncio anuncio2 = new Anuncio(2, 800);
        pintura2.agregarAnuncio(anuncio2);

        double total = pintura1.obtenerPrecio() + pintura2.obtenerPrecio();
        System.out.println("Total venta: $" + total);
    }
}
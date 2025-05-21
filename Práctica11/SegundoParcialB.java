class Anuncio {
    int numero;
    double precio;

    public Anuncio(int numero, double precio) {
        this.numero = numero;
        this.precio = precio;
    }

    public void incrementarPrecio(double x) {
        this.precio += x;
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

    public boolean contieneArtistaConNombre(String nombre) {
        return a1.nombre.equals(nombre) || a2.nombre.equals(nombre);
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
        Artista art1 = new Artista("Sofia", "111", 6);
        Artista art2 = new Artista("Luis", "222", 9);
        Artista art3 = new Artista("Carlos", "333", 10);
        Artista art4 = new Artista("Sofia", "444", 8);

        Anuncio anuncio1 = new Anuncio(1, 1200);
        Anuncio anuncio2 = new Anuncio(2, 1500);

        Pintura pintura1 = new Pintura("Paisaje", "Óleo", art1, art2, anuncio1, "Realismo");
        Pintura pintura2 = new Pintura("Retrato", "Acrílico", art3, art4, anuncio2, "Retrato");

        int totalExperiencia = art1.añosExperiencia + art2.añosExperiencia + art3.añosExperiencia + art4.añosExperiencia;
        double promedio = totalExperiencia / 4.0;
        System.out.println("Promedio de años de experiencia: " + promedio);

        double incremento = 300;
        if (pintura1.contieneArtistaConNombre("Sofia")) {
            pintura1.anuncio.incrementarPrecio(incremento);
        }
        if (pintura2.contieneArtistaConNombre("Sofia")) {
            pintura2.anuncio.incrementarPrecio(incremento);
        }

        System.out.println("Nuevo precio Pintura 1: $" + pintura1.anuncio.precio);
        System.out.println("Nuevo precio Pintura 2: $" + pintura2.anuncio.precio);
    }
}
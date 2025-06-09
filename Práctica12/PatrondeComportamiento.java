import java.util.*;

interface Observador {
    void actualizar(String mensaje);
}

class ObservadorA implements Observador {
    private String nombre;

    public ObservadorA(String nombre) {
        this.nombre = nombre;
    }

    public void actualizar(String mensaje) {
        System.out.println(nombre + " recibió: " + mensaje);
    }
}

class Sujeto {
    private List<Observador> observadores = new ArrayList<>();

    public void agregar(Observador o) {
        observadores.add(o);
    }

    public void notificar(String mensaje) {
        for (Observador o : observadores) {
            o.actualizar(mensaje);
        }
    }
}

class Main {
    public static void main(String[] args) {
        Sujeto s = new Sujeto();
        s.agregar(new ObservadorA("Cliente 1"));
        s.agregar(new ObservadorA("Cliente 2"));
        s.notificar("Nuevo producto disponible");
    }
}

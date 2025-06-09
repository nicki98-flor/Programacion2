public class Singleton {
    private static Singleton instancia;
private Singleton() {}

    public static Singleton getInstancia() {
        if (instancia == null)
            instancia = new Singleton();
        return instancia;
    }
    public void mostrarMensaje() {
        System.out.println("Soy una única instancia");
    }
}
class Main {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstancia();
        Singleton s2 = Singleton.getInstancia();
        s1.mostrarMensaje();
        System.out.println(s1 == s2);
}
}
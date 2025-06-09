class AntiguoSistema {
    public void ejecutar() {
        System.out.println("Ejecutando sistema antiguo");
    }
}
interface NuevoSistema {
    void metodoAdaptado();
}
class Adaptador implements NuevoSistema {
    private AntiguoSistema adaptee;

    public Adaptador(AntiguoSistema adaptee) {
        this.adaptee = adaptee;
    }

    public void metodoAdaptado() {
        adaptee.ejecutar();
    }
}
class Main {
    public static void main(String[] args) {
        NuevoSistema sistema = new Adaptador(new AntiguoSistema());
        sistema.metodoAdaptado();
    }
}
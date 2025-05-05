import java.util.*;
public class Ministerio {
    Public String nombre, direccion;
    Public ArrayList<String> empleados = new ArrayList<>();
    Public ArrayList<Integer> edades = new ArrayList<>();
    Public ArrayList<Double> sueldos = new ArrayList<>();
    public Ministerio(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }
    public void agregarEmpleado(String nombre, int edad, double sueldo) {
        empleados.add(nombre);
        edades.add(edad);
        sueldos.add(sueldo);
    }
    public void eliminarPorEdad(int edadX) {
        for (int i = edades.size() - 1; i >= 0; i--) {
            if (edades.get(i) == edadX) {
                empleados.remove(i);
                edades.remove(i);
                sueldos.remove(i);
            }
        }
    }
    public void mostrarMenorEdad() {
        if (!edades.isEmpty()) {
            int menor = Collections.min(edades);
            for (int i = 0; i < edades.size(); i++) {
                if (edades.get(i) == menor) {
                    System.out.println(empleados.get(i) + " con edad " + menor);
                }
            }
        }
    }
    public void mostrarMenorSueldo() {
        if (!sueldos.isEmpty()) {
            double menor = Collections.min(sueldos);
            for (int i = 0; i < sueldos.size(); i++) {
                if (sueldos.get(i) == menor) {
                    System.out.println(empleados.get(i) + " con sueldo " + menor);
                }
            }
        }
    }
    public void transferirEmpleado(Ministerio otro, String nombreEmpleado) {
        int i = otro.empleados.indexOf(nombreEmpleado);
        if (i != -1) {
            this.agregarEmpleado(otro.empleados.get(i), otro.edades.get(i), otro.sueldos.get(i));
            otro.empleados.remove(i);
            otro.edades.remove(i);
            otro.sueldos.remove(i);
        }
    }
    public static void main(String[] args) {
        Ministerio m1 = new Ministerio("Rojo", "Estación Central");
        Ministerio m2 = new Ministerio("Azul", "Estación Cementerio");
        m1.agregarEmpleado("Pedro", 35, 2500);
        m1.agregarEmpleado("Lucy", 43, 3250);
        m2.agregarEmpleado("Ana", 26, 2700);
        m2.agregarEmpleado("Saul", 29, 2500);
        m1.eliminarPorEdad(43);
        m1.transferirEmpleado(m2, "Ana");
        m1.mostrarMenorEdad();
        m1.mostrarMenorSueldo();
    }
}
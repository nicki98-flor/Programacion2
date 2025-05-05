import java.util.*;
public class LineaTeleferico {
    Public String color, tramo;
    Public int nroCabinas;
    Public int nroEmpleados;
    Public  ArrayList<String[]> empleados; // Lista de [nombre, ap_paterno, ap_materno]
    Public ArrayList<Integer> edades;
    Public ArrayList<Double> sueldos;
    public LineaTeleferico(String color, String tramo, int nroCabinas) {
        this.color = color;
        this.tramo = tramo;
        this.nroCabinas = nroCabinas;
        this.nroEmpleados = 0;
        this.empleados = new ArrayList<>();
        this.edades = new ArrayList<>();
        this.sueldos = new ArrayList<>();
    }
    public LineaTeleferico() {
        this("", "", 0);
    }
    public void agregarEmpleado(String nombre, String apPaterno, String apMaterno, int edad, double sueldo) {
        empleados.add(new String[]{nombre, apPaterno, apMaterno});
        edades.add(edad);
        sueldos.add(sueldo);
        nroEmpleados++;
    }
    public void eliminarEmpleadoPorApellido(String apellido) {
        for (int i = empleados.size() - 1; i >= 0; i--) {
            String[] emp = empleados.get(i);
            if (emp[1].equals(apellido) || emp[2].equals(apellido)) {
                empleados.remove(i);
                edades.remove(i);
                sueldos.remove(i);
                nroEmpleados--;
            }
        }
    }
    public void transferirEmpleado(int indice, LineaTeleferico otro) {
        if (indice >= 0 && indice < empleados.size()) {
            String[] emp = empleados.get(indice);
            otro.agregarEmpleado(emp[0], emp[1], emp[2], edades.get(indice), sueldos.get(indice));
            empleados.remove(indice);
            edades.remove(indice);
            sueldos.remove(indice);
            nroEmpleados--;
        }
    }
    public void mostrarEmpleadoMayorEdad() {
        if (edades.isEmpty()) {
            System.out.println("No hay empleados.");
            return;
        }
        int maxEdad = Collections.max(edades);
        int idx = edades.indexOf(maxEdad);
        String[] emp = empleados.get(idx);
        System.out.println("Empleado con mayor edad: " + String.join(" ", emp) + " - Edad: " + maxEdad);
    }
    public void mostrarEmpleadoMayorSueldo() {
        if (sueldos.isEmpty()) {
            System.out.println("No hay empleados.");
            return;
        }
        double maxSueldo = Collections.max(sueldos);
        int idx = sueldos.indexOf(maxSueldo);
        String[] emp = empleados.get(idx);
        System.out.println("Empleado con mayor sueldo: " + String.join(" ", emp) + " - Sueldo: Bs " + maxSueldo);
    }
    public static void main(String[] args) {
        LineaTeleferico t1 = new LineaTeleferico("Rojo", "Estación Central - Cementerio - 16 de Julio", 20);
        LineaTeleferico t2 = new LineaTeleferico();
        t1.agregarEmpleado("Pedro", "Rojas", "Luna", 35, 2500);
        t1.agregarEmpleado("Lucy", "Sosa", "Rios", 43, 3250);
        t1.agregarEmpleado("Ana", "Perez", "Rojas", 26, 2700);
        t1.agregarEmpleado("Saul", "Arce", "Calle", 29, 2500);
        t1.eliminarEmpleadoPorApellido("Rojas");
        t1.transferirEmpleado(0, t2);
        t1.mostrarEmpleadoMayorEdad();
        t1.mostrarEmpleadoMayorSueldo();
    }
}
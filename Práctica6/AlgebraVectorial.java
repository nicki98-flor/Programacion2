package algebravectorial;


public class AlgebraVectorial { 
    public double x, y, z;

public AlgebraVectorial(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
}

public static boolean esPerpendicularA(AlgebraVectorial a, AlgebraVectorial b) {
    return a.suma(b).magnitud() == a.resta(b).magnitud();
}

public static boolean esMutuamentePerpendicular(AlgebraVectorial a, AlgebraVectorial b) {
    return a.resta(b).magnitud() == b.resta(a).magnitud();
}

public static boolean esOrtogonal(AlgebraVectorial a, AlgebraVectorial b) {
    return a.productoPunto(b) == 0;
}

public static boolean verificaTeoremaPitagoras(AlgebraVectorial a, AlgebraVectorial b) {
    return a.suma(b).magnitudCuadrado() == (a.magnitudCuadrado() + b.magnitudCuadrado());
}

public static boolean esParalelo(AlgebraVectorial a, AlgebraVectorial b) {
    return a.productoCruz(b).magnitud() == 0;
}

public static boolean esParaleloProductoCruz(AlgebraVectorial a, AlgebraVectorial b) {
    return a.productoCruz(b).esCero();
}

public static AlgebraVectorial proyeccion(AlgebraVectorial a, AlgebraVectorial b) {
    double escalar = a.productoPunto(b) / b.productoPunto(b);
    return new AlgebraVectorial(escalar * b.x, escalar * b.y, escalar * b.z);
}

public static double componente(AlgebraVectorial a, AlgebraVectorial b) {
    return a.productoPunto(b) / Math.sqrt(b.productoPunto(b));
}

public AlgebraVectorial suma(AlgebraVectorial b) {
    return new AlgebraVectorial(this.x + b.x, this.y + b.y, this.z + b.z);
}

public AlgebraVectorial resta(AlgebraVectorial b) {
    return new AlgebraVectorial(this.x - b.x, this.y - b.y, this.z - b.z);
}

public double productoEscalar(AlgebraVectorial b) {
        return this.x * b.x + this.y * b.y + this.z * b.z;
}

public double productoPunto(AlgebraVectorial b) {
    return this.x * b.x + this.y * b.y + this.z * b.z;
}

public AlgebraVectorial productoCruz(AlgebraVectorial b) {
    return new AlgebraVectorial(
        this.y * b.z - this.z * b.y,
        this.z * b.x - this.x * b.z,
        this.x * b.y - this.y * b.x
    );
}

public double magnitud() {
    return Math.sqrt(x * x + y * y + z * z);
}

public double magnitudCuadrado() {
    return x * x + y * y + z * z;
}

public boolean esCero() {
    return x == 0 && y == 0 && z == 0;
}

@Override
public String toString() {
    return "(" + x + ", " + y + ", " + z + ")";
}

public static void main(String[] args) {
    AlgebraVectorial a = new AlgebraVectorial(2, 5, 0);
    AlgebraVectorial b = new AlgebraVectorial(4,10,0);

    System.out.println("Producto escalar :"+  a.productoEscalar(b));
    System.out.println("Producto cruzado :"+  a.productoCruz(b));
    System.out.println("Proyección de a sobre b: " + proyeccion(a, b));
}
}
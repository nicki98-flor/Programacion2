package vectortridimensional;

public class VectorTridimensional { 
     public double x, y, z;

    public VectorTridimensional(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public VectorTridimensional suma(VectorTridimensional b) {
        return new VectorTridimensional(this.x + b.x, this.y + b.y, this.z + b.z);
    }

    public VectorTridimensional multiplicacionEscalar(double r) {
        return new VectorTridimensional(r * this.x, r * this.y, r * this.z);
    }

    public double longitud() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public VectorTridimensional normal() {
        double mag = longitud();
        if (mag == 0) throw new IllegalArgumentException("El vector es nulo.");
        return new VectorTridimensional(x / mag, y / mag, z / mag);
    }

    public double productoEscalar(VectorTridimensional b) {
        return this.x * b.x + this.y * b.y + this.z * b.z;
    }

    public VectorTridimensional productoVectorial(VectorTridimensional b) {
        return new VectorTridimensional(
            this.y * b.z - this.z * b.y,
            this.z * b.x - this.x * b.z,
            this.x * b.y - this.y * b.x
        );
    }

    public static VectorTridimensional proyeccion(VectorTridimensional a, VectorTridimensional b) {
        double magnitudB = b.longitud();
        if (magnitudB == 0) {
            throw new IllegalArgumentException("El vector b no puede ser nulo.");
        }
        double escalar = a.productoEscalar(b) / (magnitudB * magnitudB);
        return null;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    public static void main(String[] args) {
        VectorTridimensional a = new VectorTridimensional(1, 2, 3);
        VectorTridimensional b = new VectorTridimensional(-2, 1, 0);
        double scalar = 2.0;

        System.out.println("Producto escalar: " + a.productoEscalar(b));
        System.out.println("Producto vectorial: " + a.productoVectorial(b));
        System.out.println("Proyección: " + proyeccion(a, b));
    } 
}
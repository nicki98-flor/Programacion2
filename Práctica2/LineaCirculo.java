package punto;

public class Punto {
    public float x;
    public float y;
    
    public Punto(float x, float y)
    {
        this.x = x;
        this.y = y;
    }
    
    public float[] coord_cartesianas()
    {
        return new float[] {this.x, this.y};
    }
    
    public float[] coord_polares()
    {
        float radio = (float)Math.sqrt(this.x * this.x + this.y * this.y);
        float angulo = (float)Math.sqrt(this.x/this.y);
        angulo = (float)Math.toDegrees(angulo);
        return new float[] {radio, angulo};
    }
    
    @Override
    public String toString()
    {
        return String.format("(%.2f, %.2f)", this.x, this.y);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Punto p1 = new Punto(0, 3);
        System.out.println("-------------Punto p1----------------");
        float a[] = p1.coord_cartesianas();
        System.out.println(a[0]+" "+a[1]);
        float b[] = p1.coord_polares();
        System.out.println(b[0]+" "+b[1]);
        
        Punto p2 = new Punto(0, 3);
        System.out.println("-------------Punto p2----------------");
        float c[] = p2.coord_cartesianas();
        System.out.println(c[0]+" "+c[1]);
        float d[] = p2.coord_polares();
        System.out.println(d[0]+" "+d[1]);
        
        Linea l1 = new Linea(p2, p1);
        System.out.println("---------------------Linea------------------");
        l1.dibujaLinea();
        
        Circulo c1 = new Circulo(p2, 4);
        System.out.println("---------------------Circulo----------------");
        c1.dibujaCirculo();
    }   
}

class Linea {
    private Punto p1;
    private Punto p2;

    public Linea(Punto p1, Punto p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public String toString() {
        return "Línea de " + p1 + " a " + p2;
    }

    public void dibujaLinea() {
        System.out.println("Dibujando linea desde " + p1 + " hasta " + p2);
    }
}

class Circulo{
    public Punto centro;
    public float radio;
    
    public Circulo(Punto c, float r)
    {
        this.centro = c;
        this.radio = r;
    }
    
    @Override
    public String toString()
    {
        return "Circulo con centro en "+centro+" y radio "+radio;
    }
    
    public void dibujaCirculo()
    {
        System.out.println("Dibujando un circulo con centro en "+centro+" y radio "+radio);
    } 
}
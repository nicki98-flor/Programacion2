package figurageométrica;

public class FiguraGeométrica {

    double area (double radio){
        return Math.PI * radio * radio;
    } 
    
    double area (double base, double altura)
    {
        return base * altura;
    }
    
    double area(double base, double altura, double triangulo)
    {
        return (base * altura) / 2;
    }

    double area(double base1, double base2, double altura, boolean trapecio)  
    {
        return ((base1 + base2) * altura) / 2;
    }

    double area(double perimetro, double apotema, boolean hexagono)
    {
        return (perimetro * apotema) / 2;
    }

    
    public static void main(String[] args) {
        // TODO code application logic here
        FiguraGeométrica f1 = new FiguraGeométrica();
        FiguraGeométrica f2 = new FiguraGeométrica();
        
        FiguraGeométrica f3 = new FiguraGeométrica();
        FiguraGeométrica f4 = new FiguraGeométrica();
        FiguraGeométrica f5 = new FiguraGeométrica();
        
        System.out.println("Circulo: "+f1.area(1));
        System.out.println("Rectangulo: "+f2.area(2,3));
        
        System.out.println("---------------------TAREA----------------");
        System.out.println("Triangulo Rectangulo: "+f3.area(3,5));
        System.out.println("Trapecio: "+f4.area(4,6,7));
        System.out.println("Hexagono: "+f5.area(3,5));
        
    }
}
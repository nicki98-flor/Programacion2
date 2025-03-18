import math

class FiguraGeometrica:
    def area(self, *args):
        if len(args) == 1:
            radio = args[0]
            return math.pi * radio ** 2  # Círculo
        elif len(args) == 2:
            base, altura = args
            return base * altura  # Rectángulo o paralelogramo
        elif len(args) == 3:
            base, altura, _ = args
            return (base * altura) / 2  # Triángulo
        elif len(args) == 4:
            base1, base2, altura, _ = args
            return ((base1 + base2) * altura) / 2  # Trapecio
        elif len(args) == 3 and isinstance(args[2], bool):
            perimetro, apotema, _ = args
            return (perimetro * apotema) / 2  # Hexágono
        else:
            raise ValueError("Número de argumentos no válido")

# Creación de instancias y pruebas
f = FiguraGeometrica()

print("Círculo:", f.area(1))
print("Rectángulo:", f.area(2, 3))
print("---------------------TAREA----------------")
print("Triángulo Rectángulo:", f.area(3, 5, 0))
print("Trapecio:", f.area(4, 6, 7, True))
print("Hexágono:", f.area(3, 5, True))

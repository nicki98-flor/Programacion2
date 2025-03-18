import math
class Punto:
    def __init__(self, x, y):
        self.x = x
        self.y = y
    def coord_cartesianas(self):
        return self.x, self.y
    def coord_polares(self):
        radio = math.sqrt(self.x * self.x + self.y * self.y)
        angulo = math.atan(self.y / self.y)
        angulo = math.degrees(angulo)
        return radio, angulo
    def __str__(self):
        return "({:.2f},{:.2f})".format(self.x, self.y)

class Linea:
    def __init__(self, p1, p2):
        self.p1 = p1
        self.p2 = p2

    def __str__(self):
        return f"Línea de {self.p1} a {self.p2}"

    def dibujaLinea(self):
        print(f"Dibujando línea desde {self.p1} hasta {self.p2}")

# Definición de la clase Circulo
class Circulo:
    def __init__(self, centro, radio):
        self.centro = centro
        self.radio = radio

    def __str__(self):
        return f"Círculo con centro en {self.centro} y radio {self.radio}"

    def dibujaCirculo(self):
        print(f"Dibujando un círculo con centro en {self.centro} y radio {self.radio}")
p1 = Punto(0,3)
print(p1)
x,y = p1.coord_cartesianas()
print(x,y)
r,a = p1.coord_polares()
print(r,a) 

p2 = Punto(4, 0)

l1 = Linea(p1, p2)
print(l1)
l1.dibujaLinea()

c1 = Circulo(p1, 5)
print(c1)
c1.dibujaCirculo()
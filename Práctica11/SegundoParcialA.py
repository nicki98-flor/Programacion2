class Anuncio:
    def __init__(self, numero, precio):
        self.numero = numero
        self.precio = precio

class Artista:
    def __init__(self, nombre, ci, años_experiencia):
        self.nombre = nombre
        self.ci = ci
        self.años_experiencia = años_experiencia

class Obra:
    def __init__(self, titulo, material, a1, a2, anuncio=None):
        self.titulo = titulo
        self.material = material
        self.a1 = a1
        self.a2 = a2
        self.anuncio = anuncio

    def agregar_anuncio(self, anuncio):
        self.anuncio = anuncio

    def obtener_precio(self):
        return self.anuncio.precio if self.anuncio else 0

    def artista_mas_experto(self):
        return self.a1 if self.a1.años_experiencia > self.a2.años_experiencia else self.a2

class Pintura(Obra):
    def __init__(self, titulo, material, a1, a2, anuncio, genero):
        super().__init__(titulo, material, a1, a2, anuncio)
        self.genero = genero

# Crear artistas
art1 = Artista("Ana", "123", 5)
art2 = Artista("Luis", "456", 10)
art3 = Artista("Carla", "789", 7)
art4 = Artista("Mario", "012", 12)

anuncio1 = Anuncio(1, 1000)

pintura1 = Pintura("Pintura 1", "Oleo", art1, art2, anuncio1, "Abstracto")
pintura2 = Pintura("Pintura 2", "Acrílico", art3, art4, None, "Realismo")

experto1 = pintura1.artista_mas_experto()
experto2 = pintura2.artista_mas_experto()
mas_experto = experto1 if experto1.años_experiencia > experto2.años_experiencia else experto2

print("Artista con más experiencia:", mas_experto.nombre)

anuncio2 = Anuncio(2, 800)
pintura2.agregar_anuncio(anuncio2)

total = pintura1.obtener_precio() + pintura2.obtener_precio()
print("Total de venta de ambas pinturas: $", total)
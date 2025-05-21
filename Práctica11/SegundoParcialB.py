class Anuncio:
    def __init__(self, numero, precio):
        self.numero = numero
        self.precio = precio

    def incrementar_precio(self, x):
        self.precio += x

class Artista:
    def __init__(self, nombre, ci, años_experiencia):
        self.nombre = nombre
        self.ci = ci
        self.años_experiencia = años_experiencia

class Obra:
    def __init__(self, titulo, material, a1, a2, anuncio):
        self.titulo = titulo
        self.material = material
        self.a1 = a1
        self.a2 = a2
        self.anuncio = anuncio

    def contiene_artista(self, nombre):
        return self.a1.nombre == nombre or self.a2.nombre == nombre

class Pintura(Obra):
    def __init__(self, titulo, material, a1, a2, anuncio, genero):
        super().__init__(titulo, material, a1, a2, anuncio)
        self.genero = genero

# Crear artistas
art1 = Artista("Sofia", "111", 6)
art2 = Artista("Luis", "222", 9)
art3 = Artista("Carlos", "333", 10)
art4 = Artista("Sofia", "444", 8)

# Crear anuncios
anuncio1 = Anuncio(1, 1200)
anuncio2 = Anuncio(2, 1500)

# a. Crear pinturas con anuncios
pintura1 = Pintura("Paisaje", "Óleo", art1, art2, anuncio1, "Realismo")
pintura2 = Pintura("Retrato", "Acrílico", art3, art4, anuncio2, "Retrato")

# b. Calcular promedio de experiencia
total_exp = art1.años_experiencia + art2.años_experiencia + art3.años_experiencia + art4.años_experiencia
promedio = total_exp / 4
print("Promedio de años de experiencia:", promedio)

# c. Incrementar precio de anuncio si artista se llama "Sofia"
incremento = 300
if pintura1.contiene_artista("Sofia"):
    pintura1.anuncio.incrementar_precio(incremento)
if pintura2.contiene_artista("Sofia"):
    pintura2.anuncio.incrementar_precio(incremento)

print("Nuevo precio pintura 1:", pintura1.anuncio.precio)
print("Nuevo precio pintura 2:", pintura2.anuncio.precio)
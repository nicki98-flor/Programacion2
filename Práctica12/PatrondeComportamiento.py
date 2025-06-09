class Observador:
    def actualizar(self, mensaje):
        pass

class ObservadorA(Observador):
    def __init__(self, nombre):
        self.nombre = nombre

    def actualizar(self, mensaje):
        print(f"{self.nombre} recibió: {mensaje}")

class Sujeto:
    def __init__(self):
        self.observadores = []

    def agregar(self, observador):
        self.observadores.append(observador)

    def notificar(self, mensaje):
        for observador in self.observadores:
            observador.actualizar(mensaje)

if __name__ == "__main__":
    sujeto = Sujeto()
    sujeto.agregar(ObservadorA("Cliente 1"))
    sujeto.agregar(ObservadorA("Cliente 2"))
    sujeto.notificar("Nuevo producto disponible")
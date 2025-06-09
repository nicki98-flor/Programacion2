class AntiguoSistema:
    def ejecutar(self):
        print("Ejecutando sistema antiguo")

class NuevoSistema:
    def metodo_adaptado(self):
        pass

class Adaptador(NuevoSistema):
    def __init__(self, adaptee):
        self.adaptee = adaptee
    def metodo_adaptado(self):
        self.adaptee.ejecutar()

if __name__ == "__main__":
    sistema = Adaptador(AntiguoSistema())
sistema.metodo_adaptado()
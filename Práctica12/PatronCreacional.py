class Singleton:
    _instancia = None
    def __new__(cls):
        if cls._instancia is None:
            cls._instancia = super(Singleton, cls).__new__(cls)
        return cls._instancia
    def mostrar_mensaje(self):
        print("Soy una única instancia")
if __name__ == "__main__":
    s1 = Singleton()
    s2 = Singleton()
    s1.mostrar_mensaje()
print(s1 is s2)
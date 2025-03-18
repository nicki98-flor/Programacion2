class Cola:
    def __init__(self, n):
        self.n = n
        self.arreglo = [0] * n
        self.inicio = 0
        self.fin = 0

    def insert(self, e):
        if not self.isFull():
            self.arreglo[self.fin] = e
            self.fin += 1
        else:
            print("Cola llena")

    def remove(self):
        if not self.isEmpty():
            valor = self.arreglo[self.inicio]
            self.inicio += 1
            return valor
        else:
            print("Cola vacía")
            return None

    def peek(self):
        if not self.isEmpty():
            return self.arreglo[self.inicio]
        else:
            print("Cola vacía")
            return None

    def isEmpty(self):
        return self.inicio == self.fin

    def isFull(self):
        return self.fin == self.n

    def size(self):
        return self.fin - self.inicio
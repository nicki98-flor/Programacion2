class Pila:
    def __init__(self, n):
        self.n = n
        self.arreglo = [0] * n
        self.top = -1

    def push(self, e):
        if not self.isFull():
            self.top += 1
            self.arreglo[self.top] = e
        else:
            print("Pila llena")

    def pop(self):
        if not self.isEmpty():
            valor = self.arreglo[self.top]
            self.top -= 1
            return valor
        else:
            print("Pila vacía")
            return None

    def peek(self):
        if not self.isEmpty():
            return self.arreglo[self.top]
        else:
            print("Pila vacía")
            return None

    def isEmpty(self):
        return self.top == -1

    def isFull(self):
        return self.top == self.n - 1
class Ministerio:
    def __init__(self, nombre, direccion):
        self.nombre = nombre
        self.direccion = direccion
        self.empleados = []
        self.edades = []
        self.sueldos = []
    def agregarEmpleado(self, nombre, edad, sueldo):
        self.empleados.append(nombre)
        self.edades.append(edad)
        self.sueldos.append(sueldo)
    def eliminarPorEdad(self, edadX):
        for i in reversed(range(len(self.edades))):
            if self.edades[i] == edadX:
                del self.empleados[i]
                del self.edades[i]
                del self.sueldos[i]
    def mostrarMenorEdad(self):
        if self.edades:
            min_edad = min(self.edades)
            for i in range(len(self.edades)):
                if self.edades[i] == min_edad:
                    print(f"{self.empleados[i]} con edad {min_edad}")
    def mostrarMenorSueldo(self):
        if self.sueldos:
            min_sueldo = min(self.sueldos)
            for i in range(len(self.sueldos)):
                if self.sueldos[i] == min_sueldo:
                    print(f"{self.empleados[i]} con sueldo {min_sueldo}")
    def transferirEmpleado(self, otro, nombreEmpleado):
        if nombreEmpleado in otro.empleados:
            i = otro.empleados.index(nombreEmpleado)
            self.agregarEmpleado(otro.empleados[i], otro.edades[i], otro.sueldos[i])
            del otro.empleados[i]
            del otro.edades[i]
            del otro.sueldos[i]
m1 = Ministerio("Rojo", "Estación Central")
m2 = Ministerio("Azul", "Estación Cementerio")
m1.agregarEmpleado("Pedro", 35, 2500)
m1.agregarEmpleado("Lucy", 43, 3250)
m2.agregarEmpleado("Ana", 26, 2700)
m2.agregarEmpleado("Saul", 29, 2500)
m1.eliminarPorEdad(43)
m1.transferirEmpleado(m2, "Ana")
m1.mostrarMenorEdad()
m1.mostrarMenorSueldo()
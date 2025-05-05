class LineaTeleferico:
    def __init__(self, color="", tramo="", nroCabinas=0):
        self.color = color
        self.tramo = tramo
        self.nroCabinas = nroCabinas
        self.nroEmpleados = 0
        self.empleados = []       # Lista de listas [[nombre, ap_paterno, ap_materno], ...]
        self.edades = []          # Lista de edades
        self.sueldos = []         # Lista de sueldos
    def agregar_empleado(self, nombre, ap_paterno, ap_materno, edad, sueldo):
        self.empleados.append([nombre, ap_paterno, ap_materno])
        self.edades.append(edad)
        self.sueldos.append(sueldo)
        self.nroEmpleados += 1
    def eliminar_empleado_por_apellido(self, apellido):
        i = 0
        while i < len(self.empleados):
            if apellido in self.empleados[i]:
                del self.empleados[i]
                del self.edades[i]
                del self.sueldos[i]
                self.nroEmpleados -= 1
            else:
                i += 1
    def transferir_empleado(self, indice, otro_objeto):
        if 0 <= indice < self.nroEmpleados:
            otro_objeto.agregar_empleado(*self.empleados[indice], self.edades[indice], self.sueldos[indice])
            del self.empleados[indice]
            del self.edades[indice]
            del self.sueldos[indice]
            self.nroEmpleados -= 1
    def mostrar_empleado_mayor_edad(self):
        if not self.edades:
            print("No hay empleados.")
            return
        idx = self.edades.index(max(self.edades))
        print("Empleado con mayor edad:", self.empleados[idx], "- Edad:", self.edades[idx])
    def mostrar_empleado_mayor_sueldo(self):
        if not self.sueldos:
            print("No hay empleados.")
            return
        idx = self.sueldos.index(max(self.sueldos))
        print("Empleado con mayor sueldo:", self.empleados[idx], "- Sueldo:", self.sueldos[idx])
# ===============================
t1 = LineaTeleferico("Rojo", "Estación Central - Cementerio - 16 de Julio", 20)
t2 = LineaTeleferico()
# Agregar empleados al primer teleférico
t1.agregar_empleado("Pedro", "Rojas", "Luna", 35, 2500)
t1.agregar_empleado("Lucy", "Sosa", "Rios", 43, 3250)
t1.agregar_empleado("Ana", "Perez", "Rojas", 26, 2700)
t1.agregar_empleado("Saul", "Arce", "Calle", 29, 2500)
t1.eliminar_empleado_por_apellido("Rojas")
t1.transferir_empleado(0, t2)
t1.mostrar_empleado_mayor_edad()
t1.mostrar_empleado_mayor_sueldo()
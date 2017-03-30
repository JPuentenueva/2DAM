# -*- coding: utf-8 -*-

class Vehiculo():

    def __init__(self, color, matricula):
        self.__color = color
        self.__matricula = matricula

    def __str__(self):
        return "Vehiculo [Color: %s, Matricula: %s]" % (self.__matricula, self.__matricula)

    def getColor(self):
        return self.__color

    def getMatricula(self):
        return self.__matricula

    def setColor(self, color):
        self.__color = color

    def setMatricula(self, matricula):
        self.__matricula = matricula

class Coche(Vehiculo):

    def __init__(self, color, matricula, numero_puertas):
        super(Coche, self).__init__(color, matricula)
        self.__numero_puertas = numero_puertas

    def __str__(self):
        return "Coche [Color: %s, Matricula: %s, Numero puertas: %s]" % (self.getColor(), self.getMatricula(), str(self.__numero_puertas))

class Moto(Vehiculo):

    def __init__(self, color, matricula, numero_ruedas):
        super(Coche, self).__init__(color, matricula)
        self.__numero_ruedas = numero_ruedas

    def __str__(self):
        return "Moto [Color: %s, Matricula: %s, Numero ruedas: %s]" % (self.getColor(), self.getMatricula(), str(self.__numero_ruedas))


v = Vehiculo("rojo","1234 ZZZ")
print v
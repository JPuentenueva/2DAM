# -*- coding: utf-8 -*-

class Calculadora(object):
    def __init__(self, operando1, operando2):
        self.__op1 = operando1 # los guiones bajos hacen que el atributo sea "privado"
        self.__op2 = operando2

    def sumar(self):
        return self.op1 + self.op2

    def restar(self):
        return self.op1 - self.op2

    def multiplicar(self):
        return self.op1 * self.op2

    def dividir(self):
        return self.op1 / self.op2

calc = Calculadora(operando2 = 2, operando1 = 10)
print calc.sumar()
print calc.restar()
print calc.multiplicar()
print calc.dividir()
# -*- coding: utf-8 -*-

class Fraccion(object):
	def __init__(self, numerador, denominador = 1):
		self.numerador = numerador
		self.denominador = denominador

	def __add__(self, fraccion):
		resul = Fraccion(self.numerador, self.denominador)
        
        if self.denominador == fraccion.denominador:
            resul.numerador = self.numerador + fraccion.numerador
            resul = resul.simplifica()
        
        else:
            mcm = resul.mcm(self.denominador, fraccion.denominador)
            resul.numerador = (mcm / self.denominador) * self.numerador + (mcm / fraccion.denominador) * fraccion.numerador
            resul.denominador = mcm
            resul = resul.simplifica()
            
        return resul

	def __sub__(self, fraccion):
		resul = Fraccion(self.numerador, self.denominador)
        
        if self.denominador == fraccion.denominador:
            resul.numerador = self.numerador - fraccion.numerador
            resul = resta.simplifica()
        
        else:
            mcm1 = resul.mcm(self.denominador, fraccion.denominador)
            resul.numerador = (mcm1 / self.denominador) * self.numerador + (mcm1 / fraccion.denominador) * fraccion.numerador
            resul.denominador = mcm1
            resul = resul.simplifica()
            
        return resul

 	def __mul__(self, fraccion):
        resul = Fraccion(self.numerador, self.denominador)
        resul.numerador = self.numerador * fraccion.numerador
        resul.denominador = self.denominador * fraccion.denominador
        resul = resul.simplifica()
        
        return resul

    def __div__(self, fraccion):
        resul = Fraccion(self.numerador, self.denominador)
        resul.numerador = self.numerador * fraccion.denominador
        resul.denominador = self.numerador * fraccion.denominador
        resul = resul.simplifica()
        
        return resul

    def simplificar(self):
        resul = Fraccion(self.numerador, self.denominador)
        mcd = gcd(self.numerador, self.denominador)
        resul.numerador = self.numerador / mcd
        resul.denominador = self.denominador / mcd
        
        return (resul)

	def mcm(self, a, b):
        mcm = (a * b) / gcd(a, b)
        
        return mcm
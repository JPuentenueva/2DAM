# -*- coding: utf-8 -*-

class Carta(object):
    def __init__(self, numero, palo):
        self.numero = numero
        self.palo = palo
    def salud(self,nombre):
        print "Hola " + nombre


class Oros(Carta):
    def __init__(self, numero):
        super(Oros, self).__init__(numero, "oros")

c = Carta()
c.saluda("Mi arma")
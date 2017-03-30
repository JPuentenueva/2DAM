# -*- coding: utf-8 -*-

class Entero(object):

    def __init__(self, val):
        self.__x = val

    def getEntero(self):
        return self.__x

    def setEntero(self, val):
        self.__x = val

    def __add__(self, other):
        return self.__x + other.getEntero()

    def __str__(self):
        return str(self.__x)

n1 = Entero(7)
print n1
n2 = Entero(8)
print n2
print n1 + n2
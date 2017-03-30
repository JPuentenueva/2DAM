# -*- coding: utf-8 -*-

""" Crear una nueva clase Fecha. Tendrá por atributos el día, mes y anio. Estos parámetros se podrán inicializar cuando se cree un objeto.
Sobrecargar los métodos especiales __lt__ (menor estricto <), __le__ (menor o igual <=), __gt__ (mayor estricto >),
 __ge__ (mayor o igual >=) para que devuelva True cuando una fecha sea menor que otra, menor o igual que otra,
 mayor que otra o mayor o igual que otra, respectivamente. Un ejemplo de implementación de la función mayor o igual, __ge__, sería:

def __ge__ (self, otra_fecha):
   #codigo
"""

class Fecha(object):
    def __init__(self, dia, mes, anio):
        self.__dia = dia
        self.__mes = mes
        self.__anio = anio

    def __lt__(self, other):
        if self.__anio < other.getAnio():
            return True
        elif self.__anio == other.getAnio():
            if self.__mes == other.getMes():
                if self.__dia == other.getMes():
                    return False
            elif self.__mes > other.getMes():
                return False
            else:
                if self.__dia >= other.getDia():
                    return False
                else:
                    return True
        else:
            return False

    def __le__(self, other):
        if self.__anio < other.getAnio():
            return True
        elif self.__anio == other.getAnio():
            if self.__mes == other.getMes():
                if self.__dia == other.getMes():
                    return True
            elif self.__mes > other.getMes():
                return False
            else:
                if self.__dia > other.getDia():
                    return False
                else:
                    return True
        else:
            return False

    def __gt__(self, other):
        if self.__anio > other.getAnio():
            return True
        elif self.__anio == other.getAnio():
            if self.__mes == other.getMes():
                if self.__dia == other.getMes():
                    return False
            elif self.__mes > other.getMes():
                return True
            else:
                return False
        else:
            return False

    def __ge__(self, other):
        if self.__anio > other.getAnio():
            return True
        elif self.__anio == other.getAnio():
            if self.__mes == other.getMes():
                if self.__dia == other.getMes():
                    return True
            elif self.__mes > other.getMes():
                return True
            else:
                return False
        else:
            return False

    def getDia(self):
        return self.__dia

    def getMes(self):
        return self.__mes

    def getAnio(self):
        return self.__anio
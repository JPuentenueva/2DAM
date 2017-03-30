# -*- coding: utf-8 -*-

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

class Fecha_mod(Fecha):
    def __init__(self, dia, mes, anio):
        self.__dia = dia
        self.__mes = mes
        self.__anio = anio

    def __str__(self):
        cadenaFecha = ""

        if len(str(self.__dia) == 2):
            cadenaFecha += str(self.__dia) + "/"
        else:
            cadenaFecha += "0" + str(self.__dia) + "/"

        if len(str(self.__mes) == 2):
            cadenaFecha += str(self.__mes) + "/"
        else:
            cadenaFecha += "0" + str(self.__mes) + "/"

        if len(str(self.__anio)) == 4:
            cadenaFecha = str(self.__anio)
        else:
            cadenaFecha = "20" + str(self.__anio)

        return cadenaFecha

o = Fecha_mod (8, 2, 12)
print o
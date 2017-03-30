# -*- coding: utf-8 -*-
import datetime

class Fecha(object):
    def __init__(self, dia = 1, mes = 1, anyo = 1900):
        self.__dia = dia
        self.__mes = mes
        self.__anyo = anyo

    def __le__(self, other):
        if self.__anyo > other.getAnyo():
            return False
        elif self.__mes > other.getMes():
            return False
        elif self.__dia > other.getDia():
            return False
        else:
            return True

    def getAnyo(self):
        return self.__anyo

    def setAnyo(self, anyo):
        self.__anyo = anyo

    def getMes(self):
        return self.__mes

    def setMes(self, mes):
        self.__mes = mes

    def getDia(self):
        return self.__dia

    def setDia(self, dia):
        self.__dia = dia

    def validar(self):
        try:
            str_fecha = str(self.__get_dia()) + "/" + str(self.__get_dia()) + "/" + str(self.__get_dia())
            datetime.datetime.strptime(str_fecha, '%d/%m/%Y')
            return True
        except ValueError:
            return False



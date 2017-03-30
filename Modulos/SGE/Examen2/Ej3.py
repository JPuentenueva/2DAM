# -*- coding: utf-8 -*-

"""
Implementar la clase Persona, pensando en usarla en un calendario para felicitaciones, que tendrá como atributos el nombre completo,
la fecha de nacimiento, la fecha de su onomástica (santo), su teléfono y email.
Tiene que hacer uso de la clase Fecha del ejercicio 1. Implementar el constructor y los getter y setter correspondientes.
Sobreescribir el método __le__ de forma que una persona será menor que otra cuando su fecha de nacimiento lo sea.

"""

class Persona(object):
    def __init__(self, nombre, fecha_nacimiento, fecha_santo, telefono, email):
        self.__nombre = nombre
        self.__fecha_nacimiento = fecha_nacimiento
        self.__fecha_santo = fecha_santo
        self.__telefono = telefono
        self.__email = email

    def __le__(self, other):
        if(self.__fecha_nacimiento < other.getFechaNacimiento()):
            return True
        else:
            return False

    def getNombre(self):
        return self.__nombre
    def getFechaNacimiento(self):
        return self.__fecha_nacimiento
    def getFechaSanto(self):
        return self.__fecha_santo
    def getTelefono(self):
        return self.__telefono
    def getEmail(self):
        return self.__email
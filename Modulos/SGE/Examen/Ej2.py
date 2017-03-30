def VALIDAR_FECHA(dia, mes, anyo):
    if dia < 1 or mes < 1 or anyo < 1:
        return False
    else:
        if (mes == 1 or mes == 3 or mes == 5 or mes == 7 or mes == 8 or mes == 10 or mes == 12)and dia <= 31:
            return True
        elif mes == 2 and anyo % 400 == 0 and dia <= 29:
            return True
        elif mes == 2 and anyo % 400 != 0 and dia <= 28:
            return True
        elif (mes == 4 or mes == 6 or mes == 9 or mes == 11) and dia <= 30:
            return True
        else:
            return False

day = raw_input("Introduzca una fecha. Dia: ")
month = raw_input("Mes: ")
year = raw_input("Anyo: ")

valido = VALIDAR_FECHA(day, month, year)

if valido:
    print str(day) + "-" + str(month) + "-" + str(year) + " es una fecha valida"
else:
    print str(day) + "-" + str(month) + "-" + str(year) + " no es una fecha valida"
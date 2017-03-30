def CANTIDAD_DIGITOS(num):
    if num < 0:
        num = num + (-num * 2)
    return len(str(num))

numeroLargo = 45891938563
numeroCorto = -16

print str(numeroLargo) + " tiene " + str(CANTIDAD_DIGITOS(numeroLargo)) + " digitos"
print str(numeroCorto) + " tiene " + str(CANTIDAD_DIGITOS(numeroCorto)) + " digitos"
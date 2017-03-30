def calcular_precio_del_bus(distancia, num_pasajeros):
    precio_ticket = 20.00
    precio_total = 0.0

    if distancia < 1 or num_pasajeros < 1:
        return "Algun dato proporcionado es negativo"
    else:
        if distancia > 200:
            precio_ticket += precio_ticket + float(distancia) * 0.03
        if distancia > 400:
            precio_ticket -= precio_ticket * 0.15
        if num_pasajeros >= 3:
            precio_ticket -= precio_ticket * 0.1

        precio_total = precio_ticket * float(num_pasajeros)

        return "Precio de ticket individual: " + str(round(precio_ticket,2)) + ", precio total: " + str(round(precio_total,2))

kilometros = raw_input("Indique cuantos km recorrera el autobus: ")
pasajeros = raw_input("Y ahora el numero de pasajeros: ")

print calcular_precio_del_bus(kilometros, pasajeros)
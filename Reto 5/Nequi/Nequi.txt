fun main() {
    var saldoDisponible = 4500
    var intentos = 3

    while (intentos > 0) {
        println("Ingrese su número de celular:")
        val celular = readLine()

        println("Ingrese su clave de 4 dígitos:")
        val clave = readLine()

        if (celular == "1234567890" && clave == "1234") {
            println("¡Bienvenido a Nequi!")
            break
        } else {
            intentos--
            if (intentos > 0) {
                println("¡Upps! Parece que tus datos de acceso no son correctos. Tienes $intentos intentos más.")
            } else {
                println("Agotaste los intentos. La aplicación se cerrará.")
                return
            }
        }
    }

    while (true) {
        println("Saldo Disponible: $saldoDisponible")
        println("Opciones:")
        println("1. Saca")
        println("2. Envía")
        println("3. Recarga")
        println("4. Salir")

        val opcion = readLine()?.toIntOrNull() ?: 0

        when (opcion) {
            1 -> {
                println("Escoge la opción:")
                println("1. Cajero")
                println("2. Punto físico")
                val opcionSaca = readLine()?.toIntOrNull() ?: 0

                if (saldoDisponible < 2000) {
                    println("No te alcanza para hacer el retiro.")
                } else {
                    println("Confirma el monto a retirar:")
                    val monto = readLine()?.toIntOrNull() ?: 0

                    if (monto <= saldoDisponible) {
                        println("Retiro exitoso. Código de retiro: ${generarCodigoRetiro()}")
                        saldoDisponible -= monto
                    } else {
                        println("Monto insuficiente para el retiro.")
                    }
                }
            }
            2 -> {
                println("Ingrese el número de teléfono al que desea enviar dinero:")
                val numTelefono = readLine()

                println("Ingrese el valor a enviar:")
                val valorEnvio = readLine()?.toIntOrNull() ?: 0

                if (valorEnvio <= saldoDisponible) {
                    saldoDisponible -= valorEnvio
                    println("Envío exitoso.")
                } else {
                    println("Saldo insuficiente para enviar dinero.")
                }
            }
            3 -> {
                println("Ingrese el valor a recargar:")
                val valorRecarga = readLine()?.toIntOrNull() ?: 0

                println("¿Desea confirmar la recarga? (s/n)")
                val confirmacion = readLine()

                if (confirmacion == "s" || confirmacion == "S") {
                    saldoDisponible += valorRecarga
                    println("Recarga exitosa.")
                } else {
                    println("Recarga cancelada.")
                }
            }
            4 -> {
                println("¡Gracias por usar Nequi!")
                return
            }
            else -> println("Opción inválida. Por favor, seleccione una opción válida.")
        }
    }
}

fun generarCodigoRetiro(): Int {
    return (100000..999999).random()
}
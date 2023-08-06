fun main() {
    val notifi = mutableMapOf<String, Int>()
    notifi ["WhatsApp"] = 76
    notifi ["Email"] = 101
    notifi ["Facebook"] = 0

    for ((apli, cont) in notifi) {
        val appsNotifi = when {
            cont < 1 -> "No hay mensajes disponibles en $apli"
            cont < 100 -> "Tienes $cont notificaciones en $apli"
            else -> "Tienes 99+ notificaciones en $apli"
        }
        println(appsNotifi)
    }
}
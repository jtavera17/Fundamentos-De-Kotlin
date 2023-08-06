fun main() {
    val precioBaseArticulo1 = obtenerPrecio("Artículo 1")
    val precioBaseArticulo2 = obtenerPrecio("Artículo 2")

    var mejorOfertaArticulo1 = precioBaseArticulo1
    var mejorOfertaArticulo2 = precioBaseArticulo2

    // Simulación de ofertas para el artículo 1
    println("Ingrese una oferta para el Artículo 1:")
    val oferta1 = readLine()?.toIntOrNull() ?: 0
    if (oferta1 > mejorOfertaArticulo1) {
        mejorOfertaArticulo1 = oferta1
    }

    // Simulación de ofertas para el artículo 2
    println("Ingrese una oferta para el Artículo 2:")
    val oferta2 = readLine()?.toIntOrNull() ?: 0
    if (oferta2 > mejorOfertaArticulo2) {
        mejorOfertaArticulo2 = oferta2
    }

    // Resultado final de la subasta para ambos artículos
    println("Artículo 1: ${obtenerGanador(mejorOfertaArticulo1, precioBaseArticulo1)}")
    println("Artículo 2: ${obtenerGanador(mejorOfertaArticulo2, precioBaseArticulo2)}")
}

fun obtenerPrecio(nombreArticulo: String): Int {
    println("Ingrese el precio base para el $nombreArticulo:")
    return readLine()?.toIntOrNull() ?: 0
}

fun obtenerGanador(mejorOferta: Int, precioBase: Int): String {
    return if (mejorOferta > precioBase) "Ofertante con mejor precio: $mejorOferta" else "La casa se queda con el artículo."
}
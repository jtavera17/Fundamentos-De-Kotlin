fun main() {
    val menu = mutableMapOf<String, MutableList<MutableMap<String, Any>>>()

    agregarPlato(menu, "Entradas", "Ensalada César", "Lechuga, pollo, crutones y aderezo.", 8.99)
    agregarPlato(menu, "Entradas", "Calamares Fritos", "Calamares fritos con salsa tártara.", 10.99)
    agregarPlato(menu, "Platos Fuertes", "Filete Mignon", "Filete mignon con guarnición.", 24.99)
    agregarPlato(menu, "Platos Fuertes", "Salmón a la Parrilla", "Salmón a la parrilla con verduras.", 19.99)
    agregarPlato(menu, "Postres", "Tiramisú", "Tiramisú italiano.", 6.99)
    agregarPlato(menu, "Postres", "Cheesecake", "Cheesecake de fresa.", 5.99)
    agregarPlato(menu, "Bebidas", "Margarita", "Cóctel de margarita.", 7.99)
    agregarPlato(menu, "Bebidas", "Cerveza", "Cerveza fría.", 3.99)

    mostrarPlatos(menu)

    modificarPlato(menu, "Calamares Fritos", "Calamares a la Romana", "Calamares a la romana con salsa tártara.", 12.99)

    println("----- PLATO MODIFICADO -----")
    mostrarPlato(menu, "Calamares a la Romana")

    eliminarPlato(menu, "Tiramisú")

    println("----- PLATOS DESPUÉS DE ELIMINAR -----")
    mostrarPlatos(menu)
}

fun agregarPlato(menu: MutableMap<String, MutableList<MutableMap<String, Any>>>, categoria: String, nombre: String, descripcion: String, precio: Double) {
    val plato = mutableMapOf<String, Any>()
    plato["nombre"] = nombre
    plato["descripcion"] = descripcion
    plato["precio"] = precio

    if (menu.containsKey(categoria)) {
        menu[categoria]?.add(plato)
    } else {
        menu[categoria] = mutableListOf(plato)
    }
}

fun mostrarPlatos(menu: Map<String, List<Map<String, Any>>>) {
    for ((categoria, platos) in menu) {
        println("----- $categoria -----")
        for (plato in platos) {
            println("Nombre: ${plato["nombre"]}, Descripción: ${plato["descripcion"]}, Precio: ${plato["precio"]}")
        }
    }
}

fun mostrarPlato(menu: Map<String, List<Map<String, Any>>>, nombrePlato: String) {
    for ((categoria, platos) in menu) {
        for (plato in platos) {
            if (plato["nombre"] == nombrePlato) {
                println("Nombre: ${plato["nombre"]}, Descripción: ${plato["descripcion"]}, Precio: ${plato["precio"]}")
                return
            }
        }
    }
    println("Plato no encontrado.")
}

fun modificarPlato(menu: MutableMap<String, MutableList<MutableMap<String, Any>>>, nombrePlato: String, nuevoNombre: String, nuevaDescripcion: String, nuevoPrecio: Double) {
    for ((categoria, platos) in menu) {
        for (plato in platos) {
            if (plato["nombre"] == nombrePlato) {
                plato["nombre"] = nuevoNombre
                plato["descripcion"] = nuevaDescripcion
                plato["precio"] = nuevoPrecio
                return
            }
        }
    }
    println("Plato no encontrado.")
}

fun eliminarPlato(menu: MutableMap<String, MutableList<MutableMap<String, Any>>>, nombrePlato: String) {
    for ((categoria, platos) in menu) {
        val iterator = platos.iterator()
        while (iterator.hasNext()) {
            val plato = iterator.next()
            if (plato["nombre"] == nombrePlato) {
                iterator.remove()
                return
            }
        }
    }
}
package gestioninventario.producto;

import gestioninventario.producto.Producto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorio {
    private static List<Producto> productos = new ArrayList<>();

    // Método para crear un producto
    public static void agregarProducto(Producto producto) {
        productos.add(producto);
    }


    public static List<Producto> obtenerTodos() {
        return new ArrayList<>(productos);
    }

   
    public static Producto buscarPorId(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }
    
     
    public static List<Producto> buscarPorNombre(String nombre) {
        List<Producto> resultados = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                resultados.add(producto);
            }
        }
        return resultados;
    }

    
    public static List<Producto> buscarPorCategoria(String categoria) {
        List<Producto> resultados = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                resultados.add(producto);
            }
        }
        return resultados;
    }


 
    public static boolean actualizarProducto(int id, Producto productoModificado) {
        Producto productoExistente = buscarPorId(id);
        if (productoExistente != null) {
            int index = productos.indexOf(productoExistente);
            productos.set(index, productoModificado);
            return true;
        }
        return false;
    }


public static void eliminarProducto(int id) {
    Producto producto = buscarPorId(id); // Verificamos si el producto existe
    if (producto != null) {
        productos.remove(producto); // Eliminamos el producto
    } else {
        throw new IllegalArgumentException("Producto no encontrado.");
    }
}
    
   
    public static void añadirExistencias(int id, int cantidad, String motivo) {
        Producto producto = buscarPorId(id);
        if (producto != null) {
            producto.setCantidad(producto.getCantidad() + cantidad);
            System.out.println("Añadidas " + cantidad + " unidades al producto ID " + id + ". Motivo: " + motivo);
            registrarMovimiento(producto, "ADICION", cantidad, motivo);
        } else {
            throw new IllegalArgumentException("Producto no encontrado.");
        }
    }
    
    
    public static void disminuirExistencias(int id, int cantidad, String motivo) {
        Producto producto = buscarPorId(id);
        if (producto != null) {
            if (producto.getCantidad() >= cantidad) {
                producto.setCantidad(producto.getCantidad() - cantidad);
                System.out.println("Disminuidas " + cantidad + " unidades al producto ID " + id + ". Motivo: " + motivo);
                registrarMovimiento(producto, "DISMINUCION", cantidad, motivo);
            } else {
                throw new IllegalArgumentException("No hay suficientes existencias.");
            }
        } else {
            throw new IllegalArgumentException("Producto no encontrado.");
        }
    }
    
    private static void registrarMovimiento(Producto producto, String tipo, int cantidad, String motivo) {
        Movimiento movimiento = new Movimiento(LocalDate.now(), producto, tipo, cantidad, motivo);
        MovimientoRepositorio.registrarMovimiento(movimiento); // Registro del movimiento
    }
}




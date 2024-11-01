package gestioninventario.producto;

import gestioninventario.producto.Producto;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;


public class ProductoServicio {

    public static void crearProducto(int id, String nombre, String categoria, int cantidad, double precioUnitario, String fechaExpiracion, String proveedor) {
        Producto producto = new Producto(id, nombre, categoria, cantidad, precioUnitario, fechaExpiracion, proveedor);
        ProductoRepositorio.agregarProducto(producto);
    }

    public static Producto obtenerProductoPorId(int id) {
        return ProductoRepositorio.buscarPorId(id);
    }

    public static List<Producto> obtenerTodosLosProductos() {
        return ProductoRepositorio.obtenerTodos();
    }

    public static boolean actualizarProducto(int id, String nombre, String categoria, int cantidad, double precioUnitario, String fechaExpiracion, String proveedor) {
        Producto productoModificado = new Producto(id, nombre, categoria, cantidad, precioUnitario, fechaExpiracion, proveedor);
        return ProductoRepositorio.actualizarProducto(id, productoModificado);
    }

    public static void eliminarProducto(int id) {
        ProductoRepositorio.eliminarProducto(id);
    }
    
    public static void adicionarExistencias(int idProducto, int cantidad, String motivo) {
        Producto producto = ProductoRepositorio.buscarPorId(idProducto);
        if (producto != null) {
            producto.setCantidad(producto.getCantidad() + cantidad);

            // Crear y registrar el movimiento
            Movimiento movimiento = new Movimiento(
                    LocalDate.now(),
                    producto,
                    "ADICION",
                    cantidad,
                    motivo
            );
            MovimientoRepositorio.registrarMovimiento(movimiento);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public static void disminuirExistencias(int idProducto, int cantidad, String motivo) {
        Producto producto = ProductoRepositorio.buscarPorId(idProducto);
        if (producto != null) {
            if (producto.getCantidad() >= cantidad) {
                producto.setCantidad(producto.getCantidad() - cantidad);

                // Crear y registrar el movimiento
                Movimiento movimiento = new Movimiento(
                        LocalDate.now(),
                        producto,
                        "DISMINUCION",
                        cantidad,
                        motivo
                );
                MovimientoRepositorio.registrarMovimiento(movimiento);
            } else {
                System.out.println("Cantidad insuficiente para realizar la operación.");
            }
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
    
}


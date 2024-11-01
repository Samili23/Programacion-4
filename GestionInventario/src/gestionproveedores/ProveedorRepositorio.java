package gestionproveedores;

import java.util.ArrayList;
import java.util.List;


public class ProveedorRepositorio {
    private static List<Proveedor> proveedores = new ArrayList<>();

    // Crear o agregar un proveedor
    public static void agregarProveedor(Proveedor proveedor) {
        proveedores.add(proveedor);
    }

    // Leer o obtener todos los proveedores
    public static List<Proveedor> obtenerTodos() {
        return new ArrayList<>(proveedores);
    }

    // Buscar un proveedor por ID
    public static Proveedor buscarPorId(int id) {
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getId() == id) {
                return proveedor;
            }
        }
        return null;
    }

    // Actualizar un proveedor
    public static boolean actualizarProveedor(int id, Proveedor proveedorActualizado) {
        Proveedor proveedorExistente = buscarPorId(id);
        if (proveedorExistente != null) {
            proveedorExistente.setNombre(proveedorActualizado.getNombre());
            proveedorExistente.setDireccion(proveedorActualizado.getDireccion());
            proveedorExistente.setTelefono(proveedorActualizado.getTelefono());
            return true;
        }
        return false;
    }

    // Eliminar un proveedor
    public static boolean eliminarProveedor(int id) {
        return proveedores.removeIf(proveedor -> proveedor.getId() == id);
    }
}


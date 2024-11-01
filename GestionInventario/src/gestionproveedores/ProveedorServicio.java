package gestionproveedores;

import java.util.List;

public class ProveedorServicio {
    // Agregar un nuevo proveedor
    public void agregarProveedor(int id, String nombre, String direccion, String telefono) {
        Proveedor proveedor = new Proveedor(id, nombre, direccion, telefono);
        ProveedorRepositorio.agregarProveedor(proveedor);
    }

    // Obtener todos los proveedores
    public List<Proveedor> obtenerProveedores() {
        return ProveedorRepositorio.obtenerTodos();
    }

    // Actualizar un proveedor existente
    public boolean actualizarProveedor(int id, String nombre, String direccion, String telefono) {
        Proveedor proveedorActualizado = new Proveedor(id, nombre, direccion, telefono);
        return ProveedorRepositorio.actualizarProveedor(id, proveedorActualizado);
    }

    // Eliminar un proveedor por ID
    public boolean eliminarProveedor(int id) {
        return ProveedorRepositorio.eliminarProveedor(id);
    }

    // Buscar un proveedor por ID
    public Proveedor buscarProveedorPorId(int id) {
        return ProveedorRepositorio.buscarPorId(id);
    }
}


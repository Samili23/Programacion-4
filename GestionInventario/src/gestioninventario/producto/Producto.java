
package gestioninventario.producto;


public class Producto {
    private int id;
    private String nombre;
    private String categoria;
    private int cantidad;
    private double precioUnitario;
    private String fechaExpiracion;
    private String proveedor;

    public Producto(int id, String nombre, String categoria, int cantidad, double precioUnitario, String fechaExpiracion, String proveedor) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.fechaExpiracion = fechaExpiracion;
        this.proveedor = proveedor;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public String getProveedor() {
        return proveedor;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    // Método toString
    @Override
    public String toString() {
        return "Producto{" +
                ", Nombre='" + nombre + '\'' +
                ", Categoria='" + categoria + '\'' +
                ", Cantidad=" + cantidad +
                ", PrecioUnitario=" + precioUnitario +
                '}';
    }
}

 


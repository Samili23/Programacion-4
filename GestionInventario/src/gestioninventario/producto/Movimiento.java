package gestioninventario.producto;

import java.time.LocalDate;

public class Movimiento {
    private LocalDate fecha;
    private Producto producto;
    private String tipoMovimiento; // "ADICION" o "DISMINUCION"
    private int cantidad;
    private String motivo;

    public Movimiento(LocalDate fecha, Producto producto, String tipoMovimiento, int cantidad, String motivo) {
        this.fecha = fecha;
        this.producto = producto;
        this.tipoMovimiento = tipoMovimiento;
        this.cantidad = cantidad;
        this.motivo = motivo;
    }

    // Getters y Setters
    public LocalDate getFecha() {
        return fecha;
    }

    public Producto getProducto() {
        return producto;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getMotivo() {
        return motivo;
    }

    @Override
    public String toString() {
        return "Movimiento{" +
                "fecha=" + fecha +
                ", producto=" + producto.getNombre() +
                ", tipoMovimiento='" + tipoMovimiento + '\'' +
                ", cantidad=" + cantidad +
                ", motivo='" + motivo + '\'' +
                '}';
    }
}

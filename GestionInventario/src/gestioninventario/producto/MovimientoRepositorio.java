package gestioninventario.producto;

import java.util.ArrayList;
import java.util.List;

public class MovimientoRepositorio {
    private static List<Movimiento> movimientos = new ArrayList<>();

   
    public static void registrarMovimiento(Movimiento movimiento) {
        movimientos.add(movimiento);
    }

   
    public static List<Movimiento> obtenerMovimientos() {
        return new ArrayList<>(movimientos);
    }
}


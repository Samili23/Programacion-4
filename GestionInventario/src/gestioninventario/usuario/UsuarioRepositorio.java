package gestioninventario.usuario;

import gestioninventario.usuario.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositorio {
    // Array estático para almacenar los usuarios
    private static List<Usuario> usuarios = new ArrayList<>();

    // Método para crear usuario
    public static void crearUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Método para modificar usuario
    public static void modificarUsuario(int id, Usuario usuarioModificado) {
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);
            if (usuario.getId() == id) {
                usuarios.set(i, usuarioModificado);
                return;
            }
        }
        System.out.println("Usuario no encontrado.");
    }

    // Método para obtener un usuario por correo electrónico
    public static Usuario obtenerUsuarioPorEmail(String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null; // No encontrado
    }

    // Método para obtener el listado de usuarios
    public static List<Usuario> obtenerListadoUsuarios() {
        return new ArrayList<>(usuarios); // Retorna una copia del listado
    }

    // Método para activar usuario
    public static void activarUsuario(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                usuario.setEstadoActivo(true);
                return;
            }
        }
        System.out.println("Usuario no encontrado.");
    }

    // Método para inactivar usuario
    public static void inactivarUsuario(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                usuario.setEstadoActivo(false);
                return;
            }
        }
        System.out.println("Usuario no encontrado.");
    }

    static void modificarUsuario(Usuario usuarioModificado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

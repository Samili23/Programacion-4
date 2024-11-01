
package gestioninventario;

import gestioninventario.usuario.UsuarioRepositorio;
import gestioninventario.usuario.UsuarioServicio;
import gestioninventario.usuario.Usuario;
import gestioninventario.usuario.LoginForm;
import gestioninventario.usuario.PrincipalForm;

public class GestionInventario {

    
   public static void main(String[] args) {
       
       // Agregar usuarios al repositorio antes de mostrar el login
        Usuario usuario1 = new Usuario(1, "Juan", "Pérez", "DNI", "12345678", "Calle Falsa 123", "123456789",  "root", "contra123", true);
        Usuario usuario2 = new Usuario(2, "Nathalia", "Gonzalez", "DNI", "87654321", "Avenida Siempre Viva 742", "987654321", "Nathalia.gonzalez@example.com", "pass456", true);
        Usuario usuario3 = new Usuario(3, "Andres", "Mejia", "DNI", "87654321", "san luis", "314652816", "A.m@example.com", "pass123", true);
        
        UsuarioRepositorio.crearUsuario(usuario1);
        UsuarioRepositorio.crearUsuario(usuario2);
        UsuarioRepositorio.crearUsuario(usuario3);
        // Crear y mostrar la ventana de login
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);
    }
    
}

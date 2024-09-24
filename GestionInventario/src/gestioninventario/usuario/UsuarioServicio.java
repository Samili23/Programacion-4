package gestioninventario.usuario;


import gestioninventario.usuario.Usuario;

public class UsuarioServicio {
    // Instancia de UsuarioRepositorio
    private UsuarioRepositorio repositorio;

    // Constructor
    public UsuarioServicio() {
        this.repositorio = new UsuarioRepositorio();
    }

    // Método para validar usuario
    public Boolean validarUsuario(String email, String contraseña) {
        // Obtener el usuario por correo electrónico
        Usuario usuario = repositorio.obtenerUsuarioPorEmail(email);

        // Validar que el usuario exista y que la contraseña sea correcta
        if (usuario != null && validarContraseña(usuario, contraseña)) {
            return true;
        }
        return false;
    }

    // Método privado para validar la contraseña
    private Boolean validarContraseña(Usuario usuario, String contraseña) {
        // Verificar que la contraseña proporcionada coincida con la almacenada
        return usuario.getContraseña().equals(contraseña);
    }
}

package gestioninventario.usuario;

import gestioninventario.usuario.Usuario;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PrincipalForm extends JFrame {
    private JLabel welcomeLabel;
    private JButton logoutButton;
    private JButton addUserButton;
    private JButton modifyUserButton;
    private JButton listUsersButton;
    private JButton activateUserButton;
    private JButton deactivateUserButton;

    public PrincipalForm(Usuario usuario) {
        // Configuración de la ventana principal
        setTitle("Pantalla Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Etiqueta de bienvenida
        welcomeLabel = new JLabel("Bienvenido, " + usuario.getNombre() + " " + usuario.getApellido());
        welcomeLabel.setBounds(10, 20, 300, 25);
        add(welcomeLabel);

        // Botón de cerrar sesión
        logoutButton = new JButton("Cerrar Sesión");
        logoutButton.setBounds(10, 50, 150, 25);
        add(logoutButton);

        // Botón para agregar usuario
        addUserButton = new JButton("Agregar Usuario");
        addUserButton.setBounds(10, 90, 150, 25);
        add(addUserButton);

        // Botón para modificar usuario
        modifyUserButton = new JButton("Modificar Usuario");
        modifyUserButton.setBounds(10, 130, 150, 25);
        add(modifyUserButton);

        // Botón para mostrar lista de usuarios
        listUsersButton = new JButton("Mostrar Usuarios");
        listUsersButton.setBounds(200, 90, 150, 25);
        add(listUsersButton);

        // Botón para activar usuario
        activateUserButton = new JButton("Activar Usuario");
        activateUserButton.setBounds(200, 130, 150, 25);
        add(activateUserButton);

        // Botón para inactivar usuario
        deactivateUserButton = new JButton("Inactivar Usuario");
        deactivateUserButton.setBounds(200, 170, 150, 25);
        add(deactivateUserButton);

        // Acción del botón "Cerrar Sesión"
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cierra la ventana principal y vuelve a mostrar el login
                LoginForm loginForm = new LoginForm();
                loginForm.setVisible(true);
                dispose();  // Cierra la ventana principal
            }
        });

        // Acción del botón "Agregar Usuario"
        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarUsuario();
            }
        });

        // Acción del botón "Modificar Usuario"
        modifyUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarUsuario(); // Aquí puedes cambiar el ID y los datos a modificar
            }
        });
        
        // Botón para buscar un usuario
        JButton buscarUsuarioButton = new JButton("Buscar Usuario");
        buscarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarUsuarioPorEmail();
            }
        });

        // Acción del botón "Mostrar Usuarios"
        listUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarUsuarios();
            }
        });

        // Acción del botón "Activar Usuario"
        activateUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activarUsuario(1); // Cambia el ID por el usuario que deseas activar
            }
        });

        // Acción del botón "Inactivar Usuario"
        deactivateUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inactivarUsuario(1); // Cambia el ID por el usuario que deseas inactivar
            }
        });
    }

    // Método para agregar un nuevo usuario con datos ingresados por el usuario
private void agregarUsuario() {
    try {
        // Pedir datos al usuario
        String idStr = JOptionPane.showInputDialog(this, "Ingrese el ID del usuario:");
        int id = Integer.parseInt(idStr); // Convertir a entero
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del usuario:");
        String apellido = JOptionPane.showInputDialog(this, "Ingrese el apellido del usuario:");
        String tipoDocumento = JOptionPane.showInputDialog(this, "Ingrese el tipo de documento (e.g., DNI):");
        String documento = JOptionPane.showInputDialog(this, "Ingrese el número de documento:");
        String direccion = JOptionPane.showInputDialog(this, "Ingrese la dirección del usuario:");
        String telefono = JOptionPane.showInputDialog(this, "Ingrese el teléfono del usuario:");
        String email = JOptionPane.showInputDialog(this, "Ingrese el email del usuario:");
        String password = JOptionPane.showInputDialog(this, "Ingrese la contraseña del usuario:");

        // Confirmar si el usuario estará activo o inactivo
        int activo = JOptionPane.showConfirmDialog(this, "¿El usuario está activo?", "Estado del usuario", JOptionPane.YES_NO_OPTION);
        boolean estadoActivo = (activo == JOptionPane.YES_OPTION);

        // Crear una instancia de Usuario con los datos ingresados
        Usuario nuevoUsuario = new Usuario(id, nombre, apellido, tipoDocumento, documento, direccion, telefono, email, password, estadoActivo);
        
        // Agregar el nuevo usuario al repositorio
        UsuarioRepositorio.crearUsuario(nuevoUsuario);

        // Mostrar mensaje de éxito
        JOptionPane.showMessageDialog(this, "Usuario creado con éxito");

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El ID debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al crear el usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
// Método para modificar un usuario existente con datos ingresados por el usuario
private void modificarUsuario() {
    try {
        // Pedir el email del usuario a modificar
        String email = JOptionPane.showInputDialog(this, "Ingrese el email del usuario a modificar:");

        // Buscar el usuario por email
        Usuario usuarioExistente = UsuarioRepositorio.obtenerUsuarioPorEmail(email);

        // Verificar si el usuario existe
        if (usuarioExistente == null) {
            JOptionPane.showMessageDialog(this, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Pedir nuevos datos para modificar
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nuevo nombre del usuario:", usuarioExistente.getNombre());
        String apellido = JOptionPane.showInputDialog(this, "Ingrese el nuevo apellido del usuario:", usuarioExistente.getApellido());
        String tipoDocumento = JOptionPane.showInputDialog(this, "Ingrese el nuevo tipo de documento:", usuarioExistente.getTipoDocumento());
        String documento = JOptionPane.showInputDialog(this, "Ingrese el nuevo número de documento:", usuarioExistente.getNumeroDocumento());
        String direccion = JOptionPane.showInputDialog(this, "Ingrese la nueva dirección del usuario:", usuarioExistente.getDireccion());
        String telefono = JOptionPane.showInputDialog(this, "Ingrese el nuevo teléfono del usuario:", usuarioExistente.getTelefono());
        String password = JOptionPane.showInputDialog(this, "Ingrese la nueva contraseña del usuario:");

        // Confirmar si el usuario estará activo o inactivo
        int activo = JOptionPane.showConfirmDialog(this, "¿El usuario está activo?", "Estado del usuario", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
        boolean estadoActivo = (activo == JOptionPane.YES_OPTION);

        // Crear un objeto usuario modificado, manteniendo el ID del usuario existente
        Usuario usuarioModificado = new Usuario(
            usuarioExistente.getId(), // Usamos el ID del usuario existente
            nombre, 
            apellido, 
            tipoDocumento, 
            documento, 
            direccion, 
            telefono, 
            email, // Mantener el email existente
            password, 
            estadoActivo
        );

        // Invocar el método de UsuarioRepositorio para modificar el usuario
        UsuarioRepositorio.modificarUsuario(usuarioExistente.getId(), usuarioModificado); // Pasamos el ID y el objeto modificado

        // Mostrar un mensaje de éxito
        JOptionPane.showMessageDialog(this, "Usuario modificado con éxito");

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al modificar el usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

// Método para buscar un usuario por correo y mostrar su información
private void buscarUsuarioPorEmail() {
    try {
        // Pedir el email del usuario a buscar
        String email = JOptionPane.showInputDialog(this, "Ingrese el email del usuario a buscar:");

        // Buscar el usuario por email
        Usuario usuarioEncontrado = UsuarioRepositorio.obtenerUsuarioPorEmail(email);

        // Verificar si el usuario existe
        if (usuarioEncontrado == null) {
            JOptionPane.showMessageDialog(this, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear un mensaje con la información del usuario
        String mensaje = "Información del Usuario:\n" +
                         "Nombre: " + usuarioEncontrado.getNombre() + "\n" +
                         "Apellido: " + usuarioEncontrado.getApellido() + "\n" +
                         "Tipo de Documento: " + usuarioEncontrado.getTipoDocumento() + "\n" +
                         "Número de Documento: " + usuarioEncontrado.getNumeroDocumento() + "\n" +
                         "Dirección: " + usuarioEncontrado.getDireccion() + "\n" +
                         "Teléfono: " + usuarioEncontrado.getTelefono() + "\n" +
                         "Email: " + usuarioEncontrado.getEmail();
                       

        // Mostrar la información del usuario
        JOptionPane.showMessageDialog(this, mensaje, "Detalles del Usuario", JOptionPane.INFORMATION_MESSAGE);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al buscar el usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}




    // Método para mostrar el listado de usuarios
    private void mostrarUsuarios() {
        List<Usuario> usuarios = UsuarioRepositorio.obtenerListadoUsuarios();
        StringBuilder sb = new StringBuilder();
        
        for (Usuario usuario : usuarios) {
            sb.append("ID: ").append(usuario.getId())
              .append(", Nombre: ").append(usuario.getNombre())
              .append(", Apellido: ").append(usuario.getApellido())
              .append(", Email: ").append(usuario.getEmail())
              .append(", Activo: ").append(usuario.isEstadoActivo())
              .append("\n");
        }
        
        JOptionPane.showMessageDialog(this, sb.toString());
    }

    // Método para activar un usuario
    private void activarUsuario(int id) {
        UsuarioRepositorio.activarUsuario(id);
        JOptionPane.showMessageDialog(this, "Usuario activado con éxito");
    }

    // Método para inactivar un usuario
    private void inactivarUsuario(int id) {
        UsuarioRepositorio.inactivarUsuario(id);
        JOptionPane.showMessageDialog(this, "Usuario inactivado con éxito");
    }
}

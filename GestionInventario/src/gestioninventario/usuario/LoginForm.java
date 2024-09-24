package gestioninventario.usuario;


import gestioninventario.usuario.UsuarioServicio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JLabel messageLabel;

    public LoginForm() {
        // Configuración de la ventana de login
        setTitle("Login de Usuario");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Etiqueta y campo de correo
        emailLabel = new JLabel("Correo:");
        emailLabel.setBounds(10, 20, 80, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(100, 20, 165, 25);
        add(emailField);

        // Etiqueta y campo de contraseña
        passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setBounds(10, 50, 80, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 50, 165, 25);
        add(passwordField);

        // Botón de login
        loginButton = new JButton("Ingresar");
        loginButton.setBounds(10, 80, 100, 25);
        add(loginButton);

        // Etiqueta para mostrar mensajes
        messageLabel = new JLabel();
        messageLabel.setBounds(10, 110, 250, 25);
        add(messageLabel);

        // Acción del botón "Ingresar"
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                UsuarioServicio usuarioServicio = new UsuarioServicio();
                if (usuarioServicio.validarUsuario(email, password)) {
                    Usuario usuario = UsuarioRepositorio.obtenerUsuarioPorEmail(email);
                    // Si la validación es correcta, mostrar la interfaz principal
                    PrincipalForm principalForm = new PrincipalForm(usuario);
                    principalForm.setVisible(true);
                    dispose();  // Cierra la ventana de login
                } else {
                    // Si la validación falla, mostrar un mensaje de error
                    messageLabel.setText("Correo o contraseña incorrecta");
                }
            }
        });
    }
}


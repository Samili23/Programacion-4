package gestioninventario.usuario;


import gestioninventario.producto.Movimiento;
import gestioninventario.producto.MovimientoRepositorio;
import gestioninventario.usuario.Usuario;
import gestioninventario.producto.ProductoRepositorio;
import gestioninventario.producto.Producto;
import gestioninventario.producto.ProductoServicio;
import gestionproveedores.Proveedor;
import gestionproveedores.ProveedorServicio;
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
    private JButton addProductButton;
    private JButton modifyProductButton;
    private JButton deleteProductButton;
    private JButton listProductsButton;
    private JButton addStockButton;
    private JButton removeStockButton;  
    private JButton mostrarMovimientoButton;
    private JButton buscarPorNombreButton;
    private JButton buscarPorCategoriaButton;
    private JButton agregarProveedorButton;
    private JButton actualizarProveedorButton;
    private JButton eliminarProveedorButton;
    private JButton buscarPorIdButton;
    private JButton obtenerTodosButton;

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
        
        // Botón para agregar un producto
        addProductButton = new JButton("Agregar Producto");
        addProductButton.setBounds(10, 200, 150, 25);
        add(addProductButton);

        // Botón para modificar un producto
        modifyProductButton = new JButton("Modificar Producto");
        modifyProductButton.setBounds(200, 200, 150, 25);
        add(modifyProductButton);

        // Botón para eliminar un producto
        deleteProductButton = new JButton("Eliminar Producto");
        deleteProductButton.setBounds(10, 240, 150, 25);
        add(deleteProductButton);

        // Botón para mostrar lista de productos
        listProductsButton = new JButton("Mostrar Productos");
        listProductsButton.setBounds(200, 240, 150, 25);
        add(listProductsButton);

        // Botón para añadir existencias
        addStockButton = new JButton("Añadir Existencias");
        addStockButton.setBounds(10, 280, 150, 25);
        add(addStockButton);

        // Botón para disminuir existencias
        removeStockButton = new JButton("Disminuir Existencias");
        removeStockButton.setBounds(200, 280, 150, 25);
        add(removeStockButton);
        
         // Botón para mostrar movimientos
        mostrarMovimientoButton = new JButton("Mostrar Movimientos");
        mostrarMovimientoButton.setBounds(10, 320, 150, 25);
        add(mostrarMovimientoButton);
        
        // Botón para buscar por nombre
        buscarPorNombreButton = new JButton("Buscar por nombre");
        buscarPorNombreButton.setBounds(10, 360, 150, 25);
        add(buscarPorNombreButton);
        
        // Botón para mostrar movimientos
        buscarPorCategoriaButton = new JButton("Buscar por categoria");
        buscarPorCategoriaButton.setBounds(10, 400, 150, 25);
        add(buscarPorCategoriaButton);
        
        agregarProveedorButton = new JButton("Agregar proveedor");
        agregarProveedorButton.setBounds(390, 50, 150, 25);
        add(agregarProveedorButton);
        
        actualizarProveedorButton = new JButton("Actualizar proveedor");
        actualizarProveedorButton.setBounds(390, 90, 150, 25);
        add(actualizarProveedorButton);
        
        eliminarProveedorButton = new JButton("Eliminar proveedor");
        eliminarProveedorButton.setBounds(390, 130, 150, 25);
        add(eliminarProveedorButton);
        
        buscarPorIdButton = new JButton("Buscar proveedor por su id");
        buscarPorIdButton.setBounds(390, 170, 150, 25);
        add(buscarPorIdButton);
        
        obtenerTodosButton = new JButton("Obtener todos los proveedores");
        obtenerTodosButton.setBounds(390, 210, 150, 25);
        add(obtenerTodosButton);


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
        
        // Acción del botón "Agregar Producto"
        addProductButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        agregarProducto();
            }
        });

        // Acción del botón "Modificar Producto"
        modifyProductButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        modificarProducto();
            }
        });

        // Acción del botón "Eliminar Producto"
        deleteProductButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        eliminarProducto();
            }
        });

        // Acción del botón "Mostrar Productos"
        listProductsButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        mostrarProductos();
            }

          
        });

        // Acción del botón "Añadir Existencias"
        addStockButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        añadirExistencias();
            }

           
        });

        // Acción del botón "Disminuir Existencias"
        removeStockButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        disminuirExistencias();
            }

           
        });
       
        // Acción del botón "Mostrar movimientos"
        mostrarMovimientoButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        mostrarMovimientos();
            }

           
        });
        
        // Añadir acciones a los botones
        buscarPorNombreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPorNombre();
            }
        });

        buscarPorCategoriaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPorCategoria();
            }
        });

        agregarProveedorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarProveedor();
            }
                    
        });
        
        actualizarProveedorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarProveedor();
            }
                    
        });
        
        obtenerTodosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obtenerProveedores();
            }
                    
        });
        
        eliminarProveedorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarProveedor();
            }
                    
        });
        
        buscarPorIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProveedorPorId();
            }
                    
        });
}
        
      
    

    // Método para agregar un nuevo usuario con datos ingresados por el usuario
private void agregarUsuario() {
    try {
       
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

      
        int activo = JOptionPane.showConfirmDialog(this, "¿El usuario está activo?", "Estado del usuario", JOptionPane.YES_NO_OPTION);
        boolean estadoActivo = (activo == JOptionPane.YES_OPTION);

       
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


private void buscarUsuarioPorEmail() {
    try {
       
        String email = JOptionPane.showInputDialog(this, "Ingrese el email del usuario a buscar:");

        
        Usuario usuarioEncontrado = UsuarioRepositorio.obtenerUsuarioPorEmail(email);


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

    private void activarUsuario(int id) {
        UsuarioRepositorio.activarUsuario(id);
        JOptionPane.showMessageDialog(this, "Usuario activado con éxito");
    }

    
    private void inactivarUsuario(int id) {
        UsuarioRepositorio.inactivarUsuario(id);
        JOptionPane.showMessageDialog(this, "Usuario inactivado con éxito");
    }
    
    private void agregarProducto() {
    try {
        // Pedir datos del producto al usuario
        String idStr = JOptionPane.showInputDialog(this, "Ingrese el ID del producto:");
        int id = Integer.parseInt(idStr);
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del producto:");
        String categoria = JOptionPane.showInputDialog(this, "Ingrese la categoría del producto:");
        String cantidadStr = JOptionPane.showInputDialog(this, "Ingrese la cantidad inicial:");
        int cantidad = Integer.parseInt(cantidadStr);
        String precioStr = JOptionPane.showInputDialog(this, "Ingrese el precio unitario:");
        double precioUnitario = Double.parseDouble(precioStr);
        String fechaExpiracion = JOptionPane.showInputDialog(this, "Ingrese la fecha de expiración (opcional):");
        String proveedor = JOptionPane.showInputDialog(this, "Ingrese el proveedor:");

        // Crear el producto y guardarlo en el repositorio
        Producto nuevoProducto = new Producto(id, nombre, categoria, cantidad, precioUnitario, fechaExpiracion, proveedor);
        ProductoRepositorio.agregarProducto(nuevoProducto);

        JOptionPane.showMessageDialog(this, "Producto agregado con éxito");

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al agregar el producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
    private void modificarProducto() {
    try {
        // Pedir el ID del producto a modificar
        String idStr = JOptionPane.showInputDialog(this, "Ingrese el ID del producto a modificar:");
        int id = Integer.parseInt(idStr);

        Producto productoExistente = ProductoRepositorio.buscarPorId(id);
        if (productoExistente == null) {
            JOptionPane.showMessageDialog(this, "Producto no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Pedir nuevos datos del producto
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nuevo nombre:", productoExistente.getNombre());
        String categoria = JOptionPane.showInputDialog(this, "Ingrese la nueva categoría:", productoExistente.getCategoria());
        String cantidadStr = JOptionPane.showInputDialog(this, "Ingrese la nueva cantidad:", productoExistente.getCantidad());
        int cantidad = Integer.parseInt(cantidadStr);
        String precioStr = JOptionPane.showInputDialog(this, "Ingrese el nuevo precio unitario:", productoExistente.getPrecioUnitario());
        double precioUnitario = Double.parseDouble(precioStr);
        String fechaExpiracion = JOptionPane.showInputDialog(this, "Ingrese la nueva fecha de expiración:", productoExistente.getFechaExpiracion());
        String proveedor = JOptionPane.showInputDialog(this, "Ingrese el nuevo proveedor:", productoExistente.getProveedor());

        Producto productoModificado = new Producto(id, nombre, categoria, cantidad, precioUnitario, fechaExpiracion, proveedor);
        ProductoRepositorio.actualizarProducto(id, productoModificado);

        JOptionPane.showMessageDialog(this, "Producto modificado con éxito");

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al modificar el producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
    private void eliminarProducto() {
    try {
        String idStr = JOptionPane.showInputDialog(this, "Ingrese el ID del producto a eliminar:");
        int id = Integer.parseInt(idStr);

        ProductoRepositorio.eliminarProducto(id);
        JOptionPane.showMessageDialog(this, "Producto eliminado con éxito");

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al eliminar el producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
    
    private void añadirExistencias() {
    try {
        String idStr = JOptionPane.showInputDialog(this, "Ingrese el ID del producto:");
        int id = Integer.parseInt(idStr);

        String cantidadStr = JOptionPane.showInputDialog(this, "Ingrese la cantidad a añadir:");
        int cantidad = Integer.parseInt(cantidadStr);
        
        String motivo = JOptionPane.showInputDialog(this, "Ingrese el motivo del ingreso:");

        ProductoRepositorio.añadirExistencias(id, cantidad, motivo);
        JOptionPane.showMessageDialog(this, "Existencias añadidas correctamente.");

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al añadir existencias: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
    private void disminuirExistencias() {
    try {
        String idStr = JOptionPane.showInputDialog(this, "Ingrese el ID del producto:");
        int id = Integer.parseInt(idStr);

        String cantidadStr = JOptionPane.showInputDialog(this, "Ingrese la cantidad a disminuir:");
        int cantidad = Integer.parseInt(cantidadStr);
        
        String motivo = JOptionPane.showInputDialog(this, "Ingrese el motivo de la disminución:");

        ProductoRepositorio.disminuirExistencias(id, cantidad, motivo);
        JOptionPane.showMessageDialog(this, "Existencias disminuidas correctamente.");

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al disminuir existencias: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
  
    private void buscarPorNombre() {
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del producto:");
        if (nombre != null && !nombre.trim().isEmpty()) {
            List<Producto> resultados = ProductoRepositorio.buscarPorNombre(nombre);
            mostrarResultados(resultados, "Resultados de la búsqueda por nombre");
        }
    }

    // Método para buscar por categoría
    private void buscarPorCategoria() {
        String categoria = JOptionPane.showInputDialog(this, "Ingrese la categoría del producto:");
        if (categoria != null && !categoria.trim().isEmpty()) {
            List<Producto> resultados = ProductoRepositorio.buscarPorCategoria(categoria);
            mostrarResultados(resultados, "Resultados de la búsqueda por categoría");
        }
    }
    
    private void mostrarProductos() {
    try {
        // Obtenemos la lista de productos desde el repositorio
        List<Producto> productos = ProductoRepositorio.obtenerTodos();
        
        // Verificamos si la lista está vacía
        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay productos en el inventario.");
            return;
        }

        // Construimos una cadena con la información de los productos
        StringBuilder sb = new StringBuilder("Productos en Inventario:\n");
        for (Producto producto : productos) {
            sb.append(producto.toString()).append("\n");
        }

        // Mostramos la lista de productos en un cuadro de diálogo
        JOptionPane.showMessageDialog(this, sb.toString());

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al mostrar productos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    private void mostrarMovimientos() {
    try {
        List<Movimiento> movimientos = MovimientoRepositorio.obtenerMovimientos();

        if (movimientos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay movimientos registrados.");
            return;
        }

        StringBuilder sb = new StringBuilder("Historial de Movimientos:\n");
        for (Movimiento movimiento : movimientos) {
            sb.append(movimiento.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(this, sb.toString());

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al mostrar movimientos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    // Método para mostrar los resultados de la búsqueda
    private void mostrarResultados(List<Producto> resultados, String titulo) {
        if (resultados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron productos.");
        } else {
            StringBuilder sb = new StringBuilder(titulo + ":\n");
            for (Producto producto : resultados) {
                sb.append(producto.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(this, sb.toString());
        }
    }
    
    private void agregarProveedor() {
    try {
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el ID del proveedor:"));
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del proveedor:");
        String direccion = JOptionPane.showInputDialog(this, "Ingrese la dirección del proveedor:");
        String telefono = JOptionPane.showInputDialog(this, "Ingrese el teléfono del proveedor:");

        ProveedorServicio servicio = new ProveedorServicio();
        servicio.agregarProveedor(id, nombre, direccion, telefono);
        JOptionPane.showMessageDialog(this, "Proveedor agregado correctamente.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al agregar proveedor: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
    private void obtenerProveedores() {
    ProveedorServicio servicio = new ProveedorServicio();
    List<Proveedor> proveedores = servicio.obtenerProveedores();

    if (proveedores.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No hay proveedores registrados.");
    } else {
        StringBuilder sb = new StringBuilder("Lista de Proveedores:\n");
        for (Proveedor proveedor : proveedores) {
            sb.append(proveedor.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }
}
    
    private void actualizarProveedor() {
    try {
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el ID del proveedor a actualizar:"));

        String nuevoNombre = JOptionPane.showInputDialog(this, "Ingrese el nuevo nombre del proveedor:");
        String nuevaDireccion = JOptionPane.showInputDialog(this, "Ingrese la nueva dirección del proveedor:");
        String nuevoTelefono = JOptionPane.showInputDialog(this, "Ingrese el nuevo teléfono del proveedor:");

        ProveedorServicio servicio = new ProveedorServicio();
        boolean actualizado = servicio.actualizarProveedor(id, nuevoNombre, nuevaDireccion, nuevoTelefono);

        if (actualizado) {
            JOptionPane.showMessageDialog(this, "Proveedor actualizado correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Proveedor no encontrado.");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
    private void eliminarProveedor() {
    try {
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el ID del proveedor a eliminar:"));

        ProveedorServicio servicio = new ProveedorServicio();
        boolean eliminado = servicio.eliminarProveedor(id);

        if (eliminado) {
            JOptionPane.showMessageDialog(this, "Proveedor eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Proveedor no encontrado.");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
    private void buscarProveedorPorId() {
    try {
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el ID del proveedor a buscar:"));

        ProveedorServicio servicio = new ProveedorServicio();
        Proveedor proveedor = servicio.buscarProveedorPorId(id);

        if (proveedor != null) {
            JOptionPane.showMessageDialog(this, "Proveedor encontrado:\n" + proveedor.toString());
        } else {
            JOptionPane.showMessageDialog(this, "Proveedor no encontrado.");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
}

    








    



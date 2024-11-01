package gestioninventario.usuario;


public class Usuario {
    // Atributos privados
    private int id;
    private String nombre;
    private String apellido;
    private String tipoDocumento;
    private String numeroDocumento;
    private String direccion;
    private String telefono;
    private String email;
    private String contraseña;
    private boolean estadoActivo;

    // Constructor
    public Usuario(int id, String nombre, String apellido, String tipoDocumento, 
                   String numeroDocumento, String direccion, String telefono,
                   String email, String contraseña, boolean estadoActivo) {
        
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.contraseña = contraseña;
        this.estadoActivo = estadoActivo;
    }

    // Métodos getters y setters
    public int getId() {
        return id;
    }
    

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getContraseña() {
    return contraseña;
    }

    public void setContraseña(String contraseña) {
    this.contraseña = contraseña;
    }
    
    public boolean isEstadoActivo() {
        return estadoActivo;
    }

    public void setEstadoActivo(boolean estadoActivo) {
        this.estadoActivo = estadoActivo;
    }

    // Método toString para representar el objeto en formato de cadena
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", Nombre='" + nombre + '\'' +
                ", Apellido='" + apellido + '\'' +
                ", TipoDocumento='" + tipoDocumento + '\'' +
                ", NumeroDocumento='" + numeroDocumento + '\'' +
                ", Direccion='" + direccion + '\'' +
                ", Telefono='" + telefono + '\'' +
                ", Email='" + email + '\'' +
                ", Contraseña='" + contraseña + '\'' +
                ", EstadoActivo=" + estadoActivo +
                '}';
    }
}

package dominio;

public class Usuario {

    // Atributos
    private int idUsuario;
    private String nombre;
    private String contrasenia;

    // Constructor por defecto"
    public Usuario() {
        this.idUsuario = 1;
        this.nombre = "Juan Pérez";
        this.contrasenia = "16_deMarzo";
    }

    // Constructor con parámetros
    public Usuario(int idUsuario, String nombre, String contrasenia) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }

    /**
     *MÉTODOS SETTER
     */
    public void setIdUsuario(int idUsuario) {
        if (idUsuario <= 0) {
            throw new IllegalArgumentException("Por favor llenar Campo Obligatorio: ID de usuario debe ser mayor a 0.");
        }
        this.idUsuario = idUsuario;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("Por favor llenar Campo Obligatorio: Nombre.");
        }
        this.nombre = nombre;
    }

    public void setContrasenia(String contrasenia) {
        if (contrasenia == null || contrasenia.isEmpty()) {
            throw new IllegalArgumentException("Por favor llenar Campo Obligatorio: Contraseña.");
        }
        this.contrasenia = contrasenia;
    }

    /**
     *MÉTODOS GETTER
     */
    public int getIdUsuario() {

        return idUsuario;
    }
    public String getNombre() {
        return nombre;
    }
    public String getContrasenia() {
        return contrasenia;
    }


    // Método adicional

    public String toString() {
        return "Usuario: " +
                "\nID: " + idUsuario +
                "\nNombre: " + nombre +
                "\nContraseña: " + contrasenia;
    }
}
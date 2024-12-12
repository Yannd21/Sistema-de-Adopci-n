package util;

public class validacion {

    // Método para validar solo letras
    public static boolean soloLetras(String texto) {
        return texto != null && texto.matches("[a-zA-Z]+");  // Solo letras
    }

    // Método para validar que la cadena tenga exactamente 10 números
    public static boolean esIdValido(String id) {
        return id != null && id.matches("\\d{10}");  // Verifica que contenga exactamente 10 dígitos
    }

    // Método para validar si la edad es mayor de 18 años
    public static boolean esMayorDeEdad(String edad) {
        try {
            int edadInt = Integer.parseInt(edad);  // Convertir la cadena a un número
            return edadInt >= 18;  // Validar que sea mayor o igual a 18
        } catch (NumberFormatException e) {
            return false;  // Si no es un número válido, devolver false
        }
    }

    // Validar que la dirección contenga al menos un número (número de casa)
    public static boolean contieneNumero(String direccion) {
        return direccion != null && direccion.matches(".*\\d.*");  // Verifica que contenga al menos un número
    }

    // Validar que el teléfono contenga exactamente 10 dígitos
    public static boolean esTelefonoValido(String telefono) {
        return telefono != null && telefono.matches("\\d{10}");  // Verifica que contenga exactamente 10 dígitos
    }

    // Validar que el email contenga '@' y termine en '.com'
    public static boolean esEmailValido(String email) {
        return email != null && email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.com$");
    }

    // Validar que la cadena contenga al menos una letra mayúscula
    public static boolean contieneMayuscula(String texto) {
        return texto != null && texto.matches(".*[A-Z].*");  // Verifica que haya al menos una mayúscula
    }

    // Validar que la contraseña sea mayor a 8 caracteres, contenga al menos un número, una letra y un carácter especial
    public static boolean esContrasenaValida(String contrasenia) {
        return contrasenia != null && contrasenia.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*(),.?\":{}|<>]).{8,}$");
    }

    // Validar que el ID de usuario tenga exactamente 10 dígitos
    public static boolean esIdUsuarioValido(String idUsuario) {
        return idUsuario != null && idUsuario.matches("\\d{10}");  // Verifica que contenga exactamente 10 dígitos
    }


    // Validar que el ID de lugar de adopción contenga hasta 4 números
    public static boolean esIdLugarAdopcionValido(String idLugarAdopcion) {
        return idLugarAdopcion != null && idLugarAdopcion.matches("\\d{1,4}");  // Verifica hasta 4 dígitos
    }

    // Validar que la fecha esté en formato dd/mm/aaaa
    public static boolean esFechaValida(String fecha) {
        return fecha != null && fecha.matches("^([0-2][0-9]|(3)[0-1])/(0[1-9]|1[0-2])/(19|20)\\d\\d$");
        // El patrón valida dd/mm/yyyy donde el día es de 01-31, mes de 01-12 y el año debe ser de 1900-2099.
    }

    // Validar que la capacidad sea un número mayor a 10
    public static boolean esCapacidadValida(String capacidad) {
        try {
            int capacidadInt = Integer.parseInt(capacidad);  // Convertir la cadena a un número
            return capacidadInt > 10;  // Validar que sea mayor que 10
        } catch (NumberFormatException e) {
            return false;  // Si no es un número válido, devolver false
        }
    }

    // Validar que la edad sea un número mayor o igual a 1
    public static boolean esEdadValida(String edad) {
        try {
            int edadInt = Integer.parseInt(edad);  // Convertir la cadena a un número
            return edadInt >= 1;  // Validar que sea mayor o igual a 1
        } catch (NumberFormatException e) {
            return false;  // Si no es un número válido, devolver false
        }
    }

    // Validar que el sexo sea "hembra" o "macho"
    public static boolean esSexoValido(String sexo) {
        return sexo != null && (sexo.equalsIgnoreCase("hembra") || sexo.equalsIgnoreCase("macho"));
    }

}



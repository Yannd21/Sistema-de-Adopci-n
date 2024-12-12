package consola;

import util.validacion;

import java.util.Scanner;

public class SubMenuIngresodeSistema {
    public void mostrarSubMenu() {
        System.out.println("**********************************************");
        System.out.println("-----Ingresar al sistema-----");
        System.out.println("**********************************************");
        System.out.println("1. Ingresar Usuario y Contraseña");
        System.out.println("2. Crear nuevo usuario ");
    }

    public void seleccionarOpcion(int opcion) {
        Scanner scanner = new Scanner(System.in);
        switch (opcion) {
            case 1:
                String nombreusuario;
                do {
                    System.out.print("Nombre Usuario: ");
                    nombreusuario = scanner.nextLine();

                    // Validar que el nombre de usuario contenga al menos una letra mayúscula
                    if (!validacion.contieneMayuscula(nombreusuario)) {
                        System.out.println("El nombre de usuario debe contener al menos una letra mayúscula. Intenta nuevamente.");
                    }
                } while (!validacion.contieneMayuscula(nombreusuario));

                System.out.println("Nombre de usuario registrado correctamente: " + nombreusuario);

                String contrasenia;

                do {
                    System.out.print("Ingrese Contraseña: ");
                    contrasenia = scanner.nextLine();

                    if (!validacion.esContrasenaValida(contrasenia)) {
                        System.out.println("La contraseña debe tener más de 8 caracteres, contener al menos un número, una letra y un carácter especial. Intenta nuevamente.");
                    }

                } while (!validacion.esContrasenaValida(contrasenia));  // Repetir hasta que sea válida

                System.out.println("Contraseña registrada correctamente.");
                System.out.print(" Ingresando al sistema . . . . .");
                System.out.println("..................................");
                System.out.println(" --------- BIENVENIDO ------- ");
                System.out.println("..................................");
                break;

            case 2: // Crear nuevo usuario
                System.out.println("Ingrese un  Id Usuario:");
                String idusuario;
                do {
                    System.out.print("Id Usuario: ");
                    idusuario = scanner.nextLine();

                    // Validar que el ID tenga exactamente 10 dígitos
                    if (!validacion.esIdUsuarioValido(idusuario)) {
                        System.out.println("El ID debe contener exactamente 10 dígitos. Intenta nuevamente.");
                    }
                } while (!validacion.esIdUsuarioValido(idusuario));  // Repetir hasta que tenga 10 dígitos
                System.out.println("ID de usuario registrado correctamente: " + idusuario);

                String nombreUsuario;
                do {
                    System.out.print("Nombre Usuario: ");
                    nombreUsuario = scanner.nextLine();

                    // Validar que el nombre de usuario contenga al menos una letra mayúscula
                    if (!validacion.contieneMayuscula(nombreUsuario)) {
                        System.out.println("El nombre de usuario debe contener al menos una letra mayúscula. Intenta nuevamente.");
                    }
                } while (!validacion.contieneMayuscula(nombreUsuario));

                System.out.println("Nombre de usuario registrado correctamente: " + nombreUsuario);
                System.out.println("Usuario: " + nombreUsuario);

                // Pedir contraseña
                do {
                    System.out.print("Ingrese Contraseña: ");
                    contrasenia = scanner.nextLine();

                    if (!validacion.esContrasenaValida(contrasenia)) {
                        System.out.println("La contraseña debe tener más de 8 caracteres, contener al menos un número, una letra y un carácter especial. Intenta nuevamente.");
                    }
                } while (!validacion.esContrasenaValida(contrasenia));

                // Confirmar la contraseña
                String repetirContrasenia;
                do {
                    System.out.print("Confirmar Contraseña: ");
                    repetirContrasenia = scanner.nextLine();

                    // Validar si las contraseñas coinciden
                    if (!contrasenia.equals(repetirContrasenia)) {
                        System.out.println("Las contraseñas no coinciden. Intenta nuevamente.");
                    }
                } while (!contrasenia.equals(repetirContrasenia)); // Repetir hasta que coincidan

                System.out.println("Contraseña confirmada correctamente.");
                System.out.println("..................................");
                System.out.println(" --------- Usuario Creado ------- ");
                System.out.println("..................................");
                System.out.println("Id Usuario: " + idusuario);
                System.out.println("Nombre Usuario: " + nombreUsuario);
                break;

            case 6: // Salir
                System.out.println("Regresando al menu principal");
                break;

            default:
                System.out.println("Opción Invalida.");
        }
    }
}

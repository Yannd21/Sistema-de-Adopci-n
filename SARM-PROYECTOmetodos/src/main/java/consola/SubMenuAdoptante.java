package consola;

import util.validacion;

import java.util.Scanner;

public class SubMenuAdoptante {
    private int MAX_ADOPTANTES = 25; // Tamaño máximo del arreglo
    private String[][] adoptantes = new String[MAX_ADOPTANTES][7]; // Arreglo bidimensional para almacenar datos
    private int adoptanteCount = 0; // Contador de adoptantes registrados

    public void mostrarSubMenu() {
        System.out.println("**********************************************");
        System.out.println("---- Gestión de Adoptantes ----");
        System.out.println("**********************************************");
        System.out.println("1. Crear adoptante");
        System.out.println("2. Modificar adoptante");
        System.out.println("3. Consultar adoptante");
        System.out.println("4. Eliminar adoptante");
    }

    public void seleccionarOpcion(int opcion) {
        Scanner scanner = new Scanner(System.in);

        switch (opcion) {
            case 1: // Crear adoptante
                if (adoptanteCount >= MAX_ADOPTANTES) {
                    System.out.println("No se pueden registrar más adoptantes. Límite alcanzado.");
                    break;
                }
                System.out.println("Ingrese los Datos del Adoptante:");
                System.out.println("----------------------------------");

                String id;
                do {
                    System.out.print("ID del Adoptante: ");
                    id = scanner.nextLine();
                    if (!validacion.esIdValido(id)) {
                        System.out.println("El ID debe contener exactamente 10 números. Intenta nuevamente.");
                    }
                } while (!validacion.esIdValido(id));

                String nombre;
                do {
                    System.out.print("Nombre: ");
                    nombre = scanner.nextLine();
                    if (!validacion.soloLetras(nombre)) {
                        System.out.println("El nombre debe contener solo letras. Intenta nuevamente.");
                    }
                } while (!validacion.soloLetras(nombre));

                String edad;
                do {
                    System.out.print("Edad: ");
                    edad = scanner.nextLine();
                    if (!validacion.esMayorDeEdad(edad)) {
                        System.out.println("La edad debe ser mayor o igual a 18. Intenta nuevamente.");
                    }
                } while (!validacion.esMayorDeEdad(edad));

                System.out.print("Dirección: ");
                String direccion = scanner.nextLine();

                String telefono;
                do {
                    System.out.print("Teléfono: ");
                    telefono = scanner.nextLine();
                    if (!validacion.esTelefonoValido(telefono)) {
                        System.out.println("El teléfono debe contener exactamente 10 dígitos. Intenta nuevamente.");
                    }
                } while (!validacion.esTelefonoValido(telefono));

                System.out.print("Ocupación: ");
                String ocupacion = scanner.nextLine();

                String email;
                do {
                    System.out.print("Email: ");
                    email = scanner.nextLine();
                    if (!validacion.esEmailValido(email)) {
                        System.out.println("El email debe contener '@' y terminar con '.com'. Intenta nuevamente.");
                    }
                } while (!validacion.esEmailValido(email));

                // Guardar datos en el arreglo
                adoptantes[adoptanteCount][0] = id;
                adoptantes[adoptanteCount][1] = nombre;
                adoptantes[adoptanteCount][2] = edad;
                adoptantes[adoptanteCount][3] = direccion;
                adoptantes[adoptanteCount][4] = telefono;
                adoptantes[adoptanteCount][5] = ocupacion;
                adoptantes[adoptanteCount][6] = email;
                adoptanteCount++;

                System.out.println("Adoptante registrado con éxito.");
                break;

            case 2: // Modificar adoptante
                System.out.print("Ingrese el ID del adoptante a modificar: ");
                String idModificar = scanner.nextLine();
                int indexModificar = buscarAdoptantePorID(idModificar);
                if (indexModificar == -1) {
                    System.out.println("Adoptante no encontrado.");
                } else {
                    System.out.println("Ingrese los nuevos datos del adoptante (deje en blanco para no modificar):");
                    System.out.print("Nombre (" + adoptantes[indexModificar][1] + "): ");
                    String nuevoNombre = scanner.nextLine();
                    if (!nuevoNombre.isEmpty()) adoptantes[indexModificar][1] = nuevoNombre;

                    System.out.print("Edad (" + adoptantes[indexModificar][2] + "): ");
                    String nuevaEdad = scanner.nextLine();
                    if (!nuevaEdad.isEmpty() && validacion.esMayorDeEdad(nuevaEdad)) {
                        adoptantes[indexModificar][2] = nuevaEdad;
                    }

                    System.out.print("Dirección (" + adoptantes[indexModificar][3] + "): ");
                    String nuevaDireccion = scanner.nextLine();
                    if (!nuevaDireccion.isEmpty()) adoptantes[indexModificar][3] = nuevaDireccion;

                    System.out.print("Teléfono (" + adoptantes[indexModificar][4] + "): ");
                    String nuevoTelefono = scanner.nextLine();
                    if (!nuevoTelefono.isEmpty() && validacion.esTelefonoValido(nuevoTelefono)) {
                        adoptantes[indexModificar][4] = nuevoTelefono;
                    }

                    System.out.print("Ocupación (" + adoptantes[indexModificar][5] + "): ");
                    String nuevaOcupacion = scanner.nextLine();
                    if (!nuevaOcupacion.isEmpty()) adoptantes[indexModificar][5] = nuevaOcupacion;

                    System.out.print("Email (" + adoptantes[indexModificar][6] + "): ");
                    String nuevoEmail = scanner.nextLine();
                    if (!nuevoEmail.isEmpty() && validacion.esEmailValido(nuevoEmail)) {
                        adoptantes[indexModificar][6] = nuevoEmail;
                    }

                    System.out.println("Adoptante modificado con éxito.");
                }
                break;

            case 3: // Consultar adoptante
                System.out.print("Ingrese el ID del adoptante a consultar: ");
                String idConsultar = scanner.nextLine();
                int indexConsultar = buscarAdoptantePorID(idConsultar);
                if (indexConsultar == -1) {
                    System.out.println("Adoptante no encontrado.");
                } else {
                    System.out.println("Datos del adoptante:");
                    System.out.println("ID: " + adoptantes[indexConsultar][0]);
                    System.out.println("Nombre: " + adoptantes[indexConsultar][1]);
                    System.out.println("Edad: " + adoptantes[indexConsultar][2]);
                    System.out.println("Dirección: " + adoptantes[indexConsultar][3]);
                    System.out.println("Teléfono: " + adoptantes[indexConsultar][4]);
                    System.out.println("Ocupación: " + adoptantes[indexConsultar][5]);
                    System.out.println("Email: " + adoptantes[indexConsultar][6]);
                }
                break;

            case 4: // Eliminar adoptante
                System.out.print("Ingrese el ID del adoptante a eliminar: ");
                String idEliminar = scanner.nextLine();
                int indexEliminar = buscarAdoptantePorID(idEliminar);
                if (indexEliminar == -1) {
                    System.out.println("Adoptante no encontrado.");
                } else {
                    for (int i = indexEliminar; i < adoptanteCount - 1; i++) {
                        adoptantes[i] = adoptantes[i + 1];
                    }
                    adoptanteCount--;
                    System.out.println("Adoptante eliminado con éxito.");
                }
                break;

            case 6: // Salir
                System.out.println("Regresando al menú principal...");
                break;

            default: // Opción inválida
                System.out.println("Opción inválida.");
        }
    }

    private void nuevaCacidadMaxAdoptantes() {
        MAX_ADOPTANTES *= 2; // Duplica el tamaño
        String[][] nuevaCapacidad = new String[MAX_ADOPTANTES][7];
        for (int i = 0; i < adoptanteCount; i++) {
            nuevaCapacidad[i] = adoptantes[i];
        }
        adoptantes = nuevaCapacidad;
        System.out.println("La capacidad de adoptantes ha sido actualizada a " + MAX_ADOPTANTES + " adoptantes.");
    }
    private int buscarAdoptantePorID(String id) {
        for (int i = 0; i < adoptanteCount; i++) {
            if (adoptantes[i][0].equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
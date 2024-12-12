package consola;

import util.validacion;

import java.util.Scanner;

public class SubMenuSolicitudAdopcion {
    private final int MAX_SOLICITUDES = 25;
    private String[][] solicitudes = new String[MAX_SOLICITUDES][5];
    private int solicitudCount = 0;

    public void mostrarSubMenu() {
        System.out.println("**********************************************");
        System.out.println("---- Gestión de Solicitudes de Adopción ----");
        System.out.println("**********************************************");
        System.out.println("1. Crear solicitud de adopción");
        System.out.println("2. Modificar solicitud de adopción");
        System.out.println("3. Consultar solicitud de adopción");
        System.out.println("4. Eliminar solicitud de adopción");
    }

    public void seleccionarOpcion(int opcion) {
        Scanner scanner = new Scanner(System.in);

        switch (opcion) {
            case 1: // Crear solicitud
                if (solicitudCount >= MAX_SOLICITUDES) {
                    System.out.println("No se pueden registrar más solicitudes. Límite alcanzado.");
                    break;
                }
                System.out.println("Ingrese los Datos de la Solicitud de Adopción:");
                System.out.println("------------------------------------------------");

                System.out.print("ID de la solicitud: ");
                String idSolicitud = scanner.nextLine();

                System.out.print("Nombre del adoptante: ");
                String nombreAdoptante = scanner.nextLine();

                System.out.print("ID de la mascota: ");
                String idMascota = scanner.nextLine();

                System.out.print("Fecha de solicitud (dd/mm/aaaa): ");
                String fechaSolicitud = scanner.nextLine();

                System.out.print("Estado (pendiente/aprobada/rechazada): ");
                String estado = scanner.nextLine();

                // Guardar datos
                solicitudes[solicitudCount][0] = idSolicitud;
                solicitudes[solicitudCount][1] = nombreAdoptante;
                solicitudes[solicitudCount][2] = idMascota;
                solicitudes[solicitudCount][3] = fechaSolicitud;
                solicitudes[solicitudCount][4] = estado;
                solicitudCount++;

                System.out.println("Solicitud registrada con éxito.");
                break;

            case 2: // Modificar solicitud
                System.out.print("Ingrese el ID de la solicitud a modificar: ");
                String idModificar = scanner.nextLine();
                int indexModificar = buscarSolicitudPorID(idModificar);
                if (indexModificar == -1) {
                    System.out.println("Solicitud no encontrada.");
                } else {
                    System.out.println("Ingrese los nuevos datos de la solicitud (deje en blanco para no modificar):");
                    System.out.print("Nombre del adoptante (" + solicitudes[indexModificar][1] + "): ");
                    String nuevoNombre = scanner.nextLine();
                    if (!nuevoNombre.isEmpty()) solicitudes[indexModificar][1] = nuevoNombre;

                    System.out.print("ID de la mascota (" + solicitudes[indexModificar][2] + "): ");
                    String nuevoIDMascota = scanner.nextLine();
                    if (!nuevoIDMascota.isEmpty()) solicitudes[indexModificar][2] = nuevoIDMascota;

                    System.out.print("Fecha de solicitud (" + solicitudes[indexModificar][3] + "): ");
                    String nuevaFecha = scanner.nextLine();
                    if (!nuevaFecha.isEmpty()) solicitudes[indexModificar][3] = nuevaFecha;

                    System.out.print("Estado (" + solicitudes[indexModificar][4] + "): ");
                    String nuevoEstado = scanner.nextLine();
                    if (!nuevoEstado.isEmpty()) solicitudes[indexModificar][4] = nuevoEstado;

                    System.out.println("Solicitud modificada con éxito.");
                }
                break;

            case 3: // Consultar solicitud
                System.out.print("Ingrese el ID de la solicitud a consultar: ");
                String idConsultar = scanner.nextLine();
                int indexConsultar = buscarSolicitudPorID(idConsultar);
                if (indexConsultar == -1) {
                    System.out.println("Solicitud no encontrada.");
                } else {
                    System.out.println("Datos de la solicitud:");
                    System.out.println("ID: " + solicitudes[indexConsultar][0]);
                    System.out.println("Nombre del adoptante: " + solicitudes[indexConsultar][1]);
                    System.out.println("ID de la mascota: " + solicitudes[indexConsultar][2]);
                    System.out.println("Fecha de solicitud: " + solicitudes[indexConsultar][3]);
                    System.out.println("Estado: " + solicitudes[indexConsultar][4]);
                }
                break;

            case 4: // Eliminar solicitud
                System.out.print("Ingrese el ID de la solicitud a eliminar: ");
                String idEliminar = scanner.nextLine();
                int indexEliminar = buscarSolicitudPorID(idEliminar);
                if (indexEliminar == -1) {
                    System.out.println("Solicitud no encontrada.");
                } else {
                    for (int i = indexEliminar; i < solicitudCount - 1; i++) {
                        solicitudes[i] = solicitudes[i + 1];
                    }
                    solicitudCount--;
                    System.out.println("Solicitud eliminada con éxito.");
                }
                break;

            case 6: // Salir
                System.out.println("Regresando al menú principal...");
                break;

            default: // Opción inválida
                System.out.println("Opción inválida.");
        }
    }

    private int buscarSolicitudPorID(String id) {
        for (int i = 0; i < solicitudCount; i++) {
            if (solicitudes[i][0].equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
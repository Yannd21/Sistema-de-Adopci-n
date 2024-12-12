package consola;

import util.validacion;


import java.util.Scanner;

public class SubMenuLugarAdopcion {
    private int MAX_LUGARES = 25;
    private String[][] lugaresDeAdopcion = new String[MAX_LUGARES][4];
    private int lugarCount = 0;

    public void mostrarSubMenu() {
        System.out.println("**********************************************");
        System.out.println("---- Gestión de Lugares de Adopción ----");
        System.out.println("**********************************************");
        System.out.println("1. Agregar lugar de adopción");
        System.out.println("2. Modificar lugar de adopción");
        System.out.println("3. Consultar lugar de adopción");
        System.out.println("4. Eliminar lugar de adopción");
    }

    public void seleccionarOpcion(int opcion) {
        Scanner scanner = new Scanner(System.in);

        switch (opcion) {
            case 1: // Agregar lugar de adopción
                if (lugarCount >= MAX_LUGARES) {
                    System.out.println("No se pueden registrar más lugares. Límite alcanzado.");
                    break;
                }
                System.out.println("Ingrese los Datos del Lugar de Adopción:");
                System.out.println("----------------------------------------");

                System.out.print("ID del lugar: ");
                String id = scanner.nextLine();

                System.out.print("Nombre del lugar: ");
                String nombre = scanner.nextLine();

                System.out.print("Dirección: ");
                String direccion = scanner.nextLine();

                System.out.print("Teléfono de contacto: ");
                String telefono = scanner.nextLine();

                // Guardar datos
                lugaresDeAdopcion[lugarCount][0] = id;
                lugaresDeAdopcion[lugarCount][1] = nombre;
                lugaresDeAdopcion[lugarCount][2] = direccion;
                lugaresDeAdopcion[lugarCount][3] = telefono;
                lugarCount++;

                System.out.println("Lugar de adopción registrado con éxito.");
                break;

            case 2: // Modificar lugar de adopción
                System.out.print("Ingrese el ID del lugar a modificar: ");
                String idModificar = scanner.nextLine();
                int indexModificar = buscarLugarPorID(idModificar);
                if (indexModificar == -1) {
                    System.out.println("Lugar de adopción no encontrado.");
                } else {
                    System.out.println("Ingrese los nuevos datos del lugar (deje en blanco para no modificar):");
                    System.out.print("Nombre (" + lugaresDeAdopcion[indexModificar][1] + "): ");
                    String nuevoNombre = scanner.nextLine();
                    if (!nuevoNombre.isEmpty()) lugaresDeAdopcion[indexModificar][1] = nuevoNombre;

                    System.out.print("Dirección (" + lugaresDeAdopcion[indexModificar][2] + "): ");
                    String nuevaDireccion = scanner.nextLine();
                    if (!nuevaDireccion.isEmpty()) lugaresDeAdopcion[indexModificar][2] = nuevaDireccion;

                    System.out.print("Teléfono (" + lugaresDeAdopcion[indexModificar][3] + "): ");
                    String nuevoTelefono = scanner.nextLine();
                    if (!nuevoTelefono.isEmpty()) lugaresDeAdopcion[indexModificar][3] = nuevoTelefono;

                    System.out.println("Lugar de adopción modificado con éxito.");
                }
                break;

            case 3: // Consultar lugar de adopción
                System.out.print("Ingrese el ID del lugar a consultar: ");
                String idConsultar = scanner.nextLine();
                int indexConsultar = buscarLugarPorID(idConsultar);
                if (indexConsultar == -1) {
                    System.out.println("Lugar de adopción no encontrado.");
                } else {
                    System.out.println("Datos del lugar de adopción:");
                    System.out.println("ID: " + lugaresDeAdopcion[indexConsultar][0]);
                    System.out.println("Nombre: " + lugaresDeAdopcion[indexConsultar][1]);
                    System.out.println("Dirección: " + lugaresDeAdopcion[indexConsultar][2]);
                    System.out.println("Teléfono: " + lugaresDeAdopcion[indexConsultar][3]);
                }
                break;

            case 4: // Eliminar lugar de adopción
                System.out.print("Ingrese el ID del lugar a eliminar: ");
                String idEliminar = scanner.nextLine();
                int indexEliminar = buscarLugarPorID(idEliminar);
                if (indexEliminar == -1) {
                    System.out.println("Lugar de adopción no encontrado.");
                } else {
                    for (int i = indexEliminar; i < lugarCount - 1; i++) {
                        lugaresDeAdopcion[i] = lugaresDeAdopcion[i + 1];
                    }
                    lugarCount--;
                    System.out.println("Lugar de adopción eliminado con éxito.");
                }
                break;

            case 6: // Salir
                System.out.println("Regresando al menú principal...");
                break;

            default: // Opción inválida
                System.out.println("Opción inválida.");
        }
    }
    private void nuevaCacidadMaxLugares() {
        MAX_LUGARES *= 2; // Duplica el tamaño
        String[][] nuevaCapacidad = new String[MAX_LUGARES][7];
        for (int i = 0; i < lugarCount; i++) {
            nuevaCapacidad[i] = lugaresDeAdopcion[i];
        }
        lugaresDeAdopcion = nuevaCapacidad;
        System.out.println("Luagres de adopción ha sido actualizada a " + MAX_LUGARES + " lugares de adopción.");
    }

    private int buscarLugarPorID(String id) {
        for (int i = 0; i < lugarCount; i++) {
            if (lugaresDeAdopcion[i][0].equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
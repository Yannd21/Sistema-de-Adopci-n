package consola;

import util.validacion;

import java.util.Scanner;

public class SubMenuMascotas {
    private final int MAX_MASCOTAS = 25;
    private String[][] mascotas = new String[MAX_MASCOTAS][5];
    private int mascotaCount = 0;

    public void mostrarSubMenu() {
        System.out.println("**********************************************");
        System.out.println("---- Gestión de Mascotas ----");
        System.out.println("**********************************************");
        System.out.println("1. Registrar mascota");
        System.out.println("2. Modificar mascota");
        System.out.println("3. Consultar mascota");
        System.out.println("4. Eliminar mascota");
    }

    public void seleccionarOpcion(int opcion) {
        Scanner scanner = new Scanner(System.in);

        switch (opcion) {
            case 1: // Registrar mascota
                if (mascotaCount >= MAX_MASCOTAS) {
                    System.out.println("No se pueden registrar más mascotas. Límite alcanzado.");
                    break;
                }
                System.out.println("Ingrese los Datos de la Mascota:");
                System.out.println("--------------------------------");

                System.out.print("ID de la mascota: ");
                String id = scanner.nextLine();

                System.out.print("Nombre de la mascota: ");
                String nombre = scanner.nextLine();

                System.out.print("Especie: ");
                String especie = scanner.nextLine();

                System.out.print("Raza: ");
                String raza = scanner.nextLine();

                System.out.print("Edad (en años): ");
                String edad = scanner.nextLine();

                // Guardar datos
                mascotas[mascotaCount][0] = id;
                mascotas[mascotaCount][1] = nombre;
                mascotas[mascotaCount][2] = especie;
                mascotas[mascotaCount][3] = raza;
                mascotas[mascotaCount][4] = edad;
                mascotaCount++;

                System.out.println("Mascota registrada con éxito.");
                break;

            case 2: // Modificar mascota
                System.out.print("Ingrese el ID de la mascota a modificar: ");
                String idModificar = scanner.nextLine();
                int indexModificar = buscarMascotaPorID(idModificar);
                if (indexModificar == -1) {
                    System.out.println("Mascota no encontrada.");
                } else {
                    System.out.println("Ingrese los nuevos datos de la mascota (deje en blanco para no modificar):");
                    System.out.print("Nombre (" + mascotas[indexModificar][1] + "): ");
                    String nuevoNombre = scanner.nextLine();
                    if (!nuevoNombre.isEmpty()) mascotas[indexModificar][1] = nuevoNombre;

                    System.out.print("Especie (" + mascotas[indexModificar][2] + "): ");
                    String nuevaEspecie = scanner.nextLine();
                    if (!nuevaEspecie.isEmpty()) mascotas[indexModificar][2] = nuevaEspecie;

                    System.out.print("Raza (" + mascotas[indexModificar][3] + "): ");
                    String nuevaRaza = scanner.nextLine();
                    if (!nuevaRaza.isEmpty()) mascotas[indexModificar][3] = nuevaRaza;

                    System.out.print("Edad (" + mascotas[indexModificar][4] + "): ");
                    String nuevaEdad = scanner.nextLine();
                    if (!nuevaEdad.isEmpty()) mascotas[indexModificar][4] = nuevaEdad;

                    System.out.println("Mascota modificada con éxito.");
                }
                break;

            case 3: // Consultar mascota
                System.out.print("Ingrese el ID de la mascota a consultar: ");
                String idConsultar = scanner.nextLine();
                int indexConsultar = buscarMascotaPorID(idConsultar);
                if (indexConsultar == -1) {
                    System.out.println("Mascota no encontrada.");
                } else {
                    System.out.println("Datos de la mascota:");
                    System.out.println("ID: " + mascotas[indexConsultar][0]);
                    System.out.println("Nombre: " + mascotas[indexConsultar][1]);
                    System.out.println("Especie: " + mascotas[indexConsultar][2]);
                    System.out.println("Raza: " + mascotas[indexConsultar][3]);
                    System.out.println("Edad: " + mascotas[indexConsultar][4]);
                }
                break;

            case 4: // Eliminar mascota
                System.out.print("Ingrese el ID de la mascota a eliminar: ");
                String idEliminar = scanner.nextLine();
                int indexEliminar = buscarMascotaPorID(idEliminar);
                if (indexEliminar == -1) {
                    System.out.println("Mascota no encontrada.");
                } else {
                    for (int i = indexEliminar; i < mascotaCount - 1; i++) {
                        mascotas[i] = mascotas[i + 1];
                    }
                    mascotaCount--;
                    System.out.println("Mascota eliminada con éxito.");
                }
                break;

            case 6: // Salir
                System.out.println("Regresando al menú principal...");
                break;

            default: // Opción inválida
                System.out.println("Opción inválida.");
        }
    }

    private int buscarMascotaPorID(String id) {
        for (int i = 0; i < mascotaCount; i++) {
            if (mascotas[i][0].equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
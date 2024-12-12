package consola;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Menu menu = new Menu();
        SubMenuIngresodeSistema subMenuIngresodeSistema = new SubMenuIngresodeSistema();

        SubMenuAdoptante subMenuAdoptante = new SubMenuAdoptante();

        SubMenuLugarAdopcion subMenuLugarAdopcion = new SubMenuLugarAdopcion();

        SubMenuMascotas subMenuMascotas = new SubMenuMascotas();

        SubMenuSolicitudAdopcion subMenuSolicitudAdopcion = new SubMenuSolicitudAdopcion();

        int opcion;

        do {
            menu.mostrarMenu();
            System.out.print("Seleccione una Opcion:");
            opcion = scanner.nextInt();
//Gestion:
            switch (opcion) {
                case 1: //Ingreso Sistema
                    int subOpcion1;
                    do {
                        subMenuIngresodeSistema.mostrarSubMenu();
                        System.out.println("Seleccione una Opcion del Submenu: ");
                        subOpcion1 = scanner.nextInt();
                        subMenuIngresodeSistema.seleccionarOpcion(subOpcion1);
                    } while (subOpcion1 == 6);// Regresar al menú principal
                    break;

                case 2: //Adoptantes
                    int subOpcion2;
                    do {
                        subMenuAdoptante.mostrarSubMenu();
                        System.out.print("Seleccione una Opcion del Submenu: ");
                        subOpcion2 = scanner.nextInt();
                        subMenuAdoptante.seleccionarOpcion(subOpcion2);
                    } while (subOpcion2 == 6);// Regresar al menú principal
                    break;
                case 3: //Lugar Adopcion
                    int subOpcion3;
                    do {
                        subMenuLugarAdopcion.mostrarSubMenu();
                        System.out.print("Seleccione una Opcion del Submenu: ");
                        subOpcion3 = scanner.nextInt();
                        subMenuLugarAdopcion.seleccionarOpcion(subOpcion3);
                    } while (subOpcion3 ==6);// Regresar menu principal
                    break;
                case 4: //Mascotas
                    int subOpcion4;
                    do {
                        subMenuMascotas.mostrarSubMenu();
                        System.out.println("Seleccione una Opcion del Submenu: ");
                        subOpcion4 = scanner.nextInt();
                        subMenuMascotas.seleccionarOpcion(subOpcion4);
                    }while (subOpcion4 ==6);// Regresar al menú principal
                    break;
                case 5: //Solicitudes
                    int subOpcion5;
                    do {
                        subMenuSolicitudAdopcion.mostrarSubMenu();
                        System.out.println("Seleccione una Opcion del Submenu: ");
                        subOpcion5 = scanner.nextInt();
                        subMenuSolicitudAdopcion.seleccionarOpcion(subOpcion5);
                    } while (subOpcion5 ==6);// Regresar al menú principal
                    break;
                case 7: // Salir
                    System.out.println("Saliendo del sistema...");
                    opcion = 0;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion !=0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("***************************************");
        System.out.println("--Menu Principal--");
        System.out.println("***************************************");
        System.out.println("1. Ingresar al Sistema");
        System.out.println("2. Gestionar Adoptante");
        System.out.println("3. Gestionar Lugar de Adopcion");
        System.out.println("4. Gestionar Mascotas");
        System.out.println("5. Gestionar Solicitud de Adopcion");
        System.out.println("7. Salir del Sistema");
    }
}


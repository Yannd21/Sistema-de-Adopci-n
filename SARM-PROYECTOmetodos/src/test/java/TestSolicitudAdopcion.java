import dominio.SolicitudAdopcion;

public class TestSolicitudAdopcion {
    public static void main(String[] args) {

        SolicitudAdopcion solicitud1 = new SolicitudAdopcion();
        System.out.println("constructor por defecto:");
        System.out.println(solicitud1.toString());

        SolicitudAdopcion solicitud2 = new SolicitudAdopcion("2024-12-01", "María Pérez", 2);
        System.out.println("\nconstructor con parámetros:");
        System.out.println(solicitud2.toString());


        solicitud2.setFecha("2024-12-05");
        solicitud2.setNombreadoptante(" Martin Perez ");
        solicitud2.setId(3);

        System.out.println("\nDatos Modificados");
        System.out.println("Fecha: " + solicitud2.getFecha());
        System.out.println("Adoptante: " + solicitud2.getNombreadoptante());
        System.out.println("Id: " + solicitud2.getId());
    }
}


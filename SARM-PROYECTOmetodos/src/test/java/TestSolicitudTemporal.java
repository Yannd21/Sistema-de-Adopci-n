import dominio.SolicitudTemporal;

public class TestSolicitudTemporal {
    public static void main(String[] args) {

        SolicitudTemporal solicitud1 = new SolicitudTemporal();
        System.out.println("constructor por defecto:");
        System.out.println(solicitud1.getDetalle());


        SolicitudTemporal solicitud2 = new SolicitudTemporal(14, "Mudanza pronta", "2024-12-30");
        System.out.println("\nconstructor con parámetros:");
        System.out.println(solicitud2.getDetalle());

        solicitud2.setDuracionDias(10);
        solicitud2.setMotivo(" Pocos dias en el pais ");
        solicitud2.setFechaFin(" 2024-12-31");


        System.out.println("\nDatos Modificados");
        System.out.println("Duracion dias: " + solicitud2.getDuracionDias());
        System.out.println("Motivo: " + solicitud2.getMotivo());
        System.out.println("Fecha fin: " + solicitud2.getFechaFin());
    }
}


import dominio.Adoptante;
import dominio.Mascota;

public class TestMascota {
    private static Mascota m;
    public static void main(String[] args) {
        testConstructor();
        System.out.println(m.getSolicitudes());
        System.out.println(m.getNumeroDeSolicitudes());
        testConsultar();
        testAgregar();;
        System.out.println("... Buscar ... ");
        testBuscar(0);
    }
    public static void testConstructor() {
        m = new Mascota();
    }
    public static void testConsultar() {
        System.out.println(m.consultarSolicitudes());
    }
    public static void testAgregar() {
        m.agregarSolicitudAdopcion("15/05/2020", "Paula",1719368504);
    }
    public static void testBuscar(int pos) {
        System.out.println(m.buscarSolicitudes(pos));


        System.out.println();
        System.out.println();

        Mascota mascota1 = new Mascota();
        System.out.println("Constructor por defecto:");
        System.out.println(mascota1.toString());

        Mascota mascota2 = new Mascota("Zeus", "Gato", 2, "Hembra");
        System.out.println("\nconstructor con parámetros:");
        System.out.println(mascota2.toString());

        System.out.println("\nDatos modificados");
        mascota2.setNombre("Coco");
        mascota2.setEspecie("Gato");
        mascota2.setEdad(3);
        mascota2.setSexo("Hembra");

        System.out.println("Nombre: " + mascota2.getNombre());
        System.out.println("Especie: " + mascota2.getEspecie());
        System.out.println("Edad: " + mascota2.getEdad());
        System.out.println("Sexo: " +  mascota2.getSexo());
    }
}


import dominio.CentroAdopcion;

public class TestCentroAdopcion {
    private static CentroAdopcion c;

    public static void main(String[] args) {
        testConstructor();
        System.out.println(c.getLugares());
        System.out.println(c.getNumeroDeLugares());
        testConsultarLugares();
        testAgregarLugar();
        System.out.println("... Buscar Lugar de Adopcion ... ");
        testBuscarLugares(0);
        System.out.println();
        testConsultarUsuarios();
        testAgregarUsuario();
        System.out.println("... Buscar Usuario ... ");
        testBuscarUsuarios(0);
    }

    public static void testConstructor() {
        c = new CentroAdopcion();
    }
    public static void testConsultarLugares() {
        System.out.println(c.consultarLugares());
    }

    public static void testAgregarLugar() {
        c.agregarLugarAdopcion("Huellitas", "La Colon 4", 15, "12/05/2020", 1452);
    }

    public static void testBuscarLugares(int pos) {
        System.out.println(c.buscarLugares(pos));
    }

    public static void testConsultarUsuarios() {
        System.out.println(c.consultarUsuarios());
    }

    public static void testAgregarUsuario() {
        c.agregarUsuario(1754366621, "Carlos", "16_deMarzo");
    }

    public static void testBuscarUsuarios(int pos) {
        System.out.println(c.buscarUsuarios(pos));


        System.out.println();
        System.out.println();

        CentroAdopcion centro1 = new CentroAdopcion();
        System.out.println("constructor por defecto:");
        System.out.println(centro1.toString());


        CentroAdopcion centro2 = new CentroAdopcion("Av. Guayasamin 742", "Lunes a Viernes: 8 AM - 6 PM", 25);
        System.out.println("\nCentro de Adopción creado con constructor con parámetros:");
        System.out.println(centro2.toString());


        centro2.setDireccion("Av. Principal 123");
        System.out.println("\nDirección actualizada del centro:");
        System.out.println("Nueva dirección: " + centro2.getDireccion());

        centro2.setHorario("Sábado y Domingo: 9 AM - 5 PM");
        System.out.println("Nuevo horario: " + centro2.getHorario());

        centro2.setCapacidadMaxima(30);
        System.out.println("Nueva capacidad máxima: " + centro2.getCapacidadMaxima());




    }
}


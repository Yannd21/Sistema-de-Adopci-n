import dominio.Adoptante;

public class TestAdoptante {
        private static Adoptante r;
    public static void main(String[] args) {
            testConstructor();
            System.out.println(r.getSolicitudes());
            System.out.println(r.getNumeroDeSolicitudes());
            testConsultar();
            testAgregar();;
            System.out.println("... Buscar ... ");
            testBuscar(0);
    }
        public static void testConstructor() {
                r = new Adoptante();
        }
        public static void testConsultar() {
                System.out.println(r.consultarSolicitudes());
        }
         public static void testAgregar() {
           r.agregarSolicitudAdopcion("02/10/2022", "Ana",1754366504);
        }
        public static void testBuscar(int pos) {
                System.out.println(r.buscarSolicitudes(pos));


            System.out.println();
            Adoptante adoptante1 = new Adoptante();
            System.out.println("constructor por defecto:");
            System.out.println(adoptante1.toString());

            Adoptante adoptante2 = new Adoptante(
                    "Ana",
                    25,
                    1728390123,
                    "Av. Principal 456",
                    "0987654321",
                    "Ingeniera",
                    "ana25@gmail.com"
            );
            System.out.println("\nconstructor con parámetros:");
            System.out.println(adoptante2.toString());

            adoptante2.setNombre("Andrea");
            adoptante2.setEdad(26);
            adoptante2.setId(1728300000);
            adoptante2.setDireccion("Calle Secundaria 789");
            adoptante2.setTelefono("0999999999");
            adoptante2.setOcupacion("Doctora");
            adoptante2.setEmail("andrea.doctor@gmail.com");

            System.out.println("\nDetalles del adoptante modificado:");
            System.out.println("Nombre: " + adoptante2.getNombre());
            System.out.println("Edad: " + adoptante2.getEdad());
            System.out.println("ID: " + adoptante2.getId());
            System.out.println("Dirección: " + adoptante2.getDireccion());
            System.out.println("Teléfono: " + adoptante2.getTelefono());
            System.out.println("Ocupación: " + adoptante2.getOcupacion());
            System.out.println("Email: " + adoptante2.getEmail());

        }
    }

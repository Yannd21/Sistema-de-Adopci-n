import dominio.LugarAdopcion;

public class TestLugarAdopcion {
    private static LugarAdopcion l;
    public static void main(String[] args) {
        testConstructor();
        System.out.println(l.getMascotas());
        System.out.println(l.getNumeroDeMascotas());
        testConsiltarMascota();
        testAgregarMascota();
        System.out.println("... Busacar Mascota ...");
        testBuscarMascota(0);
    }
    public static void testConstructor(){
        l = new LugarAdopcion();
    }
    public static void testConsiltarMascota(){
        System.out.println(l.consultarMascotas());
    }
    public static void testAgregarMascota(){
        l.agragarMascota("Lili","Gato",2,"Hembra");
    }
    public static void testBuscarMascota(int pos){
        System.out.println(l.buscarMascotas(pos));


        System.out.println();
        System.out.println();

        LugarAdopcion lugar1 = new LugarAdopcion();
        System.out.println(" constructor por defecto:");
        System.out.println(lugar1.toString());


        LugarAdopcion lugar2 = new LugarAdopcion("Hogar Animal", "Calle Libertad 456", 30, "02/12/2022",02);
        System.out.println("\nconstructor con parámetros:");
        System.out.println(lugar2.toString());


        System.out.println("\nconstructor con parámetros:");
        System.out.println(lugar2.toString());
        lugar2.setFecha("18/05/2023");
        lugar2.setId( 03 );


        System.out.println("\nModificar datos");
        lugar2.setNombre(" Huellitas");
        lugar2.setDireccion(" La mena ");
        lugar2.setCapacidad(40);


        System.out.println("ID: " + lugar2.getId());
        System.out.println("Nombre: " + lugar2.getNombre());
        System.out.println("Direccion: " + lugar2.getDireccion());
        System.out.println("Capacidad: " + lugar2.getCapacidad());
        System.out.println("Fecha: " + lugar2.getFecha());


    }
}


import dominio.Usuario;

public class TestUsuario {
    public static void main(String[] args) {

        Usuario usuario1 = new Usuario();
        System.out.println("constructor por defecto:");
        System.out.println(usuario1.toString());


        Usuario usuario2 = new Usuario(2, "María López", "abril_18");
        System.out.println("\nconstructor con parámetros:");
        System.out.println(usuario2.toString());

        usuario2.setIdUsuario(3);
        usuario2.setNombre("Alan Carrasco");
        usuario2.setContrasenia("m123");


        System.out.println("\nDatos Modificados");
        System.out.println("Id: "+usuario2.getIdUsuario());
        System.out.println("Nombre: "+usuario2.getNombre());
        System.out.println("Contraseña: "+usuario2.getContrasenia());
    }
}


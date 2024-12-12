package dominio;

public class LugarAdopcion {
    // Atributos
    private String nombre;
    private String direccion;
    private int capacidad;
    private String fecha;
    private int id;
    //Arreglo mascotas
    private Mascota[]mascotas;
    private int numeroDeMascotas;
    //Relacion Centro de Adopcion
    private CentroAdopcion centro;

    /**
     * CONSTRUCTOR POR DEFECTO
     */
    public LugarAdopcion() {
        this.nombre = "Refugio de Animales";
        this.direccion = "Av. Siempre Viva 123";
        this.capacidad = 50;
        this.fecha = "09/10/2020";
        this.id =01;
        this.numeroDeMascotas = 0;
        this.mascotas = new Mascota[10];
    }

    /**
     * CONSTRUCTOR CON PARÁMETROS
     */
    public LugarAdopcion(String nombre, String direccion, int capacidad, String fecha, int id) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.capacidad = capacidad;
        this.fecha= fecha;
        this.id= id;
        this.mascotas = new Mascota[10];
        this.numeroDeMascotas = 0;
    }
    public LugarAdopcion(String nombre, String direccion, int capacidad, String fecha, int id, int capacidadMaximaMascotas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.capacidad = capacidad;
        this.fecha= fecha;
        this.id= id;
        this.mascotas = new Mascota[capacidadMaximaMascotas];
        this.numeroDeMascotas = 0;
    }
    /**
     *MÉTODOS SETTER
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("Por favor llenar Campo Obligatorio: Nombre.");
        }
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        if (direccion == null || direccion.isEmpty()) {
            throw new IllegalArgumentException("Por favor llenar Campo Obligatorio: Dirección.");
        }
        this.direccion = direccion;
    }

    public void setCapacidad(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("Por favor llenar Campo Obligatorio: Capacidad debe ser mayor a 0.");
        }
        this.capacidad = capacidad;
    }

    public void setFecha(String fecha) {
        if (fecha == null || fecha.isEmpty()) {
            throw new IllegalArgumentException("Por favor llenar Campo Obligatorio: Fecha.");
        }
        this.fecha = fecha;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID debe ser mayor a 0.");
        }
        this.id = id;
    }
    public void setMascotas(Mascota[] mascotas) {
        if (mascotas == null) {
            throw new IllegalArgumentException("El arreglo de mascotas no puede ser nulo.");
        }
        if (mascotas.length == 0) {
            throw new IllegalArgumentException("El arreglo de mascotas no puede estar vacío.");
        }
        if (mascotas.length > capacidad) {  // capacidad máxima del lugar
            throw new IllegalArgumentException("El número de mascotas excede la capacidad del lugar.");
        }
        this.mascotas = mascotas;
    }
    public void setNumeroDeMascotas(int numeroDeMascotas) {
        if (numeroDeMascotas < 0) {
            throw new IllegalArgumentException("El número de mascotas no puede ser negativo.");
        }
        if (mascotas == null) {
            throw new IllegalStateException("El arreglo de mascotas no está inicializado.");
        }
        if (numeroDeMascotas > mascotas.length) {
            throw new IllegalArgumentException("El número de mascotas no puede ser mayor que el tamaño del arreglo.");
        }
        this.numeroDeMascotas = numeroDeMascotas;
    }

    public void setCentro(CentroAdopcion centro) {
        this.centro = centro;
    }

    /**
     *MÉTODOS GETTER
     */
    public String getNombre() {

        return nombre;
    }
    public String getDireccion() {

        return direccion;
    }
    public int getCapacidad() {

        return capacidad;
    }
    public String getFecha() {

        return fecha;
    }
    public int getId() {

        return id;
    }
    public Mascota[] getMascotas() {
        return mascotas;
    }
    public int getNumeroDeMascotas() {
        return numeroDeMascotas;
    }
    public CentroAdopcion getCentro() {
        return centro;
    }

    @Override
    public String toString() {
        return "Lugar de Adopción: " +
                "\nNombre: " + nombre +
                "\nDirección: " + direccion +
                "\nCapacidad: " + capacidad+
                "\nFecha: " + fecha+
                "\nId: " + id;
    }
    // Agregar mascotas
    public void agragarMascota(String nombre, String especie, int edad, String sexo){
        if (numeroDeMascotas>= mascotas.length){
            throw new IllegalStateException(" No se puede agragr mas solicitudes");
        }
        mascotas[numeroDeMascotas] = new Mascota(nombre,especie,edad,sexo);
        numeroDeMascotas++;
    }
    /**
     * Consultar solicitudes
     *
     * @return solicitud registrada
     */

    //Consultar mascotas
    public String consultarMascotas() {
        String texto = "";
        for (int i = 0; i < numeroDeMascotas; i++)
            texto += mascotas[i] + "/r/n";

        return texto;
    }
    //Buscar mascotas
    public Mascota buscarMascotas(int pos){
        return mascotas [pos] ;
    }
}



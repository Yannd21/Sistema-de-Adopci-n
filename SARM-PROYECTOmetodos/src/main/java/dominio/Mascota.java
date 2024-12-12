package dominio;

public class Mascota {

    // Atributos
    private String nombre;
    private String especie;
    private int edad;
    private String sexo;
    // Arreglo solicitudes de adopcion
    private SolicitudAdopcion[] solicitudes;
    private int numeroDeSolicitudes;
    //Relacion Lugar de Adopcion
    private LugarAdopcion lugar;

    /**
     * CONSTRUCTOR POR DEFECTO
     */
    public Mascota() {
        this.nombre = "Firulais";
        this.especie = "Perro";
        this.edad = 3;
        this.sexo = "Macho";
        this.numeroDeSolicitudes = 0;
        this.solicitudes = new SolicitudAdopcion[3];
    }

    /**
     * CONSTRUCTOR CON PARÁMETROS
     */
    public Mascota(String nombre, String especie, int edad, String sexo) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.sexo = sexo;
        this.solicitudes = new SolicitudAdopcion[3];
        this.numeroDeSolicitudes = 0;
    }
    public Mascota(String nombre, String especie, int edad, String sexo,int capacidadMaximaSolicitudes) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.sexo = sexo;
        this.solicitudes = new SolicitudAdopcion[capacidadMaximaSolicitudes];
        this.numeroDeSolicitudes = 0;
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

    public void setEspecie(String especie) {
        if (especie == null || especie.isEmpty()) {
            throw new IllegalArgumentException("Por favor llenar Campo Obligatorio: Especie.");
        }
        this.especie = especie;
    }

    public void setEdad(int edad) {
        if (edad <= 0) {
            throw new IllegalArgumentException(" Edad debe ser mayor a 0.");
        }
        this.edad = edad;
    }

    public void setSexo(String sexo) {
        if (sexo == null || sexo.isEmpty()) {
            throw new IllegalArgumentException("Por favor llenar Campo Obligatorio: Sexo.");
        }
        this.sexo = sexo;
    }
    public void setSolicitudes(SolicitudAdopcion[] solicitudes) {
        if (solicitudes == null || solicitudes.length == 0) {
            throw new IllegalArgumentException("El arreglo de solicitudes no puede estar vacío.");
        }
        this.solicitudes = solicitudes;
    }

    public void setNumeroDeSolicitudes(int numeroDeSolicitudes) {
        if (numeroDeSolicitudes < 0) {
            throw new IllegalArgumentException("El número de solicitudes no puede ser negativo.");
        } else if (solicitudes != null && numeroDeSolicitudes > solicitudes.length) {
            throw new IllegalArgumentException("El número de solicitudes no puede exceder la capacidad del arreglo.");
        }
        this.numeroDeSolicitudes = numeroDeSolicitudes;
    }
    public void setLugar(LugarAdopcion lugar) {
        this.lugar = lugar;
    }

    /**
     *MÉTODOS GETTER
     */
    public String getNombre() {
        return nombre;
    }
    public String getEspecie() {
        return especie;
    }
    public int getEdad() {
        return edad;
    }
    public String getSexo() {
        return sexo;
    }
    public SolicitudAdopcion[] getSolicitudes() {
        return solicitudes;
    }
    public int getNumeroDeSolicitudes() {
        return numeroDeSolicitudes;
    }
    public LugarAdopcion getLugar() {
        return lugar;
    }

    @Override
    public String toString() {
        return "Mascota: " +
                "\nNombre: " + nombre +
                "\nEspecie: " + especie +
                "\nEdad: " + edad +
                "\nSexo: " + sexo;
    }
    //Agregar solicitudes
    public void agregarSolicitudAdopcion(String fecha, String nombreadoptante, int Id){
        // Verificar si el arreglo está lleno antes de agregar una nueva solicitud
        if (numeroDeSolicitudes >= solicitudes.length) {
            throw new IllegalStateException("No se pueden agregar más solicitudes.");
        }
        // Si no está lleno, agregar la nueva solicitud en la posición actual
        solicitudes[numeroDeSolicitudes] = new SolicitudAdopcion(fecha,nombreadoptante,Id);
        numeroDeSolicitudes++;
    }

    /**
     * Consultar solicitudes
     *
     * @return solicitud registrada
     */

    //Consultar solicitudes
    public String consultarSolicitudes() {
        String texto = "";
        for (int i = 0; i < numeroDeSolicitudes; i++)
            texto += solicitudes[i] + "/r/n";

        return texto;
    }
    //Buscar solicitudes
    public SolicitudAdopcion buscarSolicitudes(int pos){
        return solicitudes [pos] ;
    }
}


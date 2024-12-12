package dominio;

public class Adoptante {

    /**
     * Atributos
     */

    private String nombre;
    private int edad;
    private int id;
    private String direccion;
    private String telefono;
    private String ocupacion;
    private String email;
    // Arreglo solicitudes de adopcion
    private SolicitudAdopcion[] solicitudes;
    private int numeroDeSolicitudes;


    /**
     * CONSTRUCTOR POR DEFECTO
     */
    public Adoptante() {
        this.nombre = " Luis ";
        this.edad = 20 ;
        this.id = 1719598423;
        this.direccion = " Calle Amazonas";
        this.telefono = " 0968728312";
        this.email = " luis14@gmil.com";
        this.ocupacion = " Profesor ";
        this.numeroDeSolicitudes = 0;
        this.solicitudes = new SolicitudAdopcion[5];

    }

    /**
     * CONSTRUCTOR CON PARÁMETROS
     */
    public Adoptante(String nombre, int edad, int id, String direccion, String telefono, String ocupacion, String email) {
        this.nombre = nombre;
        this.edad = edad;
        this.id = id;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.ocupacion = ocupacion;
        this.solicitudes = new SolicitudAdopcion[5];
        this.numeroDeSolicitudes = 0;
    }

    public Adoptante(String nombre, int edad,int id, String direccion, String telefono, String ocupacion, String email, int capacidadMaximaSolicitudes) {
        this.nombre = nombre;
        this.edad = edad;
        this.id = id;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.ocupacion = ocupacion;
        this.solicitudes = new SolicitudAdopcion[capacidadMaximaSolicitudes];
        this.numeroDeSolicitudes = 0;

    }

    /**
     * MÉTODOS SETTEr VALIDACIONES DE FONDO
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }
    public void setEdad(int edad) {
        if (edad < 18) {
            throw new IllegalArgumentException("La edad debe ser mayor o igual a 18 años.");
        }
        this.edad = edad;
    }
    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que 0.");
        }
        this.id = id;
    }
    public void setDireccion(String direccion) {
        if (direccion == null || direccion.isEmpty()) {
            throw new IllegalArgumentException("La dirección no puede estar vacía.");
        }
        this.direccion = direccion;
    }
    public void setTelefono(String telefono) {
        if (telefono == null || telefono.isEmpty()) {
            throw new IllegalArgumentException("El teléfono no puede estar vacío.");
        }
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("El email no puede estar vacío.");
        }
        this.email = email;
    }

    public void setOcupacion(String ocupacion) {
        if (ocupacion == null || ocupacion.isEmpty()) {
            throw new IllegalArgumentException("La ocupación no puede estar vacía.");
        }
        this.ocupacion = ocupacion;
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

    /**
     * MÉTODOS GETTER
     */
    public String getNombre() {
        return nombre;
    }
    public int getEdad() {
        return edad;
    }
    public int getId() {
        return id;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getEmail() {
        return email;
    }
    public String getOcupacion() {
        return ocupacion;
    }
    public SolicitudAdopcion[] getSolicitudes() {
        return solicitudes;
    }
    public int getNumeroDeSolicitudes() {
        return numeroDeSolicitudes;
    }

    /**
     * Imprime Todo
     */
    @Override
    public String toString() {
        return " Adoptante: \n " +
                " \n Nombre adoptante: " + nombre +
                " \n Edad adoptante: " + edad +
                " \n Dirección adoptante : " + direccion +
                " \n Telefono adoptante : " + telefono +
                " \n Email adoptante : " + email +
                " \n Ocupación adoptante : " + ocupacion +
                "\nNumero de solicitudes: " + numeroDeSolicitudes;


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
    private void redimensionarSolicitudes(){
        int nuevaCapacidad =solicitudes.length*2;
        SolicitudAdopcion[] nuevaCap=new SolicitudAdopcion[nuevaCapacidad];
        System.arraycopy(solicitudes,0, nuevaCap,0, solicitudes.length);
        solicitudes = nuevaCap;
        System.out.println("La capacidad de solicitudes ha sido redimensionado a" + nuevaCapacidad + " solicitudes.");
    }

    /**
     * Consultar solicitudes
     *
     * @return solicitud registrada
     */

    //Consultar solicitudes
    public String consultarSolicitudes() {
        StringBuilder texto = new StringBuilder();
        for (int i = 0; i < numeroDeSolicitudes; i++){
            texto.append(solicitudes[i]).append("\r\n");
    }
        return texto.toString();
    }
    //Buscar solicitudes
    public SolicitudAdopcion buscarSolicitudes(int pos){
        if (pos<0 || pos >= numeroDeSolicitudes){
            throw new IllegalArgumentException("Posicion de solicitud invalida");
        }
        return solicitudes [pos] ;
    }

    //Metodo para modificar solicitudes
    public void modificarSolicitudeAdopcion(int index, String newFecha, String newNombreAdp, int newId){
        if (index < 0 || index >= numeroDeSolicitudes){
            throw new IllegalArgumentException("Indice de solicitud invalido");
        }
        SolicitudAdopcion solicitud = solicitudes[index];
        if (newFecha != null && !newFecha.isEmpty()){
            solicitud.setFecha(newFecha);
        }
        if (newNombreAdp != null && !newNombreAdp.isEmpty()){
            solicitud.setNombreadoptante(newNombreAdp);
        }
        if (newId>0){
            solicitud.setId(newId);
        }
        System.out.println("Solicitud de Adopcion modificada correctamente");

    }
}




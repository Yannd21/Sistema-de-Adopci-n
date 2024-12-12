package dominio;

public class CentroAdopcion {
    /**
     * Atributos
     */
    private String direccion;
    private String horario;
    private int capacidadMaxima;
    //Arreglo lugares de adopcion
    private LugarAdopcion[] lugares;
    private int numeroDeLugares;
    /// Arreglo usuarios
    private Usuario[] usuarios;
    private int numeroDeUsuarios;

    /**
     * Constructor por defecto
     */
    public CentroAdopcion() {
        this.direccion = "calle 10 de Agosto";
        this.horario = " Lunes a viernes 8 am - 6 pm ";
        this.capacidadMaxima = 10;
        this.numeroDeLugares = 0;
        this.lugares = new LugarAdopcion[3];
        this.numeroDeUsuarios = 0;
        this.usuarios = new Usuario[3];
    }

    /**
     * Constructor con parámetros
     */
    public CentroAdopcion(String direccion, String horario, int capacidadMaxima) {
        this.direccion = direccion;
        this.horario = horario;
        this.capacidadMaxima = capacidadMaxima;
        this.lugares = new LugarAdopcion[3];
        this.numeroDeLugares = 0;
        this.usuarios = new Usuario[3];
        this.numeroDeUsuarios = 0;
    }

    public CentroAdopcion(String direccion, String horario, int capacidadMaxima, int capacidadMaximaLugares, int capacidadMaximaUsuarios) {
        this.direccion = direccion;
        this.horario = horario;
        this.capacidadMaxima = capacidadMaxima;
        this.lugares = new LugarAdopcion[capacidadMaximaLugares];
        this.numeroDeLugares = 0;
        this.usuarios = new Usuario[capacidadMaximaUsuarios];
        this.numeroDeUsuarios = 0;
    }

    /**
     * Setters
     */
    public void setDireccion(String direccion) {
        if (direccion == null || direccion.isEmpty()) {
            throw new IllegalArgumentException("La dirección no puede estar vacía.");
        }
        this.direccion = direccion;
    }

    public void setHorario(String horario) {
        if (horario == null || horario.isEmpty()) {
            throw new IllegalArgumentException("El horario no puede estar vacío.");
        }
        this.horario = horario;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        if (capacidadMaxima <= 0) {
            throw new IllegalArgumentException("La capacidad máxima debe ser mayor a 0.");
        }
        this.capacidadMaxima = capacidadMaxima;
    }

    public void setLugares(LugarAdopcion[] lugares) {
        if (lugares == null) {
            throw new IllegalArgumentException("El arreglo de lugares no puede ser nulo.");
        }
        if (lugares.length == 0) {  // Validación de arreglo vacío
            throw new IllegalArgumentException("El arreglo de lugares no puede estar vacío.");
        }
        this.lugares = lugares;
    }

    public void setNumeroDeLugares(int numeroDeLugares) {
        if (numeroDeLugares < 0) {
            throw new IllegalArgumentException("El número de lugares no puede ser negativo.");
        }
        this.numeroDeLugares = numeroDeLugares;
    }

    public void setUsuarios(Usuario[] usuarios) {
        if (usuarios == null) {
            throw new IllegalArgumentException("El arreglo de usuarios no puede ser nulo.");
        }
        if (usuarios.length == 0) {  // Validación de arreglo vacío
            throw new IllegalArgumentException("El arreglo de usuarios no puede estar vacío.");
        }
        this.usuarios = usuarios;
    }

    public void setNumeroDeUsuarios(int numeroDeUsuarios) {
        if (numeroDeUsuarios < 0) {
            throw new IllegalArgumentException("El número de usuarios no puede ser negativo.");
        }
        this.numeroDeUsuarios = numeroDeUsuarios;
    }

    /**
     * Getters
     */
    public String getDireccion() {
        return direccion;
    }

    public String getHorario() {
        return horario;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public LugarAdopcion[] getLugares() {
        return lugares;
    }

    public int getNumeroDeLugares() {
        return numeroDeLugares;
    }

    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public int getNumeroDeUsuarios() {
        return numeroDeUsuarios;
    }


    @Override
    public String toString() {
        return "Centro de Adopción: " +
                "\nDirección: " + direccion +
                "\nHorario: " + horario +
                "\nCapacidad Máxima: " + capacidadMaxima;
    }

    //Agregar lugares
    public void agregarLugarAdopcion(String nombre, String direccion, int capacidad, String fecha, int id) {
        if (numeroDeLugares >= lugares.length) {
            throw new IllegalStateException(" No se puede agregar mas lugares ");
        }
        lugares[numeroDeLugares] = new LugarAdopcion(nombre, direccion, capacidad, fecha, id);
        numeroDeLugares++;
    }
        /**
         * Consultar solicitudes
         *
         * @return solicitud registrada
         */
        //Consultar lugares
        public String consultarLugares(){
            String texto = "";
            for (int i=0; i<  numeroDeLugares; i++){
                texto += lugares[i] +"/r/n";
            }
            return texto;
        }

         // Buscar un lugares
        public LugarAdopcion buscarLugares(int pos){
            return lugares [pos] ;
        }

        //Agregar un usuario

        public void agregarUsuario(int idUsuario, String nombre, String contrasenia) {
            if (numeroDeUsuarios >= usuarios.length) {
                throw new IllegalStateException("No se puede agregar más usuarios");
            }
            usuarios[numeroDeUsuarios] = new Usuario(idUsuario, nombre, contrasenia);
            numeroDeUsuarios++;
        }


        // Consultar los usuarios
        public String consultarUsuarios() {
            String texto = " ";
            for (int i = 0; i < numeroDeUsuarios; i++)
                texto += usuarios[i] + "/r/n";
                return texto;

        }


         // Buscar un usuario por su índice
        public Usuario buscarUsuarios(int pos) {
            return usuarios[pos];
        }
}




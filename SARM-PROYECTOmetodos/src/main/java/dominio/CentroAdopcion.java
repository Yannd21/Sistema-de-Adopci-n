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
            redimensionarLugares();
        }
        lugares[numeroDeLugares] = new LugarAdopcion(nombre, direccion, capacidad, fecha, id);
        numeroDeLugares++;
    }

        // Metodo para redimensionar el arreglo de lugares
    private void redimensionarLugares() {
         int nuevaCapacidad = lugares.length * 2;
         LugarAdopcion[] nuevoCap = new LugarAdopcion[nuevaCapacidad];
         System.arraycopy(lugares, 0, nuevoCap, 0, lugares.length); lugares = nuevoCap;
         System.out.println("El arreglo de lugares ha sido actializaddo a " + nuevaCapacidad + " lugares.");
    }

        /**
         * Consultar solicitudes
         *
         * @return solicitud registrada
         */
        //Consultar lugares
        public String consultarLugares(){
            StringBuilder texto = new StringBuilder();
            for (int i=0; i<  numeroDeLugares; i++){
                texto.append(lugares[i]).append("\r\n");
            }
            return texto.toString();
        }

         // Buscar un lugares
        public LugarAdopcion buscarLugares(int pos){
            if (pos <0 || pos >= numeroDeLugares){
                throw new IllegalArgumentException("Posicion de lugar invalida");
            }
            return lugares [pos] ;
        }

        //Moficar-Editar lugares
    public void modificarLugarAdopcion(int index, String nuevoNombre, String nuevaDireccion, int nuevaCapacidad, String nuevaFecha, int nuevoId){
        if (index < 0 || index >= numeroDeLugares){
            throw new IllegalArgumentException("Indice de lugar invalido");
        }
        LugarAdopcion lugar = lugares[index];
        if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
            lugar.setNombre(nuevoNombre);
        }
        if (nuevaDireccion != null && !nuevaDireccion.isEmpty()) {
            lugar.setDireccion(nuevaDireccion);
        }
        if (nuevaCapacidad>0){
            lugar.setCapacidad(nuevaCapacidad);
        }
        if (nuevaFecha != null && !nuevaFecha.isEmpty()){
            lugar.setFecha(nuevaFecha);
        }
        if (nuevoId>0){
            lugar.setId(nuevoId);
        }
        System.out.println("Lugar de adopcion modificado correctamente");
    }

        //Agregar un usuario

        public void agregarUsuario(int idUsuario, String nombre, String contrasenia) {
            if (numeroDeUsuarios >= usuarios.length) {
                redimensionarUsuarios();
            }
            usuarios[numeroDeUsuarios] = new Usuario(idUsuario, nombre, contrasenia);
            numeroDeUsuarios++;
        }

        // Metodo redimensionar el arreglo de usuarios
    private void redimensionarUsuarios() {
            int nuevaCapacidad = usuarios.length * 2;
            Usuario[] nuevoArreglo = new Usuario[nuevaCapacidad];
            System.arraycopy(usuarios, 0, nuevoArreglo, 0, usuarios.length);
            usuarios = nuevoArreglo; System.out.println("El arreglo de usuarios ha sido redimensionado a " + nuevaCapacidad + " usuarios.");
        }


        // Consultar los usuarios
        public String consultarUsuarios() {
            StringBuilder texto = new StringBuilder();
            for (int i = 0; i < numeroDeUsuarios; i++) {
                texto.append(usuarios[i]).append("\r\n");
            }
                return texto.toString();

        }

         // Buscar un usuario por su índice
        public Usuario buscarUsuarios(int pos) {
            if (pos <0 || pos >= numeroDeUsuarios){
                throw new IllegalArgumentException("Posicion de usuario invalido");
            }
            return usuarios[pos];
        }
    public void modificarUsuario(int index, int nuevoId, String nuevoNombre, String nuevaContrasenia) {
        if (index < 0 || index >= numeroDeUsuarios) {
            throw new IllegalArgumentException("Índice de usuario inválido.");
        }
        Usuario usuario = usuarios[index];
        if (nuevoId > 0) {
            usuario.setIdUsuario(nuevoId);
        }
        if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
            usuario.setNombre(nuevoNombre);
        }
        if (nuevaContrasenia != null && !nuevaContrasenia.isEmpty()){
            usuario.setContrasenia(nuevaContrasenia);
        }
        System.out.println("Usuario modificado exitosamente");
    }
}




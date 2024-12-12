package dominio;

public class SolicitudAdopcion {

    /**
     * Atributos
      */

    private String fecha;
    private String nombreadoptante;
    private int Id;
    // Relacion con Adontante
    private Adoptante adoptante;
    // Relacion con mascota
    private Mascota mascota;


    /**
     * Constructor por defecto
      */

    public SolicitudAdopcion() {
        this.fecha = "2024-11-22";
        this.nombreadoptante = "Luis Fernández";
        this.Id = 1;
    }

    /**
     * Constructor con parámetros
     */
    public SolicitudAdopcion(String fecha, String adoptante, int Id) {
        this.fecha = fecha;
        this.nombreadoptante = adoptante;
        this.Id = Id;
    }

    /**
     *MÉTODOS SETTER
     */
    public void setFecha(String fecha) {
        if (fecha == null || fecha.isEmpty()) {
            throw new IllegalArgumentException("Por favor llenar Campo Obligatorio: Fecha.");
        }
        this.fecha = fecha;
    }

    public void setNombreadoptante(String nombreadoptante) {
        if (nombreadoptante == null || nombreadoptante.isEmpty()) {
            throw new IllegalArgumentException("Por favor llenar Campo Obligatorio: Adoptante.");
        }
        this.nombreadoptante = nombreadoptante;
    }
    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser un número positivo.");
        }
        this.Id = id;
    }
    public void setAdoptante(Adoptante adoptante) {
        this.adoptante = adoptante;
    }
    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    /**
     *MÉTODOS GETTER
     */
    public String getFecha() {

        return fecha;
    }
    public String getNombreadoptante() {

        return nombreadoptante;
    }
    public int getId() {

        return Id;
    }
    public Adoptante getAdoptante() {
        return adoptante;
    }
    public Mascota getMascota() {
        return mascota;
    }

    @Override
    public String toString() {
        return "Solicitud de Adopción: " +
                "\nFecha: " + fecha +
                "\nAdoptante: " + nombreadoptante +
                "\nId: " + Id;

    }
}
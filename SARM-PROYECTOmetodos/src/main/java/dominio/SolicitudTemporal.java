package dominio;

public class SolicitudTemporal {
    // Atributos
    private int duracionDias;
    private String motivo;
    private String fechaFin;

    // Constructor por defecto
    public SolicitudTemporal() {
        this.duracionDias = 7;
        this.motivo = "Cuidado temporal por viaje";
        this.fechaFin = "2024-12-15";
    }

    // Constructor con parámetros
    public SolicitudTemporal(int duracionDias, String motivo, String fechaFin) {
        this.duracionDias = duracionDias;
        this.motivo = motivo;
        this.fechaFin = fechaFin;
    }
    /**
     *MÉTODOS SETTER
     */
    public void setDuracionDias(int duracionDias) {
        if (duracionDias <= 0) {
            throw new IllegalArgumentException("Por favor llenar Campo Obligatorio: Duración en días debe ser mayor a 0.");
        }
        this.duracionDias = duracionDias;
    }

    public void setMotivo(String motivo) {
        if (motivo == null || motivo.isEmpty()) {
            throw new IllegalArgumentException("Por favor llenar Campo Obligatorio: Motivo.");
        }
        this.motivo = motivo;
    }

    public void setFechaFin(String fechaFin) {
        if (fechaFin == null || fechaFin.isEmpty()) {
            throw new IllegalArgumentException("Por favor llenar Campo Obligatorio: Fecha de fin.");
        }
        this.fechaFin = fechaFin;
    }

    /**
     *MÉTODOS GETTER
     */
    public int getDuracionDias() {

        return duracionDias;
    }
    public String getMotivo() {

        return motivo;
    }
    public String getFechaFin() {

        return fechaFin;
    }

    // Método adicional

    public String getDetalle() {
        return "Solicitud Temporal: " +
                "\nDuración en días: " + duracionDias +
                "\nMotivo: " + motivo +
                "\nFecha de fin: " + fechaFin;
    }
}
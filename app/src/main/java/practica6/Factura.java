package practica6;

import java.io.Serializable;
/**
 * Verificar que genera un UUID aleatorio donde se haria?
 * ya, que sea en el manejador, que mande llamar al manejador
 */

public class Factura implements Serializable {
    private String concepto;
    private Double monto;
    private Double iva;
    private Double montoTotal;
    private String UUID;
    private Fecha fecha;
    private RFC rfc;
    private Boolean esRecibida;
    /*
    * Constructor
    * */

    public Factura(String concepto, Double monto, Double iva, Double montoTotal, String UUID, Fecha fecha, RFC rfc, Boolean esRecibida) {
        this.concepto = concepto;
        this.monto = monto;
        this.iva = iva;
        this.montoTotal = montoTotal;
        this.UUID = UUID;
        this.fecha = fecha;
        this.rfc = rfc;
        this.esRecibida = esRecibida;
    }

    /**
     * Getters y Setters
     */
    public String getConcepto() {
        return this.concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Double getMonto() {
        return this.monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Double getIva() {
        return this.iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getMontoTotal() {
        return this.montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getUUID() {
        return this.UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public Fecha getFecha() {
        return this.fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public RFC getRfc() {
        return this.rfc;
    }

    public void setRfc(RFC rfc) {
        this.rfc = rfc;
    }

    public Boolean getEsRecibida() {
        return esRecibida;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "\n\tconcepto='" + concepto +
                "\n\tmonto=" + monto +
                "\n\tiva=" + iva +
                "\n\tmontoTotal=" + montoTotal +
                "\n\tUUID='" + UUID + 
                "\n\tfecha=" + fecha +
                "\n\trfc=" + rfc + 
                "\n\tTipo: " + ((esRecibida) ? "Recibida" : "Emitida") +
                "\n}";
    }
}

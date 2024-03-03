package practica6;

import java.io.Serializable;
import java.util.Random;
import java.util.Date;

/**
 * Verificar que genera un UUID aleatorio donde se haria?
 * ya, que sea en el manejador, que mande llamar al manejador
 */

public class Factura implements Serializable {
    /**
     * Identificador
     * Emisor : PersonaFactura
     * receptor: PersonaFactura
     * EsInvalida? : bool
      */
    private String concepto;
    private Double monto;
    private Double iva;
    private Double montoTotal;
    private String UUID;
    private Date fecha;
    private RFC rfc;
    private Boolean validez;

    /*
    * Constructor
    * */

    public Factura(String concepto, Double monto, Double iva, Double montoTotal, String UUID, Date fecha, RFC rfc) {
        this.concepto = concepto;
        this.monto = monto;
        this.iva = iva;
        this.montoTotal = montoTotal;
        this.UUID = UUID;
        this.fecha = fecha;
        this.rfc = rfc;
        this.validez = true; 
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

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public RFC getRfc() {
        return this.rfc;
    }

    public void setRfc(RFC rfc) {
        this.rfc = rfc;
    }

    public Boolean getValidez() {
        return this.validez;
    }

    public void setValidez(Boolean validez) {
        this.validez = validez;
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
                "\n\tvalidez=" + validez +
                "\n}";
    }
}

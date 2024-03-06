package practica6;

import java.io.Serializable;

public class Factura implements Serializable {
    private String concepto;
    private Double monto;
    private Double iva;
    private Double montoTotal;
    private String UUID;
    private Fecha fecha;
    private String rfc;
    
    /*
    * Constructor
    * */
    public Factura(String concepto, Double monto, Double iva, String UUID, Fecha fecha, String rfc) {
        this.concepto = concepto;
        this.monto = monto;
        this.iva = iva;
        this.montoTotal = monto + monto*iva;
        this.UUID = UUID;
        this.fecha = fecha;
        this.rfc = rfc;
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

    public String getRfc() {
        return this.rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    @Override
    public String toString() {
        return "==Factura==" +
                "\n\tConcepto: " + concepto +
                "\n\tMonto: " + monto +
                "\n\tIVA: " + iva +
                "\n\tMonto Total:" + montoTotal +
                "\n\tUUID: " + UUID + 
                "\n\tFecha: " + fecha +
                "\n\tRFC: " + rfc;
    }
}

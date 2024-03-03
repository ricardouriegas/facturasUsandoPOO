package practica6;

import java.io.Serializable;

public class RFC implements Serializable {
    private String nombreCompleto;
    private String direccionFiscal;
    private String email;
    private Boolean tipo;
    

    RFC(String nombreCompleto, String direccionFiscal, String email, Boolean tipo){
        this.nombreCompleto = nombreCompleto;
        this.direccionFiscal = direccionFiscal;
        this.email = email;
        this.tipo = tipo;
    }

    /** 
     * Getters y Setters
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDireccionFiscal() {
        return direccionFiscal;
    }
    public void setDireccionFiscal(String direccionFiscal) {
        this.direccionFiscal = direccionFiscal;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getTipo() {
        return tipo;
    }
    public void setTipo(Boolean tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "RFC{" +
                "\n\tnombreCompleto='" + nombreCompleto +
                "\n\tdireccionFiscal='" + direccionFiscal + 
                "\n\temail='" + email + 
                "\n\ttipo=" + tipo +
                "\n}";
    }
};

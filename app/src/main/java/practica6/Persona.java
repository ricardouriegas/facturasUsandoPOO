package practica6;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre;
    private String apellido;
    private String rfc;
    private String direccionFiscal;
    private String email;
    private Boolean esPersonaFisica;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRfc() {
        return this.rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getDireccionFiscal() {
        return this.direccionFiscal;
    }

    public void setDireccionFiscal(String direccionFiscal) {
        this.direccionFiscal = direccionFiscal;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEsPersonaMoral() {
        return this.esPersonaFisica;
    }

    public void setEsPersonaMoral(Boolean esPersonaFisica) {
        this.esPersonaFisica = esPersonaFisica;
    }

    Persona(String nombre, String apellido, String rfc, String direccionFiscal, String email, Boolean esPersonaFisica){
        this.nombre = nombre;
        this.apellido = apellido;
        this.rfc = rfc;
        this.direccionFiscal = direccionFiscal;
        this.email = email;
        this.esPersonaFisica = esPersonaFisica;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + 
        ((esPersonaFisica) ? "\nApellido :" + apellido : "") +  
        "\nRFC: " + rfc + 
        "\nDirección Fiscal: " + direccionFiscal + 
        "\nEmail: " + email + 
        "\nEs Persona Moral: " + (esPersonaFisica ? "Sí" : "No") + "\n";
    }

}
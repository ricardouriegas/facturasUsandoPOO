package practica6;

import java.io.Serializable;
/**
 * @author Luis Roberto Flores
 * @Collaborator Ricardo Emmanuel Uriegas Ibarra
 * @Collaborator Joshua Nathaniel Arrazola Elizondo
  */

/**
 * Representa una Fecha (día, més, año) ademas que imprime en el formato 
 * dd/MM/yyyy
 */
public class Fecha implements Serializable {
    
    // Variables de instancia
    private int año;
    private int mes;
    private int dia;

    private Fecha(int año, int mes, int dia) {
        this.año = año;
        this.mes = mes;
        this.dia = dia;
    }

    /**
     * Obtiene un objeto Fecha si los parámetros para construir la fecha son
     * válidos, de otra forma, regresa null.
     */
    public static Fecha de(int año, int mes, int dia) {
        return esValida(año, mes, dia) ?  new Fecha(año, mes, dia) : null;
    }

    /**
     * Regresa un objeto Fecha a partir de una fecha en String en un formato
     * determinado. Los formatos permitidos son dd/MM/yyyy, dd-MM-yyyy,
     * yyyy-MM-dd, yyyy/MM/dd. En caso de no poder determinar la fecha, se
     * regresa un null.
     * @param fechaStr Fecha representada en String en los formatos de
     * dd/MM/yyyy, dd-MM-yyyy, yyyy-MM-dd, yyyy/MM/dd
     */
    public static Fecha de(String fechaStr) {

        // Validaciones básicas del formato
        if (fechaStr == null) {
            return null;
        }
        fechaStr = fechaStr.trim();
        if (fechaStr.length() < 10) {
            return null;
        }
        int año = 0, mes = 0, dia = 0;

        // Si el char en ix 2 es un caracter separador y el char en ix 5 es
        // un caracter separador, de determina que es el formato dd/MM/yyyy
        char c2 = fechaStr.charAt(2);
        char c5 = fechaStr.charAt(5);
        if ((c2 == '-' || c2 == '/' || c2 == ' ') && 
                (c5 == '-' || c5 == '/' || c5 == ' ')) {

            // Se obtienen los datos de día, mes y año del String según 
            // sus posiciones.
            dia = NumerosUtil.getInt(fechaStr.substring(0, 2));
            mes = NumerosUtil.getInt(fechaStr.substring(3, 5));
            año = NumerosUtil.getInt(fechaStr.substring(6, 10));
            
            // Se manda llamar la otra función "de", en el que se le especifica
            // los parámetros año, mes y día, según si los datos son correctos, 
            // devolverá un objeto fecha o null.
            return de(año, mes, dia);
        }

        // Si el char en ix 4 es un caracter separador y el char en ix 7 es 
        // un caracter separador, se determina que el formato es yyyy-MM-dd
        char c4 = fechaStr.charAt(4);
        char c7 = fechaStr.charAt(7);
        if ((c4 == '-' || c4 == '/' || c4 == ' ') && 
                (c7 == '-' || c7 == '/' || c7 == ' ')) {
            
            // Se obtienen los datos de día, mes y año del String según 
            // sus posiciones.
            año = NumerosUtil.getInt(fechaStr.substring(0, 4));
            mes = NumerosUtil.getInt(fechaStr.substring(6, 7));
            dia = NumerosUtil.getInt(fechaStr.substring(8, 10));

            return de(año, mes, dia);
        }
        
        // No se pudo determinar en qué formato está la fecha.
        return null;
    }

    /**
     * Determina si una fecha es válida según los parámetros propocionados.
     */
    public static boolean esValida(int año, int mes, int dia) {

        // Comprobación básica de los parámetros proporcionados.
        if ( año < 0 || año > 9999 ||  mes < 1 || mes > 12  ||  
                dia < 1 || dia > 31) {
            return false;
        }

        // TODO: condiciones para los días de los meses.

        switch (mes) {
            case 1:
                if(dia>31) return false;
                break;
            case 2:
                if(esAñoBisiesto(año)&&dia>29){
                    return false;
                } else if(!esAñoBisiesto(año)&&dia>28){
                    return false;
                }
                break;
            case 3:
                if(dia>31) return false;
                break;
            case 4:
                if(dia>30) return false;
                break;
            case 5:
                if(dia>31) return false;
                break;
            case 6:
                if(dia>30) return false;
                break;
            case 7:
                if(dia>30) return false;
                break;
            case 8:
                if(dia>31) return false;
                break;
            case 9:
                if(dia>30) return false;
                break;
            case 10:
                if(dia>31) return false;
                break;
            case 11:
                if(dia>30) return false;
                break;
            case 12:
                if(dia>31) return false;
                break;
            default:
                break;
        }
        
        return true;
    }

    /**
     * Determina si un año es bisiesto.
     * @param año Valor del año a comparar.
     */
    public static boolean esAñoBisiesto(int año) {
        return año % 4 == 0 && año % 100 != 0 || año % 400 == 0;
    }

    /**
     * Obtiene el año de la fecha.
     */
    public final int getAño() { return año; }

    /**
     * Obtiene el més de la fecha. 1 = Enero ... 12 = Diciembre.
     */
    public final int getMes() { return mes; }
    
    /**
     * Obtiene el día de la fecha.
     */
    public final int getDia() { return dia; }

    @Override
    public String toString() {
        final String formato = "%02d/%02d/%04d";
        return String.format(formato, getDia(), getMes(), getAño());
    }
}
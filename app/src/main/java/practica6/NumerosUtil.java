package practica6;

/**
 * Clase con implementaciones para manejo de números.
 * @author L.R.Flores
 */
public final class NumerosUtil {
    
    /**
     * De una String, regresa su representación en int, si es que es un número.
     * Regresa de todas formas un 0 si no se pudo obtener un número del String.
     * @param s String a obtener el int.
     * @return
     */
    public static int getInt(String s) {
        try { return Integer.parseInt(s); } 
        catch (NumberFormatException e) { }
        return 0;
    }

}
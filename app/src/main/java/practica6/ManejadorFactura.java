package practica6;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Date;

/**
 * TODO URIEGAS: modificar el UML y agregar lo de generateRandomString
*/

public class ManejadorFactura{
    final private String appPath = new File("").getAbsolutePath() + "/";
    final String facturasRecibidasFile = appPath + "facturasRecibidas/";
    final String facturasEmitidasFile = appPath + "facturasEmitidas/";
    
    final private Scanner in = new Scanner(System.in);

    private final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    ArrayList<Factura> facturasRecibidas;
    ArrayList<Factura> facturasEmitidas;

    /**
     * Se recupera la informacion de las facturas recibidas y emitidas
     */
    public ManejadorFactura () {
        facturasRecibidas = FileManagement.deserialize(facturasRecibidasFile + "FacturasRecibidas.obj",Factura.class);
        facturasEmitidas = FileManagement.deserialize(facturasEmitidasFile + "FacturasEmitidas.obj", Factura.class);
    }

    /**
     * Función que guarda los datos procesados en el programa
      */
    public void save() {
        FileManagement.serialize(facturasRecibidasFile + "FacturasRecibidas.obj", facturasRecibidas, Factura.class);
        FileManagement.serialize(facturasEmitidasFile + "FacturasEmitidas.obj", facturasEmitidas, Factura.class);
    }

    /**
     * Función que genera un string aleatorio en java
     * @return 
      */
    public String generateRandomString(){
        Random random = new Random();

        do {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 10; i++){
                int index = random.nextInt(CHARACTERS.length());
                char randomChar = CHARACTERS.charAt(index);
                sb.append(randomChar);
            }
            if(verificarRandomString(sb.toString())) return sb.toString();
        } while (true);
    }

    public Boolean verificarRandomString(String rs){
        for(Factura p : facturasEmitidas) if(rs == p.getUUID()) return false;
        for(Factura p : facturasRecibidas) if(rs == p.getUUID()) return false;
        return true;
    }
};

package practica6;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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

    /**
     * Función para listar las facturas recibidas
      */
    public void listarFacturasRecibidas(){    
        if(facturasRecibidas.isEmpty()){
            System.out.println("No hay facturas recibidas registradas");
            return;
        }
        
        int opc;
        do {
            Menus.menuListarFacturasRecibidas();
            opc = Integer.parseInt(in.nextLine());
            switch (opc) {
                case 1:
                    System.out.println("Ingresa el número de mes por el que listar: ");
                    int mes;
                    do {
                        mes = Integer.parseInt(in.nextLine());
                        if(mes>=1&&mes<=12) break;
                        System.out.println("Mes inválido.");
                    } while (true);

                    for(Factura f : facturasRecibidas) if(f.getFecha().getMes()==mes) System.out.println(f.toString());
                    break;
                case 2:
                    System.out.println("Ingresa el año por el que listar: ");
                    int año = Integer.parseInt(in.nextLine());
                    for(Factura f : facturasRecibidas) if(f.getFecha().getAño()==año) System.out.println(f.toString());
                    break;
                case 3:
                    for(Factura f : facturasRecibidas) System.out.println(f.toString());
                    break;
                default:
                    break;
            }
        } while (opc!=0);
    }

    public void agregarFacturaRecibida() {
        
    }

    public void eliminarFactura(){

    }
};

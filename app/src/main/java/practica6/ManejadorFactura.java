package practica6;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ManejadorFactura {
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
    public void save () {
        FileManagement.serialize(facturasRecibidasFile + "FacturasRecibidas.obj", facturasRecibidas, Factura.class);
        FileManagement.serialize(facturasEmitidasFile + "FacturasEmitidas.obj", facturasEmitidas, Factura.class);
    }

    /**
     * Función que genera un string aleatorio en java
     * @return 
      */
    public String generateRandomString () {
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

    public Boolean verificarRandomString (String rs) {
        for(Factura p : facturasEmitidas) if(rs.equals(p.getUUID())) return false;
        for(Factura p : facturasRecibidas) if(rs.equals(p.getUUID())) return false;
        return true;
    }

    /**
     * Función para listar las facturas recibidas
      */
    public void listarFacturasRecibidas () {    
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

    /**
     * Función para agregar una nueva factura
      */
    public void agregarFacturaRecibida (String rfc) {
        System.out.println("=== Usuario encontrado con éxito ===");
        
        String uuid = generateRandomString();
        
        System.out.println("Ingresa el concepto de la factura: ");
        String concepto = in.nextLine();
        
        System.out.println("Ingresa el monto de la factura: ");
        Double monto = Double.parseDouble(in.nextLine());

        System.out.println("Ingresa el IVA: ");
        Double iva;
        do {
            iva = Double.parseDouble(in.nextLine());
            if(iva< 0 || iva > 1)
                System.out.println("IVA inválido, el IVA tiene que ser un valor decimal entre 0 y 1");
            else 
                break;
        } while (true);

        System.out.println("Ingresa la fecha de la factura en formato (dd/mm/yyyy): ");
        Fecha fecha = Fecha.de(in.nextLine());
        do {
            if(fecha!=null) break;
            System.out.println("Fecha inválida: ");
            fecha = Fecha.de(in.nextLine());
        } while (true);

        facturasRecibidas.add(new Factura(concepto, monto, iva, uuid, fecha, rfc));
        System.out.println("El UUID de la factura es: " + uuid);
    }

    public void eliminarFacturaRecibida() {
        System.out.println("Ingrese el UUID de la factura a borrar: ");
        String uuid = in.nextLine();

        for(Factura f : facturasRecibidas){
            if(f.getUUID().equals(uuid)){
                facturasRecibidas.remove(f);
                System.out.println("Factura encontrada y eliminada con éxito");
                return;
            }
        }

        System.out.println("No se encontró la factura");
    }
    
    public void eliminarFacturaEmitida () {
        if(facturasEmitidas.isEmpty()){
            System.out.println("No hay facturas emitidas registradas");
            return;
        }
        
        System.out.println("Ingresa el UUID de la factura a eliminar: ");
        String uuid = in.nextLine();

        for(Factura f : facturasEmitidas){
            if(f.getUUID().equals(uuid)){
                facturasEmitidas.remove(f); 
                System.out.println("Registro encontrado y eliminado con éxito"); 
                return;
            }
        }

        System.out.println("No se encontró el registro a eliminar");
    }

    public void listarFacturasEmitidas () {
        if(facturasEmitidas.isEmpty()){
            System.out.println("No hay facturas emitidas registradas");
            return;
        }
        
        int opc;
        do {
            Menus.menuListarFacturasRecibidas();
            opc = Integer.parseInt(in.nextLine());
            switch (opc) {
                case 1: // Listar por mes
                    System.out.println("Ingresa el número de mes por el que listar: ");
                    int mes;
                    do {
                        mes = Integer.parseInt(in.nextLine());
                        if(mes>=1&&mes<=12) break;
                        System.out.println("Mes inválido.");
                    } while (true);

                    for(Factura f : facturasEmitidas) if(f.getFecha().getMes()==mes) System.out.println(f.toString());
                    break;
                case 2: // Listar por año
                    System.out.println("Ingresa el año por el que listar: ");
                    int año = Integer.parseInt(in.nextLine());
                    for(Factura f : facturasEmitidas) if(f.getFecha().getAño()==año) System.out.println(f.toString());
                    break;
                case 3: // Listar todas
                    for(Factura f : facturasEmitidas) System.out.println(f.toString());
                    break;
                default:
                    break;
            }
        } while (opc!=0);
    }

    public void agregarFacturaEmitida (String rfc) {
        String uuid = generateRandomString();

        System.out.println("Ingresa el concepto de la factura: ");
        String concepto = in.nextLine();

        System.out.println("Ingresa el monto de la factura: ");
        Double monto = Double.parseDouble(in.nextLine());

        System.out.println("Ingresa el IVA: ");
        Double iva;

        do {
            iva = Double.parseDouble(in.nextLine());
            if(iva< 0 || iva > 1)
                System.out.println("IVA inválido, el IVA tiene que ser un valor decimal entre 0 y 1");
            else 
                break;
        } while (true);

        System.out.println("Ingresa la fecha de la factura en formato (dd/mm/yyyy): ");
        Fecha fecha;
        do {
            fecha = Fecha.de(in.nextLine());
            if(fecha==null) break;
            System.out.println("Ingrese una fecha válida");
        } while (true);

        facturasEmitidas.add(new Factura(concepto, monto, iva, uuid, fecha, rfc));
        System.out.println("El UUID de la factura es: " + uuid);
    }

    public void buscarFacturaRecibida () {
        if (facturasRecibidas.isEmpty()){
            System.out.println("No hay facturas recibidas registradas");
            return;
        }

        System.out.println("Ingrese el UUID de la factura: ");
        String uuid = in.nextLine();
        
        for(Factura f : facturasRecibidas){
            if(f.getUUID().equals(uuid)){
                System.out.println(f.toString());
            } else {
                System.out.println("Factura no encontrada");
            }
        }
    }

    public void buscarFacturaEmitida () {
        // if empty 
        if (facturasEmitidas.isEmpty()){
            System.out.println("No hay facturas emitidas registradas");
            return;
        }

        System.out.println("Ingrese el UUID de la factura: ");
        String uuid = in.nextLine();

        for(Factura f : facturasEmitidas){
            if(f.getUUID().equals(uuid)){
                System.out.println(f.toString());
            } else {
                System.out.println("Factura no encontrada");
            }
        }
    }
};

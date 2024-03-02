package practica6;

import java.io.*;
import java.util.Scanner;

public class App{
    final Scanner in = new Scanner(System.in);

    // Se definen los paths de todas las carpetas
    final String appPath = new File("").getAbsolutePath() + "/";
    final String personasFiscalesFile = appPath + "personasFiscales/";
    final String facturasRecibidasFile = appPath + "facturasRecibidas/";
    final String facturarEmitidasFile = appPath + "facturasEmitidas/";

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    void run(){
        verificacionInicial();
        
        // Manejador de personas
        ManejadorPersona mp = new ManejadorPersona();

        int opc;
        do {
            imprimirMenu();
            opc = Integer.parseInt(in.nextLine());
            
            switch (opc) {
                case 1: // Guardar persona fiscal
                    mp.agregarPersona(mp.crearUsuario());
                    break;
                case 2: // Modificar datos de persona fiscal
                    System.out.println("Ingresa el RFC de la persona a modificar: ");
                    mp.modificarPersona(in.nextLine());
                    break;
                case 3: // Guardar factura recibida
                    
                    break;
                case 4: // Borrar factura recibida

                    break;
                case 5: // Emitir factura

                    break;
                case 6: // Cancelar factura emitida 

                    break;
                case 7: // Listar facturas recibidad en año-mes específico

                    break;
                case 8: // Listar facturas emitidas en un año-mes específico
                    
                    break;
                case 9: // Consultar factura por su identificador fiscal

                    break;
                case 10: 
                    System.out.println("=== Gracias por usar el sistema de gestión de facturas ===");
                    break;
                default:    
                    break;
            }
        } while (opc != 10);

        // Se guarda el ArrayList de personas como un binario
        mp.save();
    }   

    /**
     * Función que verifica si existen los archivos necesarios para el funcionamiento del programa
      */
    void verificacionInicial(){
        if(!new File(personasFiscalesFile).exists()) new File(personasFiscalesFile).mkdirs();
        if(!new File(facturasRecibidasFile).exists()) new File(facturasRecibidasFile).mkdirs();
        if(!new File(facturarEmitidasFile).exists()) new File(facturarEmitidasFile).mkdirs();
    }

    /**
     * Menú principal de la aplicación
      */
    void imprimirMenu(){
        System.out.println("1) Guardar persona fiscal");
        System.out.println("2) Modificar datos de persona fiscal");
        System.out.println("3) Guardar factura recibida");
        System.out.println("4) Borrar factura recibida");
        System.out.println("5) Emitir factura");
        System.out.println("6) Cancelar factura emitida");
        System.out.println("7) Listar facturas recibidas de un año-mes específico");
        System.out.println("8) Listar facturas emitidas de un año-mes específico");
        System.out.println("9) Consultar factura por su identificador fiscal");
        System.out.println("10) Salir");
    }
};

package practica6;

import java.util.Scanner;

public class App{
    final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    void run(){
        FileManagement.verificacionInicial();

        // Manejador de personas
        ManejadorPersona mp = new ManejadorPersona();
        ManejadorFactura mf = new ManejadorFactura();

        int opc;
        do {
            System.out.println("=== Bienvenido al sistema de facturas de Ficticia S.A. de C.V. ===");
            Menus.mostrarMenuPrincipal();
            opc = Integer.parseInt(in.nextLine());
            switch (opc) {
                case 1: // Datos fiscales de la empresa
                    
                    break;
                case 2: // Catálogo de personas fiscales
                
                    break;
                case 3: // Gestión de facturas recibidas
                
                    break;
                case 4: // Gestión de facturas emitidas
            
                    break;
                case 5: // Mostrar detalle de factura

                    break;
                default:
                    break;
            }
        } while (opc!=0);

        // Se guarda el ArrayList de personas como un binario
        mp.save();
        mf.save();
    }   

    

};

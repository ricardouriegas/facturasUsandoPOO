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
            mostrarMenuPrincipal();
            opc = Integer.parseInt(in.nextLine());
        } while (opc!=0);

        // Se guarda el ArrayList de personas como un binario
        mp.save();
        mf.save();
    }   

    /**
     * Menú principal de la aplicación
      */
    void mostrarMenuPrincipal() {
        System.out.println("----- Menú de Facturación -----");
        System.out.println("1. Datos Fiscales de la Empresa");
        System.out.println("2. Catálogo de Personas Fiscales");
        System.out.println("3. Gestión de Facturas Recibidas");
        System.out.println("4. Gestión de Facturas Emitidas");
        System.out.println("5. Mostrar Detalle de Factura");
        System.out.println("0. Salir");
    }

    
};

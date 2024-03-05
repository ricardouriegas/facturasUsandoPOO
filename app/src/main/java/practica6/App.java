package practica6;

import java.util.Scanner;

public class App{
    private final Scanner in = new Scanner(System.in);

    // Manejador de personas
    private final ManejadorPersona mp = new ManejadorPersona();
    private final ManejadorFactura mf = new ManejadorFactura();

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    void run(){
        FileManagement.verificacionInicial();

        int opc;
        do {
            System.out.println("=== Bienvenido al sistema de facturas de Ficticia S.A. de C.V. ===");
            Menus.mostrarMenuPrincipal();
            opc = Integer.parseInt(in.nextLine());
            switch (opc) {
                case 1: // Datos fiscales de la empresa
                    datosFiscalesEmpresa();
                    break;
                case 2: // Catálogo de personas fiscales
                    catalogoPersonasFiscales();
                    break;
                case 3: // Gestión de facturas recibidas
                    gestionFacturasRecibidas();
                    break;
                case 4: // Gestión de facturas emitidas
                    
                    break;
                case 5: // Mostrar detalle de factura

                    break;
                default:
                    break;
            }
        } while (opc != 0);

        // Se guarda el ArrayList de personas como un binario
        mp.save();
        mf.save();
    }   

    /**
     * Método que muestra el menú de datos fiscales de la empresa
     * @param void
     * @return void
     */
    void datosFiscalesEmpresa(){
        int opc;
        do {
            Menus.mostrarMenuDatosFiscales();
            opc = Integer.parseInt(in.nextLine());
            switch (opc) {
                case 1: // Mostrar Datos Fiscales Actuales
                    System.out.println("Los datos fiscales de la empresa son: \n" + mp.imprimirPersonaInicial());
                    break;
                case 2: // Modificar Datos Fiscales
                    mp.modificarUsuarioInicial();
                    break;
                default:
                    break;
            }
        } while (opc != 0);
    }

    void catalogoPersonasFiscales(){
        int opc;
        String rfc;
        do {
            Menus.mostrarMenuCatalogoPersonasFiscales();
            opc = Integer.parseInt(in.nextLine());
            switch (opc) {
                case 1: // Agregar Persona Fiscal
                    mp.agregarPersona(mp.crearUsuario());
                    break;
                case 2: // Modificar Persona Fiscal
                    System.out.println("Ingrese el RFC de la persona a modificar: ");
                    rfc = in.nextLine();
                    mp.modificarPersona(rfc);
                    break;
                case 3: // Eliminar Persona Fiscal
                    System.out.println("Ingrese el RFC de la persona a eliminar: ");
                    rfc = in.nextLine();
                    mp.eliminarPersona(rfc);
                    break;
                case 4: // Mostrar Personas Fiscales
                    mp.mostrarPersonas();
                    break;
                default:
                    break;
            }
        } while (opc != 0);
    }

    @SuppressWarnings("null")
    void gestionFacturasRecibidas(){
        int opc;
        do {
            Menus.mostrarMenuGestionFacturasRecibidas();
            opc = Integer.parseInt(in.nextLine());
            switch (opc) {
                case 1: // Listar factura recibida
                    mf.listarFacturasRecibidas();
                    break;
                case 2: 
                    System.out.println("Ingresa el RFC del usuario al que emitirle una factura: ");
                    String rfc = in.nextLine();
                    Persona persona = mp.buscarPersona(rfc);
                    if(persona==null) System.out.println("No se encontró la persona indicada");
                    
                    mf.agregarFacturaRecibida(persona.getRfc());
                    break;
                case 3: 
                    mf.eliminarFacturaRecibida();
                    break;
                default:
                    break;
            }
        } while (opc != 0);
    }

    void gestionFacturasEmitidas () {
        int opc;
        do {
            Menus.mostrarMenuGestionFacturasEmitidas();
            opc = Integer.parseInt(in.nextLine());
            switch (opc) {
                case 1: // Listar factura emitida
                    mf.listarFacturasEmitidas();
                    break;
                case 2: // Agregar Factura Emitida
                    System.out.println("Ingresa el RFC del usuario al que se le emitirá la factura: ");
                    String rfc = in.nextLine();
                    Persona persona = mp.buscarPersona(rfc);
                    if(persona==null) {
                        System.out.println("No se encontró la persona indicada");
                        return;
                    }
                    
                    // mf.agregarFacturaEmitida();
                    break;
                case 3: // Eliminar Factura Emitida
                    mf.eliminarFacturaEmitida();
                    break;
                default:
                    break;
            }
        } while (opc != 0);
    }

    
};

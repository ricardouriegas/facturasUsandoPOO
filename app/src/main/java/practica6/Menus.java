package practica6;

/**
 * Clase que contiene los menús de la aplicación
  */
public class Menus {
    /**
     * Menú principal de la aplicación
      */
    public static void mostrarMenuPrincipal() {
        System.out.println("----- Menú de Facturación -----");
        System.out.println("1. Datos Fiscales de la Empresa");
        System.out.println("2. Catálogo de Personas Fiscales");
        System.out.println("3. Gestión de Facturas Recibidas");
        System.out.println("4. Gestión de Facturas Emitidas");
        System.out.println("5. Mostrar Detalle de Factura");
        System.out.println("0. Salir");
    }

    public static void mostrarMenuDatosFiscales() {
        System.out.println("----- Menú de Datos Fiscales -----");
        System.out.println("1. Mostrar Datos Fiscales Actuales");
        System.out.println("2. Modificar Datos Fiscales");
        System.out.println("0. Volver al Menú Principal");
    }

    public static void mostrarMenuCatalogoPersonasFiscales() {
        System.out.println("----- Menú de Catálogo de Personas Fiscales -----");
        System.out.println("1. Mostrar Catálogo de Personas Fiscales");
        System.out.println("2. Agregar Persona Fiscal");
        System.out.println("3. Modificar Persona Fiscal");
        System.out.println("0. Volver al Menú Principal");
    }

    public static void mostrarMenuGestionFacturasRecibidas() {
        System.out.println("----- Menú de Gestión de Facturas Recibidas -----");
        System.out.println("1. Listar Facturas Recibidas");
        System.out.println("2. Agregar Factura Recibida");
        System.out.println("3. Borrar Factura Recibida");
        System.out.println("0. Volver al Menú Principal");
    }

    public static void mostrarMenuGestionFacturasEmitidas() {
        System.out.println("----- Menú de Gestión de Facturas Emitidas -----");
        System.out.println("1. Listar Facturas Emitidas");
        System.out.println("2. Agregar Factura Emitida");
        System.out.println("3. Cancelar Factura Emitida");
        System.out.println("0. Volver al Menú Principal");
    }
}

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
        System.out.println("1. Agregar persona fiscal");
        System.out.println("2. Modificar persona fiscal");
        System.out.println("3. Eliminar persona fiscal");
        System.out.println("4. Mostar personas fiscales registradas");
        System.out.println("0. Volver al Menú Principal");
    }

    public static void  mostrarMenuGestionFacturasRecibidas() {
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

    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    public static void menuModificarDatosFiscales(Persona p){
        System.out.println("----- ¿Qué dato desea modificar? -----");
        System.out.println("1. Nombre");
        System.out.println("2. RFC");
        System.out.println("3. Dirección fiscal");
        System.out.println(((p.getEsPersonaFisica()) ? "4. Apellidos.\n5. Salir" : "4. Salir"));
    }

    public static void menuListarFacturasRecibidas(){
        System.out.println("---- ¿Cómo deseas listar? ----");
        System.out.println("1. Listar mes específico");
        System.out.println("2. Listar por año específico");
        System.out.println("3. Listar todos");
        System.out.println("0. Salir");
    }

    public static void menuMostrarDetalleFactura(){
        System.out.println("---- ¿Qué tipo de factura deseas ver? ----");
        System.out.println("1. Factura Recibida");
        System.out.println("2. Factura Emitida");
        System.out.println("0. Salir");
    }
}

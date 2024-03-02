package practica6;

import java.io.File;

public class App{

    // Se definen los paths de todas las carpetas
    String appPath = new File("").getAbsolutePath() + "/";
    String personasFiscalesFile = appPath + "/personasFiscales/";
    String facturasRecibidasFile = appPath + "/facturasRecibidas/";
    String facturarEmitidasFile = appPath + "/facturasEmitidas/";

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    void run(){
        verificacionInicial();

    

    }

    /**
     * Función que verifica si existen los archivos necesarios para el funcionamiento del programa
     * @author Joshua Arrazola
      */
    void verificacionInicial(){
        if(!new File(personasFiscalesFile).exists()) new File(personasFiscalesFile).mkdirs();
        if(!new File(facturasRecibidasFile).exists()) new File(facturasRecibidasFile).mkdirs();
        if(!new File(facturarEmitidasFile).exists()) new File(facturarEmitidasFile).mkdirs();
    }

    /**
     * Menú principal de la aplicación
     * @autor Joshua Arrazola
      */
    void menu(){
        System.out.println("1) Guardar persona fiscal");
        System.out.println("2) Modificar datos de persona fiscal");
        System.out.println("3) Guardar factura recibida");
        System.out.println("4) Borrar factura recibida");
        System.out.println("5) Emitir factura");
        System.out.println("6) Cancelar factura emitida");
        System.out.println("7) Listar facturas recibidas de un año-mes específico");
        System.out.println("8) Listar facturas emitidas de un año-mes específico");
        System.out.println("9) Consultar factura por su identificador fiscal");
    }
};

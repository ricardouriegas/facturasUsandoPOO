package practica6;

import java.io.*;
import java.util.ArrayList;

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
     * @author Joshua Arrazola
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

    /**
     * Función que gestiona la serialización de la aplicación
     * @author Joshua Arrazola
     * 
     * @param <T> Plantilla genérica del ArrayList
     * @param path Ruta del objeto a escribir
     * @param list ArrayList del objeto a escribir
     * @param clazz Especificación de la clase del ArrayList
      */
    <T> void serialize(String path, ArrayList<T> list, Class<T> clazz){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){
            oos.writeObject(list);
        } catch (Exception e) { }
    }
    
    /**
     * Función que gestiona la recuperación de la información del ArrayList
     * @author Joshua Arrazola
     * 
     * @param <T> Plantilla genérica de la clase del ArrayList a retornar
     * @param path Ruta del archivo a recuperar
     * @param clazz Clase que compone el ArrayList a recuperar
     * @return ArrayList<T> lista
      */
    @SuppressWarnings("unchecked")
    <T> ArrayList<T> deserialize(String path, Class<T> clazz){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))){
            return (ArrayList<T>) ois.readObject();
        } catch (Exception e) { }
        return null;
    }

};

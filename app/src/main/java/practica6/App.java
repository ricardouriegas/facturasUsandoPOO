package practica6;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class App{
    final Scanner in = new Scanner(System.in);

    // Se definen los paths de todas las carpetas
    final String appPath = new File("").getAbsolutePath() + "/";
    final String personasFiscalesFile = appPath + "/personasFiscales/";
    final String facturasRecibidasFile = appPath + "/facturasRecibidas/";
    final String facturarEmitidasFile = appPath + "/facturasEmitidas/";

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    void run(){
        verificacionInicial();
        
        // Deserialización de objetos del programa
        ArrayList<Persona> personasFiscales = deserialize(personasFiscalesFile + "personas.obj", Persona.class);

        Persona usuarioInicial = crearUsuarioInicial();

        
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
     * Función que gestiona la recuperación de la información delos .obj (Proceso de deserialización1)
     * @author Joshua Arrazola
     * 
     * @param <T> Plantilla genérica de la clase del ArrayList a retornar
     * @param path Ruta del archivo a recuperar
     * @param clazz Clase que compone el ArrayList a recuperar
     * @return ArrayList<T> lista
      */
    @SuppressWarnings("unchecked")
    <T> ArrayList<T> deserialize(String path, Class<T> clazz){
        if(!(new File(path).exists())) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))){
            return (ArrayList<T>) ois.readObject();
        } catch (Exception e) { }
        return null;
    }

    Persona crearUsuarioInicial(){
        Boolean esPersonaFisica;
        
        do {
            System.out.println("¿Eres una persona física?");
            System.out.println("1. Sí");
            System.out.println("2. No");
            int opc = Integer.parseInt(in.nextLine());

            if(opc==1){
                esPersonaFisica = true;
                break;
            }  else if(opc==2) {
                esPersonaFisica = false;
                break;
            }
        } while (true);
        
        System.out.println("Ingresa tu nombre: ");
        String name = in.nextLine();

        String apellido;
        if(esPersonaFisica){
            System.out.println("Ingresa tu apellido: ");
            apellido = in.nextLine();
        } else apellido = "";

        // -----------------------------------------------
        // todo: Verificar que el RFC no se encuentre repetido
        System.out.println("Ingresa el rfc: ");
        String rfc = in.nextLine();
        // -----------------------------------------------
        System.out.println("Ingresa tu dirección fiscal: ");
        String direccionFiscal = in.nextLine();

        System.out.println("Ingresa tu email: ");
        String email = in.nextLine();

        return new Persona(name, apellido, rfc, direccionFiscal, email, esPersonaFisica);
    }
};

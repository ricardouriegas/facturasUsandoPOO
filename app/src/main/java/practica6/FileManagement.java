package practica6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Clase que se encarga de la serialización y deserialización de la información
  */

public class FileManagement {
    /**
     * Función que gestiona la serialización de la aplicación
     * 
     * @param <T> Plantilla genérica del ArrayList
     * @param path Ruta del objeto a escribir
     * @param list ArrayList del objeto a escribir
     * @param clazz Especificación de la clase del ArrayList
      */
    public static <T> void serialize(String path, ArrayList<T> list, Class<T> clazz){
        if(list.size()==0) return;

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){
            oos.writeObject(list);
        } catch (Exception e) { }
    }
    
    /**
     * Función que gestiona la recuperación de la información de los .obj (Proceso de deserialización)
     * 
     * @param <T> Plantilla genérica de la clase del ArrayList a retornar
     * @param path Ruta del archivo a recuperar
     * @param clazz Clase que compone el ArrayList a recuperar
     * @return ArrayList<T> lista
      */
    @SuppressWarnings("unchecked")
    public static <T> ArrayList<T> deserialize(String path, Class<T> clazz){
        if(!(new File(path).exists())) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))){
            return (ArrayList<T>) ois.readObject();
        } catch (Exception e) { }
        return null;
    }
}

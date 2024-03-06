package practica6;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ManejadorPersona {
    final private Scanner in = new Scanner(System.in);
    
    final private String appPath = new File("").getAbsolutePath() + "/";
    final private String personasFiscalesFile = appPath + "personasFiscales/";
    final private String personaInicialObj = appPath + "persona.obj";
    private ArrayList<Persona> list;
    private Persona personaInicial;

    /**
     * Se recupera la información y se crea un nuevo usuario
      */
    public ManejadorPersona(){
        list = FileManagement.deserialize(personasFiscalesFile + "Personas.obj", Persona.class);

        // Cosas de persona inicial
        if(!new File(personaInicialObj).exists()){
            System.out.println("No se encontraron sus datos fiscales, ingrese lo que se le pide: ");
            personaInicial = crearUsuario();
        } else {
            personaInicial = FileManagement.deserializePersonaInicial(personaInicialObj);
        }
    }

    /**
     * Getter de personaInicial
     */
    public Persona getPersonaInicial(){
        return personaInicial;
    }

    /**
     * Función que imprime los datos de la persona inicial
     * @return datosPersona
      */
    public String imprimirPersonaInicial(){
        return personaInicial.toString();
    }

    /**
     * Función que crea un nuevo usuario
     * @return nuevoUsuario
      */
    public Persona crearUsuario(){
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

        String rfc;

        do {
            System.out.println("Ingresa el RFC: ");
            rfc = in.nextLine();
            if(!esRfcUnico(rfc)) System.out.println("El RFC se encuentra repetido");
            else break;
        } while (true);

        System.out.println("Ingresa tu dirección fiscal: ");
        String direccionFiscal = in.nextLine();

        System.out.println("Ingresa tu email: ");
        String email = in.nextLine();
        System.out.println("\n\n");
        return new Persona(name, apellido, rfc, direccionFiscal, email, esPersonaFisica);
    }

    /**
     * Función que agrega una persona al ArrayList
     * @param p
      */
    public void agregarPersona(Persona p){
        list.add(p);
    }

    /**
     * Función que busca a una persona por RFC
     * 
     * @param rfc
     * @return Persona
      */
    public Persona buscarPersona(String rfc){
        for(Persona p : list) if(p.getRfc().equals(rfc)) return p;
        return null;
    }

    /**
 * Función para determinar si un RFC es único
 * @param rfc
 * @return Boolean
 */
    public Boolean esRfcUnico(String rfc){
        if(personaInicial==null) return true;
        if(personaInicial.getRfc().equals(rfc)) return false;

        for(Persona p : list) 
            if(p!=null&&(p.getRfc().equals(rfc) || p.getRfc().equals(personaInicial.getRfc()))) 
                return false;
        return true;
    }


    void modificarPersona(String rfc){
        Persona p = buscarPersona(rfc);

        if(p == null) {
            System.out.println("No se encontró la persona");
            return;
        }

        do {
            int opc;
            System.out.println("=== Menú: Modificar ===");
            System.out.println("¿Qué desea modificar?");                
            System.out.println("1. Nombre");
            System.out.println("2. RFC");
            System.out.println("3. Dirección fiscal");
            System.out.println("4. Email");
            System.out.println((p.getEsPersonaFisica()) ? "5. Apellido\n6. Salir\n" : "5. Salir");

            opc = Integer.parseInt(in.nextLine());
            switch (opc) {
                case 1:
                    System.out.println("Ingresa el nuevo nombre: ");
                    p.setNombre(in.nextLine());
                    break;
                case 2:
                    System.out.println("Ingresa el nuevo RFC: ");
                    String newRfc = in.nextLine();
                    if(esRfcUnico(rfc)){
                        p.setRfc(newRfc);
                        System.out.println("RFC modificado con éxito");
                    } else {
                        System.out.println("El rfc se encuentra repetido, lo sentimos");
                    }
                    break;
                case 3: 
                    System.out.println("Ingresa la nueva dirección fiscal: ");
                    p.setDireccionFiscal(in.nextLine());
                    break;
                case 4:
                    System.out.println("Ingresa el nuevo email: ");
                    p.setEmail(in.nextLine());
                    break;
                case 5:
                    if(!p.getEsPersonaFisica()) return;

                    System.out.println("Ingresa el nuevo apellido: ");
                    p.setApellido(in.nextLine());
                    break;
                case 6:
                    if(p.getEsPersonaFisica()) return;
                    break;
                default:
                    break;
            }
        } while (true);
    }

    /**
     * Función que elimina a una persona del ArrayList
     * @param rfc
     * @return void
     */
    public void eliminarPersona(String rfc){
        Persona p = buscarPersona(rfc);
        if(p == null) {
            System.out.println("No se encontró la persona");
            return;
        }
        list.remove(p);
    }

    /**
     * Función que muestra a todas las personas
     * @return void
     */
    public void mostrarPersonas(){
        if(list.isEmpty()){
            System.out.println("No hay personas para mostrar");
            return;
        }
        
        for(Persona p : list) System.out.println(p);
    }

    public void modificarUsuarioInicial(){
        Menus.menuModificarDatosFiscales(personaInicial);
        int opc = Integer.parseInt(in.nextLine());

        switch (opc) {
            case 1:
                System.out.println("Ingresa el nuevo nombre: ");
                personaInicial.setNombre(in.nextLine());
                break;
            case 2:
                System.out.println("Ingresa el nuevo RFC: ");
                String errefece = in.nextLine();
                if(esRfcUnico(errefece) == false){
                    System.out.println("El RFC ya existe, lo sentimos\n");
                } else {
                    personaInicial.setRfc(errefece);
                    System.out.println("RFC modificado con éxito");
                }
                break;
            case 3:
                System.out.println("Ingresa la nueva dirección fiscal: ");
                personaInicial.setDireccionFiscal(in.nextLine());
                break;
            case 4:
                if(personaInicial.getEsPersonaFisica()==false) return;
                System.out.println("Ingresa el nuevo apellido: ");
                personaInicial.setApellido(in.nextLine());
                break;
            case 5:
                return; 
            default:
                break;
        }
    }

    /**
     * Se guarda la información
      */
    public void save(){
        FileManagement.serialize(personasFiscalesFile + "Personas.obj", list, Persona.class);
        FileManagement.serialize(personaInicialObj, personaInicial);
    }
}

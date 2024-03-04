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
        if(!new File(personaInicialObj).exists()){
            System.out.println("No se encontraron sus datos fiscales, ingrese lo que se le pide: ");
            personaInicial = crearUsuario();
        } else {
            personaInicial = FileManagement.deserializePersonaInicial(personaInicialObj);
        }
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

        // -----------------------------------------------
        // todo: Verificar que el RFC no se encuentre repetido
        System.out.println("Ingresa el rfc: ");
        String rfc = in.nextLine();
        // -----------------------------------------------

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
        for(Persona p : list) if(p.getRfc() == rfc) return p;
        return null;
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
                    // todo: Validación de que no se repita
                    p.setRfc(newRfc);
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
     * Se guarda la información
      */
    public void save(){
        FileManagement.serialize(personasFiscalesFile + "Personas.obj", list, Persona.class);
        FileManagement.serialize(personaInicialObj, personaInicial);
    }
}

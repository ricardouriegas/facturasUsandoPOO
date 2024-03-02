package practica6;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ManejadorFactura{
    final private String appPath = new File("").getAbsolutePath() + "/";
    final String facturasRecibidasFile = appPath + "facturasRecibidas/";
    final String facturasEmitidasFile = appPath + "facturasEmitidas/";
    
    ArrayList<Factura> facturasRecibidas;
    ArrayList<Factura> facturasEmitidas;

    /**
     * Se recupera la informacion de las facturas recibidas y emitidas
     */
    public ManejadorFactura () {
        facturasRecibidas = FileManagement.deserialize(facturasRecibidasFile + "FacturasRecibidas.obj",Factura.class);
        facturasEmitidas = FileManagement.deserialize(facturasEmitidasFile + "FacturasEmitidas.obj", Factura.class);
    }

    /**
     * Función que guarda los datos procesados en el programa
      */
    public void save() {
        FileManagement.serialize(facturasRecibidasFile + "FacturasRecibidas.obj", facturasRecibidas, Factura.class);
        FileManagement.serialize(facturasEmitidasFile + "FacturasEmitidas.obj", facturasEmitidas, Factura.class);
    }

    
    
};

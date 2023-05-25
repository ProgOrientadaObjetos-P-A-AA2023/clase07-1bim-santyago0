package paquete5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import paquete1.Calificacion;
import paquete3.LecturaArchivoSecuencial;

public class EscrituraArchivo {
    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Hospital registro;
    private ArrayList<Hospital> lista;

    public EscrituraArchivo(String nombreArc) {
        nombreArchivo = nombreArc;
        establecerLista();
        
        try
        {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            if (obtenerLista().size() > 0) {
                for (int i = 0; i < obtenerLista().size(); i++) {
                    establecerRegistro(obtenerLista().get(i));
                    establecerSalida();
                }
            }
        }
        catch (IOException ioException) {
            System.err.println("Error al abrir el archivo.");
        }
    }
    
    public void establecerNombreArchivo(String n){
        nombreArchivo = n;
    }

    public void establecerRegistro(Hospital h) {
        registro = h;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registro); // envía el registro como salida
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    public void establecerLista() {
        LecturaArchivo l = new LecturaArchivo(obtenerNombreArchivo());
        l.establecerListaHospital();
        lista = l.obtenerListaHospital();
    }

    public String obtenerNombreArchivo(){
        return nombreArchivo;
    }
    
    public ArrayList<Hospital> obtenerLista() {
        return lista;
    }

    public ObjectOutputStream obtenerSalida(){
        return salida;
    }
    public void cerrarArchivo() {
        try
        {
            if (salida != null) {
                salida.close();
            }
        }
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
        }
    }
    
}

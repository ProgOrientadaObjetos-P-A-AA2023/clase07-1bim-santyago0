package paquete5;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import paquete1.Calificacion;

public class LecturaArchivo {
    private ObjectInputStream entrada;
    private ArrayList<Hospital> hospitales;
    private String nombreArchivo;

    public LecturaArchivo(String n) {
        nombreArchivo = n;
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            try
            {
                entrada = new ObjectInputStream(
                        new FileInputStream(n));
            }
            catch (IOException ioException) {
                System.err.println("Error al abrir el archivo.");

            }
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerListaHospital() {
        // 
        hospitales = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Hospital registro = (Hospital) entrada.readObject();
                    hospitales.add(registro);
                } catch (EOFException endOfFileException) {
                    return;

                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    break;
                }
            }
        }

    }

    public ArrayList<Hospital> obtenerListaHospital() {
        return hospitales;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "Lista de Hospitales\n";
        for (int i = 0; i < obtenerListaHospital().size(); i++) {
            Hospital p = obtenerListaHospital().get(i);
            cadena = String.format("%s%s - %d - %.2f (%s - %s)\n", 
                    cadena,
                    p.obtenerNombre(),
                    p.obtenerNumeroCamas(),
                    p.obtenerPresupuesto(),
                    p.obtenerCiudad().obtenerNombre(),
                    p.obtenerCiudad().obtenerProvincia());
        }

        return cadena;
    }

    public void cerrarArchivo() {
        try
        {
            if (entrada != null) {
                entrada.close();
            }
            System.exit(0);
        }
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        }
    }
    
}

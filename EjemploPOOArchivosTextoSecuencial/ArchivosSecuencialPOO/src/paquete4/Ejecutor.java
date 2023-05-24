/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete4;

import paquete1.Empresa;

public class Ejecutor {

    public static void main(String[] args) {

        // nombre del archivo
        String nombreArchivo = "empresas2.txt";
        
        Empresa c1 = new Empresa("Textiles del Ecuador", "Quito");
        

        ArchivoEscritura escritura = new ArchivoEscritura(nombreArchivo);
        // establecer el valor del atributo registro
        escritura.establecerRegistro(c1);
        // estabalecer en el archivo el atributo del registro
        escritura.establecerSalida(); 
        
        // proceso para lectura del archivo
        ArchivoLectura lectura = new ArchivoLectura(nombreArchivo);
        lectura.establecerLista();
        // System.out.println(lectura.toString());
        System.out.println(lectura);
        lectura.cerrarArchivo();
    }
}

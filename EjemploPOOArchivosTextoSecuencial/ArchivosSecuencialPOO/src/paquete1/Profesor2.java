/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete1;

public class Profesor2{
    private String nombre;
    private String tipo;
    private int edad;
    
    public Profesor2(String n, String t, int e){
        nombre = n;
        tipo = t;
        edad = e;
    }
    
    public void establecerNombre(String n){
        nombre = n;
    }
    
    public void establecerTipo(String n){
        tipo = n;
    }
    
    public void establecerEdad(int e){
        edad = e;
    }
    
    public String obtenerNombre(){
        return nombre;
    }
    
    public String obtenerTipo(){
        return tipo;
    }
    
    public int obtenerEdad(){
        return edad;
    }
    
    @Override
    public String toString(){
        return String.format("%s - %s - %d",
                nombre,
                tipo,
                edad);
        // return String.format("%s - %s",obtenerNombre(),
        //        obtenerTipo());
    }
}

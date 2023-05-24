package paquete5;

import java.util.ArrayList;
import java.util.Arrays;
import paquete1.Calificacion;
import paquete1.Profesor2;

/**
 *
 * @author santy
 */
public class ManejoArrayList5 {
    public static void main(String[] args) {
        String [] lineas = {"Tara Hernandez|contratado|30",
            "Luis Andrade|factura|35","Ana Juarez|nombramiento|40"};
        
        ArrayList<String> linea = new ArrayList<>();
        for (int i=0; i<lineas.length; i++){
            linea = new ArrayList<>(Arrays.asList(
                    lineas[i].split("\\|")));
            Profesor2 profe = new Profesor2(linea.get(0),linea.get(1),
                Integer.parseInt(linea.get(2)));
            System.out.printf("%s\n",profe);
        }
    }
    
}

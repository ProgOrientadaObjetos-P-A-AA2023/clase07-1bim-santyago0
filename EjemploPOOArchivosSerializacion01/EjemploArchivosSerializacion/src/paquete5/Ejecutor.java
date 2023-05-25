package paquete5;

public class Ejecutor {
    public static void main(String[] args) {
        
        String nombreArchivo = "hospitales.data";

        Hospital h1 = new Hospital("San Agustín",100,5000.2);
        Hospital h2 = new Hospital("Isidro Ayora",200,8500.5);
        Hospital h3 = new Hospital("Santa Inés",700,12000.6);
        Hospital h4 = new Hospital("Ignacio Monteros",1000,125000.5);
        Hospital h5 = new Hospital("San José",600,6000.75);

        Ciudad c1 = new Ciudad("Loja", "Loja");
        Ciudad c2 = new Ciudad("Loja", "Loja");
        Ciudad c3 = new Ciudad("Quito", "Pichincha");
        Ciudad c4 = new Ciudad("Cuenca", "Azuay");
        Ciudad c5 = new Ciudad("Machala", "El Oro");

        h1.establecerCiudad(c1);
        h2.establecerCiudad(c2);
        h3.establecerCiudad(c3);
        h4.establecerCiudad(c4);
        h5.establecerCiudad(c5);

        Hospital[] lista = {h1, h2, h3, h4, h5};

        EscrituraArchivo archivo = new EscrituraArchivo(nombreArchivo);

        for (int i = 0; i < lista.length; i++) {
            archivo.establecerRegistro(lista[i]);
            archivo.establecerSalida();
        }

        archivo.cerrarArchivo();

        LecturaArchivo lectura = new LecturaArchivo(nombreArchivo);
        lectura.establecerListaHospital();
        System.out.println(lectura);
    }
    
}

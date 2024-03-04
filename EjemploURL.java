/*
    Autor: Claudia Palacios
    Date: 02-2024
    Referencia: https://docs.oracle.com/javase/10/docs/api/java/net/URL.html

    Autor de Prueba: José Maria Cabrera Peralta
    Fecha: 04/03/2024
 */
import java.io.IOException;
import java.net.URL;

public class EjemploURL {
    public static void main(String[] args) throws IOException {
        String test_url= "http://www.pol.una.py";
        URL pagina1 = new URL(test_url);
        URL pagina2 = new URL("http","grado.pol.una.py",80,"index.html");
        URL pagina3 = new URL("https://www.poeticous.com/");
        //Primera Prueba
        System.out.println("***** Primera pagina");
        System.out.println("Protocolo: "+pagina1.getProtocol());
        System.out.println("Puerto: "+pagina1.getPort());
        System.out.println("Host: "+pagina1.getHost());
        System.out.println("Archivo: "+pagina1.getFile());
        System.out.println("External form: "+pagina1.toExternalForm());

        //Segunda prueba
        System.out.println("***** Segunda pagina");
        System.out.println("Protocolo: "+pagina2.getProtocol());
        System.out.println("Puerto: "+pagina2.getPort());
        System.out.println("Host: "+pagina2.getHost());
        System.out.println("Archivo: "+pagina2.getFile());
        System.out.println("External form: "+pagina2.toExternalForm());

        // Tercera prueba
        System.out.println("***** Tercera página");
        System.out.println("Protocolo: "+pagina3.getProtocol());
        System.out.println("Puerto: "+pagina3.getPort());
        System.out.println("Host: "+pagina3.getHost());
        System.out.println("Archivo: "+pagina3.getFile());
        System.out.println("External form: "+pagina3.toExternalForm());

    } //fin main

} //fin EjemploURL
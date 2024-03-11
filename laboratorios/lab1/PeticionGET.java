/*
    Autor: Claudia Palacios
    Date: 02-2024

    Autor de Prueba: José Maria Cabrera Peralta
    Fecha: 04/03/2024
 */
import java.io.*;
import java.net.*;
import java.util.regex.*;

public class PeticionGET {

    public static void main(String[] args) {
        try {
            String var_url = "https://www.google.com/";
            URL url = new URL(var_url);

            URLConnection conexion = url.openConnection();

            // LEER DE LA URL
            InputStreamReader input_str = new InputStreamReader(conexion.getInputStream());
            BufferedReader reader = new BufferedReader(input_str);

            String linea;
            /* La idea de crear este patter es encontrar la mayor cantidad de coincidencias.
            * Luego con un matcher ir extrayendo los enlaces. Esto haria que la impresion en
            * la consola sea mas limpia en caso que querramos encontrar distintos enlaces*/
            Pattern pattern = Pattern.compile("href=\"(.*?)\"");

            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);

                Matcher matcher = pattern.matcher(linea);
                while (matcher.find()) {
                    System.out.println("Enlace encontrado: " + matcher.group(1));
                }
            }
            reader.close();// cerrar flujo

        } catch (MalformedURLException me) {

            System.err.println("MalformedURLException: " + me);

        } catch (IOException ioe) {

            System.err.println("IOException:  " + ioe);
        }
    }// main
}

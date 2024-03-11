/*
    Autor: Claudia Palacios
    Date: 02-2024

    Autor de Prueba: José Maria Cabrera Peralta
    Fecha: 04/03/2024
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class Test01 {
    public static void main(String[] args) {
        /*String url = "https://www.datos.gov.py/dataset/proyectos-adjudicados-hackathon"; Primer ejemplo*/
        String url = "https://pivigames.blog/";
        String respuesta = "";
        try {
            respuesta = peticionHttpGet(url);
            System.out.println("La respuesta es:\n" + respuesta);
        } catch (Exception e) {
            // Manejar excepción
            e.printStackTrace();
        }
    }

    public static String peticionHttpGet(String urlParaVisitar) throws Exception {
        StringBuilder resultado = new StringBuilder();
        URL url = new URL(urlParaVisitar);

        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        String linea;
        while ((linea = rd.readLine()) != null) {
            resultado.append(linea);
        }

        rd.close();
        return resultado.toString();
    }
}

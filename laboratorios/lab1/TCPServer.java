/*
    Autor: Claudia Palacios
    Date: 02-2024
    Notas:
    -En este ejemplo el servidor TCP espera a que el cliente se conecte, luego recibe un mensaje del cliente, lo convierte a mayúsculas y lo envía de vuelta al cliente.
    -El cliente se conecta al servidor, envía un mensaje al servidor, espera la respuesta del servidor y la imprime en la consola.
    -Para ejecutar este código, primero ejecuta el servidor y luego el cliente.
    -Revisar que el puerto 9876 esté disponible y que no esté bloqueado o este en uso por otro programa.

    Autor de Prueba: José Maria Cabrera Peralta
    Fecha: 04/03/2024

 */
import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        final int SERVER_PORT = 9876;

        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Servidor TCP escuchando en el puerto " + SERVER_PORT + "...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nuevo cliente conectado: " + clientSocket);

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String message = in.readLine();
                System.out.println("Mensaje recibido del cliente: " + message);

                String response = "Respuesta del servidor: " + message.toUpperCase();
                out.println(response);

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

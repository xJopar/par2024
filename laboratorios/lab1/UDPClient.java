
/*
    Autor: Claudia Palacios
    Date: 02-2024
    Notas:
    -En este ejemplo el servidor UDP escucha en el puerto 9877 y recibe los mensajes de los clientes,
    -luego convierte los mensajes a mayúsculas y los envía de vuelta al cliente.
    -El cliente envía un mensaje al servidor, espera la respuesta del servidor y la imprime en la consola.
    -Para ejecutar este código, primero ejecuta el servidor y luego el cliente.
    -Revisar que el puerto 9877 esté disponible y que no esté bloqueado o este en uso por otro programa.


    Autor de Prueba: José Maria Cabrera Peralta
    Fecha: 04/03/2024
 */

import java.io.*;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost";
        final int SERVER_PORT = 9877;

        try {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName(SERVER_ADDRESS);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.print("Ingrese un mensaje para enviar al servidor: ");
                String message = userInput.readLine();
                byte[] sendData = message.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, SERVER_PORT);
                clientSocket.send(sendPacket);

                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);

                String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Respuesta del servidor: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

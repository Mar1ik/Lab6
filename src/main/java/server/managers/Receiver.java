package server.managers;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Receiver {
    public static void main(String[] args) {
        int port = args.length == 0 ? 4445 : Integer.parseInt(args[0]);
        new Receiver().run(port);
    }

    public void run(int port) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(port);
            byte[] receiveData = new byte[8];
            String sendString = "polo";
            byte[] sendData = sendString.getBytes("UTF-8");

            System.out.printf("Listening on udp:%s:%d%n",
                    InetAddress.getLocalHost().getHostAddress(), port);
            DatagramPacket receivePacket = new DatagramPacket(receiveData,
                    receiveData.length);

            while (true) {
                serverSocket.receive(receivePacket);
                String sentence = new String(receivePacket.getData(), 0,
                        receivePacket.getLength());
                System.out.println("RECEIVED: " + sentence);
                // now send acknowledgement packet back to sender
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
                        receivePacket.getAddress(), receivePacket.getPort());
                serverSocket.send(sendPacket);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        // should close serverSocket in finally block
    }
}

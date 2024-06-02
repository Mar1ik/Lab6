package client.system;

import client.managers.InsertCMD;
import client.resources.Worker;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Client {
    public static void main(String[] args) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData;
        byte[] receiveData = new byte[1024];
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Worker> workers = new TreeMap<>();
        while (true) {
            System.out.println("Enter a command:");
            String command = scanner.nextLine();
            if (command.startsWith("insert")) {
                InsertCMD insertCMD = new InsertCMD();
                insertCMD.execute(command.split(" "));
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.writeObject(workers);
                oos.flush();
                sendData = baos.toByteArray();
            } else {
                sendData = command.getBytes();
            }
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 5000);
            clientSocket.send(sendPacket);
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("FROM SERVER: " + response);
        }
    }
}
package server;

import server.managers.CollectionManager;
import server.managers.CommandManager;
import server.resources.Worker;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.TreeMap;

public class UDPserver {
    public static void main(String[] args) throws Exception {
        CommandManager commandManager = new CommandManager();
        DatagramSocket serverSocket = new DatagramSocket(5000);
        CollectionManager collectionManager = new CollectionManager();
        Worker worker = new Worker();
        byte[] receiveData = new byte[1024];
        byte[] sendData;
        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String command = new String(receivePacket.getData(), 0, receivePacket.getLength());
            if(command.equals("insert")) {
                ByteArrayInputStream bais = new ByteArrayInputStream(receivePacket.getData());
                ObjectInputStream ois = new ObjectInputStream(bais);
                TreeMap<String, Worker> workers = (worker) ois.readObject();
                System.out.println("Received command: " + command);
            }else{
                System.out.println("Received command: " + command);
                String result;
                try {
                    result = commandManager.startExecuting(command);
                } catch (Exception e) {
                    result = "Error executing command: " + e.getMessage();
                }
                InetAddress IPAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();
                sendData = result.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                serverSocket.send(sendPacket);
            }
        }
    }
}
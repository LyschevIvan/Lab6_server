package com.company.Application.Controllers;

import com.company.Application.Commands.CommandInvoker;
import com.company.Application.Data;

import java.io.*;
import java.net.*;

public class ServerController {
    private final static int BUFFER_SIZE = 2048;
    Data data;
    DatagramSocket channel;
    byte[] buff = new byte[BUFFER_SIZE];
    DatagramPacket packet = new DatagramPacket(buff, buff.length);
    CommandInvoker commandInvoker;
    public ServerController(CommandInvoker commandInvoker){
        this.commandInvoker = commandInvoker;
        try {
            channel = new DatagramSocket(8989);
        }
        catch (SocketException e) {
            e.printStackTrace();
        }



    }
    public void nextRequest() throws IOException, ClassNotFoundException {

        channel.receive(packet);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(packet.getData());
        ObjectInputStream objectInputStream =  new ObjectInputStream(byteArrayInputStream);

        data = (Data) objectInputStream.readObject();
        System.out.println(1);
        Data responseData = commandInvoker.executeCommand(data);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(responseData);
        buff = byteArrayOutputStream.toByteArray();
        DatagramPacket responsePacket = new DatagramPacket(buff, buff.length, packet.getAddress(), packet.getPort());
        channel.send(responsePacket);
        System.out.println("sent");

    }
}

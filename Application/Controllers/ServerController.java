package com.company.Application.Controllers;

import com.company.Application.Data;


import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;

public class ServerController {
    private final static int BUFFER_SIZE = 2048;
    ServerSocket serverSocket;
    Socket socket;
    ByteBuffer buff = ByteBuffer.allocate(BUFFER_SIZE);
    public ServerController(int port) throws IOException {
            serverSocket = new ServerSocket(port);
    }


    void checkConnection(){
        if (socket == null){
            try {
                System.out.println("waiting for connection...");
                socket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("connected");
        }


    }

    public Data nextRequest() throws IOException, ClassNotFoundException {

            try {
                checkConnection();
                InputStream in = socket.getInputStream();
                System.out.println("waiting for data...");
                ObjectInputStream objectInputStream = new ObjectInputStream(in);

                return (Data) objectInputStream.readObject();


            } catch (SocketException e) {
                System.out.println("disconnected");
                socket.close();
                socket = null;
                return null;
            }

    }


    public void response(Data responseData) throws IOException {

            try{
                checkConnection();
                OutputStream out = socket.getOutputStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(responseData);
                objectOutputStream.flush();
                buff.put(outputStream.toByteArray()).flip();
                out.write(buff.array());
                out.flush();
                buff.clear();
            }
            catch (SocketException e){
                System.out.println("disconnected");
                socket.close();
                socket = null;
                socket = null;
            }







    }




}

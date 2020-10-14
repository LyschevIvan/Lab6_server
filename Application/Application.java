

package com.company.Application;

import com.company.Application.Commands.CommandInvoker;
import com.company.Application.Commands.ControllersProvider;
import com.company.Application.Controllers.ServerController;
import com.company.Application.Controllers.TreeMapController;
import com.company.Application.Controllers.XMLController;
import sun.nio.ch.ChannelInputStream;

import java.io.*;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Scanner;

/**
 * Class uses to start the application
 */
public class Application {
    private final String fileName;
    private final int port;

    public Application(int port, String fileName) {
        this.port = port;
        this.fileName = fileName;
    }

    /**
     * starts the application
     * exits if input stream is closed
     */
    public void start() throws IOException {
        XMLController xmlController = new XMLController();
        TreeMapController treeMapController = new TreeMapController();
        ServerController serverController = new ServerController(port);
        ControllersProvider controllersProvider = new ControllersProvider(treeMapController, xmlController, serverController);
        CommandInvoker commandInvoker = new CommandInvoker(controllersProvider);

        xmlController.loadTree(fileName, treeMapController);
        Scanner console =new Scanner(System.in);
        System.out.println("Успешный запуск. порт: "+ port);
        Data data;
        String inp = "";
        while (!inp.equals("exit")){
            try {

                data = serverController.nextRequest();
                if (data != null)
                    commandInvoker.executeCommand(data);
                if (System.in.available() > 0){
                    inp = console.nextLine();
                    if (inp.equals("save")){
                        data = new Data("save");
                        commandInvoker.executeCommand(data);
                    }
                }
            } catch (IOException e) {
                System.out.println("Ошибка в передачи данных");
            } catch (ClassNotFoundException e) {
                System.out.println("Возможно данные повреждены!");
            }
        }


    }
    
}

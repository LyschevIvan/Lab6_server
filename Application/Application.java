

package com.company.Application;

import com.company.Application.Commands.CommandInvoker;
import com.company.Application.Commands.ControllersProvider;
import com.company.Application.Controllers.ServerController;
import com.company.Application.Controllers.TreeMapController;
import com.company.Application.Controllers.XMLController;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Class uses to start the application
 */
public class Application {
//    private final String fileName;
//    public Application(String fileName) {
//        this.fileName = fileName;
//    }

    public Application() {
    }

    /**
     * starts the application
     * exits if input stream is closed
     */
    public void start() {

        XMLController xmlController = new XMLController();
        TreeMapController treeMapController = new TreeMapController();
        ControllersProvider controllersProvider = new ControllersProvider(treeMapController, xmlController);
        CommandInvoker commandInvoker = new CommandInvoker(controllersProvider);
        ServerController serverController = new ServerController(commandInvoker);
        xmlController.loadTree("products.xml", treeMapController);
        while (true){
            try {
                serverController.nextRequest();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }

    }
    
}

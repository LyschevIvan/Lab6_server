package com.company;

import com.company.Application.Application;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length == 2){
            boolean success = false;
            while (!success){
                try{
                    int port = Integer.parseInt(args[1]);
                    String fileName = args[0];
                    Application app = new Application(port,fileName);

                    try {
                        app.start();
                        success = true;
                    } catch (IOException e) {
                        System.out.println("Ошибка назначении порта!");
                        port++;
                    }
                }
                catch (NumberFormatException e){
                    System.out.println("Неправильно введенный порт!");
                }
            }

        }
        else
        {
            System.out.println("lab6-server.jar collection_path port");
        }
    }
}


package com.company.Application.Commands;

import com.company.Application.Data;

/**
 * shows last 13 entered commands
 */
class History extends AbstractCommand {
    CommandInvoker commandInvoker;
    public History(ControllersProvider controllersProvider, CommandInvoker commandInvoker) {
        super(controllersProvider);
        this.commandInvoker = commandInvoker;
    }

    @Override
    public Data execute(Data data) {
        for (String s : commandInvoker.getEnteredCommands()){
            System.out.println(s);
        }
        return null;
    }


    @Override
    public void getInfo() {
        System.out.println("history : выводит последние 13 введенных команд");
    }
}


package com.company.Application.Commands;

import com.company.Application.Data;

/**
 * shows information about commands
 */
class Help extends AbstractCommand {
    CommandInvoker commandInvoker;
    public Help(ControllersProvider controllersProvider, CommandInvoker commandInvoker) {
        super(controllersProvider);
        this.commandInvoker = commandInvoker;
    }

    @Override
    public Data execute(Data data) {

        commandInvoker.commandsInfo();
        return null;
    }


    @Override
    public void getInfo() {
        System.out.println("help : выводит информацию о командах");
    }
}


package com.company.Application.Commands;

import com.company.Application.Data;

import java.io.IOException;

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
    public void execute(Data data) throws IOException {
        controllersProvider.getServerController().response(new Data(commandInvoker.commandsInfo()));

    }


    @Override
    public String getInfo() {
        return "help : выводит информацию о командах";
    }
}

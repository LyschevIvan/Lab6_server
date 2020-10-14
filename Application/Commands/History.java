
package com.company.Application.Commands;

import com.company.Application.Data;

import java.io.IOException;

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
    public void execute(Data data) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        commandInvoker.getEnteredCommands().forEach(s -> stringBuilder.append(s+"\n"));

        controllersProvider.getServerController().response(new Data(stringBuilder.toString()));
    }


    @Override
    public String getInfo() {
        return "history : выводит последние 13 введенных команд";
    }
}

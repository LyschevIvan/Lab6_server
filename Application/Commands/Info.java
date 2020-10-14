
package com.company.Application.Commands;

import com.company.Application.Data;

import java.io.IOException;

/**
 * shows information about collection
 */
class Info extends AbstractCommand {
    public Info(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public void execute(Data data) throws IOException {
        controllersProvider.getServerController().response(new Data(controllersProvider.getTreeMapController().getInfo(controllersProvider.getXmlController())));
    }

    @Override
    public String getInfo() {
        return "info : выводит информацию о коллекции";
    }
}

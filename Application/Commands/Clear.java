
package com.company.Application.Commands;

import com.company.Application.Data;

import java.io.IOException;
import java.util.Arrays;

/**
 * clears collection
 */
class Clear extends AbstractCommand {
    public Clear(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public void execute(Data data) throws IOException {
        controllersProvider.getTreeMapController().clear();
        Data response = new Data("Коллекция очищена!");
        controllersProvider.getServerController().response(response);

    }

    @Override
    public String getInfo() {
        return "clear : очищает коллекцию";
    }
}

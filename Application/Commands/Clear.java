
package com.company.Application.Commands;

import com.company.Application.Data;

import java.util.Arrays;

/**
 * clears collection
 */
class Clear extends AbstractCommand {
    public Clear(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public Data execute(Data data) {
        controllersProvider.getTreeMapController().clear();

        return new Data("Коллекция очищена!");
    }

    @Override
    public void getInfo() {
        System.out.println("clear : очищает коллекцию");
    }
}

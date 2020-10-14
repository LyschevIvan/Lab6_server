
package com.company.Application.Commands;

import com.company.Application.Data;

import java.io.IOException;

/**
 * remove by key
 */
class Remove extends AbstractCommand {
    public Remove(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public void execute(Data data) throws IOException {
        Integer k = Integer.valueOf(data.getMessage()[1]);
        controllersProvider.getTreeMapController().remove(k);
        Data response = new Data("Продукт успешно удален!");
        controllersProvider.getServerController().response(response);
    }



    @Override
    public String getInfo() {
        return "remove_key k : удаляет элемент с ключем k";
    }
}

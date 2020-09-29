
package com.company.Application.Commands;

import com.company.Application.Data;

/**
 * remove by key
 */
class Remove extends AbstractCommand {
    public Remove(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public Data execute(Data data) {
        Integer k = Integer.valueOf(data.getMessage()[1]);
        controllersProvider.getTreeMapController().remove(k);
        return null;
    }



    @Override
    public void getInfo() {
        System.out.println("remove_key k : удаляет элемент с ключем k");
    }
}

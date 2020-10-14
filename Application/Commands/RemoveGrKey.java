
package com.company.Application.Commands;

import com.company.Application.Data;

import java.util.Iterator;

/**
 * remove if key is greater
 */
class RemoveGrKey extends AbstractCommand {
    public RemoveGrKey(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public void execute(Data data) {
        Integer key = Integer.valueOf(data.getMessage()[1]);
        Iterator<Integer> keyIterator = controllersProvider.getTreeMapController().getKeyIterator();
        while (keyIterator.hasNext()){
            Integer k = keyIterator.next();
            if(k>key)
                keyIterator.remove();
        }

    }


    @Override
    public String getInfo() {
        return "remove_greater_key key : удалить из коллекции все элементы, ключ которых превышает заданный";
    }
}

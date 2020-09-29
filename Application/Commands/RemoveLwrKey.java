
package com.company.Application.Commands;

import com.company.Application.Data;

import java.util.Iterator;

/**
 * removes if key is lower
 */
class RemoveLwrKey extends AbstractCommand {
    public RemoveLwrKey(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public Data execute(Data data) {
        Integer key = Integer.valueOf(data.getMessage()[1]);
        Iterator<Integer> keyIterator = controllersProvider.getTreeMapController().getKeyIterator();
        while(keyIterator.hasNext()){
            Integer k = keyIterator.next();
            if(k<key)
                keyIterator.remove();
        }

        return null;
    }

    @Override
    public void getInfo() {
        System.out.println("remove_lower_key key : удалить из коллекции все элементы, ключ которых меньше чем заданный");
    }
}

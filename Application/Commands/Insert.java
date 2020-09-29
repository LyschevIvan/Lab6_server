
package com.company.Application.Commands;


import com.company.Application.Data;

/**
 * insert with key
 */
class Insert extends AbstractCommand {
    public Insert(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public Data execute(Data data) {
//        Product product = controllersProvider.readProduct();
        Integer key = Integer.valueOf(data.getMessage()[1]);
//        controllersProvider.getTreeMapController().put(key,product);
        return null;
    }



    @Override
    public void getInfo() {
        System.out.println("insert int: команда служит для добавления элемента в коллекцию");
    }
}

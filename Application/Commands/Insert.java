
package com.company.Application.Commands;


import com.company.Application.Data;
import com.company.Application.ProductClasses.Product;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;

/**
 * insert with key
 */
class Insert extends AbstractCommand {
    public Insert(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public void execute(Data data) throws IOException {
        Product product = data.getProduct();
        Integer key = Integer.valueOf(data.getMessage()[1]);
        LinkedList<Long> idList = controllersProvider.getTreeMapController().getIdList();
        long id = Math.round(Math.random()*1000);
        while(idList.contains(id))
            id = Math.round(Math.random()*1000);
        product.setId(id);
        product.setCreationDate(new Date());
        controllersProvider.getTreeMapController().put(key,product);
        Data response = new Data("Продукт успешно добавлен!");
        controllersProvider.getServerController().response(response);
    }



    @Override
    public String getInfo() {
        return "insert int: команда служит для добавления элемента в коллекцию";
    }
}

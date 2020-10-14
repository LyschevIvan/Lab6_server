
package com.company.Application.Commands;

import com.company.Application.Data;
import com.company.Application.ProductClasses.Product;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;


/**
 * print collection content to System.out
 */
class Show extends AbstractCommand {
    public Show(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public void execute(Data data) throws IOException {
        TreeMap<Integer,Product> products = controllersProvider.getTreeMapController().getProducts();
        List<Map.Entry<Integer, Product>> sorted = products.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
        for (Map.Entry<Integer, Product> entry : sorted){
            controllersProvider.getServerController().response(new Data(entry.getKey(),entry.getValue()));
        }

    }



    @Override
    public String  getInfo() {
       return "show : выводит элементы коллекции";
    }
}

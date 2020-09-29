
package com.company.Application.Commands;

import com.company.Application.Data;
import com.company.Application.ProductClasses.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * print collection content to System.out
 */
class Show extends AbstractCommand {
    public Show(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public Data execute(Data data){
//        controllersProvider.getTreeMapController().forEach((k,v)->System.out.println(k +" " + v.toString()));
        ArrayList<Product> sorted = (ArrayList) controllersProvider.getTreeMapController().getStream().sorted().collect(Collectors.toList());

        return new Data(sorted);

    }



    @Override
    public void getInfo() {
        System.out.println("show : выводит элементы коллекции");
    }
}

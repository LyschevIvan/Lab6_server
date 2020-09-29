package com.company.Application.Commands;

import com.company.Application.Data;
import com.company.Application.ProductClasses.Product;

import java.util.Iterator;

/**
 * counts all products with manufactureCost less then entered
 */
class CountLessManCost extends AbstractCommand {
    public CountLessManCost(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public Data execute(Data data) {
        long cost = Long.parseLong(data.getMessage()[1]);
        Iterator<Product> values = controllersProvider.getTreeMapController().getValueIterator();
        long counter = 0;
        while (values.hasNext()) {
            Product value = values.next();
            if (value.getManufactureCost() < cost)
                counter++;
        }
        String ending = "";
        if (counter == 1)
            ending = "";
        else if((counter>=2)&&(counter<=4))
            ending = "а";
        else
            ending = "ов";

        System.out.println("Коллекция содержит "+counter+" элемент"+ending+" с рыночной стоимостью меньше заданной ");
        return null;
    }


    @Override
    public void getInfo() {
        System.out.println("count_less_than_manufacture_cost long : выводит количество элементов, зачения поля manufectureCost которых меньше заданного");
    }
}

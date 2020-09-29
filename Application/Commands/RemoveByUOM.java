
package com.company.Application.Commands;

import com.company.Application.Data;
import com.company.Application.ProductClasses.Product;
import com.company.Application.ProductClasses.UnitOfMeasure;

import java.util.Iterator;

/**
 * remove by UnitOfMeasure
 */
class RemoveByUOM extends AbstractCommand {
    public RemoveByUOM(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public Data execute(Data data) {
        UnitOfMeasure unitOfMeasure;
        switch (data.getMessage()[1].toLowerCase()){
            case "kg": unitOfMeasure = UnitOfMeasure.KILOGRAMS; break;
            case "pcs": unitOfMeasure = UnitOfMeasure.PCS; break;
            case "gr": unitOfMeasure = UnitOfMeasure.GRAMS; break;
            case "mg": unitOfMeasure = UnitOfMeasure.MILLIGRAMS; break;
            default: unitOfMeasure = null;
        }
        Iterator<Product> valueIterator = controllersProvider.getTreeMapController().getValueIterator();
        while(valueIterator.hasNext()){
            Product k = valueIterator.next();
            if(k.getUnitOfMeasure().equals(unitOfMeasure)){
                valueIterator.remove();
            }
        }
        return null;
    }



    @Override
    public void getInfo() {
        System.out.println("remove_all_by_unit_of_measure (KG|PCS|GR|MG|null) : удалить из коллекции все элементы значение поля unitOfmeasure которого эквивалентно заданному");
    }
}

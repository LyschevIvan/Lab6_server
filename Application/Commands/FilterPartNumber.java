
package com.company.Application.Commands;

import com.company.Application.Data;
import com.company.Application.ProductClasses.Product;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * shows if PartNumber contains substring
 */
class FilterPartNumber extends AbstractCommand {
    public FilterPartNumber(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public Data execute(Data data) {
        String subStr = data.getMessage()[1];
        boolean foundOnce = false;
        Iterator<Product> values = controllersProvider.getTreeMapController().getValueIterator();
        Pattern pattern = Pattern.compile(subStr);
        Matcher matcher;

        while (values.hasNext()){
            Product value = values.next();
            matcher = pattern.matcher(value.getPartNumber());
            if(matcher.find()) {
                System.out.println(value.toString());
                foundOnce = true;
            }

        }
        if (!foundOnce)
            System.out.println("Совпадений нет");
        return null;
    }


    @Override
    public void getInfo() {
        System.out.println("filter_contains_part_number string : вывести элементы, значение поля partNumber которых содержит заданную подстроку");
    }
}

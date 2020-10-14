
package com.company.Application.Commands;

import com.company.Application.Data;
import com.company.Application.ProductClasses.Product;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * shows if PartNumber contains substring
 */
class FilterPartNumber extends AbstractCommand {
    public FilterPartNumber(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public void execute(Data data) throws IOException {
        String subStr = data.getMessage()[1];
        Pattern pattern = Pattern.compile(subStr);
        TreeMap<Integer, Product> products = controllersProvider.getTreeMapController().getProducts();
        List<Map.Entry<Integer,Product>> filtered = products.entrySet().stream().filter(e -> pattern.matcher(e.getValue().getPartNumber()).find()).collect(Collectors.toList());
        if (!filtered.isEmpty())
        {
            for(Map.Entry<Integer,Product> entry : filtered){
                controllersProvider.getServerController().response(new Data(entry.getKey(), entry.getValue()));
            }
        }
        else {
            controllersProvider.getServerController().response(new Data("Совпадений нет"));
        }

   }


    @Override
    public String getInfo(){
        return "filter_contains_part_number string : вывести элементы, значение поля partNumber которых содержит заданную подстроку";
    }
}

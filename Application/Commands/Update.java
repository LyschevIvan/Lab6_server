
package com.company.Application.Commands;

import com.company.Application.Data;

import java.io.IOException;

/**
 * uses to change value by key in collection
 */
class Update extends AbstractCommand {
    public Update(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public void execute(Data data) throws IOException {
        int key = Integer.parseInt(data.getMessage()[1]);
        if(data.getProduct()!= null){
            controllersProvider.getTreeMapController().getProducts().replace(key, data.getProduct());
            controllersProvider.getServerController().response(new Data("Продукт обновлен успешно"));
        }
        else {
            Data response = new Data(key, controllersProvider.getTreeMapController().getProducts().get(key));
            if (response.getProduct() != null) {
                controllersProvider.getServerController().response(response);
            }
            else {
                controllersProvider.getServerController().response(new Data("Не удалось найти элемент с данным Id. Попробуйте еще раз"));
            }
        }


    }

    @Override
    public String getInfo() {
        return "update key : предлагает изменить данные о продукте с ключем key";
    }
}

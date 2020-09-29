
package com.company.Application.Commands;

import com.company.Application.Data;

/**
 * uses to change value by key in collection
 */
class Update extends AbstractCommand {
    public Update(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public Data execute(Data data) {
        int key = Integer.parseInt(data.getMessage()[1]);
//        try {
//            controllersProvider.getInputReader().updateProduct(controllersProvider.getTreeMapController().getByID(key));
//        } catch (NullPointerException e) {
//            System.out.println("Не удалось найти элемент с данным Id. Попробуйте еще раз");
//        }
        return null;
    }

    @Override
    public void getInfo() {
        System.out.println("update key : предлагает изменить данные о продукте с ключем key");
    }
}

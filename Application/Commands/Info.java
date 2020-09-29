
package com.company.Application.Commands;

import com.company.Application.Data;

/**
 * shows information about collection
 */
class Info extends AbstractCommand {
    public Info(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public Data execute(Data data) {
        controllersProvider.getTreeMapController().showInfo(controllersProvider.getXmlController());
        return null;
    }

    @Override
    public void getInfo() {
        System.out.println("info : выводит информацию о коллекции");
    }
}

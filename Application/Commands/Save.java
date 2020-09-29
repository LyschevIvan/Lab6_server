
package com.company.Application.Commands;

import com.company.Application.Data;

/**
 * saves collection to file
 */
class Save extends AbstractCommand {
    public Save(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public Data execute(Data data) {
        controllersProvider.getXmlController().convertToXml(controllersProvider.getTreeMapController());
        return null;
    }


    @Override
    public void getInfo() {
        System.out.println("save : сохраняет коллекцию в файл");
    }
}

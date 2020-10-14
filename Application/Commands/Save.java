
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
    public void execute(Data data) {
        controllersProvider.getXmlController().convertToXml(controllersProvider.getTreeMapController());
        System.out.println("Collection was saved!");
    }


    @Override
    public String getInfo() {
       return "save : сохраняет коллекцию в файл";
    }
}

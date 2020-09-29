
package com.company.Application.Commands;


import com.company.Application.Data;

import java.io.File;

/**
 * reads commands from file
 */
class ExecuteScript extends AbstractCommand {
    public ExecuteScript(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public Data execute(Data data) {
        String fileName = data.getMessage()[1];

        File file = new File(fileName);
//        controllersProvider.getInputReader().changeInputStream(file);

        return null;
    }



    @Override
    public void getInfo() {
        System.out.println("execute_script filename.txt : для выполнения программы из файла");

    }
}

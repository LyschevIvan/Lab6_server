
package com.company.Application.Commands;

import com.company.Application.Data;

/**
 * exit from application
 */
class Exit extends AbstractCommand {
    public Exit(ControllersProvider controllersProvider) {
        super(controllersProvider);
    }

    @Override
    public Data execute(Data data) {
//        controllersProvider.getInputReader().exit();
        return null;
    }

    @Override
    public void getInfo() {
        System.out.println("exit : выход из программы без сохранения");
    }
}

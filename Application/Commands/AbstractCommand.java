
package com.company.Application.Commands;

import com.company.Application.Data;

/**
 * designate all Commands interface
 */
abstract public class AbstractCommand {

    protected ControllersProvider controllersProvider;

    public AbstractCommand(ControllersProvider controllersProvider) {
        this.controllersProvider = controllersProvider;
    }

    /**
     * executes command
     * @param data Data
     */
    abstract Data execute(Data data);


    /**
     * print info about command
     */
    abstract void getInfo();
}

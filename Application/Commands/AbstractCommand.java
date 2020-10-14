
package com.company.Application.Commands;

import com.company.Application.Data;

import java.io.IOException;

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
    abstract void execute(Data data)throws IOException;


    /**
     * print info about command
     */
    abstract String getInfo();
}

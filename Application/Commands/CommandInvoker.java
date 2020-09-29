
package com.company.Application.Commands;


import com.company.Application.Data;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * manages commands and produce access to some inputReader functions
 */
public class CommandInvoker {

    private final Queue<String> enteredCommands = new LinkedList<>();
    private int enteredCommandsCounter =0;
    private final LinkedHashMap<String, AbstractCommand> commands = new LinkedHashMap<>();


    public CommandInvoker(ControllersProvider controllersProvider) {
        initCommands(controllersProvider);
    }

    private void initCommands(ControllersProvider controllersProvider){
        commands.put("help", new Help(controllersProvider, this));
        commands.put("info", new Info(controllersProvider));
        commands.put("insert", new Insert(controllersProvider));
        commands.put("execute_script", new ExecuteScript(controllersProvider));
        commands.put("exit", new Exit(controllersProvider));
        commands.put("save", new Save(controllersProvider));
        commands.put("show", new Show(controllersProvider));
        commands.put("remove_key", new Remove(controllersProvider));
        commands.put("clear", new Clear(controllersProvider));
        commands.put("update", new Update(controllersProvider));
        commands.put("history", new History(controllersProvider, this));
        commands.put("remove_greater_key", new RemoveGrKey(controllersProvider));
        commands.put("remove_lower_key", new RemoveLwrKey(controllersProvider));
        commands.put("remove_all_by_unit_of_measure", new RemoveByUOM(controllersProvider));
        commands.put("count_less_than_manufacture_cost", new CountLessManCost(controllersProvider));
        commands.put("filter_contains_part_number", new FilterPartNumber(controllersProvider));
    }






    /**
     * execute command by it's name
     * @param data Data
     */
    public Data executeCommand(Data data){
        String commandName = data.getMessage()[0].toLowerCase();
        Data responseData =  commands.get(commandName).execute(data);
        if(enteredCommandsCounter == 13)
            enteredCommands.remove();
        else
            enteredCommandsCounter++;
        enteredCommands.add(commandName);
        return responseData;
    }

    /**
     *
     * @return Queue entered commands
     */
    Queue<String> getEnteredCommands() {
        return enteredCommands;
    }

    /**
     * uses to call function getInfo in each command
     */
    void commandsInfo(){
        commands.forEach((k,v)->v.getInfo());
    }



}

package com.company.Application.Commands;


import com.company.Application.Controllers.ServerController;
import com.company.Application.Controllers.TreeMapController;
import com.company.Application.Controllers.XMLController;
import com.company.Application.ProductClasses.Product;


/**
 *  produce access to controllers
 */
public class ControllersProvider {

    private final TreeMapController treeMapController;
    private final XMLController xmlController;
    private final ServerController serverController;

    public ControllersProvider(TreeMapController treeMapController, XMLController xmlController, ServerController serverController){
        this.serverController = serverController;
        this.treeMapController = treeMapController;
        this.xmlController = xmlController;
    }


    /**
     * produce access to TreeMapController
     * @return treeMapController
     */
    public TreeMapController getTreeMapController() {
        return treeMapController;
    }

    /**
     * produce access to XMLController
     * @return xmlController
     */
    public XMLController getXmlController() {
        return xmlController;
    }

    public ServerController getServerController() {
        return serverController;
    }
}

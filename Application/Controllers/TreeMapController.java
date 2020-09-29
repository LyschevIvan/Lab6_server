


package com.company.Application.Controllers;


import com.company.Application.ProductClasses.Product;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

/**
 * Singleton
 * uses to manage collection
 */
@XmlRootElement
public class TreeMapController
{

    private TreeMap<Integer, Product> products = new TreeMap<>();

    /**
     * put Product to Map by key
     * @param key Integer
     * @param product product
     */
    public void put(Integer key, Product product){
        products.put(key,product);
    }

    /**
     * returns map of products
     * @return TreeMap
     */
    @XmlElement
    TreeMap<Integer, Product> getProducts() {
        return products;
    }

    /**
     * set Map of products
     * @param products TreeMap
     */
    void setProducts(TreeMap<Integer, Product> products) {
        this.products = products;
    }

    /**
     * removes element by key
     * @param k Integer
     */
    public void remove(Integer k) {
        products.remove(k);

    }

    /**
     * shows info about collection file
     */
    public void showInfo(XMLController xmlController){
        SimpleDateFormat date_format = new SimpleDateFormat("HH:mm:ss dd.MM.yy");

        BasicFileAttributes attributes = xmlController.getAttrs();
        System.out.println("Тип: TreeMap");
        System.out.println("Количество элементов: " + products.size());
        System.out.println("Дата создания: " + (attributes == null ? "файл еще не создавался" : date_format.format(attributes.creationTime().toMillis())));
        System.out.println("Дата последнего изменения: " + (attributes == null ? "файл еще не создавался" : date_format.format(attributes.lastModifiedTime().toMillis())));

    }

    /**
     * clears collection
     */
    public void clear(){
        products.clear();
    }

    /**
     * returns key iterator
     * @return Iterator
     */
    public Iterator<Integer> getKeyIterator(){
        return products.keySet().iterator();
    }

    /**
     * returns value iterator
     * @return Iterator
     */
    public Iterator<Product> getValueIterator(){
        return products.values().iterator();
    }

    /**
     * do function for each element
     * @param biConsumer BiConsumer
     */
    public void forEach(BiConsumer biConsumer){
        products.forEach(biConsumer);

    }

    public Stream getStream(){
        return products.values().stream();
    }

    /**
     * returns list of Id
     * @return LinkedList
     */
    public LinkedList<Long> getIdList(){
        LinkedList<Long> idList = new LinkedList<>();
        for(Product value : products.values())
            idList.add(value.getId());
        return idList;
    }

    /**
     * returns product by id
     * @param id int
     * @return Product
     */
    public Product getByID(int id){
        return products.get(id);
}
}

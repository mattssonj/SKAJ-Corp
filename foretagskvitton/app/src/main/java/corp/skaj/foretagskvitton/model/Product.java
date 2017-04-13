package corp.skaj.foretagskvitton.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Product {
    private String name;
    private Category category;
    private List<Comment> listOfComments;
    private double price;
    private double tax;

    public Product(String name, Category category, List<Comment> listOfComments, Double price, Double tax) {
        this.name = name;
        this.category = category;
        this.listOfComments = listOfComments;
        this.price = price;
        this.tax = tax;
    }

    public Product(String name, double price, double tax) {
        this.name = name;
        this.price = price;
        this.tax = tax;
        listOfComments = new ArrayList<>();
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     *
     * @param listOfComments
     */
    public void setListOfComments(List<Comment> listOfComments) {
        this.listOfComments = listOfComments;
    }

    /**
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *
     * @param tax
     */
    public void setTax(double tax) {
        this.tax = tax;
    }

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return category
     */
    public Category getCategory() {
        return category;
    }

    /**
     *
     * @return listOfComments
     */
    public List<Comment> getListOfComments() {
        return listOfComments;
    }

    /**
     *
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @return tax
     */
    public double getTax() {
        return tax;
    }

}

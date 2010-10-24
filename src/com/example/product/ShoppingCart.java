package com.example.product;

import java.util.*;


/**
 * An example shopping cart. 
 * This class should not be mistaken for a production-quality shopping cart. 
 * It's merely provided as an example class under test as described in the
 * JUnitPrimer.
 *
 * @author Hiperion
 * @author  
 */
 
public class ShoppingCart {

    private ArrayList<Product> _items;

    /**
     * Constructs a ShoppingCart instance.
     */
    public ShoppingCart() {
        _items = new ArrayList<Product>();
    }

    /**
     * Returns the balance.
     * @return Balance.
     */
    public double getBalance() {
        Iterator<Product> i = _items.iterator();
        double balance = 0.00;
        while (i.hasNext()) {
            Product p = (Product)i.next();
            balance = balance + p.getPrice();
        }

        return balance;
    }
    
    /**
     * Adds the specified product.
     * @param p Product.
     */
    public void addItem(Product p) {
        _items.add(p);
    }

    /**
     * Removes the specified product.
     * @param p Product.
     * @throws ProductNotFoundException If the product does not exist.
     */
    public void removeItem(Product p) throws ProductNotFoundException {
        if (!_items.remove(p)) {
            throw new ProductNotFoundException();
        }
    }

    /**
     * Returns the number of items in the cart.
     * @return Item count.
     */
    public int getItemCount() {
        return _items.size();
    }
    
    /**
     * Empties the cart.
     */
    public void empty() {
        _items = new ArrayList<Product>();
    }

    /**
     * Indicates whether the cart is empty.
     * @return true if the cart is empty;
     *     false otherwise.
     */
    public boolean isEmpty() {
        return (_items.size() == 0);
    }
}

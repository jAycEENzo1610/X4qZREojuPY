// 代码生成时间: 2025-09-18 00:11:07
package com.example.shopping;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

/**
 * The Shopping Cart Service, responsible for managing the shopping cart.
 */
@ApplicationScoped
public class ShoppingCartService {

    private Map<String, Integer> cart; // Stores the items and their quantities in the cart

    public ShoppingCartService() {
        cart = new HashMap<>();
    }

    /**
     * Adds an item to the shopping cart.
     *
     * @param itemId the ID of the item to add
     * @param quantity the quantity of the item to add
     */
    public void addItem(String itemId, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        cart.merge(itemId, quantity, Integer::sum);
    }

    /**
     * Removes an item from the shopping cart.
     *
     * @param itemId the ID of the item to remove
     */
    public void removeItem(String itemId) {
        cart.remove(itemId);
    }

    /**
     * Calculates the total price of the items in the cart.
     * Assumes there is a PriceService that provides the price for an item.
     *
     * @param priceService the service used to get item prices
     * @return the total price of the cart
     */
    public double calculateTotal(PriceService priceService) {
        double total = 0.0;
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String itemId = entry.getKey();
            int quantity = entry.getValue();
            double price = priceService.getPrice(itemId);
            total += price * quantity;
        }
        return total;
    }
}

/*
 * Price Service
 *
 * This service provides the price for an item given its ID.
 */
package com.example.shopping;

import javax.enterprise.context.ApplicationScoped;

/**
 * The Price Service, responsible for getting the price of an item.
 */
@ApplicationScoped
public class PriceService {

    // This is a placeholder, in a real application this would be replaced with actual logic
    // to retrieve item prices from a database or external service.
    private Map<String, Double> prices;

    public PriceService() {
        prices = new HashMap<>();
        // Initialize prices with some example data
        prices.put("item1", 9.99);
        prices.put("item2", 19.99);
    }

    /**
     * Returns the price of an item.
     *
     * @param itemId the ID of the item to get the price for
     * @return the price of the item
     */
    public double getPrice(String itemId) {
        return prices.getOrDefault(itemId, 0.0);
    }
}

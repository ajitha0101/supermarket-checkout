package org.checkout;

import java.util.HashMap;
import java.util.Map;

/**
 * Checkout class handles the supermarket checkout system by calculating the total price of scanned items.
 */
public class Checkout {
    private final Map<Character, Item> pricingRules;
    private final Map<Character, Integer> scannedItems;

    /**
     * Constructor for the Checkout class.
     *
     * @param pricingRules The pricing rules for the items in the supermarket.
     */
    public Checkout(Map<Character, Item> pricingRules) {
        this.pricingRules = pricingRules;
        this.scannedItems = new HashMap<>();
    }

    /**
     * Scans an item and updates the scanned items list.
     *
     * @param SKU The Stock Keeping Unit identifier of the item.
     * @throws InvalidItemException If the item is not found in the pricing rules.
     */
    public void scan(char SKU) throws InvalidItemException {
        if (!pricingRules.containsKey(SKU)) {
            throw new InvalidItemException("ERROR*** Invalid item: " + SKU);
        }
        scannedItems.put(SKU, scannedItems.getOrDefault(SKU, 0) + 1);
    }

    /**
     * Calculates and returns the total price of all scanned items.
     *
     * @return The total price of scanned items in pence.
     */
    public int getTotal() {
        int total = 0;
        for (Map.Entry<Character, Integer> entry : scannedItems.entrySet()) {
            char SKU = entry.getKey();
            int quantity = entry.getValue();
            Item item = pricingRules.get(SKU);
            total += calculateItemTotal(item, quantity);
        }
        return total;
    }

    /**
     * Calculates and returns the total price for a specific item with its quantity.
     *
     * @param item     The item to calculate the total price for.
     * @param quantity The quantity of the item.
     * @return The total price for the item in pence.
     * */
    private int calculateItemTotal(Item item, int quantity) {
        int total = 0;
        if (item.getSpecialQuantity() > 0) {
            total += (quantity / item.getSpecialQuantity()) * item.getSpecialPrice();
            quantity %= item.getSpecialQuantity();
        }
        total += quantity * item.getUnitPrice();
        return total;
    }
}

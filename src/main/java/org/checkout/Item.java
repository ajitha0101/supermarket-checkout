package org.checkout;

/**
 * Item class represents an item in the supermarket with SKU, unit price, special quantity, and special price.
 */
public class Item {
    private final char SKU;
    private final int unitPrice;
    private final int specialQuantity;
    private final int specialPrice;

    /**
     * Constructor for the Item class.
     *
     * @param SKU            The Stock Keeping Unit identifier.
     * @param unitPrice      The unit price of the item in pence.
     * @param specialQuantity The quantity required for the special price.
     * @param specialPrice   The special price of the item in pence.
     */
    public Item(char SKU, int unitPrice, int specialQuantity, int specialPrice) {
        this.SKU = SKU;
        this.unitPrice = unitPrice;
        this.specialQuantity = specialQuantity;
        this.specialPrice = specialPrice;
    }

    // Getters
    public char getSKU() {
        return SKU;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public int getSpecialQuantity() {
        return specialQuantity;
    }

    public int getSpecialPrice() {
        return specialPrice;
    }
}

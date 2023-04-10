package org.checkout;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * CheckoutTest class contains test methods for the Checkout class.
 */
public class CheckoutTest {
    private Map<Character, Item> pricingRules;

    /**
     * Set up method to initialize the pricing rules before running each test.
     */
    @BeforeEach
    public void setUp() {
        pricingRules = new HashMap<>();
        pricingRules.put('A', new Item('A', 50, 3, 130));
        pricingRules.put('B', new Item('B', 30, 2, 45));
        pricingRules.put('C', new Item('C', 20, 0, 0));
        pricingRules.put('D', new Item('D', 15, 0, 0));
    }

    /**
     * Test method for getTotal() with no items scanned.
     */
    @Test
    public void testGetTotalWithNoItems() {
        Checkout checkout = new Checkout(pricingRules);
        assertEquals(0, checkout.getTotal());
    }

    /**
     * Test method for getTotal() with single items scanned.
     */
    @Test
    public void testGetTotalWithSingleItems() throws InvalidItemException {
        Checkout checkout = new Checkout(pricingRules);
        checkout.scan('A');
        checkout.scan('B');
        checkout.scan('C');
        checkout.scan('D');
        assertEquals(115, checkout.getTotal());
    }

    /**
     * Test method for getTotal() with multiple items scanned, including items with special prices.
     */
    @Test
    public void testGetTotalWithMultipleItems() throws InvalidItemException {
        Checkout checkout = new Checkout(pricingRules);
        checkout.scan('A');
        checkout.scan('A');
        checkout.scan('A');
        checkout.scan('B');
        checkout.scan('B');
        checkout.scan('C');
        checkout.scan('D');
        assertEquals(210, checkout.getTotal());
    }

    /**
     * Test method for scan() when an invalid item is scanned.
     */
    @Test
    public void testScanInvalidItemThrowsException() {
        Checkout checkout = new Checkout(pricingRules);
        assertThrows(InvalidItemException.class, () -> checkout.scan('E'));
    }
}

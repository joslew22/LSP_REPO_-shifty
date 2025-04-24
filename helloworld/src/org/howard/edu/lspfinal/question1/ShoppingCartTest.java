package org.howard.edu.lspfinal.question1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Map;

class ShoppingCartTest {
    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    @DisplayName("Test for adding valid item")
    void testAddValidItem() {
        cart.addItem("Laptop", 999.99);
        assertEquals(999.99, cart.getTotalCost(), 0.001);
    }

    @Test
    @DisplayName("Test for adding item with 0 price (expect exception)")
    void testAddItemWithZeroPrice() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("FreeItem", 0.0);
        });
        assertEquals("Price cannot be negative.", exception.getMessage());
    }

    @Test
    @DisplayName("Test for adding item with negative price (expect exception)")
    void testAddItemWithNegativePrice() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("NegativeItem", -10.0);
        });
        assertEquals("Price cannot be negative.", exception.getMessage());
    }

    @Test
    @DisplayName("Test for applying \"SAVE10\"")
    void testApplySave10() {
        cart.addItem("Item1", 100.0);
        cart.applyDiscountCode("SAVE10");
        assertEquals(10.0, cart.getDiscountPercentage(), 0.001);
        assertEquals(90.0, cart.getTotalCost(), 0.001);
    }

    @Test
    @DisplayName("Test for applying \"SAVE20\"")
    void testApplySave20() {
        cart.addItem("Item1", 100.0);
        cart.applyDiscountCode("SAVE20");
        assertEquals(20.0, cart.getDiscountPercentage(), 0.001);
        assertEquals(80.0, cart.getTotalCost(), 0.001);
    }

    @Test
    @DisplayName("Test for applying invalid code (expect exception)")
    void testApplyInvalidCode() {
        cart.addItem("Item1", 100.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.applyDiscountCode("SAVE50");
        });
        assertEquals("Invalid discount code.", exception.getMessage());
    }

    @Test
    @DisplayName("Test total cost without discount")
    void testTotalCostWithoutDiscount() {
        cart.addItem("Item1", 50.0);
        cart.addItem("Item2", 30.0);
        assertEquals(80.0, cart.getTotalCost(), 0.001);
    }

    @Test
    @DisplayName("Test total cost with discount")
    void testTotalCostWithDiscount() {
        cart.addItem("Item1", 100.0);
        cart.addItem("Item2", 50.0);
        cart.applyDiscountCode("SAVE20");
        assertEquals(120.0, cart.getTotalCost(), 0.001);
    }

    @Test
    @DisplayName("Test total cost with empty cart")
    void testTotalCostWithEmptyCart() {
        assertEquals(0.0, cart.getTotalCost(), 0.001);
    }
    @Test
    @DisplayName("Test removing existing item")
    void testRemoveExistingItem() {
        // Add an item first
        cart.addItem("Laptop", 999.99);
        
        // Verify removal returns true and affects total
        assertTrue(cart.removeItem("Laptop"));
        assertEquals(0.0, cart.getTotalCost(), 0.001);
    }

    @Test
    @DisplayName("Test removing non-existent item")
    void testRemoveNonExistentItem() {
        // Attempt to remove item that was never added
        assertFalse(cart.removeItem("NonExistentItem"));
        
        // Verify total remains unchanged (should be 0 with empty cart)
        assertEquals(0.0, cart.getTotalCost(), 0.001);
    }
}
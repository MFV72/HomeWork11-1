package ru.netology.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PurchaseItemTest {
    @Test
    void shouldToCreate() {
        PurchaseItem item = new PurchaseItem(1, 1, "first", 100, 2);
        int expectedID = 1;
        int expectedProductID = 1;
        String expectedProductName = "first";
        int expectedProductPrice = 100;
        int expectedCount = 2;
        int actualID = item.getId();
        int actualProductID = item.getProductId();
        String actualProductName = item.getProductName();
        int actualPrice = item.getProductPrice();
        int actualCount = item.getCount();
        assertEquals(expectedID, actualID);
        assertEquals(expectedProductID, actualProductID);
        assertEquals(expectedProductName, actualProductName);
        assertEquals(expectedProductPrice, actualPrice);
        assertEquals(expectedCount, actualCount);
    }

}
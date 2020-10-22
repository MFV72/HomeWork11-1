package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseItem;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

class CartManagerTest {

    @Test
    void shouldToCreate() {
        CartManager manager = new CartManager(5, null);
        int expected = 5;
        int actual = manager.getShowLast();
        assertEquals(expected, actual);
    }

    @Test
    void shouldToCreateDefault() {
        CartManager manager = new CartManager();
        int expected = 10;
        int actual = manager.getShowLast();
        assertEquals(expected, actual);
    }

    @Test
    void shouldAddItem() {
        CartManager manager = new CartManager();
        PurchaseItem item = new PurchaseItem(8, 2, "film one", 100, 1);
        manager.add(item);
        PurchaseItem actual = manager.getItems()[0];
        assertEquals(item, actual);
        int expectedLength = manager.getItems().length;
        int actualLength = 1;
        assertEquals(expectedLength, actualLength);
    }

    @Test
    void shouldGetAll() {
        CartManager manager = new CartManager();
        PurchaseItem[] testItems = new PurchaseItem[]{
                new PurchaseItem(1, 1, "first", 1, 1),
                new PurchaseItem(2, 2, "second", 2, 2),
                new PurchaseItem(3, 3, "third", 3, 3),
        };
        manager.setItems(testItems);
        PurchaseItem[] actual = manager.getAll();
        assertEquals(testItems[0], actual[2]);
        assertEquals(testItems[1], actual[1]);
        assertEquals(testItems[2], actual[0]);
    }

    @Test
    void removeById() {
        CartManager manager = new CartManager();
        int idToRemove = 1;
        PurchaseItem first = new PurchaseItem(1, 1, "first", 1, 1);
        PurchaseItem second = new PurchaseItem(2, 2, "second", 1, 1);
        PurchaseItem third = new PurchaseItem(3, 3, "third", 1, 1);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.removeById(idToRemove);
        PurchaseItem[] actual = manager.getAll();
        PurchaseItem[] expected = new PurchaseItem[]{third, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowLastTen() {
        CartManager manager = new CartManager();
        PurchaseItem item1 = new PurchaseItem(1, 1, "item-1", 1, 1);
        PurchaseItem item2 = new PurchaseItem(2, 2, "item-2", 2, 2);
        PurchaseItem item3 = new PurchaseItem(3, 3, "item-3", 3, 3);
        PurchaseItem item4 = new PurchaseItem(4, 4, "item-4", 4, 4);
        PurchaseItem item5 = new PurchaseItem(5, 5, "item-5", 5, 5);
        PurchaseItem item6 = new PurchaseItem(6, 6, "item-6", 6, 6);
        PurchaseItem item7 = new PurchaseItem(7, 7, "item-7", 7, 7);
        PurchaseItem item8 = new PurchaseItem(8, 8, "item-8", 8, 8);
        PurchaseItem item9 = new PurchaseItem(9, 9, "item-9", 9, 9);
        PurchaseItem item10 = new PurchaseItem(10, 10, "item-10", 10, 10);
        PurchaseItem item11 = new PurchaseItem(11, 11, "item-11", 11, 11);
        PurchaseItem[] testItems = new PurchaseItem[]{item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11};
        manager.setItems(testItems);
        PurchaseItem[] actual = manager.lastTen();
        PurchaseItem[] expected = new PurchaseItem[]{item11, item10, item9, item8, item7, item6, item5, item4, item3, item2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowLastFive() {
        PurchaseItem item1 = new PurchaseItem(1, 1, "item-1", 1, 1);
        PurchaseItem item2 = new PurchaseItem(2, 2, "item-2", 2, 2);
        PurchaseItem item3 = new PurchaseItem(3, 3, "item-3", 3, 3);
        PurchaseItem item4 = new PurchaseItem(4, 4, "item-4", 4, 4);
        PurchaseItem item5 = new PurchaseItem(5, 5, "item-5", 5, 5);
        PurchaseItem item6 = new PurchaseItem(6, 6, "item-6", 6, 6);
        PurchaseItem item7 = new PurchaseItem(7, 7, "item-7", 7, 7);
        PurchaseItem item8 = new PurchaseItem(8, 8, "item-8", 8, 8);
        PurchaseItem item9 = new PurchaseItem(9, 9, "item-9", 9, 9);
        PurchaseItem item10 = new PurchaseItem(10, 10, "item-10", 10, 10);
        PurchaseItem item11 = new PurchaseItem(11, 11, "item-11", 11, 11);
        PurchaseItem[] testItems = new PurchaseItem[]{item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11};
        CartManager manager = new CartManager(5, testItems);
        PurchaseItem[] actual = manager.lastTen();
        PurchaseItem[] expected = new PurchaseItem[]{item11, item10, item9, item8, item7};
        assertArrayEquals(expected, actual);
    }
}
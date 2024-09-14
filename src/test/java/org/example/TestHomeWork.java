package org.example;

import java.util.function.Predicate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TestHomeWork {

    private final HomeWork homeWork = new HomeWork();

    @Test
    void test_partitionBy() {
        Predicate<Integer> predicate = integer -> integer < 4;
        Predicate<Integer> predicateZero = integer -> integer < 0;
        assertEquals(3, homeWork.partitionBy(createNodes(), predicate));
        assertEquals(0, homeWork.partitionBy(createNodes(), predicateZero));
        assertThrows(NullPointerException.class, () -> homeWork.partitionBy(createNodes(), null));
    }

    @Test
    void test_findNthElement() {
        assertEquals(2, homeWork.findNthElement(createNodes(), 1));
        assertEquals(5, homeWork.findNthElement(createNodes(), 4));
        assertNull(homeWork.findNthElement(createNodes(), 6));
        assertNull(homeWork.findNthElement(null, 6));
    }

    static Node<Integer> createNodes() {
        var listNodes = new Node<>(1);
        listNodes.add(2);
        listNodes.add(3);
        listNodes.add(4);
        listNodes.add(5);
        return listNodes;
    }
}

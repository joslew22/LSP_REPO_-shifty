package org.howard.edu.assignment6;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class IntegerSetTest {

    private IntegerSet set1;
    private IntegerSet set2;

    @BeforeEach
    public void setUp() {
        set1 = new IntegerSet();
        set2 = new IntegerSet();
    }

    @Test
    @DisplayName("Test case for clear")
    public void testClear() {
        set1.add(1);
        set1.add(2);
        set1.clear();
        assertTrue(set1.isEmpty());
    }

    @Test
    @DisplayName("Test case for length")
    public void testLength() {
        assertEquals(0, set1.length());
        set1.add(10);
        set1.add(20);
        assertEquals(2, set1.length());
    }

    @Test
    @DisplayName("Test case for equals")
    public void testEquals() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(1);
        assertTrue(set1.equals(set2));
        
        set2.add(3);
        assertFalse(set1.equals(set2));
    }

    @Test
    @DisplayName("Test case for contains")
    public void testContains() {
        set1.add(5);
        assertTrue(set1.contains(5));
        assertFalse(set1.contains(10));
    }

    @Test
    @DisplayName("Test case for largest")
    public void testLargest() throws IntegerSetException {
        set1.add(1);
        set1.add(3);
        set1.add(2);
        assertEquals(3, set1.largest());
    }

    @Test
    @DisplayName("Test case for largest exception")
    public void testLargestException() {
        Exception exception = assertThrows(IntegerSetException.class, () -> {
            set1.largest();
        });
        assertEquals("IntegerSet is empty", exception.getMessage());
    }

    @Test
    @DisplayName("Test case for smallest")
    public void testSmallest() throws IntegerSetException {
        set1.add(5);
        set1.add(3);
        set1.add(7);
        assertEquals(3, set1.smallest());
    }

    @Test
    @DisplayName("Test case for smallest exception")
    public void testSmallestException() {
        Exception exception = assertThrows(IntegerSetException.class, () -> {
            set1.smallest();
        });
        assertEquals("IntegerSet is empty", exception.getMessage());
    }

    @Test
    @DisplayName("Test case for add")
    public void testAdd() {
        set1.add(10);
        set1.add(10); // duplicate
        assertEquals(1, set1.length());
    }

    @Test
    @DisplayName("Test case for remove")
    public void testRemove() {
        set1.add(1);
        set1.add(2);
        set1.remove(1);
        assertFalse(set1.contains(1));
        set1.remove(10); // not in set
        assertEquals(1, set1.length());
    }

    @Test
    @DisplayName("Test case for union")
    public void testUnion() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        set1.union(set2);
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
        assertTrue(set1.contains(3));
    }

    @Test
    @DisplayName("Test case for intersect")
    public void testIntersect() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        set1.intersect(set2);
        assertTrue(set1.contains(2));
        assertFalse(set1.contains(1));
        assertFalse(set1.contains(3));
    }

    @Test
    @DisplayName("Test case for diff")
    public void testDiff() {
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.add(2);
        set1.diff(set2);
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(3));
        assertFalse(set1.contains(2));
    }

    @Test
    @DisplayName("Test case for complement")
    public void testComplement() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        set1.complement(set2);
        assertTrue(set1.contains(3));
        assertFalse(set1.contains(1));
        assertFalse(set1.contains(2));
    }

    @Test
    @DisplayName("Test case for isEmpty")
    public void testIsEmpty() {
        assertTrue(set1.isEmpty());
        set1.add(1);
        assertFalse(set1.isEmpty());
    }

    @Test
    @DisplayName("Test case for toString")
    public void testToString() {
        assertEquals("[]", set1.toString());
        set1.add(1);
        set1.add(2);
        String str = set1.toString();
        assertTrue(str.contains("1"));
        assertTrue(str.contains("2"));
    }
}

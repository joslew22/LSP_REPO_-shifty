package org.howard.edu.assignment6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A class representing a set of integers with various set operations.
 */
public class IntegerSet {
    // Store the set elements in an ArrayList.
    private List<Integer> set = new ArrayList<Integer>();

    /**
     * Default Constructor
     */
    public IntegerSet() {
    }

    /**
     * Constructor if you want to pass in already initialized set
     * @param set the initial set of integers
     */
    public IntegerSet(ArrayList<Integer> set) {
        this.set = set;
    }

    /**
     * Clears the internal representation of the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the length of the set.
     * @return the number of elements in the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Returns true if the 2 sets are equal, false otherwise.
     * Two sets are equal if they contain all of the same values in ANY order.
     * @param o the object to compare with
     * @return true if the sets are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerSet that = (IntegerSet) o;
        return set.containsAll(that.set) && that.set.containsAll(set);
    }

    /**
     * Returns true if the set contains the value, otherwise false.
     * @param value the integer value to check
     * @return true if the set contains the value, false otherwise
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest item in the set.
     * @return the largest integer in the set
     * @throws RuntimeException if the set is empty
     */
    public int largest() {
        if (isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return Collections.max(set);
    }

    /**
     * Returns the smallest item in the set.
     * @return the smallest integer in the set
     * @throws RuntimeException if the set is empty
     */
    public int smallest() {
        if (isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return Collections.min(set);
    }

    /**
     * Adds an item to the set or does nothing if already there.
     * @param item the integer to add to the set
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set or does nothing if not there.
     * @param item the integer to remove from the set
     */
    public void remove(int item) {
        set.remove((Integer) item);
    }

    /**
     * Performs set union with another IntegerSet.
     * @param intSetb the other IntegerSet to union with
     */
    public void union(IntegerSet intSetb) {
        for (int item : intSetb.set) {
            if (!set.contains(item)) {
                set.add(item);
            }
        }
    }

    /**
     * Performs set intersection with another IntegerSet.
     * @param intSetb the other IntegerSet to intersect with
     */
    public void intersect(IntegerSet intSetb) {
        set.retainAll(intSetb.set);
    }

    /**
     * Performs set difference (this set - another set).
     * @param intSetb the other IntegerSet to subtract
     */
    public void diff(IntegerSet intSetb) {
        set.removeAll(intSetb.set);
    }

    /**
     * Performs set complement (all elements not in this set but in the other set).
     * @param intSetb the other IntegerSet to complement with
     */
    public void complement(IntegerSet intSetb) {
        List<Integer> complement = new ArrayList<>();
        for (int item : intSetb.set) {
            if (!set.contains(item)) {
                complement.add(item);
            }
        }
        set = complement;
    }

    /**
     * Returns true if the set is empty, false otherwise.
     * @return true if the set is empty, false otherwise
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns String representation of the set.
     * @return the string representation of the set
     */
    @Override
    public String toString() {
        return set.toString();
    }
}
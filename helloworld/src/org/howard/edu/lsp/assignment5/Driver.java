package org.howard.edu.lsp.assignment5;

/**
 * A driver class to test the IntegerSet implementation.
 * <p>
 * This class contains the main method to demonstrate the functionality
 * of the IntegerSet class through various set operations.
 */
public class Driver {
	 /**
     * The main method that runs the test cases for IntegerSet.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Test basic operations
        IntegerSet set1 = new IntegerSet();
        System.out.println("Initial Set1: " + set1);
        System.out.println("Is Set1 empty? " + set1.isEmpty());
        
        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.println("After adding 1, 2, 3: " + set1);
        System.out.println("Is Set1 empty? " + set1.isEmpty());
        System.out.println("Length of Set1: " + set1.length());
        System.out.println("Smallest in Set1: " + set1.smallest());
        System.out.println("Largest in Set1: " + set1.largest());
        System.out.println("Does Set1 contain 2? " + set1.contains(2));
        System.out.println("Does Set1 contain 5? " + set1.contains(5));
        
        set1.remove(2);
        System.out.println("After removing 2: " + set1);
        
        // Test set operations
        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        System.out.println("\nSet1: " + set1);
        System.out.println("Set2: " + set2);
        
        System.out.println("Are Set1 and Set2 equal? " + set1.equals(set2));
        
        set1.union(set2);
        System.out.println("Union of Set1 and Set2: " + set1);
        
        set1.clear();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.intersect(set2);
        System.out.println("Intersection of [1,2,3] and [3,4,5]: " + set1);
        
        set1.clear();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.diff(set2);
        System.out.println("Difference of [1,2,3] and [3,4,5]: " + set1);
        
        set1.clear();
        set1.add(1);
        set1.add(2);
        set1.complement(set2);
        System.out.println("Complement of [1,2] with respect to [3,4,5]: " + set1);
        
        // Test exception handling
        try {
            new IntegerSet().largest();
        } catch (RuntimeException e) {
            System.out.println("\nException caught: " + e.getMessage());
        }
    }
}
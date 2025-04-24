package org.howard.edu.lspfinal.question3;

/**
 * Driver class to demonstrate the Template Method pattern 
 * with different report types
 */
public class Driver {
    
    public static void main(String[] args) {
        // Create a sales report and generate it
        Report salesReport = new SalesReport();
        salesReport.generateReport();
        
        // Add a blank line for readability
        System.out.println();
        
        // Create an inventory report and generate it
        Report inventoryReport = new InventoryReport();
        inventoryReport.generateReport();
    }
}
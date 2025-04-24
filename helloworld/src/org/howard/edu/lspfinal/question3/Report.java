package org.howard.edu.lspfinal.question3;

/**
 * Abstract base class for reports using the Template Method pattern.
 * Defines the algorithm structure while allowing subclasses to 
 * implement specific steps.
 */
public abstract class Report {
    
    /**
     * Template method that defines the algorithm structure
     * This method cannot be overridden by subclasses
     */
    public final void generateReport() {
        loadData();
        formatData();
        printReport();
    }
    
    /**
     * Loads data for the report - implementation varies by report type
     */
    protected abstract void loadData();
    
    /**
     * Formats the data for the report - implementation varies by report type
     */
    protected abstract void formatData();
    
    /**
     * Prints the final report - implementation varies by report type
     */
    protected abstract void printReport();
}
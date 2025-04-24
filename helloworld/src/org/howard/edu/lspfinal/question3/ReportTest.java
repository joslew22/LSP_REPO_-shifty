package org.howard.edu.lspfinal.question3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReportTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testSalesReport() {
        Report report = new SalesReport();
        report.generateReport();
        String expected = "Loading sales data...\nFormatting sales data...\nPrinting sales report.\n";
        assertEquals(expected, outContent.toString());
    }

    @Test
    void testInventoryReport() {
        Report report = new InventoryReport();
        report.generateReport();
        String expected = "Loading inventory data...\nFormatting inventory data...\nPrinting inventory report.\n";
        assertEquals(expected, outContent.toString());
    }
}
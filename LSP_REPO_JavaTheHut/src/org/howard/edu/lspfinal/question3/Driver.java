package org.howard.edu.lspfinal.question3;

/**
 * Driver class to Showcase the ReportGenerator framework.
 */
public class Driver {

    public static void main(String[] args) {
        // Creates and generates an Sales Report
        ReportGenerator salesReport = new SalesReportGenerator();
        salesReport.generateReport();

        System.out.println();

        // Creates and generates an Inventory Report
        ReportGenerator inventoryReport = new InventoryReportGenerator();
        inventoryReport.generateReport();
    }
}
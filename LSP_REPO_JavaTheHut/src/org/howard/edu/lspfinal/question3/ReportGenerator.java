package org.howard.edu.lspfinal.question3;

/**
 * Abstract base class for generating reports.
 */
public abstract class ReportGenerator {

    /**
     * The template method that defines the skeleton of the report generation algorithm.
     * It calls the specific steps in a fixed order. Since this is a set Order it is Final for no adjustments
     */
    public final void generateReport() {
        loadData();
        formatData();
        printReport();
    }

    /**
     * Abstract method for loading the data.
     */
    protected abstract void loadData();

    /**
     * Abstract method for formatting the data.
     */
    protected abstract void formatData();

    /**
     * Abstract method for printing the final report.
     */
    protected abstract void printReport();
}
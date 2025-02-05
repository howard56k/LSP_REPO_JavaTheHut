package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductTransfomer {
    /**
	*  Name: Howard Prioleau
	*/
	public static void main(String[] args) {
        String csvFile = "./LSP_REPO_JavaTheHut/data/products.csv";
        String line;
        String csvSplitBy = ",";

        // List to store the CSV data
        List<String[]> rawProductData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                // Check if the line contains a comma, so that it just skips over the newline in the csv
                if(line.contains(",")) {
                    // Split the line by the comma delimiter
                    String[] row = line.split(csvSplitBy);
                    // Add the row to the list
                    rawProductData.add(row);
                }
                
            }
        } catch (IOException e) {
            System.err.println(csvFile + " Does Not Exist or Error Processing");
        }

        String[] headerCol = rawProductData.get(0); // 0th row
        // Extract the rest of the rows
        List<String[]> dataRows = rawProductData.subList(1, rawProductData.size());
        apply10PerDiscount(dataRows);

        printListOfStringArrays(dataRows);
    }

    public static void apply10PerDiscount(List<String[]> data) {
        for (String[] row : data) {
            // Convert the string to a float
            float number = Float.parseFloat(row[2]);

            number *= .9;

            row[2] = String.valueOf(number);
        }
    }

    public static void printListOfStringArrays(List<String[]> data) {
        for (String[] row : data) {
            for (String value : row) {
                System.out.print(value + " ");
            }
            System.out.println(); // Move to the next line after printing a row
        }
    }
}

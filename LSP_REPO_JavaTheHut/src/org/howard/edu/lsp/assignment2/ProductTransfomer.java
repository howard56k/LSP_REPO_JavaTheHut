package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductTransfomer {
    /**
	*  Name: Howard Prioleau
	*/
	public static void main(String[] args) {
        String baseFolderPath = checkWhichInputFileExist();
        String csvFile = baseFolderPath + "products.csv";
        String line;
        String csvSplitBy = ",";

        // List to store the CSV data, USE this form so that is modifiable to be able to add PriceRange to the CSV data structure
        List<List<String>> rawProductData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                // Check if the line contains a comma, so that it just skips over the newline in the csv
                if(line.contains(",")) {
                    // Split the line by comma and convert to List<String>
                    List<String> row = new ArrayList<>(Arrays.asList(line.split(csvSplitBy)));
                    // Add the row to the list
                    rawProductData.add(row);
                }
                
            }
        } catch (IOException e) {
            System.err.println(csvFile + " Does Not Exist or Error Processing");
            System.exit(1);
        }

        // Extract the header row (0th row)
        List<String> headerCol = rawProductData.get(0);  // Now it's a List<String>

        headerCol.add("PriceRange");

        // Extract the Data Rows
        List<List<String>> dataRows = rawProductData.subList(1, rawProductData.size());

        
        apply10PerDiscount(dataRows);

        changeProductNameAndCategoryAndPriceRange(dataRows);

        printListOfStringArrays(dataRows);

        String outputCSVFile = baseFolderPath + "transformed_products.csv";
        writeToCsv(headerCol, dataRows, outputCSVFile);
    }

    public static void apply10PerDiscount(List<List<String>> data) {
        for (List<String> row : data) {
            // Convert the string to a float
            float number = Float.parseFloat(row.get(2));

            // Apply Discount of 10%
            number *= .9;

            // Round number to 2 decimal places
            String roundedNumber = String.format("%.2f", number);

            // Sets row value to the new discounted Rounded Value
            row.set(2, String.valueOf(roundedNumber));
        }
        // Also no need to return values since the ith values in the lists have the same memory address so it is not a copy when passed through, but directly changing it
    }

    public static void changeProductNameAndCategoryAndPriceRange(List<List<String>> data) {
        for (List<String> row : data) {
            // Make Product Name to Uppercase
            String productName = row.get(1).toUpperCase();
            row.set(1, productName);

            Float productPrice = Float.parseFloat(row.get(2));
            
            // Change Produce Category based on Price
            if (productPrice > 500){
                row.set(3, "Premium Electronics");
            }

            String priceRange = "";

            // Add Price Range Column
            if (productPrice <= 10) {
                priceRange = "Low";
            } else if (productPrice > 10 && productPrice <= 100) {
                priceRange = "Medium";
            } else if (productPrice > 100 && productPrice <= 500) {
                priceRange = "High";
            } else if (productPrice > 500) {
                priceRange = "Premium";
            }

            row.add(priceRange);
            
        }
        // Also no need to return values since the ith values in the lists have the same memory address so it is not a copy when passed through, but directly changing it
    }

    public static void writeToCsv(List<String> headerCol, List<List<String>> data, String outputFile){

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            // Write the header row First
            writer.write(String.join(",", headerCol));
            writer.newLine();

            // Write each data row
            for (List<String> row : data) {
                writer.write(String.join(",", row));
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to CSV file: " + outputFile);
            System.exit(1);
        }

    }


    public static String checkWhichInputFileExist() {
        File file = new File("./LSP_REPO_JavaTheHut/data/products.csv");

        if (file.exists()) {
            // IF RAN FROM Root Folder
            return "./LSP_REPO_JavaTheHut/data/";
        } else {
            // IF Ran in Eclipse and the base folder is LSP_REPO_JavaTheHut
            return "./data/";
        }
    }

    
    // For Testing Purposes to see all the Data from the CSVs
    public static void printListOfStringArrays(List<List<String>> data) {
        for (List<String> row : data) {
            for (String value : row) {
                System.out.print(value + ", ");
            }
            System.out.println();
        }
    }
}

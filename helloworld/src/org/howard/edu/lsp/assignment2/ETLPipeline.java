package org.howard.edu.lsp.assignment2;
//Joseph Lewis
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.io.*;
// Java packages and when to use them were generated from ChatGPT (chatgpt.com)

public class ETLPipeline {
    public static void main(String[] args) {
    	String input_file = "data/products.csv";
    	String output_file = "data/transformed_products.csv";
    	 List<String[]> data = ExtractFile(input_file);
    	 List<String[]> transformedData = TransformData(data);
         WriteToFile(output_file, transformedData);
    	
    
    }
    
    public static List<String[]> ExtractFile(String filename){
    	List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
        	//BufferedReader code and idea obtained from ChatGPT (chatgpt.com)
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                data.add(line.split(","));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Input file not found at " + filename);
            return null;
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            // Error exception syntax accessed from ChatGpt (chatgpt.com)
            return null;
        }
        return data;
    }
    public static List<String[]> TransformData(List<String[]> data) {
    	List<String[]> transformed = new ArrayList<>();
        transformed.add(new String[]{"ProductID", "Name", "Price", "Category", "PriceRange"});// Header
        for (String[] row : data) {
	        if (row.length < 4) continue; 
	        
	        String ProductID = row[0].trim();
	        String ProductName = row[1].trim().toUpperCase();
	        double ProductPrice = Double.parseDouble(row[2].trim());
	        String ProductCategory = row[3].trim();
	        
	        // Apply 10% discount for Electronics
	        if (ProductCategory.equals("Electronics")) {
	            ProductPrice = Math.round(ProductPrice * 0.9 * 100.0) / 100.0;
	        }
	
	        // Adjust category if price > 500
	        if (ProductCategory.equals("Electronics") && ProductPrice > 500) {
	        	ProductCategory = "Premium Electronics";
	        }
	
	        // Determine price range
	        String priceRange;
	        if (ProductPrice <= 10) {
	            priceRange = "Low";
	        } else if (ProductPrice <= 100) {
	            priceRange = "Medium";
	        } else if (ProductPrice <= 500) {
	            priceRange = "High";
	        } else {
	            priceRange = "Premium";
	        }
	
	        transformed.add(new String[]{ProductID, ProductName, String.format("%.2f", ProductPrice), ProductCategory, priceRange});
	    }
	    return transformed;
    	
    }
    public static void WriteToFile(String FileName, List<String[]> data) {
    	try (BufferedWriter bw = new BufferedWriter(new FileWriter(FileName))) {
            for (String[] row : data) {
                bw.write(String.join(",", row));
                bw.newLine();
            }
            // BufferedWriter syntax as well as code generated from ChatGPT (chatgpt.com)
            System.out.println("Transformation complete. Output saved to " + FileName);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
    	
    }

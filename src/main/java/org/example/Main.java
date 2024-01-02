package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
//    public static void main(String[] args) {
//        // Specify the path to your text file
//        String filePath = "C:\\Users\\asreekum\\Desktop\\IPL\\IPL_Test.txt";
//
//        try {
//            // Read the contents of the file into a byte array
//            byte[] fileBytes = Files.readAllBytes(Paths.get(filePath));
//
//            // Convert the byte array to a String using the default charset (UTF-8)
//            String fileContent = new String(fileBytes);
//            //System.out.println(fileContent);
//
//            // Print or use the content as needed
//            System.out.println("File Content:\n" + fileContent);
//            System.out.println("The length of the string is :" + fileContent.length() );
//            //**********************************************************************************************
//            ArrayList<String> stringArrayList = PreProcessing.getAllItemsOfFigure(fileContent, "itemdata");
//            String targetPath = "C:\\Users\\asreekum\\Desktop\\IPL\\myOutput.txt";
//            try {
//                // Convert the ArrayList elements to lines of text
//                List<String> lines = new ArrayList<>();
//                for (String element : stringArrayList) {
//                    lines.add(element);
//                }
//
//                // Write the lines to the file
//                Path path = Paths.get(targetPath);
//                System.out.println(stringArrayList);
//                Files.write(path, stringArrayList);
//                System.out.println("File saved successfully at: " + path.toAbsolutePath());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        // Specify the path to your text file
        String filePath = "C:\\Users\\asreekum\\Desktop\\IPL\\IPL-1.txt";
        String filePath1 = "C:\\Users\\asreekum\\Desktop\\Working\\04000 Cleaning.sgm";

        try {
            // Read the contents of the file into a byte array
            byte[] fileBytes = Files.readAllBytes(Paths.get(filePath));
            byte[] fileBytes1 = Files.readAllBytes(Paths.get(filePath1));

            // Convert the byte array to a String using the default charset (UTF-8)
            String fileContent = new String(fileBytes);
            String fileContent1 = new String(fileBytes1);
            System.out.println(fileContent1);

            //OutputFilePath
            String targetPath = "C:\\Users\\asreekum\\Desktop\\IPL\\myOutput.txt";
            String targetPath1 = "C:\\Users\\asreekum\\Desktop\\Working\\output.sgm";

            String outPut = SupsdInfoChanger.addSuperSedeInfoToIPLFigure(fileContent);
            try {
                Path path = Paths.get(targetPath);
                Path path1 = Paths.get(targetPath1);
                //System.out.println(stringArrayList);
                Files.write(path, outPut.getBytes());
                Files.write(path1, fileContent1.getBytes());
                System.out.println("File saved successfully at: " + path.toAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/**
 * @authors Emma-Ido Oluwaseyi Ukpong
 * @studentId 85852022
 *
 * This package contains 6 classes
 * @Galamsey is the class used for instantiating new Galamsey objects
 * @Main is the "MonitoringGUI" class which contains a javaFX program that allows users to
 * add galamsey records, observatory records and other
 * @MonitoringIO This class gives user's a menu to perfom tasks such as adding a new galamsey record, observatory record
 * and viewing galamsey records higher than a given galamsey value
 * @GalamseyCSV This class contains a method that takes in the name of a .csv file as a parameter then reads galamsey records
 * from that .csv file.
 * @Observatory This class is used for Instantiating new Observatory Objects and storing Galamsey objects
 */
package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GalamseyCSV {

    /**
     * This method reads Galamsey record details from a .csv file, inputs those details into a Galamsey Object and then prints
     * the details of that galamsey object
     * @param fileName This is the name of the .csv file this method reads from the details in the file have to be in a specific format
     */
    public static void readGalamseyFromCSV(String fileName) {
        try {
            // .csv comma separated values
            //String fileName = "data.csv"; // Enter the directory of the .csv file here if it is not in the project folder
            File file = new File(fileName); //
            Scanner inputStream = new Scanner(file);
            ArrayList<Galamsey> galamseys = new ArrayList<>(5);
            while (inputStream.hasNext()) {
                String data = inputStream.nextLine();
                int galVal = 0;
                int yearVal = 0;
                int longitude = 0;
                int latitude = 0;
                String obsName = "";
                String a = "";
                int j = 0;
                for (int i = 0; i < data.length(); i++) {
                    if (data.charAt(i) != ',') {
                        a = a + data.charAt(i);
                    }
                    else if ((j == 0) && (data.charAt(i) == ',')) {
                        galVal = Integer.parseInt(a);
                        j++;
                        a = "";
                    }
                    else if (j == 1 && data.charAt(i) == ',') {
                        yearVal = Integer.parseInt(a);
                        j++;
                        a = "";
                    }
                    else if (j == 2 && data.charAt(i) == ',') {
                        longitude = Integer.parseInt(a);
                        j++;
                        a = "";
                    }
                    else if (j == 3 && data.charAt(i) == ',') {
                        latitude = Integer.parseInt(a);
                        j++;
                        a = "";
                    }
                    if (i == data.length()-1) {
                        obsName = a;
                        a = "";
                    } else {
                    }
                }
                Galamsey galamsey = new Galamsey(galVal, yearVal, longitude, latitude);
                galamsey.setObservatoryRecorded(obsName);
                galamseys.add(galamsey);

            } // End of while loop
            for (Galamsey g : galamseys) {
                System.out.println(g);
            }

            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws FileNotFoundException {

        GalamseyCSV.readGalamseyFromCSV("data.csv");

    }
}

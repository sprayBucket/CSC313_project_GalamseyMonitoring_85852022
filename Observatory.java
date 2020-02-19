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


import java.util.ArrayList;
import java.util.HashMap;
import java.util.IllegalFormatException;

public class Observatory {

    private int galamseyCount;
    private String observatoryName;
    private int yearStarted;
    private double areaCovered;
    private String galamseyCountryLocation;
    private ArrayList<Galamsey> galamseyRecords;


    /**
     * This is a constructor for instantiating new Observatory objects
     * @param observatoryName
     * @param galamseyCountryLocation
     * @param areaCovered
     * @param yearStarted
     */
    public Observatory(String observatoryName, String galamseyCountryLocation, double areaCovered, int yearStarted) {
        this.observatoryName = observatoryName;
        this.galamseyCountryLocation = galamseyCountryLocation;
        this.areaCovered = areaCovered;
        this.yearStarted = yearStarted;
        this.galamseyRecords = new ArrayList<>(3);
        // Look up a method that gets the current year
    }

    /**
     * Overloaded constructor that only sets the area coveres and year the observatory was started
     * @param areaCovered This is the area covered by the observatory
     * @param yearStarted This is the year an observatoory started
     */
    public Observatory(double areaCovered, int yearStarted) {
        this.areaCovered = areaCovered;
        this.yearStarted = yearStarted;
        this.galamseyRecords = new ArrayList<>(3);
        // Look up a method that gets the current year
    }

    /**
     * This is a mutator method that sets the Name of the observatory
     * @param observatoryName This is the observatory name parsed into the function as a string
     */
    public void setObservatoryName(String observatoryName) {
        this.observatoryName = observatoryName;
    }


    /**
     * This is a mutator method that sets the country where an Observatory is located
     * @param galamseyCountryLocation this is the observatory country location parsed into the function
     */
    public void setGalamseyCountryLocation(String galamseyCountryLocation) {
        this.galamseyCountryLocation = galamseyCountryLocation;
    }

    /**
     * This method returns the name of the observatory
     */
    public String getObservatoryName() {
        return this.observatoryName;
    }


    /**
     * @return This method returns the highest "galamsey" value recorded
     */
    public int getLargestGalamseyVal() {
        if(galamseyCount == 0)
            return 0;
        if(galamseyCount == 1)
            return galamseyRecords.get(0).getColourValue();
        int j = 0;
        for(int i = 0; i < galamseyCount; i++) {

            j = Math.max(galamseyRecords.get(i).getColourValue(), j);

            if(j == 3) // The for loop breaks whenever a "galamsey" value of 3 is reached because that is the highest possible value
                return j;
        }
        return j;
    }

    /**
     * @return This method returns the average "galamsey" value recorded at an observatory
     */
    public int getAvgGalamseyVal() {
        if(galamseyCount == 0)
            return 0;
        if(galamseyCount == 1)
            return galamseyRecords.get(0).getColourValue();
        int j = 0;
        for(int i = 0; i < galamseyCount; i++) {
            j = j + galamseyRecords.get(i).getColourValue();
        }
        return j/this.galamseyCount;
    }


    /**
     * @param val this method gives a list of galamsey records with galamsey values higher than "value"
     */
    public void getGalamseyValGreater(int val) {
        if(val >= 0 && val <= 2) {  // If the value entered is not in the range 0-2, method exits
            for(int j = 0; j < galamseyCount; j++) {
                if(galamseyRecords.get(j).getColourValue() > val) {
                    System.out.println(galamseyRecords.get(j));
                }
            }
        } else if(val == 3) {
            System.out.println("There is no Galamsey Value greater than 3");
        } else {
            System.out.println("Galamsey values are whole numbers between 1 and 3");
        }
    }


    /**
     * @param galamsey this method adds a galamsey report to an observatory and increments the instance variable "galamseyCount"
     */
    public void addGalamseyReport(Galamsey galamsey) {
        this.galamseyRecords.add(galamsey);
        galamsey.setObservatoryRecorded(this.observatoryName);
        this.galamseyCount++;
    }


    /**
     * This method returns a list of galamsey records in an observatory with the highest galamsey values
     */
    public void getLargestGalamsey() {
        getLargestGalamsey(getLargestGalamseyVal());
    }
    private void getLargestGalamsey(int i) {
        getGalamseyValGreater(i-1);
    }


    /**
     * @return This method returns false if there are no galamsey records yet in the observatory and true otherwise
     */
    public boolean hasGalamseyRecord() {
        if(galamseyCount == 0)
            return false;
        else
            return true;
    }


// Daikstra Algorithm Daistracha

    /**
     *  toString method
     */
    public String toString() {
        return "Observatory Name: " + this.observatoryName +
                "\nArea Covered: " + this.areaCovered +
                "\nYear Started: " + this.yearStarted +
                "\nCountry Located: " + this.galamseyCountryLocation +
                "\nNumber of records: " + this.galamseyCount +
                "\n---------------------------------------------------";
    }

}

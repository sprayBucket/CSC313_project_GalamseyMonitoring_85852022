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


public class Galamsey {
    private String vegColour;
    private int galID;
    private int colourValue;
    private double[] position = new double[2]; // Longitude ranges from 0 to 180 degrees, Latitude ranges from 0 to 90
    private int yearOfEvent;
    private String observatoryRecorded;
    private double longitude;
    private double latitude;
    private int galamseyId;


    /*
     * Default Constructor
     */
    public Galamsey(int colourValue, int yearStarted) {
        this.colourValue = colourValue;
        setVegColour(colourValue);
        this.yearOfEvent = yearStarted;
    }


    /**
     * When you are done with your code delete the constructor on top
     * @param colourValue this is the colour value
     */
    public Galamsey(int colourValue, int yearStarted, double longitude, double latitude) {
        this.colourValue = colourValue;
        setVegColour(colourValue);
        this.yearOfEvent = yearStarted;
        this.longitude = longitude;
        this.latitude = latitude;
        this.position[0] = longitude;
        this.position[1] = latitude;
    }


    /**
     * This is a special constructor for the Java FX main class
     * @param galamseyId This is the galamsey Id of a galamsey report, it is automatically generated by the databse the javaFX program connects to
     * @param colourValue This is the colour value of the galamsey report that is an int
     * @param yearStarted This is the year a galamsey report started and is an int
     * @param longitude This is the longitude coordinate of where a galamsey report is found
     * @param latitude This is the latitude coordinate of where a galamsey report is found
     */
    public Galamsey(int galamseyId, int colourValue, int yearStarted, double longitude, double latitude) {
        this.colourValue = colourValue;
        this.galamseyId = galamseyId;
        setVegColour(colourValue);
        this.yearOfEvent = yearStarted;
        this.longitude = longitude;
        this.latitude = latitude;
        position[0] = longitude;
        position[1] = latitude;
    }


    /**
     * This is an accessor method for the galamsey Id, however it is not available in the Monitoring IO main method
     * @return It returns an int as the galamsey Id of a galamsey report
     */
    public int getGalamseyId() {
        return galamseyId;
    }

    /**
     * This is a mutator method for the galamsey Id of a galamsey report, however it is not available in the Monitoring IO class
     * @param galamseyId The method takes in an int as the galamsey id
     */
    public void setGalamseyId(int galamseyId) {
        this.galamseyId = galamseyId;
    }

    /**
     * This is a mutator method for the colour value of a galamsey report
     * @param colourValue The method takes in an int as the colour value of a galamsey report
     */
    public void setColourValue(int colourValue) {
        this.colourValue = colourValue;
    }



    /**
     * This method sets the year a galamsey report started
     * @param yearOfEvent The method takes in an int as a year
     */
    public void setYearOfEvent(int yearOfEvent) {
        this.yearOfEvent = yearOfEvent;
    }

    /**
     * This method returns the year a galamsey report was started
     * @return The method returns the year as an int
     */
    public int getYearOfEvent() {
        return this.yearOfEvent;
    }

    /**
     * This method returns the longitude of a galamsey report
     * @return The method returns an int which is the longitude of a galamsey report
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * This method sets the longitude of a galamsey report
     * @param longitude The method takes in an int as it's parameter
     */
    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    /**
     * This method returns the latitude of a galamsey report
     * @return It returns an int
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * This method sets the latitude of a galamsey report
     * @param latitude This is a double
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * This method sets the vegetation colour of the galamsey report after taking the colour value as a parameter
     * @param colourValue This is the colour value of the galamsey report entered into the constructor
     */
    private void setVegColour(int colourValue) {
        switch(colourValue) {
            case 1:
                this.vegColour = "Green";
                break;
            case 2:
                this.vegColour = "Yellow";
                break;
            case 3:
                this.vegColour = "Brown";
                break;
        }
    }


    /**
     * This method sets the longitude of the location the galamsey report is based on
     * @param longitude This is the longitude that would be set for the galamsey report
     */
    public void setPositionLongitude(double longitude) {
        this.position[0] = longitude;
    }

    /**
     * This method sets the latitude of the location the galamsey report is based on
     * @param latitude this is the latitude that would be set for the galamsey report
     */
    public void setPositionLatitude(double latitude) {
        this.position[1] = latitude;
    }

    /**
     * @return This method returns the vegitation colour of the galamsey report
     */
    public String getVegColour() {
        return vegColour;
    }

    /**
     * @return This method returns the colour value of a galamsey report
     */
    public int getColourValue() {
        return colourValue;
    }


    /**
     * This method sets the name of the observatory the galamsey record is recorded in
     * @param obsName this is the name of the Observatory this galamsey record is in
     */
    public void setObservatoryRecorded(String obsName) {
        this.observatoryRecorded = obsName;
    }


    /**
     * This is a toString method overriding the default toString method
     * @return It returns the details of a Galamsey report such as where is is found, what observatory is is recorded in etc.
     */
    @Override
    public String toString() {
        return "--------------------------------------" +
                "\nVegetation Colour: " + this.vegColour +
                "\nColour Value: " + this.colourValue +
                "\nYear Of Event: " + this.yearOfEvent +
                "\nCoordinates (Longitude, Latitude): " + this.position[0] + ", " + this.position[1] +
                "\nObservatory: " + this.observatoryRecorded;
    }
}

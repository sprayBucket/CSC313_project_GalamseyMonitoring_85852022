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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;
import java.util.ArrayList;

public class DBtrial {


    /**
     * This method inserts the details of a new observatory into a relation in the database
     * The details of this new observatory are gotten from the user through the javaFx program
     * @param obsName This is the name of the observatory users would store their galamsey records in. It is of type String
     * @param areaCovered This is the area the galamsey report covers. It is of type int
     * @param yearStarted This is the year an observatory was started. It is of type int
     * @param countryLocation This is the country an observatory is located. It is of type String
     */
    public static void insertIntoObservatory(String obsName, double areaCovered, int yearStarted, String countryLocation) {
        String url = "jdbc:mysql://localhost:3306/GALAMSEY";
        String user = "root";
        String password = "rootruth";
        Connection myConn = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Class.forName("com.mysql.jdbc.Driver");
            myConn = DriverManager.getConnection(url, user, password);
            Statement myStmt = myConn.createStatement();

            myStmt.executeUpdate("Insert into OBSERVATORIES" +
                    "(ObsName, yearStarted, areaCovered, countryLocation)" +
                    " values('" + obsName + "', " + yearStarted + ", " + areaCovered + ", '" + countryLocation + "')");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    /**
     * This method takes input from the JavaFx Text Entry fields and then inserts them to the "galamsey records" relation in the databse
     * @param galamseyColVal This is the Galamsey colour value
     * @param yearOfEvent This is the year the galamsey report started
     * @param Longitude This is the longitude of the location the galamsey report is based on
     * @param Latitude This is the latitude of the location the galamsey report is based on
     * @param obs This is the name of the observatory the galamsey report will be stored in
     */
    public static void insertIntoGal(int galamseyColVal, int yearOfEvent, int Longitude, int Latitude, String obs) {
        String url = "jdbc:mysql://localhost:3306/GALAMSEY";
        String user = "root";
        String password = "rootruth";
        Connection myConn = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Class.forName("com.mysql.jdbc.Driver");
            myConn = DriverManager.getConnection(url, user, password);
            Statement myStmt = myConn.createStatement();
            String col = "Yellow";
            switch(galamseyColVal) {
                case 1:
                    col = "Green";
                    break;
                case 2:
                    col = "Yellow";
                    break;
                case 3:
                    col =  "Brown";
                    break;
            }

            myStmt.executeUpdate("Insert into GALAMSEY_RECORDS" +
                    "(galamseyValue, galamseyColour, yearStarted, longitude, latitude, ObservatoryRecordedIn)" +
                    " values(" + galamseyColVal + ",'" + col + "', "+ yearOfEvent + ","+Longitude+ ","+ Latitude+ ", '"+ obs + "')");
        } catch (SQLException  e) {
            e.printStackTrace();
        }
    }


    /**
     * This method gets the names of the observatories already in the database for user to store galamsey reports in
     * @return It returns an array list of obervatory names to be displayed in a choice box menu in the MonitoringIO GUI
     */
    public static ArrayList<String> getObservatoryNames() {
        String url = "jdbc:mysql://localhost:3306/GALAMSEY";
        String user = "root";
        String password = "rootruth";
        Connection myConn = null;
        ArrayList<String> observatories = new ArrayList<>(1);
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Class.forName("com.mysql.jdbc.Driver");
            myConn = DriverManager.getConnection(url, user, password);
            Statement myStmt = myConn.createStatement();


            //This is for printing the table contents
            String sql = "select * from OBSERVATORIES";
            ResultSet rs = myStmt.executeQuery(sql);

            ////This is for printing out the records in the table
            while(rs.next()) {
                /*System.out.println(rs.getString("GalamseyId") + "\t\t\t" + rs.getString("galamseyValue")
                        + "\t\t\t\t" + rs.getString("galamseyColour") + "\t\t\t" + rs.getString("yearStarted")
                        + "\t\t\t" +  rs.getString("ObservatoryRecordedIn"));*/
                observatories.add(rs.getString("ObsName"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return observatories;
    }


    /**
     * This method returns an observable list of galamsey report details to be displayed in a table in the javaFx program
     * @return The method returns an observable list of Galamsey's
     */
    public static ObservableList<Galamsey> loadGal() {
        //String url = "jdbc:mysql://localhost:3306/GALAMSEY?autoReconnect=true&useSSL=false";
        String url = "jdbc:mysql://localhost:3306/GALAMSEY";

        ObservableList<Galamsey> galamseys = FXCollections.observableArrayList();
        String user = "root";
        String password = "rootruth";
        Connection myConn = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Class.forName("com.mysql.jdbc.Driver");
            myConn = DriverManager.getConnection(url, user, password);
            Statement myStmt = myConn.createStatement();

            //This is for printing the table contents
            String sql = "select * from GALAMSEY_RECORDS";
            ResultSet rs = myStmt.executeQuery(sql);

            ////This is for printing out the records in the table
            while(rs.next()) {

                galamseys.add(new Galamsey(Integer.parseInt(rs.getString("GalamseyId")),
                        Integer.parseInt(rs.getString("galamseyValue")),
                        Integer.parseInt(rs.getString("yearStarted")),
                        Integer.parseInt(rs.getString("longitude")),
                        Integer.parseInt(rs.getString("longitude"))));
                /*System.out.println(rs.getString("GalamseyId") + "\t\t\t" + rs.getString("galamseyValue")
                        + "\t\t\t\t" + rs.getString("galamseyColour") + "\t\t\t" + rs.getString("yearStarted")
                        + "\t\t\t" +  rs.getString("ObservatoryRecordedIn"));*/
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return galamseys;
    }


    /**
     * This method returns an observable list of galamsey records reported in a given observatory and is used by the JavaFx program
     * @param obsName This is the name of the observatory of which we will get the galamsey records recorded under it
     * @return The method returns an observable list of Galamsey objects
     * @throws NullPointerException This method also throws a NullPointerException in case the observatory name parsed in is null
     */
    public static ObservableList<Galamsey> loadGalObs(String obsName) throws NullPointerException {
        //String url = "jdbc:mysql://localhost:3306/GALAMSEY?autoReconnect=true&useSSL=false";
        String url = "jdbc:mysql://localhost:3306/GALAMSEY";

        ObservableList<Galamsey> galamseys = FXCollections.observableArrayList();
        String user = "root";
        String password = "rootruth";
        Connection myConn = null;
        try {

            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Class.forName("com.mysql.jdbc.Driver");
            myConn = DriverManager.getConnection(url, user, password);
            Statement myStmt = myConn.createStatement();

            //This is for printing the table contents
            String sql = "select * from GALAMSEY_RECORDS where ObservatoryRecordedIn = '" + obsName + "'";
            ResultSet rs = myStmt.executeQuery(sql);

            ////This is for printing out the records in the table
            while(rs.next()) {

                galamseys.add(new Galamsey(Integer.parseInt(rs.getString("GalamseyId")),
                        Integer.parseInt(rs.getString("galamseyValue")),
                        Integer.parseInt(rs.getString("yearStarted")),
                        Integer.parseInt(rs.getString("longitude")),
                        Integer.parseInt(rs.getString("longitude"))));
                /*System.out.println(rs.getString("GalamseyId") + "\t\t\t" + rs.getString("galamseyValue")
                        + "\t\t\t\t" + rs.getString("galamseyColour") + "\t\t\t" + rs.getString("yearStarted")
                        + "\t\t\t" +  rs.getString("ObservatoryRecordedIn"));*/
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return galamseys;
    }

    /**
     * This method deletes a certain galamsey record from an observatory by using the a galamsey id as a primary key
     * @param galVal This is the galamsey Id of a record that is to be deleted
     */
    public static void DeleteGalRecord(int galVal) {
        //String url = "jdbc:mysql://localhost:3306/GALAMSEY?autoReconnect=true&useSSL=false";
        String url = "jdbc:mysql://localhost:3306/GALAMSEY";

        ObservableList<Galamsey> galamseys = FXCollections.observableArrayList();
        String user = "root";
        String password = "rootruth";
        Connection myConn = null;
        try {

            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Class.forName("com.mysql.jdbc.Driver");
            myConn = DriverManager.getConnection(url, user, password);
            Statement myStmt = myConn.createStatement();

            //This is for deleting a row in the database
            myStmt.executeUpdate("delete from GALAMSEY_RECORDS" + " where GalamseyId = " + galVal);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

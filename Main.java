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

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Calendar;

public class Main extends Application {
    Stage window;
    TableView<Galamsey> table;

    public static void main(String[] args) {
        launch(args);
    }


    @SuppressWarnings("uncheked")
    @Override
    public void start(Stage primaryStage)  throws Exception {

        window = primaryStage; // Creating a primary stage
        window.setTitle("Monitoring IO"); // Setting the title of the primary stage


        GridPane grid = new GridPane(); // Creating a grid plane for the galamsey record entry page
        Scene scene = new Scene(grid, 700, 350); // Creating a scene for the galamsey record entry


        GridPane recordGrid = new GridPane(); // A grid for the records page
        Scene recordScene = new Scene(recordGrid, 800, 500); // A scene for records
        recordGrid.setPadding(new Insets(10));


        GridPane newObservatory = new GridPane();   // Creating a grid pane to add a new observatory
        Scene newObservatoryScene = new Scene(newObservatory, 700, 350); // Creating a scene to create a new observatory
        newObservatory.setPadding(new Insets(10));

        GridPane tableGrid = new GridPane(); // Creating a grid pane to view a table
        Scene tableScene = new Scene(tableGrid, 700, 350); // Creating a scene for the table
        tableGrid.setPadding(new Insets(10));


        // This is the code for the start page /////////////////////////////////////////////////////////////////////////
        GridPane startPage = new GridPane(); // Creating a grid for the start page
        startPage.setVgap(10);
        startPage.setHgap(10);
        startPage.setPadding(new Insets(10));

        Text startPageText = new Text("Welcome to Monitoring IO!");
        startPageText.setFont(Font.font("Times New Roman bold", FontWeight.LIGHT, FontPosture.REGULAR, 25));
        startPage.add(startPageText, 0, 0);

        Text startPageText2 = new Text("What would you like to do?");
        startPageText2.setFont(Font.font("Times New Roman bold", FontWeight.LIGHT, FontPosture.REGULAR, 15));
        startPage.add(startPageText2, 0, 1);


        Button galamseyButton = new Button("Add Galamsey Report");
        startPage.add(galamseyButton, 0, 2);
        galamseyButton.setOnAction(e -> window.setScene(scene));

        Button observatoryButton = new Button("Add Observatory");
        startPage.add(observatoryButton, 0, 3);
        observatoryButton.setOnAction(e -> window.setScene(newObservatoryScene));


        Button recordsButton = new Button("View Records");
        startPage.add(recordsButton, 0, 4);
        recordsButton.setOnAction(e -> window.setScene(recordScene));

        Button quitButton = new Button("Quit");
        startPage.add(quitButton, 0, 5);
        quitButton.setOnAction(e -> window.close());




        Scene scene2 = new Scene(startPage, 450, 350); // Scene for the start page
        // Ending of code for the start page ///////////////////////////////////////////////////////////////////////////



        // This is the code for the galamsey record entry page /////////////////////////////////////////////////////////
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10));

        Text welcomeText = new Text("Galamsey Record Entry");
        welcomeText.setFont(Font.font("Times New Roman bold", FontWeight.LIGHT, FontPosture.REGULAR, 25));
        grid.add(welcomeText,0, 0);

        Label label1 =  new Label("Galamsey Colour Value");
        grid.add(label1, 0, 1);

        // Trying to add a drop down list for the galamsey value (choice box)
        ChoiceBox<Integer> galVal = new ChoiceBox<>();
        galVal.getItems().add(1);
        galVal.getItems().add(2);
        galVal.getItems().add(3);
        grid.add(galVal, 1, 1);


        Label label2 =  new Label("Year Of Event");
        grid.add(label2, 0, 2);

        // A choice box for users to select the year of a galamsey report
        ChoiceBox<Integer> yearVal = new ChoiceBox<>();
        ArrayList<Integer> yearArrayList = getYears();
        yearVal.getItems().addAll(yearArrayList);

        // A text field for people to enter the year a galamsey report started
//        TextField txtUser2 = new TextField();
//        txtUser2.setPromptText("Year Of Event");
        grid.add(yearVal, 1, 2);

        Label label3 =  new Label("Longitude");
        grid.add(label3, 0, 3);

        // Uncomment this if it all goes wrong
        TextField txtUser3 = new TextField();
        txtUser3.setPromptText("Longitude");
        grid.add(txtUser3, 1, 3);

        Label label4 =  new Label("Latitude");
        grid.add(label4, 0, 4);

        // Uncomment this if it all goes wrong
        TextField txtUser4 = new TextField();
        txtUser4.setPromptText("Latitude");
        grid.add(txtUser4, 1, 4);

        Label obsLabel = new Label("Select Observatory");
        grid.add(obsLabel, 0, 5);
        ChoiceBox<String> obs = new ChoiceBox<>();
        ArrayList<String> mu = DBtrial.getObservatoryNames();
        obs.getItems().addAll(mu);
        grid.add(obs, 1, 5);


        // You need a drop box for all the observatory names
        Button enterRecords = new Button("Enter Records");
        grid.add(enterRecords, 1, 6);
        enterRecords.setOnAction(e -> System.out.println(isInt1(yearVal, txtUser3, txtUser4, galVal, obs)));
        enterRecords.setOnAction(e -> setGal(yearVal, txtUser3, txtUser4, galVal, obs));


        // This is a button to go back to the start page
        Button goToStartPage = new Button("Go back to start page");
        grid.add(goToStartPage, 1, 7);

        goToStartPage.setOnAction(e -> window.setScene(scene2));
        // Ending of code for the galamsey record entry page ///////////////////////////////////////////////////////////




        // Start of the code for creating a new Observatory ////////////////////////////////////////////////////////////
        Text obsText = new Text("Add an Observatory");
        obsText.setFont(Font.font("Times New Roman bold", FontWeight.LIGHT, FontPosture.REGULAR, 25));
        newObservatory.add(obsText,0, 0);

        // Allows user to input the observatory name
        Label obsNameLabel = new Label("Observatory Name");
        newObservatory.add(obsNameLabel, 0, 1);
        TextField obsName = new TextField();
        obsName.setPromptText("Enter Observatory Name");
        newObservatory.add(obsName, 1, 1);


        // Allows users to input the area covered by the observatory
        Label areaCovered = new Label("Area Covered");
        newObservatory.add(areaCovered, 0, 2);
        TextField obsAc = new TextField();
        obsAc.setPromptText("Enter Area Covered");
        newObservatory.add(obsAc, 1, 2);



        // A choice box that allows user to select what year an observatory started
        ChoiceBox<Integer> obsYears = new ChoiceBox<>();
        obsYears.getItems().addAll(getYears());
        Label yearStarted = new Label("Year Started");
        newObservatory.add(yearStarted, 0, 3);
        newObservatory.add(obsYears, 1, 3);

        // Allows users to enter the country the observatory is located
        Label countryLocation = new Label("Country Location");
        newObservatory.add(countryLocation, 0, 4);
        ChoiceBox<String>  countries = new ChoiceBox<>();
        ArrayList<String> countryNames = new ArrayList<>(10);
        countryNames.add("Nigeria");
        countryNames.add("Ghana");
        countryNames.add("Japan");
        countryNames.add("Russia");
        countryNames.add("India");
        countryNames.add("USA");
        countryNames.add("China");
        countryNames.add("Poland");
        countryNames.add("France");
        countryNames.add("England");
        countryNames.add("Finland");
        countryNames.add("Scotland");
        countryNames.add("Germany");
        countryNames.add("Sweden");
        countryNames.add("Netherlands");
        countryNames.add("Portugal");
        countryNames.add("Italy");
        countries.getItems().addAll(countryNames);

        TextField obsCountry = new TextField();
        obsCountry.setPromptText("Enter Country Location");
        newObservatory.add(countries, 1, 4);


        // This is the button that allows the user to add the observatory to the records
        Button addObsButton = new Button("Add Observatory");
        newObservatory.add(addObsButton, 1, 5);
        addObsButton.setOnAction(e -> System.out.println(validateObs(obsName, obsAc, obsYears, countries)));
        addObsButton.setOnAction(e -> setObs(obsName, obsAc, obsYears, countries));


        // This button allows users to go back to the home/start page
        Button goBack = new Button("Return to start page");
        newObservatory.add(goBack, 1, 6);
        goBack.setOnAction(e -> window.setScene(scene2));

        // End of the code for creating a new Observatory //////////////////////////////////////////////////////////////


        // Start of code for the record page ///////////////////////////////////////////////////////////////////////////
        Text recText = new Text("Check records from Specific Observatories");
        recText.setFont(Font.font("Times New Roman bold", FontWeight.LIGHT, FontPosture.REGULAR, 20));
        //recordGrid.add(recText,0, 0);


        // Column for the gal value
        TableColumn<Galamsey, Integer> galValColumn = new TableColumn<>("Galamsey Value");
        galValColumn.setMinWidth(100);
        galValColumn.setCellValueFactory(new PropertyValueFactory<>("colourValue"));

        TableColumn<Galamsey, String> vegColumn = new TableColumn<>("Vegetation colour");
        vegColumn.setMinWidth(100);
        vegColumn.setCellValueFactory(new PropertyValueFactory<>("vegColour"));

        TableColumn<Galamsey, Integer> yearColumn = new TableColumn<>("Year Started");
        yearColumn.setMinWidth(100);
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("yearOfEvent"));

        TableColumn<Galamsey, Integer> longColumn = new TableColumn<>("Longitude");
        longColumn.setMinWidth(100);
        longColumn.setCellValueFactory(new PropertyValueFactory<>("longitude"));

        TableColumn<Galamsey, Integer> latColumn = new TableColumn<>("Latitude");
        latColumn.setMinWidth(100);
        latColumn.setCellValueFactory(new PropertyValueFactory<>("latitude"));

        TableColumn<Galamsey, Integer> galIdColumn = new TableColumn<>("GalamseyID");
        galIdColumn.setMinWidth(100);
        galIdColumn.setCellValueFactory(new PropertyValueFactory<>("galamseyId"));


        table = new TableView<>();
        //table.setItems(getProduct());
        table.getColumns().addAll(galIdColumn, galValColumn, vegColumn, yearColumn, longColumn, latColumn);

        //recordGrid.add(table, 2, 1);

        Label obsLabelInRec = new Label("Select Observatory");
        //recordGrid.add(obsLabel, 0, 1);
        ChoiceBox<String> obsNom = new ChoiceBox<>();
        ArrayList<String> observatoryNames = DBtrial.getObservatoryNames();
        obsNom.getItems().addAll(observatoryNames);
        //recordGrid.add(obsNom, 0, 2);

        Label deleteRecord = new Label("Enter the Galamsey ID of what you want to delete");
        TextField galId = new TextField();
        galId.setPromptText("Enter Galamsey Id");
        Button deleteRecordButton = new Button("Delete record");
        recordGrid.addColumn(2, deleteRecord, galId, deleteRecordButton);
        deleteRecordButton.setOnAction(e -> System.out.println(delGalId(galId)));
        //.deleteRecordButton.setOnAction(e -> table.setItems(DBtrial.loadGal()));



        Button getAllRecords = new Button("Get all records");
        getAllRecords.setOnAction(e -> table.setItems(DBtrial.loadGal()));


        Button backToHome = new Button("Back to home page");
        //recordGrid.add(backToHome, 0, 4);
        backToHome.setOnAction(e -> window.setScene(scene2));


        Button viewRecords = new Button("View records");
        //recordGrid.add(viewRecords, 0, 3);
        viewRecords.setOnAction(e -> getRecordsOfObs(obsNom.getValue(), obsNom));


        recordGrid.addColumn(1, recText, obsLabelInRec, obsNom, viewRecords,getAllRecords, backToHome);
        //recordGrid.add(spaceMakers, 2, 1);
        recordGrid.add( table, 1, 7);
        //tableGrid.add(table, 1, 1);


        // End of code for the record page /////////////////////////////////////////////////////////////////////////////
        window.setScene(scene2);
        window.show();
    }

    /**
     * This method validates the input entered by the user when imputing the details of a new galamsey report
     * @param yearInput This is the text field that takes in the year a galamsey report started
     * @param longitudeInput This is the text field that takes in the longitude location of the galamsey location a report is based on
     * @param latitudeInput This is the text field that takes in the latitude location of the galamsey location a report is based on
     * @param galValInput This is the choice box that allows users to select a galamsey value of the galamsey report
     * @param obsChoice This is a choice box for users to select what observatory they want to record a galamsey report in
     * @return This method returns true if all the users input has been validated
     */
    private boolean isInt1(ChoiceBox<Integer> yearInput, TextField longitudeInput, TextField latitudeInput, ChoiceBox<Integer> galValInput,
    ChoiceBox<String> obsChoice) {
        try {
            int yearValue = yearInput.getValue();
            int longitudeValue = Integer.parseInt(longitudeInput.getText());
            int latitudeValue = Integer.parseInt(latitudeInput.getText());

            try {
                int galValValue = galValInput.getValue();
                String obsName = obsChoice.getValue();
            } catch(NullPointerException err) {
                return false;
            }

            System.out.println("They are all integers");
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    /**
     * This method validates the input of the user when imputing the details of an observatory
     * @param name  This is the text field that takes in the name of the observatory
     * @param areaCovered   This is the text field that takes in the are an observatory covers
     * @param year  This text field takes in the year an observatory was founded
     * @param countryLocation   This text field takes in the country where the observatory is found
     * @return  The method returns true if all the input entered by the user is valid
     */
    private boolean validateObs(TextField name, TextField areaCovered, ChoiceBox<Integer> year, ChoiceBox<String> countryLocation) {
        try {
            int obsYear = year.getValue();
            double obsAc = Double.parseDouble(areaCovered.getText());


            try {
                if(name.getText().isEmpty()) {
                    System.out.println("FAIL!!");
                    return false;
                }
                if(countryLocation.getValue().isEmpty()) {
                    System.out.println("FAIL!!");
                    return false;
                }
                if(String.valueOf(obsYear).length() != 4) {
                    return false;
                }
            } catch(NullPointerException err) {
                System.out.println("FAIL!!");
                return false;
            }
            System.out.println("PASS!!");
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    /**
     * This method calls the static method in the class "DBTrial" that adds GALAMSEY values to the GALAMSEY database
     * @param txtUser2 This is the choice box a user selects a galamsey ID from
     * @param txtUser3 This is the text field a user enters their
     * @param txtUser4 This is the text field a user enters their
     * @param galVal This is a choice box where the user selects
     * @param obs This is a choice box where a user selcts the observatory they want to store their records in
     */
    private void setGal(ChoiceBox<Integer> txtUser2, TextField txtUser3, TextField txtUser4, ChoiceBox<Integer> galVal, ChoiceBox<String> obs) {
        if(isInt1(txtUser2, txtUser3, txtUser4, galVal, obs)) {
            DBtrial.insertIntoGal(galVal.getValue(), txtUser2.getValue(), Integer.parseInt(txtUser3.getText()),
                    Integer.parseInt(txtUser4.getText()), obs.getValue());
        }
    }

    /**
     * This method calls on a method from the "DBtrial" class that allows users to delete certain galamsey records from the table
     * @param galId This is the text field where a user types in the galamsey ID of the record they want to delete
     * @return The method returns true if deleting the record was successful and false otherwise
     */
    private boolean delGalId(TextField galId) {
        try {
            int galamseyId = Integer.parseInt(galId.getText());
            DBtrial.DeleteGalRecord(galamseyId);
            return true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * This method calls the "IntsertIntoObservatory" method from the "DBtrial" class which allows users to add a new observatory to the database
     * @param obsName This is the name of the observatory
     * @param obsAc This is the area covered by the observatory
     * @param obsYear This is the year the observatory was started
     * @param obsCountry This is the country the observatory was founded
     */
    private void setObs(TextField obsName, TextField obsAc, ChoiceBox<Integer> obsYear, ChoiceBox<String> obsCountry) {
        if(validateObs(obsName, obsAc, obsYear, obsCountry)) {
            DBtrial.insertIntoObservatory(obsName.getText(), Double.parseDouble(obsAc.getText()), obsYear.getValue(),
                    String.valueOf(obsCountry.getValue()));
        }
    }


    /**
     * This method gets all the galamsey records recorded in a given observatory
     * @param name This is the name of the observatory
     * @param obsNameChoice This is the name of the observatory gotten from the choice box
     * @return The method returns true if the galamsey reports from the observatory were successfully found
     */
    private boolean getRecordsOfObs(String name, ChoiceBox<String> obsNameChoice) {
        try {
            table.setItems(DBtrial.loadGalObs(obsNameChoice.getValue()));
            return true;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * This method returns an array list of years (int's) from 1970 till the current year
     * This is to give users a choice box (drop down) of year to choose from instead of inputting theirs
     * @return This method returns an array list of years from 1970 till the current year
     */
    private ArrayList<Integer> getYears() {
        ArrayList<Integer> years = new ArrayList<>();
        int year = Calendar.getInstance().get(Calendar.YEAR);
        for(int year1 = 1970; year1 <= year; year1++) {
            years.add(year1);
        }
        return years;
    }


}

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
import java.util.IllegalFormatException;
import java.util.Scanner;

public class MonitoringIO {

    public static void main(String[] args) {

        Galamsey galamsey = new Galamsey(2, 2019,50,54);
        Galamsey galamsey2 = new Galamsey(3, 2020,180,90);
        Galamsey galamsey3 = new Galamsey(3, 2004,120,45);
        Galamsey galamsey4 = new Galamsey(2, 2000,100,32);
        Galamsey galamsey5 = new Galamsey(1, 2012,45,45);
        Galamsey galamsey6 = new Galamsey(2, 2005,65,78);
        Galamsey galamsey7 = new Galamsey(3, 2005,98,32);
        Galamsey galamsey8 = new Galamsey(1, 2003,72,43);
        Galamsey galamsey9 = new Galamsey(1, 2003,180,90);

        Observatory japanBranch = new Observatory("Hidden Leaf Observatory", "Japan",
                45.6, 2005);
        Observatory chinaBranch = new Observatory("Shanghai knight Observatory", "China",
                21.8, 2004);
        Observatory lagosBranch = new Observatory("Eko Observatory", "Nigeria",
                102.3, 2010);
        Observatory newJerseyBranch = new Observatory("RB Observatory", "USA",
                378.6, 2000);

        japanBranch.addGalamseyReport(galamsey);
        japanBranch.addGalamseyReport(galamsey2);
        chinaBranch.addGalamseyReport(galamsey3);
        chinaBranch.addGalamseyReport(galamsey4);
        lagosBranch.addGalamseyReport(galamsey5);
        lagosBranch.addGalamseyReport(galamsey6);
        lagosBranch.addGalamseyReport(galamsey7);
        newJerseyBranch.addGalamseyReport(galamsey8);
        newJerseyBranch.addGalamseyReport(galamsey9);
        ArrayList<Observatory> observatories = new ArrayList<>(4);
        observatories.add(lagosBranch);
        observatories.add(newJerseyBranch);
        observatories.add(japanBranch);
        observatories.add(chinaBranch);
        //===================================================================================================================
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            System.out.println("---------- Welcome to the monitoringIO ----------");
            System.out.println("Enter the number that comes after the task you want to perform");
            System.out.println("Enter Observatory Data  (1)\tEnter Galamasey Data (2)\nView Galamsey Statistics (3)\t" +
                    "View Galamsey records greater than a certain number (4)\nExit (5)");
            System.out.print("What would you like to do?: ");
            int input = scanner.nextInt(); // Put try catch here
            if(input == 5)
                break;
            switch(input) {


                case 1:
                    System.out.print("Please enter the year the observatory was established: ");
                    String yearStarted = scanner.next(); // Try catch
                    try {
                        int year = Integer.parseInt(yearStarted);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        break;
                    }

                    System.out.print("Enter the area covered by the observatory: ");

                    String areaCovered = scanner.next(); // Try catch
                    try {
                        double areaC = Double.parseDouble(areaCovered); // Try catch
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                    Observatory observatory1 = new Observatory(Double.parseDouble(areaCovered), Integer.parseInt(yearStarted));


                    //Why is scanner.nextLine() always fooling
                    while (true) {
                        System.out.print("Please enter the country where this observatory is found: ");
                        String countryLocation = scanner.nextLine(); // Another try catch?
                        if (countryLocation.isEmpty())
                            System.out.println("Observatory name cannot be empty");
                        else {
                            observatory1.setGalamseyCountryLocation(countryLocation);
                            break;
                        }
                    }

                    while (true) {
                        System.out.print("Please enter the observatory name: ");
                        String obsName = scanner.nextLine(); // Try catch
                        if (obsName.isEmpty())
                            System.out.println("Observatory name cannot be empty");
                        else {
                            observatory1.setObservatoryName(obsName);
                            break;
                        }
                    }
                    observatories.add(observatory1);
                    break;

                case 2:
                    System.out.print("Enter Galamsey colour value: ");
                    String input3 = scanner.next(); // Put try catch here
                    try {
                        int galVal = Integer.parseInt(input3);
                        if(galVal > 3 || galVal < 1) {
                            System.out.println("Galamsey colour value is between 1 and 3\n'Green' - 1, 'Yellow' - 2, 'Brown' - 3");
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Galamsey colour value has to be an integer");;
                        break;
                    }

                    System.out.print("Enter the year started: ");
                    String input4 = scanner.next(); // Put another try catch here
                    try {
                        int year4 = Integer.parseInt(input4);
                        if(String.valueOf(year4).length() !=  4 || input4.charAt(0) == '0') {  // This checks whether the year entered has a length of 4
                            System.out.println("Invalid year entered");
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("year has to be an interger");;
                        break;
                    }


                    Galamsey gala = new Galamsey(Integer.parseInt(input3), Integer.parseInt(input4));

                    while (true) {
                        System.out.print("Enter Longitude: ");
                        String longitudeVal = scanner.next(); // Also have to throw try catch

                        try {
                            double longitude = Double.parseDouble(longitudeVal);
                            if (longitude < -180 || longitude > 180) {
                                System.out.println("Longitude is between -180 and 180 degrees");
                                gala.setPositionLongitude(longitude);
                            } else
                                break;
                        } catch (Exception e) {
                            e.printStackTrace();
                            break;
                        }
                    }

                    while (true) {
                        System.out.print("Enter Latitude: ");
                        String latitudeVal = scanner.next(); // Also have to throw try catch
                        try {
                            double latitude = Double.parseDouble(latitudeVal);
                            if (latitude < -90 || latitude > 90) {
                                System.out.println("Latitude is between -90 and 90 degrees");
                                gala.setPositionLatitude(latitude);
                            } else
                                break;
                        } catch (Exception e) {
                            e.printStackTrace();
                            break;
                        }
                    }


                    int counter = 1;
                    for (Observatory obj : observatories) {
                        System.out.println(obj.getObservatoryName() + " (" + counter + ")");
                        counter++;
                    }

                    while (true) {
                        System.out.println("What observatory do you want to save this record in?: ");
                        String input5val = scanner.next(); // Another try catch here
                        try {
                            int input5 = Integer.parseInt(input5val);
                            if (input5 > 0 && input5 <= observatories.size()) {
                                observatories.get(input5 - 1).addGalamseyReport(gala);
                                break;
                            } else
                                System.out.println("The number you entered is not in the options listed");
                        } catch (Exception e) {
                            e.printStackTrace();
                            break;
                        }
                    }

                    break;

                case 3: // Make this part better
                    int j = 0;

                    for (Observatory obs : observatories) {
                        j = Math.max(j, obs.getLargestGalamseyVal());
                    }
                    System.out.println("The highest Galamsey value in record is: " + j);
                    break;


                case 4:
                    System.out.println("1 - 'Green', 2 - 'Yellow', 3 - 'Green");
                    System.out.print("Enter a number between 0 and 2: ");
                    String input2Val = scanner.next(); // Put try catch here fam
                    //System.out.println();
                    try {
                        int input2 = Integer.parseInt(input2Val);
                        if (input2 >= 3 || input2 < 0) {
                            System.out.println();
                            System.out.println("There is no galamsey value greater than 3 or less than 1");
                            System.out.println();
                            break;
                        }
                        System.out.println("------- Viewing Galamsey records greater than " + input2 + " -------");
                        for (Observatory i : observatories) {
                            i.getGalamseyValGreater(input2);
                        }
                        break;

                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
            }
        }
    }
}

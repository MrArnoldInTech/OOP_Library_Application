// Fruish, Arnold,
// This was a University based assignment. I have made changes to suit GitHub and added some small changes in as well.

/* A program that saves objects to a library. This program allows you to select items for the library and
choose if you want to "Select", "Borrow", "Return", "Rate" and to "Search".
*/
package UniversityLibrary;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to Handle Errors
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;

public class Main {
    public static void displayInfo() { //Always a must to have this included.
        System.out.println("-------------------------------------");
        System.out.println("OOP Library Application");
        System.out.println("Submitted by: Github @MrArnoldInTech");
        System.out.println("-------------------------------------");
    }

    static List<Movie> Movies = new ArrayList<Movie>();
    static List<Book> Books = new ArrayList<Book>();
    static List<Journal> Journals = new ArrayList<Journal>();
    static List<Library> Items = new ArrayList<Library>();


    public Main() {
        displayInfo();
        int ID = 0;
        String title = null;
        int year = 0;
        String director = null;
        String author = null;
        int numberofpages = 0;
        int number = 0;
        int volume = 0;
        String status = "available";
        int numberofreviewers = 0;
        float averagerating = 0;
        int maxnumbeofdays = 0;
        String date = null;
        
        try {
            File myObj = new File("Resources/library.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNext()) {
                String Line = myReader.nextLine();
                String[] details = Line.split(",");
                String type = details[0];

                if (type.equals("Movie")) {
                    ID = Integer.parseInt(details[1]);
                    title = details[2];
                    year = Integer.parseInt(details[3]);
                    director = details[4];
                    maxnumbeofdays = 7;
                    Movie Mov = new Movie(type, ID, title, year, director, averagerating, numberofreviewers, maxnumbeofdays, status, date);
                   // Library Lib = new Library();
                    //Movies.add(Mov);
                    Items.add(Mov);
                }
                if (type.equals("Book")) {
                    ID = Integer.parseInt(details[1]);
                    title = details[2];
                    year = Integer.parseInt(details[3]);
                    author = details[4];
                    numberofpages = Integer.parseInt(details[5]);
                    maxnumbeofdays = 28;
                    Book Bk = new Book(type, ID, title, year, author, numberofpages, averagerating, numberofreviewers, maxnumbeofdays, status, date);
                   // Library Lib = new Library();
                   // Books.add(Bk);
                    Items.add(Bk);
                }
                if (type.equals("Journal")) {
                    ID = Integer.parseInt(details[1]);
                    title = details[2];
                    year = Integer.parseInt(details[3]);
                    volume = Integer.parseInt(details[4]);
                    number = Integer.parseInt(details[5]);
                    maxnumbeofdays = 14;
                    Journal Jour = new Journal(type, ID, title, year, volume, number, averagerating, numberofreviewers, maxnumbeofdays, status, date);
                    //Library Lib = new Library();
                   // Journals.add(Jour);
                    Items.add(Jour);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // My ArrayList to read all the data into one
        for (Library Lib : Items){
            System.out.println(Lib.toString());
            }
      /*  for (Movie Mov : Movies) {
            System.out.println(Mov.toString());
        }
        for (Book Bk : Books) {
            System.out.println(Bk.toString());
        }
        for (Journal Jour : Journals) {
            System.out.println(Jour.toString());
        } */
    }
    static void Readingtheinput() {

        while (true) {
            int idsearchvalue = 0;
            Scanner myLine = new Scanner(System.in);
            String back = "b";
            String result = null;
            int myidtemp = 0;
            int itemfound = 0;
            String quit = "q";
            String id_i = "i";
            int[] numberofsearch = new int[100];
            String[] temptitle = new String[100];
            int max = 0;
            int i = 0;
            String answerofwhichnumber = null;

            // 3 options to choose from "quit", "search by id" or a "phrase in the title"
            System.out.println("Enter 'q' to quit, enter 'i' to search by ID, or enter any other key to search by phrase in title");
            String myInputValue = myLine.nextLine();


            if(!myInputValue.equals(id_i) && !myInputValue.equals(quit)) { //if its not I or Q and any other key then it will search through title

                System.out.println("Enter phrase in title to start search, or enter 'b' to go back to chose search method");
                myInputValue = myLine.nextLine();

                if(myInputValue.equals(back)){
                    continue;
                }

                for (Library Lib : Items) {
                    if (Lib.getTitle().contains(myInputValue) ) { //for searching with title

                        numberofsearch[i]++;
                        temptitle[numberofsearch[i]] = Lib.toString();
                        System.out.println("*" + " " + numberofsearch[i] + "---------------------------------------------");
                        System.out.println(Lib.toString());
                    }
                }

                max = numberofsearch[i];

                try {
                    if(max == 0){
                        throw new Exception("WARNING NO ITEM WAS FOUND OR INVALID PHRASE! RESTARTING SEARCH");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }

                for (Library Lib : Items) {
                    if (Lib.getTitle().contains(myInputValue) && !myInputValue.equals("b")) {  //for searching with title
                        System.out.println();
                        System.out.println("Enter item number to select item, or enter any other key to continue searching");
                        myInputValue = myLine.nextLine();
                        int choosennumber = 0;

                        boolean numeric = true;
                        try {
                            choosennumber = Integer.parseInt(myInputValue);
                        }catch (NumberFormatException e){
                            numeric = false;
                        }
                        if(!numeric) {
                            break;
                        }

                        for (int k = 1; k <= max; k++) {

                            if (k == choosennumber) {

                                System.out.println("Selected item is");
                                System.out.println("---------------------------------------------");
                                System.out.println(temptitle[choosennumber]);
                                myidtemp = Lib.getID();

                                BorrowandRate(myidtemp, "");
                                // Call to other function.
                            }
                        }
                    }
                }
            }

            //Option 1 of first statement
            if (myInputValue.equals((quit))) {
                System.exit(32);
            }

            //Option 2 of first statement
            if (myInputValue.equals(id_i)) {

                // Two options to choose from, b or a 3-digit number to choose from
                System.out.println("Enter ID to start search, or enter 'b' to go back to choose search method");
                myInputValue = myLine.nextLine();

                if (myInputValue.equals(back)) {
                    continue;
                }

                try {
                    if (myInputValue.matches("[0-9]+") && myInputValue.length() == 3) {

                    }
                    else {
                        throw new Exception("NOT A VALID INPUT! RESTARTING SEARCH!");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    Readingtheinput();
                }

                idsearchvalue = Integer.parseInt(myInputValue);

                for (Library Lib: Items) {
                    if (Lib.getID() == idsearchvalue) {
                       // itemfound = "not found";
                        itemfound++;
                    }
                }

                try {
                        if(itemfound == 0){
                            throw new Exception("INVALID ID NUMBER OR NOT FOUND IN THE LIST! RESTARTING SEARCH");
                        }

                } catch (Exception e) {
                    e.printStackTrace();
                    Readingtheinput();
                }


                for (Library Lib : Items) {
                    String l = (Lib.toString());
                    if (idsearchvalue == (Lib.getID())) {
                        System.out.println("-----------------------------------------------------");
                        System.out.println(l);
                        System.out.println();
                        result = l;
                       // myidtemp = Lib.getID();
                    }
                }

                // There are two options here, any key to select, else press i to search another id again.
                System.out.println("Enter 'i' to search other item by ID, or enter any other key to select this item");
                myInputValue = myLine.nextLine();

                if(myInputValue.equals(id_i)){
                    continue;
                }

                if (!myInputValue.equals(id_i)) {

                    System.out.println();
                    System.out.println("Selected item is");
                    System.out.println("-----------------------------------------------------");
                    System.out.println(result);
                    System.out.println();

                    for(Library Lib : Items){
                        if(Lib.getStatus().equals("on loan")){
                            RateandReturn(idsearchvalue, "");
                        }
                    }
                    BorrowandRate(idsearchvalue, "");
                }
            }

        }
    }


    static void BorrowandRate(int x, String s) {

        String borrow = "b";
        String _rate = "a";

        float myratingtemp = 0;
        int myidtemp = 0;
        myidtemp = x;
        String from_exception = s;

        final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date currentdate = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(currentdate);
        c.add(Calendar.DATE, 28);
       // Date currentDateamount = c.getTime();

        Scanner myLine = new Scanner(System.in);
        String myInputValue = null;

                    myInputValue = _rate;
                if(!from_exception.equals(_rate)) {

                    System.out.println("Enter 'b' to borrow the item, enter 'a' to rate the item, or enter any other key to restart");
                     myInputValue = myLine.nextLine();

                    if ((!myInputValue.equals(borrow)) && (!myInputValue.equals(_rate))) {
                        Readingtheinput();
                    }

                }
            if ((!myInputValue.equals(borrow)) && (!myInputValue.equals(_rate))) { // If its not equal to b or a then restart from the begining
                return;
            }


            if (myInputValue.equals(_rate)) {
                System.out.println("Please enter your rating (0 - 10)"); //first rating
                myInputValue = myLine.nextLine();

                myratingtemp = Float.parseFloat(myInputValue);

                try {
                    if((myratingtemp > 10) || (myratingtemp < 0)) {

                    throw new Exception("Not a valid number rating");
                      }

                } catch (Exception e) {
                    e.printStackTrace();
                    BorrowandRate(myidtemp, "a");
                }


                for (Library Lib : Items) {
                    if (myidtemp == Lib.getID()) {

                        Lib.setNumberofvieweres(Lib.getNumberofreviewers() + 1);
                        Lib.setAveragerating((Lib.getAveragerating() + myratingtemp) / Lib.getNumberofreviewers());
                        System.out.println("The item's new average rating is" + " " + Lib.getAveragerating());

                    }
                }
                for (Library Lib : Items) {
                    if (myidtemp == Lib.getID()) {
                        System.out.println("Selected item is");
                        System.out.println("-----------------------------------------------------");
                        System.out.println(Lib.toString());
                    }
                }
                BorrowandRate(myidtemp, "");
            }

            if (myInputValue.equals(borrow)) {

                for (Library Lib : Items) {

                    if (myidtemp == Lib.getID()) {

                        Lib.setStatus("on loan");

                        Calendar Mm = Calendar.getInstance();
                        Mm.setTime(currentdate);
                        Mm.add(Calendar.DATE, Lib.getMaxnumbeofdays());
                        Date newchangeindate = Mm.getTime();
                        //System.out.println(dateFormat.format(newchangeindate));
                       String test = dateFormat.format(newchangeindate);
                       Lib.setDate(test);
                        System.out.println("The item's due date is" + " " + Lib.getDate());
                        System.out.println();
                        myidtemp = Lib.getID();
                        System.out.println("Selected item is");
                        System.out.println("-----------------------------------------------------");
                    }
                }
                for (Library Lib : Items) {
                    if (myidtemp == Lib.getID()) {
                        System.out.println(Lib.toString());
                    }
                }

                for (Library Lib : Items){
                    if (myidtemp == Lib.getID()) {
                        if (Lib.getStatus().equals("on loan")) {
                       RateandReturn(myidtemp, "");
                        }
                    }

                }

            }
        }

        static void RateandReturn(int x, String s){

            Scanner myLine = new Scanner(System.in);
            int myidtemp = 0;
            float myratingtemp = 0;
            myidtemp = x;
            String _return = "r";
            String _rate = "a";
            String from_exception = s;
            String myInputValue = null;

            myInputValue = _rate;
            if(!from_exception.equals(_rate)) {
                System.out.println("Enter 'r' to return the item, enter 'a' to rate this item, or enter any other key to restart");
                myInputValue = myLine.nextLine();

                if ((!myInputValue.equals(_return)) && (!myInputValue.equals(_rate))) {
                    Readingtheinput();
                }

            }
            if (myInputValue.equals(_return)) {

                System.out.println("The item is returned");

                for (Library Lib : Items) {
                    if (myidtemp == Lib.getID()) {
                        Lib.setStatus("available");
                    }
                }

                for (Library Lib : Items) {
                    if (myidtemp == Lib.getID()) {
                        System.out.println();
                        System.out.println("Selected item is");
                        System.out.println("-----------------------------------------------------");
                        System.out.println(Lib.toString());
                    }
                }
                BorrowandRate(myidtemp, "");
            }

            if ((!myInputValue.equals(_return)) && (!myInputValue.equals(_rate))) {
               //return;
                Readingtheinput();
            }

            if (myInputValue.equals(_rate)) {

                System.out.println("Please enter your rating (0 - 10)");
                myInputValue = myLine.nextLine();

                myratingtemp = Float.parseFloat(myInputValue);

                try {
                    if((myratingtemp > 10) || (myratingtemp < 0)) {

                        throw new Exception("Not a valid number rating! Please Try Again!");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    RateandReturn(myidtemp, "a");
                }

                for (Library Lib : Items) {
                    String l = (Lib.toString());

                    if (myidtemp == Lib.getID()) {

                        Lib.setNumberofvieweres(Lib.getNumberofreviewers() + 1);
                        Lib.setAveragerating((Lib.getAveragerating() + myratingtemp) / Lib.getNumberofreviewers());
                        System.out.println("The item's new average rating is" + " " + Lib.getAveragerating());
                        System.out.println();
                    }
                }

                for (Library Lib : Items) {
                    if (myidtemp == Lib.getID()) {
                        System.out.println("Selected item is");
                        System.out.println("-----------------------------------------------------");
                        System.out.println(Lib.toString());
                        System.out.println();
                    }
                }
                RateandReturn(myidtemp, "");
            }
    }

    public static void main(String[] args) {
         new Main();
         Readingtheinput();
    }
}

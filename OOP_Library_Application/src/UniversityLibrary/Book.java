package UniversityLibrary;
public class Book extends Library {
   private String author;
   private int numberofpages;

    public Book(String type, int ID, String title, int year, String author, int numberofpages, float averagerating,  int numberofreviewers, int maxnumbeofdays, String status, String date ){
        super(type, ID, title, year, averagerating, numberofreviewers, maxnumbeofdays, status, date);
        setAuthor(author);
        setNumberofpages(numberofpages);
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setNumberofpages(int numberofpages){
        this.numberofpages = numberofpages;
    }

    public String getAuthor(){
        return author; }

    public int numberofpages() {
        return numberofpages;}

    @Override
    public String toString() {
        if (getStatus().equals("on loan")) {
            return    "Type:" + " " + getType() + "\n"
                    + "Title:" + " " + getTitle() + "\n"
                    + "ID:" + " " + getID() + "\n"
                    + "Year:" + " " + getYear() + "\n"
                    + "Average rating:" + " " + getAveragerating() + "\n"
                    + "Number of reviewers:" + " " + getNumberofreviewers() + "\n"
                    + "Status:" + " " + getStatus() + "\n"
                    + "Due date:" + " " + getDate() + "\n"
                    + "Author" + " " + this.author + "\n"
                    + "Number of pages:" + " " + this.numberofpages + "\n"
                    + "Max number of days for borrowing:" + " " + getMaxnumbeofdays() + "\n"
                    + "-----------------------------------------------------";
        }
    else {
            return    "Type:" + " " + getType() + "\n"
                    + "Title:" + " " + getTitle() + "\n"
                    + "ID:" + " " + getID() + "\n"
                    + "Year:" + " " + getYear() + "\n"
                    + "Average rating:" + " " + getAveragerating() + "\n"
                    + "Number of reviewers:" + " " + getNumberofreviewers() + "\n"
                    + "Status:" + " " + getStatus() + "\n"
                    + "Author" + " " + this.author + "\n"
                    + "Number of pages:" + " " + this.numberofpages + "\n"
                    + "Max number of days for borrowing:" + " " + getMaxnumbeofdays() + "\n"
                    + "-----------------------------------------------------";
            }
    }
}
package UniversityLibrary;

public class Movie extends Library  {
private String director;

    public Movie(String type, int ID, String title, int year, String director,  float averagerating,  int numberofreviewers, int maxnumbeofdays, String status, String date ){
        super(type, ID, title, year, averagerating, numberofreviewers, maxnumbeofdays, status, date);

        setDirector(director);

    }

    public void setDirector(String director){
        this.director = director;
    }

    public String getDirector(){
        return director;
    }

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
                    + "Director:" + " " + this.director + "\n"
                    + "Max number of days for borrowing:" + " " + getMaxnumbeofdays() + "\n"
                    + "-----------------------------------------------------";
        }
        else  {
            return    "Type:" + " " + getType() + "\n"
                    + "Title:" + " " + getTitle() + "\n"
                    + "ID:" + " " + getID() + "\n"
                    + "Year:" + " " + getYear() + "\n"
                    + "Average rating:" + " " + getAveragerating() + "\n"
                    + "Number of reviewers:" + " " + getNumberofreviewers() + "\n"
                    + "Status:" + " " + getStatus() + "\n"
                    + "Director:" + " " + this.director + "\n"
                    + "Max number of days for borrowing:" + " " + getMaxnumbeofdays() + "\n"
                    + "-----------------------------------------------------";
        }
    }
}
package UniversityLibrary;
public class Journal extends Library {
  private  int volume;
  private int number;

    public Journal(String type, int ID, String title, int year, int volume, int number, float averagerating,  int numberofrevieweres, int maxnumbeofdays, String status, String date ){
        super(type, ID, title, year, averagerating, numberofrevieweres, maxnumbeofdays, status, date);
        setVolume(volume);
        setNumber(number);
    }

    public void setVolume(int volume){
        this.volume = volume;
    }
    public void setNumber(int number){
        this.number = number;
    }

    public int getVolume(){
        return volume;
    }

    public int getNumber(){
        return number;
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
                    + "Volume:" + " " + this.volume + "\n"
                    + "Number:" + " " + this.number + "\n"
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
                    + "Volume:" + " " + this.volume + "\n"
                    + "Number:" + " " + this.number + "\n"
                    + "Max number of days for borrowing:" + " " + getMaxnumbeofdays() + "\n"
                    + "-----------------------------------------------------";
        }
    }
}
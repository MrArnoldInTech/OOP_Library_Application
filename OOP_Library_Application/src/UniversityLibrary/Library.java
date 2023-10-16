package UniversityLibrary;

public class Library {

   protected String type;
   protected int ID;
   protected int year;
   protected String title;
   protected int maxnumberofdays;
   protected float averagerating;
   protected int numberofreviewers;
   protected String status;
   protected String date;


    public Library(String type, int ID, String title, int year, float averagerating,  int numberofreviewers, int maxnumbeofdays, String status, String date ){
        setID(ID);
        setTitle(title);
        setYear(year);
        setType(type);
        setDate(date);

        setNumberofvieweres(numberofreviewers);
        setAveragerating(averagerating);
        setMaxnumbeofdays(maxnumbeofdays);
        setStatus(status);
    }

    public Library() {

    }
    //-------------------------- Set Values Part 1 ------------------------------

    public void setType(String type){
        this.type = type; }

    public void setID(int ID){
        this.ID = ID;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setYear(int year){
        this.year = year;
    }

    public void setDate(String date){
        this.date = date;
    }


//-------------------------- Set Values Part 2 ------------------------------
    public void setNumberofvieweres(int numberofvieweres){
        this.numberofreviewers = numberofvieweres;
    }

    public void setAveragerating(float averagerating){
        this.averagerating = averagerating;
    }

    public void setMaxnumbeofdays(int maxnumbeofdays){
        this.maxnumberofdays = maxnumbeofdays;
    }

    public void setStatus(String status){
        this.status = status;
    }
    //-------------------------- Get Values Part 1  ------------------------------
    public String getType(){
        return type;
    }

    public String getTitle(){
        return title;
    }

    public int getID(){
        return ID;
    }

    public int getYear(){
        return year;
    }

    public String getDate() {
        return date;
    }

//-------------------------- Get Values Part 2  ------------------------------
public int getNumberofreviewers() {

    return numberofreviewers;
}
    public float getAveragerating(){
        return averagerating;
    }

    public int getMaxnumbeofdays(){
        return maxnumberofdays;
    }

    public String getStatus(){
        return status;
    }

}

package tiger.common.dal.persistence.population;

/**
 * Created by Winter on 2016/6/30.
 */
public class SchoolDO {
   private int year;
    private String town;
    private  int town_id;
    private  int primarySchool;
    private  int middleSchool;
    private  int  highSchool;

    public int getMiddleSchool() {
        return middleSchool;
    }

    public void setMiddleSchool(int middleSchool) {
        this.middleSchool = middleSchool;
    }

    public int getHighSchool() {
        return highSchool;
    }

    public void setHighSchool(int highSchool) {
        this.highSchool = highSchool;
    }

    public int getPrimarySchool() {
        return primarySchool;
    }

    public void setPrimarySchool(int primarySchool) {
        this.primarySchool = primarySchool;
    }

    public int getTown_id() {
        return town_id;
    }

    public void setTown_id(int town_id) {
        this.town_id = town_id;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }




}

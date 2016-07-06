package tiger.web.api.form.population;

import tiger.common.util.BeanUtil;
import tiger.core.domain.population.SchoolDomain;
import tiger.web.api.form.BaseForm;
import tiger.web.api.form.FormInterface;

/**
 * Created by Winter on 2016/6/30.
 */
public class SchoolForm  extends BaseForm implements FormInterface {
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


    @Override
    public SchoolDomain convert2Domain()
    {
        SchoolDomain target=new SchoolDomain();
        BeanUtil.copyPropertiesWithIgnores(this,target);
        return target;
    }


}

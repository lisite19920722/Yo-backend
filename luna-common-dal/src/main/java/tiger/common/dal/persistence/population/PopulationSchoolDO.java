package tiger.common.dal.persistence.population;

import tiger.common.dal.persistence.BaseDO;

/**
 * Created by Eason on 2016/3/5.
 */
public class PopulationSchoolDO extends BaseDO {

    private String preyear;

    private String town;

    private Long town_id;

    private Long prePrimarySchool;

    private Long preMiddleSchool;

    private Long preHighschool;


    public String getPreyear() {
        return preyear;
    }

    public void setPreyear(String preyear) {
        this.preyear = preyear;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Long getTown_id() {
        return town_id;
    }

    public void setTown_id(Long town_id) {
        this.town_id = town_id;
    }

    public Long getPrePrimarySchool() {
        return prePrimarySchool;
    }

    public void setPrePrimarySchool(Long prePrimarySchool) {
        this.prePrimarySchool = prePrimarySchool;
    }

    public Long getPreMiddleSchool() {
        return preMiddleSchool;
    }

    public void setPreMiddleSchool(Long preMiddleSchool) {
        this.preMiddleSchool = preMiddleSchool;
    }

    public Long getPreHighschool() {
        return preHighschool;
    }

    public void setPreHighschool(Long preHighschool) {
        this.preHighschool = preHighschool;
    }
}

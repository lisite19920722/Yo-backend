package tiger.core.domain.population;

import tiger.core.domain.BaseDomain;
import java.util.Date;

/**
 * Created by Winter on 2016/6/10.
 */
public class PopulationStructureDomain extends BaseDomain {


    private static final long serialVersionUID = 4164088481611808017L;

    private Date create_time;
    private Date modify_time;
    private int year;
    private long ageType_id;
    private long sexType_id;
    private int residentPopulation;

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getModify_time() {
        return modify_time;
    }

    public void setModify_time(Date modify_time) {
        this.modify_time = modify_time;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getAgeType_id() {
        return ageType_id;
    }

    public void setAgeType_id(long ageType_id) {
        this.ageType_id = ageType_id;
    }

    public long getSexType_id() {
        return sexType_id;
    }

    public void setSexType_id(long sexType_id) {
        this.sexType_id = sexType_id;
    }

    public int getResidentPopulation() {
        return residentPopulation;
    }

    public void setResidentPopulation(int residentPopulation) {
        this.residentPopulation = residentPopulation;
    }

    public PopulationStructureDomain(int residentPopulation, long sexType_id, int year, Date modify_time, Date create_time, long ageType_id) {
        this.residentPopulation = residentPopulation;
        this.sexType_id = sexType_id;
        this.year = year;
        this.modify_time = modify_time;
        this.create_time = create_time;
        this.ageType_id = ageType_id;
    }
}

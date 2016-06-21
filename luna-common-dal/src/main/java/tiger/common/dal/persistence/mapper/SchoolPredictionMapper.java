package tiger.common.dal.persistence.mapper;

import tiger.common.dal.persistence.population.PopulationSchoolDO;

import java.util.List;

/**
 * Created by Eason on 2016/3/5.
 */
public interface SchoolPredictionMapper {

    List<PopulationSchoolDO> getSchoolList();
}

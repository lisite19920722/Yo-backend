package tiger.common.dal.persistence.mapper;

import tiger.common.dal.persistence.population.PopulationEmployInsuranceDO;

import java.util.List;

/**
 * Created by Eason on 2016/3/5.
 */
public interface EmployInsuranceMapper {

    List<PopulationEmployInsuranceDO> getEmployInsuranceList();

}

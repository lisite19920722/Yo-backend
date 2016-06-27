package tiger.common.dal.persistence.mapper;

import tiger.common.dal.persistence.population.PopulationStructureDO;

import java.util.List;

/**
 * Created by Winter on 2016/6/10.
 */
public interface PopulationStructureMapper {

    List<PopulationStructureDO> select();

    int insertSelective(PopulationStructureDO record);
}

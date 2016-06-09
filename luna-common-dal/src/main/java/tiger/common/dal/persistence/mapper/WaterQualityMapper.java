package tiger.common.dal.persistence.mapper;

import tiger.common.dal.persistence.water.WaterPollutionDO;
import tiger.common.dal.persistence.water.WaterQualityDO;

import java.util.List;

/**
 * Created by lisite on 16/5/22.
 */
public interface WaterQualityMapper {

    List<WaterQualityDO> select();

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WaterQualityDO record);

    int insertSelective(WaterQualityDO record);

}

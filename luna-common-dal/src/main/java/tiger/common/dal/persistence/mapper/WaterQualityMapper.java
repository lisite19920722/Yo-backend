package tiger.common.dal.persistence.mapper;

import tiger.common.dal.persistence.water.WaterQualityDO;

/**
 * Created by lisite on 16/5/22.
 */
public interface WaterQualityMapper {

    WaterQualityDO selectByPrimaryKey(Long id);

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WaterQualityDO record);

    int insertSelective(WaterQualityDO record);

}

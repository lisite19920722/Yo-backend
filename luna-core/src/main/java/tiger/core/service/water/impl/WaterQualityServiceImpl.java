package tiger.core.service.water.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.common.dal.persistence.water.WaterQualityDO;
import tiger.common.dal.persistence.mapper.WaterQualityMapper;
import tiger.core.domain.water.WaterQualityDomain;
import tiger.core.domain.water.convert.WaterQualityConvert;
import tiger.core.service.water.WaterQualityService;

/**
 * Created by lisite on 16/5/22.
 */

@Service
public class WaterQualityServiceImpl implements WaterQualityService{

    @Autowired
    private WaterQualityMapper waterQualityMapper;

    /**
     * Update waterQuality
     *
     * @param id
     * @return the WaterQualityDO
     * @see WaterQualityService#getWaterQualityById(Long)
     */
    @Override
    public WaterQualityDomain getWaterQualityById(Long id) {
        WaterQualityDO waterQualityDO = waterQualityMapper.selectByPrimaryKey(id);
        if (null != waterQualityDO) {
            return WaterQualityConvert.convertDOToDomain(waterQualityDO);
        }
        return null;
    }

    /**
     * Delete waterQuality by id.
     *
     * @param id
     * @return boolean
     * @see WaterQualityService#deleteWaterQualityByID(Long)
     */
    @Override
    public boolean deleteWaterQualityByID(Long id) {
        int deleteResult = waterQualityMapper.deleteByPrimaryKey(id);
        return checkReturnCode(deleteResult);
    }

    /**
     * Update waterQuality
     *
     * @param waterQualityDomain the waterQuality domain
     * @return the boolean
     * @see WaterQualityService#updateWaterQuality(WaterQualityDomain)
     */
    @Override
    public boolean updateWaterQuality(WaterQualityDomain waterQualityDomain) {
        WaterQualityDO waterQualityDO = WaterQualityConvert.convertDomainToDO(waterQualityDomain);
        int updateResult = waterQualityMapper.updateByPrimaryKeySelective(waterQualityDO);
        return checkReturnCode(updateResult);
    }

    /**
     * Create waterQuality
     *
     * @param waterQualityDomain
     * @return
     * @see WaterQualityService#createWaterQuality(WaterQualityDomain)
     */
    @Override
    public WaterQualityDomain createWaterQuality(WaterQualityDomain waterQualityDomain) {
        if (waterQualityDomain == null) {
            return null;
        }

        WaterQualityDO waterQualityDO = WaterQualityConvert.convertDomainToDO(waterQualityDomain);

        if (waterQualityMapper.insertSelective(waterQualityDO) > 0) {
            return WaterQualityConvert.convertDOToDomain(waterQualityDO);
        }

        return null;
    }

    /**
     * Check return code.
     *
     * @param rc the rc
     * @return true, if successful
     */
    private boolean checkReturnCode(int rc) {
        return rc > 0;
    }

}

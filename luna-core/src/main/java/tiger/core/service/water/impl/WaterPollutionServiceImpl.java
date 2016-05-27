package tiger.core.service.water.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.common.dal.persistence.water.WaterPollutionDO;
import tiger.common.dal.persistence.mapper.WaterPollutionMapper;
import tiger.core.domain.water.WaterPollutionDomain;
import tiger.core.domain.water.convert.WaterPollutionConvert;
import tiger.core.service.water.WaterPollutionService;

/**
 * Created by lisite on 16/5/22.
 */

@Service
public class WaterPollutionServiceImpl implements WaterPollutionService{

    @Autowired
    private WaterPollutionMapper waterPollutionMapper;

    /**
     * Update waterPollution
     *
     * @param id
     * @return the WaterPollutionDO
     * @see WaterPollutionService#getWaterPollutionById(Long)
     */
    @Override
    public WaterPollutionDomain getWaterPollutionById(Long id) {
        WaterPollutionDO waterPollutionDO = waterPollutionMapper.selectByPrimaryKey(id);
        if (null != waterPollutionDO) {
            return WaterPollutionConvert.convertDOToDomain(waterPollutionDO);
        }
        return null;
    }

    /**
     * Delete waterPollution by id.
     *
     * @param id
     * @return boolean
     * @see WaterPollutionService#deleteWaterPollutionByID(Long)
     */
    @Override
    public boolean deleteWaterPollutionByID(Long id) {
        int deleteResult = waterPollutionMapper.deleteByPrimaryKey(id);
        return checkReturnCode(deleteResult);
    }

    /**
     * Update waterPollution
     *
     * @param waterPollutionDomain the waterPollution domain
     * @return the boolean
     * @see WaterPollutionService#updateWaterPollution(WaterPollutionDomain)
     */
    @Override
    public boolean updateWaterPollution(WaterPollutionDomain waterPollutionDomain) {
        WaterPollutionDO waterPollutionDO = WaterPollutionConvert.convertDomainToDO(waterPollutionDomain);
        int updateResult = waterPollutionMapper.updateByPrimaryKeySelective(waterPollutionDO);
        return checkReturnCode(updateResult);
    }

    /**
     * Create waterPollution
     *
     * @param waterPollutionDomain
     * @return
     * @see WaterPollutionService#createWaterPollution(WaterPollutionDomain)
     */
    @Override
    public WaterPollutionDomain createWaterPollution(WaterPollutionDomain waterPollutionDomain) {
        if (waterPollutionDomain == null) {
            return null;
        }

        WaterPollutionDO waterPollutionDO = WaterPollutionConvert.convertDomainToDO(waterPollutionDomain);

        if (waterPollutionMapper.insertSelective(waterPollutionDO) > 0) {
            return WaterPollutionConvert.convertDOToDomain(waterPollutionDO);
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
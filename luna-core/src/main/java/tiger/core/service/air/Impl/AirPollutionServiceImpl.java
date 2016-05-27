package tiger.core.service.air.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.common.dal.persistence.air.AirPollutionDO;
import tiger.common.dal.persistence.mapper.AirPollutionMapper;
import tiger.core.domain.air.AirPollutionDomain;
import tiger.core.domain.air.convert.AirPollutionConvert;
import tiger.core.service.air.AirPollutionService;

/**
 * Created by lisite on 16/5/22.
 */

@Service
public class AirPollutionServiceImpl implements AirPollutionService{

    @Autowired
    private AirPollutionMapper airPollutionMapper;

    /**
     * Update airPollution
     *
     * @param id
     * @return the AirPollutionDO
     * @see AirPollutionService#getAirPollutionById(Long)
     */
    @Override
    public AirPollutionDomain getAirPollutionById(Long id) {
        AirPollutionDO airPollutionDO = airPollutionMapper.selectByPrimaryKey(id);
        if (null != airPollutionDO) {
            return AirPollutionConvert.convertDOToDomain(airPollutionDO);
        }
        return null;
    }

    /**
     * Delete airPollution by id.
     *
     * @param id
     * @return boolean
     * @see AirPollutionService#deleteAirPollutionByID(Long)
     */
    @Override
    public boolean deleteAirPollutionByID(Long id) {
        int deleteResult = airPollutionMapper.deleteByPrimaryKey(id);
        return checkReturnCode(deleteResult);
    }

    /**
     * Update airPollution
     *
     * @param airPollutionDomain the airPollution domain
     * @return the boolean
     * @see AirPollutionService#updateAirPollution(AirPollutionDomain)
     */
    @Override
    public boolean updateAirPollution(AirPollutionDomain airPollutionDomain) {
        AirPollutionDO airPollutionDO = AirPollutionConvert.convertDomainToDO(airPollutionDomain);
        int updateResult = airPollutionMapper.updateByPrimaryKeySelective(airPollutionDO);
        return checkReturnCode(updateResult);
    }

    /**
     * Create airPollution
     *
     * @param airPollutionDomain
     * @return
     * @see AirPollutionService#createAirPollution(AirPollutionDomain)
     */
    @Override
    public AirPollutionDomain createAirPollution(AirPollutionDomain airPollutionDomain) {
        if (airPollutionDomain == null) {
            return null;
        }

        AirPollutionDO airPollutionDO = AirPollutionConvert.convertDomainToDO(airPollutionDomain);

        if (airPollutionMapper.insertSelective(airPollutionDO) > 0) {
            return AirPollutionConvert.convertDOToDomain(airPollutionDO);
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
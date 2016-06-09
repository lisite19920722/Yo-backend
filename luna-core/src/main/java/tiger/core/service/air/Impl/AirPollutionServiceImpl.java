package tiger.core.service.air.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.common.dal.persistence.air.AirPollutionDO;
import tiger.common.dal.persistence.air.AirPollutionDO;
import tiger.common.dal.persistence.mapper.AirPollutionMapper;
import tiger.core.domain.air.AirPollutionDomain;
import tiger.core.domain.air.AirPollutionDomain;
import tiger.core.domain.air.convert.AirPollutionConvert;
import tiger.core.domain.air.convert.AirPollutionConvert;
import tiger.core.service.air.AirPollutionService;
import tiger.core.service.air.AirQualityService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lisite on 16/5/22.
 */

@Service
public class AirPollutionServiceImpl implements AirPollutionService{

    @Autowired
    private AirPollutionMapper airPollutionMapper;

    /**
     * Get airPollution
     *
     * @return the AirPollutionDO
     * @see AirPollutionService#getAirPollution()
     */
    @Override
    public List<AirPollutionDomain> getAirPollution() {
        List<AirPollutionDO> airPollutionDOList = airPollutionMapper.select();
        List<AirPollutionDomain> airPollutionDomainList=new ArrayList<>();
        Iterator<AirPollutionDO> e = airPollutionDOList.iterator();
        AirPollutionDO temp = e.next();
        airPollutionDomainList.add(AirPollutionConvert.convertDOToDomain(temp));
        while(e.hasNext()){
            temp = e.next();
            airPollutionDomainList.add(AirPollutionConvert.convertDOToDomain(temp));
        }
        if (airPollutionDomainList != null) {
            return airPollutionDomainList;
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

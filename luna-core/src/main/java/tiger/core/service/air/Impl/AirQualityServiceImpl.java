package tiger.core.service.air.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.common.dal.persistence.air.AirQualityDO;
import tiger.common.dal.persistence.mapper.AirQualityMapper;
import tiger.core.domain.air.AirQualityDomain;
import tiger.core.domain.air.convert.AirQualityConvert;
import tiger.core.service.air.AirQualityService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lisite on 16/5/22.
 */

@Service
public class AirQualityServiceImpl implements AirQualityService{

    @Autowired
    private AirQualityMapper airQualityMapper;

    /**
     * Update airQuality
     *
     * @return the AirQualityDO
     * @see AirQualityService#getAirQuality()
     */
    @Override
    public List<AirQualityDomain> getAirQuality() {
        List<AirQualityDO> airQualityDOList = airQualityMapper.select();
        List<AirQualityDomain> airQualityDomainList=new ArrayList<>();
        Iterator<AirQualityDO> e = airQualityDOList.iterator();
        AirQualityDO temp = e.next();
        airQualityDomainList.add(AirQualityConvert.convertDOToDomain(temp));
        while(e.hasNext()){
            temp = e.next();
            airQualityDomainList.add(AirQualityConvert.convertDOToDomain(temp));
        }
        if (airQualityDomainList != null) {
            return airQualityDomainList;
        }
        return null;
    }

    /**
     * Delete airQuality by id.
     *
     * @param id
     * @return boolean
     * @see AirQualityService#deleteAirQualityByID(Long)
     */
    @Override
    public boolean deleteAirQualityByID(Long id) {
        int deleteResult = airQualityMapper.deleteByPrimaryKey(id);
        return checkReturnCode(deleteResult);
    }

    /**
     * Update airQuality
     *
     * @param airQualityDomain the airQuality domain
     * @return the boolean
     * @see AirQualityService#updateAirQuality(AirQualityDomain)
     */
    @Override
    public boolean updateAirQuality(AirQualityDomain airQualityDomain) {
        AirQualityDO airQualityDO = AirQualityConvert.convertDomainToDO(airQualityDomain);
        int updateResult = airQualityMapper.updateByPrimaryKeySelective(airQualityDO);
        return checkReturnCode(updateResult);
    }

    /**
     * Create airQuality
     *
     * @param airQualityDomain
     * @return
     * @see AirQualityService#createAirQuality(AirQualityDomain)
     */
    @Override
    public AirQualityDomain createAirQuality(AirQualityDomain airQualityDomain) {
        if (airQualityDomain == null) {
            return null;
        }

        AirQualityDO airQualityDO = AirQualityConvert.convertDomainToDO(airQualityDomain);

        if (airQualityMapper.insertSelective(airQualityDO) > 0) {
            return AirQualityConvert.convertDOToDomain(airQualityDO);
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

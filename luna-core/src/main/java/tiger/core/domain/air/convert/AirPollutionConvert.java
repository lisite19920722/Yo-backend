package tiger.core.domain.air.convert;

import tiger.common.dal.enums.BizObjectTypeEnum;

import tiger.common.dal.persistence.air.AirPollutionDO;
import tiger.common.util.BeanUtil;
import tiger.common.util.ByteUtil;
import tiger.core.domain.air.AirPollutionDomain;


/**
 * Created by lisite on 16/5/23.
 */
public class AirPollutionConvert {

    /**
     * Convert Domain to DO.
     *
     * @param airPollutionDomain the airPollution Domain
     * @return the airPollution DO
     */
    public static AirPollutionDO convertDomainToDO(AirPollutionDomain airPollutionDomain) {
        if (null == airPollutionDomain) {
            return null;
        }
        AirPollutionDO airPollutionDO = new AirPollutionDO();
        BeanUtil.copyPropertiesWithIgnores(airPollutionDomain, airPollutionDO);

        return airPollutionDO;
    }


    /**
     * Convert DO to Domain.
     *
     * @param airPollutionDO the airPollution DO
     * @return the airPollution Domain
     */
    public static AirPollutionDomain convertDOToDomain(AirPollutionDO airPollutionDO) {
        if (null == airPollutionDO) {
            return null;
        }
        AirPollutionDomain airPollutionDomain = new AirPollutionDomain();
        BeanUtil.copyPropertiesWithIgnores(airPollutionDO, airPollutionDomain);
        return airPollutionDomain;
    }


}

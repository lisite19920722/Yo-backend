package tiger.core.domain.air.convert;

import tiger.common.dal.persistence.air.AirQualityDO;
import tiger.common.util.BeanUtil;
import tiger.core.domain.air.AirQualityDomain;


/**
 * Created by lisite on 16/5/23.
 */
public class AirQualityConvert {

    /**
     * Convert Domain to DO.
     *
     * @param airQualityDomain the airQuality Domain
     * @return the airQuality DO
     */
    public static AirQualityDO convertDomainToDO(AirQualityDomain airQualityDomain) {
        if (null == airQualityDomain) {
            return null;
        }
        AirQualityDO airQualityDO = new AirQualityDO();
        BeanUtil.copyPropertiesWithIgnores(airQualityDomain, airQualityDO);

        return airQualityDO;
    }


    /**
     * Convert DO to Domain.
     *
     * @param airQualityDO the airQuality DO
     * @return the airQuality Domain
     */
    public static AirQualityDomain convertDOToDomain(AirQualityDO airQualityDO) {
        if (null == airQualityDO) {
            return null;
        }
        AirQualityDomain airQualityDomain = new AirQualityDomain();
        BeanUtil.copyPropertiesWithIgnores(airQualityDO, airQualityDomain);
        return airQualityDomain;
    }


}

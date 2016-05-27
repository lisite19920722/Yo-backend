package tiger.core.domain.water.convert;

import tiger.common.dal.persistence.water.WaterPollutionDO;
import tiger.common.util.BeanUtil;
import tiger.core.domain.water.WaterPollutionDomain;


/**
 * Created by lisite on 16/5/23.
 */
public class WaterPollutionConvert {

    /**
     * Convert Domain to DO.
     *
     * @param waterPollutionDomain the waterPollution Domain
     * @return the waterPollution DO
     */
    public static WaterPollutionDO convertDomainToDO(WaterPollutionDomain waterPollutionDomain) {
        if (null == waterPollutionDomain) {
            return null;
        }
        WaterPollutionDO waterPollutionDO = new WaterPollutionDO();
        BeanUtil.copyPropertiesWithIgnores(waterPollutionDomain, waterPollutionDO);

        return waterPollutionDO;
    }


    /**
     * Convert DO to Domain.
     *
     * @param waterPollutionDO the waterPollution DO
     * @return the waterPollution Domain
     */
    public static WaterPollutionDomain convertDOToDomain(WaterPollutionDO waterPollutionDO) {
        if (null == waterPollutionDO) {
            return null;
        }
        WaterPollutionDomain waterPollutionDomain = new WaterPollutionDomain();
        BeanUtil.copyPropertiesWithIgnores(waterPollutionDO, waterPollutionDomain);
        return waterPollutionDomain;
    }


}

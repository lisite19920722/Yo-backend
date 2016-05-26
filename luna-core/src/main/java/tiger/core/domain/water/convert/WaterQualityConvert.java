package tiger.core.domain.water.convert;

import tiger.common.dal.persistence.water.WaterQualityDO;
import tiger.common.util.BeanUtil;
import tiger.core.domain.water.WaterQualityDomain;


/**
 * Created by lisite on 16/5/23.
 */
public class WaterQualityConvert {

    /**
     * Convert Domain to DO.
     *
     * @param waterQualityDomain the waterQuality Domain
     * @return the message DO
     */
    public static WaterQualityDO convertDomainToDO(WaterQualityDomain waterQualityDomain) {
        if (null == waterQualityDomain) {
            return null;
        }
        WaterQualityDO waterQualityDO = new WaterQualityDO();
        BeanUtil.copyPropertiesWithIgnores(waterQualityDomain, waterQualityDO);

        return waterQualityDO;
    }


    /**
     * Convert DO to Domain.
     *
     * @param waterQualityDO the waterQuality DO
     * @return the waterQuality Domain
     */
    public static WaterQualityDomain convertDOToDomain(WaterQualityDO waterQualityDO) {
        if (null == waterQualityDO) {
            return null;
        }
        WaterQualityDomain waterQualityDomain = new WaterQualityDomain();
        BeanUtil.copyPropertiesWithIgnores(waterQualityDO, waterQualityDomain);
        return waterQualityDomain;
    }


}

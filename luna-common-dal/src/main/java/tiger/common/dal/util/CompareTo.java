/**
 * 310 Inc.
 * All Right Reserved.
 */
package tiger.common.dal.util;

import tiger.common.dal.persistence.BaseDO;
import tiger.common.dal.persistence.power.PowerGdpCorrelationEnterpriseSoloDO;
import tiger.common.dal.persistence.power.PowerGdpCorrelationIndustryDO;

/**
 * Created by Bongo on 16/3/9.
 */
public class CompareTo {

    private CompareTo(){}
    /**
     * DO排序用的比较器
     *
     * @Param source
     * @Param target
     * @return
     * */
    public static int compareDO(BaseDO _source,BaseDO _target){

        int sourceYear=0,targetYear=0,sourceId=0,targetId=0,sourceSeason=0,targetSeason=0;

        if (_source instanceof PowerGdpCorrelationIndustryDO&&_target instanceof PowerGdpCorrelationIndustryDO) {

            PowerGdpCorrelationIndustryDO source = (PowerGdpCorrelationIndustryDO) _source,
            target = (PowerGdpCorrelationIndustryDO) _target;

            sourceYear      = source.getYear();
            targetYear      = target.getYear();
            sourceId        = source.getIndustryId();
            targetId        = target.getIndustryId();
            targetSeason    = target.getSeason();
            sourceSeason    = source.getSeason();
        }
        if (_source instanceof PowerGdpCorrelationEnterpriseSoloDO&&_target instanceof PowerGdpCorrelationEnterpriseSoloDO){

            PowerGdpCorrelationEnterpriseSoloDO source = (PowerGdpCorrelationEnterpriseSoloDO)_source;
            PowerGdpCorrelationEnterpriseSoloDO target = (PowerGdpCorrelationEnterpriseSoloDO)_target;

            sourceYear      = source.getYear();
            sourceId        = source.getEnterpriseId();
            targetYear      = target.getYear();
            targetId        = target.getEnterpriseId();
            targetSeason    = target.getSeason();
            sourceSeason    = source.getSeason();

        }
        if(sourceYear>targetYear)
            return 1;
        else if(sourceYear<targetYear)
            return -1;
        else{
            if (sourceId>targetId) return 1;
            else if(sourceId<targetId)return -1;
            else if(sourceSeason>targetSeason) return 1;
            else return -1;
            }
        }

}

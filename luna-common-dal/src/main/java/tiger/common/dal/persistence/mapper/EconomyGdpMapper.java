package tiger.common.dal.persistence.mapper;


import tiger.common.dal.persistence.EconomyGDP.GdpDetailDO;
import java.util.List;

/**
 * Created by xy86 on 16/6/9.
 */
public interface EconomyGdpMapper {

    List<GdpDetailDO> getGdpDetail(Long year);

    List<GdpDetailDO> getYearGdp();

    List<GdpDetailDO> getIndustryDetail();

    List<GdpDetailDO> getYearIndustryDetail(Long year);

}

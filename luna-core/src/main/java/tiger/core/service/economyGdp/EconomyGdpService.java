package tiger.core.service.economyGdp;
import tiger.common.dal.persistence.EconomyGDP.GdpDetailDO;
import java.util.List;
/**
 * Created by xy86 on 16/6/9.
 */
public interface EconomyGdpService {

    List<GdpDetailDO> getGdpDetail(Long year);

    List<GdpDetailDO> getYearGdp();

    List<GdpDetailDO> getIndustryDetail();

}

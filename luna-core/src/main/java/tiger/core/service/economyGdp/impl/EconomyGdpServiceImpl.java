package tiger.core.service.economyGdp.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.core.service.economyGdp.EconomyGdpService;
import tiger.common.dal.persistence.mapper.EconomyGdpMapper;
import tiger.common.dal.persistence.EconomyGDP.GdpDetailDO;
import java.util.List;
/**
 * Created by xy86 on 16/6/9.
 */
@Service
public class EconomyGdpServiceImpl implements EconomyGdpService {

    @Autowired
    private EconomyGdpMapper economyGdpMapper;

    @Override
    public List<GdpDetailDO> getGdpDetail(Long year) {
        return economyGdpMapper.getGdpDetail(year);
    }

    public List<GdpDetailDO> getYearGdp(){
        return economyGdpMapper.getYearGdp();
    }

    public List<GdpDetailDO> getIndustryDetail(){
        return economyGdpMapper.getIndustryDetail();
    }
}

package tiger.biz.Economy.support.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.biz.Economy.support.EconomyGdpManger;
import tiger.core.basic.BaseResult;
import tiger.core.service.economyGdp.EconomyGdpService;
import tiger.common.dal.persistence.mapper.EconomyGDP.GdpDetailDO;
import java.util.List;
/**
 * Created by xy86 on 16/6/9.
 */
@Service
public class EconomyGdpMangerimpl implements EconomyGdpManger{

    @Autowired
    private EconomyGdpService economyGdpService;

    @Override
    public List<GdpDetailDO> getGdpDetail(Long year)
    {

        return economyGdpService.getGdpDetail(year);
    }
}

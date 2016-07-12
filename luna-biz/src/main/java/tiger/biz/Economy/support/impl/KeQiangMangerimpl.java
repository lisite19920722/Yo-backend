package tiger.biz.Economy.support.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.biz.Economy.support.KeQiangManger;
import tiger.common.dal.persistence.EconomyGDP.GdpDetailDO;
import tiger.common.dal.persistence.EconomyKeQiang.KeQiangDetailDO;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tiger.core.service.economyGdp.KeQiangService;
/**
 * Created by xy86 on 16/7/11.
 */
@Service
public class KeQiangMangerimpl implements KeQiangManger{

    @Autowired
    private KeQiangService keQiangService;

    Calendar now = Calendar.getInstance();
    int nowtime = now.get(Calendar.YEAR);

    @Override
    public Map<String,double[]> getyearKeqiang(Long year){

        List<KeQiangDetailDO> keQiangDOList = keQiangService.getyearKeqiang(year);

        double  loadGrowthRate[] = new double[12];
        double  industryPowerGrowthRate[] = new double[12];
        double  freightVolumeGrowthRate[] = new double[12];

        Map<String,double[]> map = new HashMap<>();

        Iterator<KeQiangDetailDO> e = keQiangDOList.iterator();

        while(e.hasNext()){
            KeQiangDetailDO temp = e.next();
            loadGrowthRate[temp.getMonth()-1] = temp.getLoadGrowthRate();
            industryPowerGrowthRate[temp.getMonth()-1] = temp.getIndustryPowerGrowthRate();
            freightVolumeGrowthRate[temp.getMonth()-1] = temp.getFreightVolumeGrowthRate();
        }

        map.put("loadGrowRate",loadGrowthRate);
        map.put("industryPowerGrowRate",industryPowerGrowthRate);
        map.put("freightVolumeGrowthRate",freightVolumeGrowthRate);
        return map;
    }


}

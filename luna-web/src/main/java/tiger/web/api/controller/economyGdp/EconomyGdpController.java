package tiger.web.api.controller.economyGdp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tiger.core.basic.BaseResult;
import tiger.web.api.constants.APIConstants;
import tiger.biz.Economy.support.EconomyGdpManger;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by xy86 on 16/6/9.
 */
@RestController
@RequestMapping(APIConstants.BASE_API_URL + "/economy/gdp")
public class EconomyGdpController {

    @Autowired
    private EconomyGdpManger economyGdpManger;

    @RequestMapping(value="/gdpDetail/{year}",method = RequestMethod.GET)
    public BaseResult getGdpDatil(@PathVariable("year") Long year)
    {

       Map<String,double[]> map = economyGdpManger.getGdpDetail(year);
        return new BaseResult(map);

    }
}

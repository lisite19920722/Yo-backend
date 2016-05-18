/**
 * 404 Studio Inc.
 * Copyright (c) 2014-2015 All Rights Reserved.
 */
package tiger.web.api.controller.system;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import tiger.common.util.BeanUtil;
import tiger.core.basic.BaseResult;
import tiger.core.basic.enums.ErrorCodeEnum;
import tiger.web.api.constants.APIConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 字典表获取 API 接口
 * ~ 系统参数接口
 *
 * @author yiliang.gyl
 * @version v 0.1 Sep 25, 2015 11:05:14 AM yiliang.gyl Exp $
 */
@RestController
@RequestMapping(value = APIConstants.BASE_API_URL +"/system")
public class DictController {

    private static Logger logger = Logger.getLogger(DictController.class);

    /**
     * 获取系统枚举字典
     *
     * @param dictType
     * @return
     */
    @RequestMapping(value = "/dict/{dictType}", method = RequestMethod.GET)
    @ResponseBody
    public BaseResult<?> getLoanDict(@PathVariable("dictType") String dictType) {
        try {
            String clazzName = APIConstants.BASE_ENUM_PACKAGE + "." + dictType;
            if (logger.isInfoEnabled()) {
                logger.info("获取枚举类 [" + clazzName + " ]所有枚举");
            }
            Class clazz = Class.forName(clazzName);
            List<Map<String, String>> maps = new ArrayList<>();
            if (clazz.isEnum()) {
                Object[] objects = clazz.getEnumConstants();
                for (Object obj : objects) {
                    maps.add(BeanUtil.concreteEnumToMap(obj, Class.forName(clazzName).getMethods()));
                }
                return new BaseResult<>(maps);
            } else {
                return new BaseResult<>(ErrorCodeEnum.ILLEGAL_PARAMETER_VALUE);
            }
        } catch (Exception e) {
            return new BaseResult<>(ErrorCodeEnum.NOT_FOUND);
        }
    }

}

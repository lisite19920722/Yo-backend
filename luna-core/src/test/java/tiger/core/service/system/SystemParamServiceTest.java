/**
 * 404 Studio Inc.
 * Copyright (c) 2014-2015 All Rights Reserved.
 */
package tiger.core.service.system;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tiger.common.dal.enums.SystemParamTypeEnum;
import tiger.common.dal.persistence.system.query.SystemParamsQuery;
import tiger.core.AbstractCoreTests;
import tiger.core.basic.constants.SystemConstants;
import tiger.core.domain.system.SystemParamDomain;
import tiger.core.service.system.SystemParamService;

import java.util.List;
import java.util.Map;

/**
 * @author yiliang.gyl
 * @version v 0.1 Oct 3, 2015 5:21:25 PM yiliang.gyl Exp $
 */
public class SystemParamServiceTest extends AbstractCoreTests {

    @Autowired
    SystemParamService systemParamService;

    @Test
    public void testGetNormalParam() {
        systemParamService.getValueByTypeAndKey(SystemParamTypeEnum.DEFAULT,
                SystemConstants.DEFAULT);
    }
    /**
     * 测试 add&query&delete
     *
     * */
    @Test
    public void addDeleteTest() {
        //测试add
        SystemParamDomain systemParamDomain = createSystemParamDomain(SystemParamTypeEnum.SYSTEM_CONFIG, true);
        Assert.assertTrue(systemParamService.add(systemParamDomain));

        SystemParamsQuery systemParamsQuery = new SystemParamsQuery();
        systemParamsQuery.setParamType(SystemParamTypeEnum.SYSTEM_CONFIG.toString());

        //测试query
        List<SystemParamDomain> systemParamDomainList = systemParamService.query(systemParamsQuery);
        Assert.assertNotNull(systemParamDomainList);
        SystemParamDomain systemParamDomainAdd = systemParamDomainList.get(0);
        logger.info("获取到"+systemParamDomainAdd);

        Long id = systemParamDomainAdd.getId();

        //测试 delete
        Assert.assertTrue(systemParamService.delete(id));
    }
    /**
     * 测试read&update
     *
     * */
    @Test
    public void readUpdateTest() {
        SystemParamDomain systemParamDomain = createSystemParamDomain(SystemParamTypeEnum.SYSTEM_CONFIG, true);
        Assert.assertTrue(systemParamService.add(systemParamDomain));
        SystemParamsQuery systemParamsQuery = new SystemParamsQuery();
        systemParamsQuery.setParamType(SystemParamTypeEnum.SYSTEM_CONFIG.toString());
        SystemParamDomain systemParamDomainAdd = systemParamService.query(systemParamsQuery).get(0);
        Long id = systemParamDomainAdd.getId();

        //测试 read
        SystemParamDomain systemParamDomainRead = systemParamService.read(id);
        logger.info("Read到数据:"+systemParamDomainRead);

        //测试update
        systemParamDomainRead.setParamValue("updatetest");
        Assert.assertTrue(systemParamService.update(systemParamDomainRead));
        Assert.assertEquals("updatetest",systemParamService.read(id).getParamValue());
    }
    /**
     * 测试 getValueByTypeAndKey&getParamsByType
     *
     * */
    @Test
    public void getTest() {
        SystemParamDomain systemParamDomain = createSystemParamDomain(SystemParamTypeEnum.SYSTEM_CONFIG, true);
        Assert.assertTrue(systemParamService.add(systemParamDomain));

        //测试 getValueByTypeAndKey
        String value = systemParamService.getValueByTypeAndKey(SystemParamTypeEnum.SYSTEM_CONFIG,"paramName");
        logger.info("获取到paramValue为:"+value);
        Assert.assertNull(systemParamService.getValueByTypeAndKey(SystemParamTypeEnum.SYSTEM_CONFIG,"notExist"));

        //测试 getParamsByType
        Map<String, String> map = systemParamService.getParamsByType(SystemParamTypeEnum.SYSTEM_CONFIG);
        Assert.assertNotNull(map);
        Assert.assertNotEquals(0,map.size());
        logger.info("获取到的系统参数键值对:"+map.toString());
    }

    //~ private methods
    private SystemParamDomain createSystemParamDomain(SystemParamTypeEnum systemParamTypeEnum, boolean isActive) {
        SystemParamDomain systemParamDomain = new SystemParamDomain();

        systemParamDomain.setParamName("paramName");
        systemParamDomain.setParamValue("paramValue");

        systemParamDomain.setParamType(systemParamTypeEnum);
        systemParamDomain.setIsActive(isActive);

        return systemParamDomain;
    }
}

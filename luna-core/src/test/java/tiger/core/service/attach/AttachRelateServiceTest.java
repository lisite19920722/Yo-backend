/**
 * Gambition Inc.
 * All Right Reserved.
 */
package tiger.core.service.attach;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tiger.common.dal.enums.AttachBizTypeEnum;
import tiger.common.dal.enums.AttachTypeEnum;
import tiger.common.dal.persistence.attach.query.AttachRelateQuery;
import tiger.core.AbstractCoreTests;
import tiger.core.domain.attach.AttachDomain;
import tiger.core.domain.attach.AttachRelateDomain;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author: [mondooo.cgq]
 * @version: [V 0.1.1]
 * @CreateDate: [16/4/17 02:43]
 */
public class AttachRelateServiceTest extends AbstractCoreTests {

    private static Logger logger = Logger.getLogger(AttachRelateServiceTest.class);

    @Autowired
    AttachRelateService attachRelateService;
    @Autowired
    AttachService attachService;

    /**
     * 测试 增&删
     *
     * */
    @Test
    public void insertDeleteTest() {
        AttachDomain newAttachDomain_0 = attachService.create(AttachServiceTest.createAttach("/test/test0.jpg", AttachTypeEnum.PUBLIC,1000l)),
                     newAttachDomain_1 = attachService.create(AttachServiceTest.createAttach("/test/test1.jpg", AttachTypeEnum.PUBLIC,1000l));

        AttachRelateDomain attachRelateDomain_0 = createAttachRelateDomain(2000l,newAttachDomain_0.getId(),AttachBizTypeEnum.DEFAULT_ICON),
                           attachRelateDomain_1 = createAttachRelateDomain(2000l,newAttachDomain_1.getId(),AttachBizTypeEnum.FEEDBACK);

        AttachRelateQuery attachRelateQuery = createAttachRelateQuery(2000l,AttachBizTypeEnum.DEFAULT_ICON),
                          attachRelateQuery_NotExist = createAttachRelateQuery(2001l,AttachBizTypeEnum.FEEDBACK);

        //测试 增加单个附件关联
        Assert.assertTrue(attachRelateService.relateAttach(attachRelateDomain_0));
        Assert.assertTrue(attachRelateService.isExist(attachRelateDomain_0));

        logger.info("增加关联:"+attachRelateDomain_0+"成功");

        //测试 根据id删除附件关联
        Assert.assertTrue(attachRelateService.deRelateAttachById(attachRelateDomain_0));
        Assert.assertFalse(attachRelateService.isExist(attachRelateDomain_0));

        logger.info("删除关联:"+attachRelateDomain_0+"成功");

        //测试 关联一组附件
        List<AttachRelateDomain> attachRelateDomains = new ArrayList<>();
        attachRelateDomains.add(attachRelateDomain_0);attachRelateDomains.add(attachRelateDomain_1);

        Assert.assertTrue(attachRelateService.relateAttaches(attachRelateDomains));
        Assert.assertTrue(attachRelateService.isExist(attachRelateDomain_0));
        Assert.assertTrue(attachRelateService.isExist(attachRelateDomain_1));

        logger.info("关联"+attachRelateDomains+"成功");

        //测试 根据query的条件删除相关附件关联
        Assert.assertFalse(attachRelateService.deRelatedAttachesByQuery(attachRelateQuery_NotExist));
        Assert.assertTrue(attachRelateService.deRelatedAttachesByQuery(attachRelateQuery));
        Assert.assertFalse(attachRelateService.isExist(attachRelateDomain_0));
    }
    /**
     * 测试 查询&判断
     * */
    @Test
    public void queryExistTest() {
        AttachDomain newAttachDomain_0 = attachService.create(AttachServiceTest.createAttach("/test/test0.jpg", AttachTypeEnum.PUBLIC,1000l)),
                     newAttachDomain_1 = attachService.create(AttachServiceTest.createAttach("/test/test1.jpg", AttachTypeEnum.PUBLIC,1000l)),
                     newAttachDomain_2 = attachService.create(AttachServiceTest.createAttach("/test/test2.jpg", AttachTypeEnum.PUBLIC,1000l));

        AttachRelateDomain attachRelateDomain_0 = createAttachRelateDomain(2000l,newAttachDomain_0.getId(),AttachBizTypeEnum.DEFAULT_ICON),
                           attachRelateDomain_1 = createAttachRelateDomain(2000l,newAttachDomain_1.getId(),AttachBizTypeEnum.DEFAULT_ICON),
                           attachRelateDomain_2 = createAttachRelateDomain(2000l,newAttachDomain_2.getId(),AttachBizTypeEnum.FEEDBACK);

        AttachRelateQuery attachRelateQuery = createAttachRelateQuery(2000l,AttachBizTypeEnum.DEFAULT_ICON),
                          attachRelateQuery_NotExist = createAttachRelateQuery(2001l,AttachBizTypeEnum.FEEDBACK);

        attachRelateService.relateAttach(attachRelateDomain_0);
        attachRelateService.relateAttach(attachRelateDomain_2);

        //测试 根据query的条件查询相关附件关联
        Assert.assertEquals(1,attachRelateService.listAttaches(attachRelateQuery).size());
        Assert.assertEquals(0,attachRelateService.listAttaches(attachRelateQuery_NotExist).size());

        //检查relateDomain是否已经存在，主要比较subjectId, bizType, attachId
        Assert.assertTrue(attachRelateService.isExist(attachRelateDomain_0));
        Assert.assertFalse(attachRelateService.isExist(attachRelateDomain_1));
    }

    //~ 私有方法
    private AttachRelateDomain createAttachRelateDomain(Long subjectId, Long attachId, AttachBizTypeEnum attachBizTypeEnum) {
        AttachRelateDomain attachRelateDomain = new AttachRelateDomain();
        attachRelateDomain.setSubjectId(subjectId);
        attachRelateDomain.setAttachId(attachId);
        attachRelateDomain.setBizType(attachBizTypeEnum);

        return attachRelateDomain;
    }
    private AttachRelateQuery createAttachRelateQuery(Long subjectId, AttachBizTypeEnum attachBizTypeEnum) {
        AttachRelateQuery attachRelateQuery = new AttachRelateQuery();
        attachRelateQuery.setSubjectId(subjectId);
        attachRelateQuery.setBizTypeEnum(attachBizTypeEnum);

        return attachRelateQuery;
    }
}

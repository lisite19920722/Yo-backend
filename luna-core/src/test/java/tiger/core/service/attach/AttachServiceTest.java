/**
 * Gambition Inc.
 * All Right Reserved.
 */
package tiger.core.service.attach;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tiger.common.dal.enums.AttachTypeEnum;
import tiger.common.dal.persistence.attach.query.AttachQuery;
import tiger.core.AbstractCoreTests;
import tiger.core.domain.attach.AttachDomain;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: [mondooo.cgq]
 * @version: [V 0.1.1]
 * @CreateDate: [16/4/16 23:30]
 */
public class AttachServiceTest extends AbstractCoreTests {

    private static Logger logger = Logger.getLogger(AttachServiceTest.class);

    @Autowired
    AttachService attachService;

    /***
     * 测试 增&删
     *
     */
    @Test
    public void insertDeleteTest() {
        //测试插入
        AttachDomain newAttachDomain = attachService.create(createAttach("/test/test1.jpg",AttachTypeEnum.PUBLIC,1000l));
        Assert.assertNotNull(newAttachDomain);
        Assert.assertNotNull(newAttachDomain.getId());

        logger.info("插入["+newAttachDomain+"]成功");

        //根据附件id删除该附件,七牛云相关还未测试
    }

    /**
     * 测试 查询
     *
     * */
    @Test
    public void readQueryTest() {
        AttachDomain newAttachDomain_0 = attachService.create(createAttach("/test/test1.jpg",AttachTypeEnum.PUBLIC,1000l)),
                     newAttachDomain_1 = attachService.create(createAttach("/test/test2.jpg",AttachTypeEnum.PUBLIC,1000l));

        long notExistId = newAttachDomain_0.getId() + newAttachDomain_1.getId();

        List<Long> ids = new ArrayList<>(),
                   ids_withNotExistId = new ArrayList<>();
        ids.add(newAttachDomain_0.getId());ids.add(newAttachDomain_1.getId());
        ids_withNotExistId.add(newAttachDomain_0.getId());ids_withNotExistId.add(newAttachDomain_1.getId());ids_withNotExistId.add(notExistId);

        //测试 通过id获取附件模型
        Assert.assertNotNull(attachService.read(newAttachDomain_0.getId()));
        logger.info("获取["+attachService.read(newAttachDomain_0.getId())+"]成功");
        Assert.assertNull(attachService.read(notExistId));

        //根据query 查询附件信息
        AttachQuery attachQuery = new AttachQuery(),
                    attachQueryWithNotExistId = new AttachQuery();
        attachQuery.setIds(ids);
        attachQueryWithNotExistId.setIds(ids_withNotExistId);

        Assert.assertEquals(2,attachService.query(attachQuery).size());
        logger.info("查询到附件信息:"+attachService.query(attachQuery));

        Assert.assertEquals(2,attachService.query(attachQueryWithNotExistId).size());
        logger.info("查询到附件信息:"+attachService.query(attachQueryWithNotExistId));
    }

    /**
     * 测试 Attach是否存在
     *
     */
    @Test
    public void attachExistTest() {
        AttachDomain newAttachDomain_0 = attachService.create(createAttach("/test/test1.jpg",AttachTypeEnum.PUBLIC,1000l)),
                     newAttachDomain_1 = attachService.create(createAttach("/test/test2.jpg",AttachTypeEnum.PUBLIC,1000l));

        long notExistId = newAttachDomain_0.getId() + newAttachDomain_1.getId();

        List<Long> ids = new ArrayList<>(),
                   ids_withNotExistId = new ArrayList<>();
        ids.add(newAttachDomain_0.getId());ids.add(newAttachDomain_1.getId());
        ids_withNotExistId.add(newAttachDomain_0.getId());ids_withNotExistId.add(newAttachDomain_1.getId());ids_withNotExistId.add(notExistId);

        //判断attach id是否存在
        Assert.assertEquals(true,attachService.isExist(newAttachDomain_0.getId()));
        Assert.assertEquals(false,attachService.isExist(notExistId));

        //判断attach是否都存在
        Assert.assertEquals(true,attachService.isAllExist(ids));
        Assert.assertEquals(false,attachService.isAllExist(ids_withNotExistId));
    }

    /**
     * 测试 其他判断
     * */
    @Test
    public void isCorrectTest() {
        AttachDomain newAttachDomain_0 = attachService.create(createAttach("/test/test1.jpg",AttachTypeEnum.PUBLIC,1000l)),
                     newAttachDomain_1 = attachService.create(createAttach("/test/test2.jpg",AttachTypeEnum.PUBLIC,1000l));

        long notExistId = newAttachDomain_0.getId() + newAttachDomain_1.getId();

        List<Long> ids = new ArrayList<>(),
                   ids_withNotExistId = new ArrayList<>();
        ids.add(newAttachDomain_0.getId());ids.add(newAttachDomain_1.getId());
        ids_withNotExistId.add(newAttachDomain_0.getId());ids_withNotExistId.add(newAttachDomain_1.getId());ids_withNotExistId.add(notExistId);

        //检查fileName是否已经存在
        Assert.assertTrue(attachService.isFilenameExist("/test/test1.jpg"));
        Assert.assertFalse(attachService.isFilenameExist("/test/not_exist.jpg"));

        //判断附件attachId是否为对应的attachtype
        Assert.assertTrue(attachService.isAttachType(newAttachDomain_0.getId(), AttachTypeEnum.PUBLIC));
        Assert.assertFalse(attachService.isAttachType(newAttachDomain_0.getId(), AttachTypeEnum.SECRET));

        //判断附件attachIds是否为对应的attachtype
        Assert.assertTrue(attachService.isAllAttachType(ids, AttachTypeEnum.PUBLIC));
        Assert.assertFalse(attachService.isAllAttachType(ids, AttachTypeEnum.SECRET));
        Assert.assertFalse(attachService.isAllAttachType(ids_withNotExistId, AttachTypeEnum.PUBLIC));

        // 检查附件attachIds是否都为accountId所有
        Assert.assertTrue(attachService.isOwnerOfAll(ids, 1000l));
        Assert.assertFalse(attachService.isOwnerOfAll(ids, 1111l));
        Assert.assertFalse(attachService.isOwnerOfAll(ids_withNotExistId, 1000l));
    }

    //~other methods

    //通过url,attachType,accountId创建不同的AttachDomain用来测试
    public static AttachDomain createAttach(String url,AttachTypeEnum attachTypeEnum, Long accountId) {
        AttachDomain newAttachDomain = new AttachDomain();

        newAttachDomain.setUrl(url);
        newAttachDomain.setAttachType(attachTypeEnum);
        newAttachDomain.setAccountId(accountId);

        newAttachDomain.setName("test");
        newAttachDomain.setSize(1);
        newAttachDomain.setIsDel(false);

        return newAttachDomain;
    }
}

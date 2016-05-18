package tiger.core.service.account;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tiger.common.dal.enums.AccountSettingBizTypeEnum;
import tiger.common.dal.enums.AccountSettingTypeEnum;
import tiger.common.dal.enums.WorkSpaceTypeEnum;
import tiger.common.dal.persistence.account.query.AccountSettingQuery;
import tiger.core.AbstractCoreTests;
import tiger.core.domain.account.AccountSettingDomain;
import tiger.core.domain.workspace.WorkspaceDomain;
import tiger.core.service.workspace.WorkspaceService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: [mondooo.cgq]
 * @version: [V 0.1.1]
 * @CreateDate: [16/4/17 02:43]
 */
public class AccountSettingServiceTest extends AbstractCoreTests {
    Logger logger = Logger.getLogger(AccountSettingServiceTest.class);

    @Autowired
    AccountSettingService accountSettingService;
    @Autowired
    WorkspaceService workspaceService;

    /**
     * 测试 增&删除
     *
     * */
    @Test
    public void insertDelete() {
        AccountSettingDomain accountSettingDomain = accountSettingDomainGenerator(1000l);
        //测试 插入一条账户设置
        Assert.assertTrue(accountSettingService.add(accountSettingDomain));

        //根据accountSettingQuery条件查询账户设置信息
        AccountSettingQuery accountSettingQuery = accountSettingQueryGenerator(1000l,accountSettingDomain.getWorkspaceId());
        List<AccountSettingDomain> accountSettingDomains = accountSettingService.query(accountSettingQuery);
        Assert.assertEquals(1,accountSettingDomains.size());
        logger.info("获取到账户设置信息:"+accountSettingDomains);

        //更新测试
        AccountSettingDomain accountSettingDomainAdd = accountSettingDomains.get(0);
        accountSettingDomainAdd.setSettingValue("update test");
        Assert.assertTrue(accountSettingService.update(accountSettingDomainAdd));
        accountSettingDomains = accountSettingService.query(accountSettingQuery);
        Assert.assertEquals("update test",accountSettingDomains.get(0).getSettingValue());
        logger.info("获取到账户设置信息:"+accountSettingDomains.get(0));
        logger.info("更新账户成功");

        //删除测试
        accountSettingDomainAdd = accountSettingDomains.get(0);
        Assert.assertTrue(accountSettingService.delete(accountSettingDomainAdd.getId()));
        Assert.assertEquals(0,accountSettingService.query(accountSettingQuery).size());
    }

    //~ private methods
    private AccountSettingDomain accountSettingDomainGenerator(Long accountId) {
        AccountSettingDomain accountSettingDomain = new AccountSettingDomain();
        accountSettingDomain.setWorkspaceId(createWorkspace().getId());
        accountSettingDomain.setAccountId(accountId);
        accountSettingDomain.setBizType(AccountSettingBizTypeEnum.ACCOUNT);
        accountSettingDomain.setSettingType(AccountSettingTypeEnum.NOTIFICATION_PUSH);
        accountSettingDomain.setSettingValue("test");
        accountSettingDomain.setSubjectId(accountId);
        return accountSettingDomain;
    }

    private AccountSettingQuery accountSettingQueryGenerator(Long subjectId, Long workspaceId) {
        AccountSettingQuery accountSettingQuery = new AccountSettingQuery();

        accountSettingQuery.setWorkspaceId(workspaceId);
        accountSettingQuery.setSettingType(AccountSettingTypeEnum.NOTIFICATION_PUSH.toString());
        accountSettingQuery.setBizType(AccountSettingBizTypeEnum.ACCOUNT.toString());
        List<Long> subjectIds = new ArrayList<>();
        subjectIds.add(subjectId);
        accountSettingQuery.setSubjectIds(subjectIds);
        return accountSettingQuery;
    }
    private WorkspaceDomain createWorkspace() {
        WorkspaceDomain workspace = new WorkspaceDomain();
        workspace.setOwnerId(1000l);
        workspace.setType(WorkSpaceTypeEnum.PERSONAL);
        workspace.setIsVerified(false);
        workspace.setDescription("test");
        workspace.setName("test");

        WorkspaceDomain newWorkspace = workspaceService.create(workspace);
        Assert.assertNotNull(newWorkspace);
        Assert.assertNotNull(newWorkspace.getId());

        logger.info("插入成功:[" + newWorkspace + "]");

        return newWorkspace;
    }

}

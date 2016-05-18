/**
 * Gambition Inc.
 * All Right Reserved.
 */
package tiger.core.service.workspace;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tiger.common.dal.persistence.workspace.query.WorkspaceVerifyQuery;
import tiger.core.AbstractCoreTests;
import tiger.core.basic.PageResult;
import tiger.core.domain.workspace.WorkspaceMemberVerifyDomain;

import java.util.Date;
import java.util.List;

/**
 * @Author: [mondooo.cgq]
 * @version: [V 0.1.1]
 * @CreateDate: [16/4/20 21:02]
 */
public class WorkspaceInvitationServiceTest extends AbstractCoreTests{
    Logger logger = Logger.getLogger(WorkspaceInvitationServiceTest.class);

    @Autowired
    WorkspaceInvitationService workspaceInvitationService;

    /**
     * 测试 insert & read & delete
     *
     * */
    @Test
    public void insertDeleteTest() {
        WorkspaceMemberVerifyDomain workspaceMemberVerifyDomain = createWorkspaceMemberVerifyDomain(1000l,9000l);
        WorkspaceMemberVerifyDomain workspaceMemberVerifyDomainAdd =
                workspaceInvitationService.insert(workspaceMemberVerifyDomain);
        Assert.assertNotNull(workspaceMemberVerifyDomainAdd);
        logger.info("插入成功!:"+workspaceMemberVerifyDomainAdd);

        //测试 read
        WorkspaceMemberVerifyDomain workspaceMemberVerifyDomainRead =
                workspaceInvitationService.read(workspaceMemberVerifyDomainAdd.getId());
        Assert.assertNotNull(workspaceMemberVerifyDomainRead);
        logger.info("获取成功!:"+workspaceMemberVerifyDomainRead);

        //测试 删除
        Assert.assertTrue(workspaceInvitationService.delete(workspaceMemberVerifyDomainAdd.getId()));
        //️空指针异常
        //Assert.assertNull(workspaceInvitationService.read(workspaceMemberVerifyDomainAdd.getId()));
    }

    /**
     * 测试 isExist & countWorkspaceVerifies
     *
     * */
    @Test
    public void isExistTest() {
        WorkspaceMemberVerifyDomain workspaceMemberVerifyDomain = createWorkspaceMemberVerifyDomain(1000l,9000l);
        WorkspaceMemberVerifyDomain workspaceMemberVerifyDomainAdd =
                workspaceInvitationService.insert(workspaceMemberVerifyDomain);
        Assert.assertTrue(workspaceInvitationService.isExist(9000l,1000l));
        Assert.assertFalse(workspaceInvitationService.isExist(9000l,900l));

        Assert.assertEquals(1, (int)workspaceInvitationService.countWorkspaceVerifies(1000l));
        Assert.assertEquals(0, (int)workspaceInvitationService.countWorkspaceVerifies(900l));
    }

    @Test
    public void getByPageTest() {
        WorkspaceVerifyQuery workspaceVerifyQuery = new WorkspaceVerifyQuery();
        workspaceVerifyQuery.setWorkspaceId(1000l);

        WorkspaceMemberVerifyDomain workspaceMemberVerifyDomain = createWorkspaceMemberVerifyDomain(1000l,9000l);
        WorkspaceMemberVerifyDomain workspaceMemberVerifyDomainAdd =
                workspaceInvitationService.insert(workspaceMemberVerifyDomain);

        PageResult<List<WorkspaceMemberVerifyDomain>> pageResult =
                workspaceInvitationService.getByPage(workspaceVerifyQuery);
        Assert.assertNotNull(pageResult);
        logger.info("通过getByPageTest()获取到的pageResult"+pageResult);
    }
    //~ private method
    private WorkspaceMemberVerifyDomain createWorkspaceMemberVerifyDomain(Long workspaceId,Long accountId) {
        WorkspaceMemberVerifyDomain workspaceMemberVerifyDomain = new WorkspaceMemberVerifyDomain();
        workspaceMemberVerifyDomain.setAccountId(accountId);
        workspaceMemberVerifyDomain.setWorkspaceId(workspaceId);
        Date date = new Date();
        date.setTime(new Date().getTime()+1000*60*60*24);
        workspaceMemberVerifyDomain.setExpiredTime(date);
        return workspaceMemberVerifyDomain;
    }
}

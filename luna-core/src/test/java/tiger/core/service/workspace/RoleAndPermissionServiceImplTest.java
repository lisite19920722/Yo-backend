package tiger.core.service.workspace;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tiger.common.dal.enums.PermissionEnum;
import tiger.common.dal.enums.RoleEnum;
import tiger.core.AbstractCoreTests;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zhao on 2016/4/18.
 */
public class RoleAndPermissionServiceImplTest extends AbstractCoreTests{

    private static Logger logger = Logger.getLogger(RoleAndPermissionServiceImplTest.class);

    @Autowired
    private RoleAndPermissionService roleAndPermissionService;

    @Test
    public void getPermissionsOfRoles() throws Exception {
        //---------测试 List<PermissionEnum> getPermissionsOfRoles(List<RoleEnum> roles)
        List<PermissionEnum> permissionEnumList = roleAndPermissionService.getPermissionOfRole(RoleEnum.OWNER);
        Assert.assertEquals(2,permissionEnumList.get(1));
        logger.warn(permissionEnumList.toString());

    }
}
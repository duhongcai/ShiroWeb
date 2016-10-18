

import com.dhc.entry.Role;
import com.dhc.service.RoleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by DuHongcai on 2016/10/17.
 */
public class RoleTest extends BasicTest {
    @Autowired
    private RoleService roleService;

    @Test
    public void getAllRoles(){
        List<Role> roles = roleService.getAllRoles();
        for(Role role:roles){
            System.out.print(role.getRoleName());
        }
    }

}

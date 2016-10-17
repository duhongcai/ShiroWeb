package service.impl;

import dao.RoleDao;
import entry.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.RoleService;

import java.util.List;

/**
 * Created by DuHongcai on 2016/10/17.
 */
@Service
public class RoleServiceImpl  implements RoleService{
    @Autowired
    private RoleDao roleDao;
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }
}

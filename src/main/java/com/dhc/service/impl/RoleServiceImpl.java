package com.dhc.service.impl;



import com.dhc.dao.RoleDao;
import com.dhc.entry.Role;
import com.dhc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DuHongcai on 2016/10/17.
 */
@Service
public class RoleServiceImpl  implements RoleService {
    @Autowired
    private RoleDao roleDao;
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }
}

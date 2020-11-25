package org.bw.smbms.dao.role;

import org.bw.smbms.entity.Role;

import java.util.List;

public interface RoleMapper {

    public List<Role> findRoleList() throws Exception;
}

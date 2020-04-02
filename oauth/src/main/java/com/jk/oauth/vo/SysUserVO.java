package com.jk.oauth.vo;

import com.jk.oauth.entity.SysRole;
import lombok.Data;

import java.util.Set;

/**
 * @author Dylan Yang
 * @Description: TODO
 * @Title: SysUserVO
 * @ProjectName javayh-oauth2
 * @date 2019/5/18 15:05
 */
@Data
public class SysUserVO {
    private int id;
    private String username;
    private String password;
    private Set<SysRole> sysRoles;

}


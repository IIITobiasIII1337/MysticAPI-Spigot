/*
 * Copyright (c) 2020 IIITobiasIII
 *
 * Should the code used in a project, the author of this code (IIITobiasIII) should be named in it.
 */


package net.mysticarmy.mysticapi.cloudnet;

import de.dytanic.cloudnet.driver.permission.IPermissionUser;
import de.dytanic.cloudnet.driver.permission.PermissionUserGroupInfo;
import de.dytanic.cloudnet.ext.cloudperms.CloudPermissionsManagement;
import net.mysticarmy.mysticapi.entity.MysticPlayer;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Code by         / MysticArmy.net Owner
 * IIITobiasIII    / IIITobiasIII@mysticarmy.net
 * Created at 31.10.2020
 */
public class CloudPermissions {

    public String getHighestRankName(UUID uuid){
        return CloudPermissionsManagement.getInstance().getHighestPermissionGroup(getIPermissionUser(uuid)).getName();
    }

    public String getHighestRankColor(UUID uuid){
        return CloudPermissionsManagement.getInstance().getHighestPermissionGroup(getIPermissionUser(uuid)).getColor();
    }

    public IPermissionUser getIPermissionUser(UUID uuid){
        return CloudPermissionsManagement.getInstance().getUser(uuid);
    }

    public void addGroup(UUID uuid, String group){
        IPermissionUser permissionUser = getIPermissionUser(uuid);
        permissionUser.addGroup(group);
        CloudPermissionsManagement.getInstance().updateUser(permissionUser);
    }

    public void addTempGroup(UUID uuid, String group, int l, TimeUnit unit){
        IPermissionUser permissionUser = getIPermissionUser(uuid);
        permissionUser.addGroup(group, l, unit);
        CloudPermissionsManagement.getInstance().updateUser(permissionUser);
    }

    public void removeGroup(UUID uuid, String group)
    {
        IPermissionUser permissionUser = getIPermissionUser(uuid);
        permissionUser.removeGroup(group);
        CloudPermissionsManagement.getInstance().updateUser(permissionUser);
    }

    public void addPermission(UUID uuid, String permission){
        IPermissionUser permissionUser = getIPermissionUser(uuid);
        permissionUser.addPermission(permission);
        CloudPermissionsManagement.getInstance().updateUser(permissionUser);
    }

    public void removePermission(UUID uuid, String permission){
        IPermissionUser permissionUser = getIPermissionUser(uuid);
        permissionUser.removePermission(permission);
        CloudPermissionsManagement.getInstance().updateUser(permissionUser);
    }

    public void removeAllGroups(UUID uuid){
        IPermissionUser permissionUser = getIPermissionUser(uuid);
        for (PermissionUserGroupInfo info : permissionUser.getGroups()) {
            removeGroup(uuid, info.getGroup());
        }
    }
}

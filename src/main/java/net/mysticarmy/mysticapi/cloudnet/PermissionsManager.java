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
public class PermissionsManager {

    private MysticPlayer player;
    private UUID uuid;

    public PermissionsManager(MysticPlayer player){
        this.player = player;
        this.uuid = player.getUniqueID();
    }

    public String getHighestRankName(){
        return CloudPermissionsManagement.getInstance().getHighestPermissionGroup(getIPermissionUser()).getName();
    }

    public String getHighestRankColor(){
        return CloudPermissionsManagement.getInstance().getHighestPermissionGroup(getIPermissionUser()).getColor();
    }

    public IPermissionUser getIPermissionUser(){
        return CloudPermissionsManagement.getInstance().getUser(uuid);
    }

    public void addGroup(String group){
        IPermissionUser permissionUser = getIPermissionUser();
        permissionUser.addGroup(group);
        CloudPermissionsManagement.getInstance().updateUser(permissionUser);
    }

    public void addTempGroup(String group, int l, TimeUnit unit){
        IPermissionUser permissionUser = getIPermissionUser();
        permissionUser.addGroup(group, l, unit);
        CloudPermissionsManagement.getInstance().updateUser(permissionUser);
    }

    public void removeGroup(String group)
    {
        IPermissionUser permissionUser = getIPermissionUser();
        permissionUser.removeGroup(group);
        CloudPermissionsManagement.getInstance().updateUser(permissionUser);
    }

    public void addPermission(String permission){
        IPermissionUser permissionUser = getIPermissionUser();
        permissionUser.addPermission(permission);
        CloudPermissionsManagement.getInstance().updateUser(permissionUser);
    }

    public void removePermission(String permission){
        IPermissionUser permissionUser = getIPermissionUser();
        permissionUser.removePermission(permission);
        CloudPermissionsManagement.getInstance().updateUser(permissionUser);
    }

    public void removeAllGroups(){
        IPermissionUser permissionUser = getIPermissionUser();
        for (PermissionUserGroupInfo info : permissionUser.getGroups()) {
            removeGroup(info.getGroup());
        }
    }
}

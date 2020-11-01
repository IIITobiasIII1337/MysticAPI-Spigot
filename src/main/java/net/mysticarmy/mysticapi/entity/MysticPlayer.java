/*
 * Copyright (c) 2020 IIITobiasIII
 *
 * Should the code used in a project, the author of this code (IIITobiasIII) should be named in it.
 */


package net.mysticarmy.mysticapi.entity;

import de.dytanic.cloudnet.ext.bridge.player.ICloudPlayer;
import net.mysticarmy.mysticapi.MysticAPI;
import net.mysticarmy.mysticapi.cloudnet.CloudServer;
import net.mysticarmy.mysticapi.cloudnet.PermissionsManager;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.util.Vector;

import java.util.UUID;

public interface MysticPlayer {

    String getName();
    UUID getUniqueID();
    GameMode getGameMode();
    Location getLocation();
    World getWorld();
    Inventory getInventory();
    ItemStack getItemInHand();
    Vector getVelocity();
    double getHealth();
    int getLevel();
    Server getServer();
    CloudServer getCloudServer();
    MysticAPI getAPI();

    Player getPlayer();
    ICloudPlayer getCloudPlayer();

    void teleport(Location location);
    void chat(String message);
    void sendMessage(String message);
    void kick(String reason);
    void setGameMode(GameMode gameMode);
    void updateInventory();
    void setItemInHand(ItemStack itemStack);
    void setVelocity(Vector velocity);
    void setScoreboard(Scoreboard scoreboard);
    void setLevel(int level);
    void kill();
    void setHealth(int health);
    void closeInventory();
    void openInventory(Inventory inventory);
    boolean hasPermission(String permission);
    boolean isDead();
    boolean isOp();

    PermissionsManager getPermissions(); // returns PermissionManager
}

/*
 * Copyright (c) 2020 IIITobiasIII
 *
 * Should the code used in a project, the author of this code (IIITobiasIII) should be named in it.
 */


package net.mysticarmy.mysticapi;

import de.dytanic.cloudnet.ext.bridge.BridgePlayerManager;
import de.dytanic.cloudnet.ext.bridge.player.ICloudPlayer;
import net.mysticarmy.mysticapi.cloudnet.CloudPermissions;
import net.mysticarmy.mysticapi.cloudnet.CloudServer;
import net.mysticarmy.mysticapi.entity.MysticPlayer;
import net.mysticarmy.mysticapi.events.Events;
import net.mysticarmy.mysticapi.events.MysticAPIFinishStartEvent;
import net.mysticarmy.mysticapi.logger.LogType;
import net.mysticarmy.mysticapi.logger.MysticLogger;
import net.mysticarmy.mysticapi.cloudnet.PermissionsManager;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.util.Vector;

import java.util.UUID;

/**
 * Code by         / MysticArmy.net Owner
 * IIITobiasIII    / IIITobiasIII@mysticarmy.net
 * Created at 31.10.2020
 */
public class MysticAPI extends JavaPlugin {

    private String prefix = "§5§lMysticArmy §8| §r";
    private static MysticAPI instance;
    private CloudServer cloudServer;
    private CloudPermissions cloudPermissions;

    @Override
    public void onEnable() {
        instance = this;
        cloudServer = new CloudServer();
        cloudPermissions = new CloudPermissions();
        MysticLogger.log(LogType.INFO, "MysticAPI successfully initialized!");
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new Events(), this);
        pluginManager.callEvent(new MysticAPIFinishStartEvent(this, pluginManager));
    }

    @Override
    public void onDisable() {
        MysticLogger.log(LogType.INFO, "MysticAPI successfully disabled!");
    }

    public String getPrefix() {
        return prefix;
    }
    public CloudServer getCloudServer() {
        return cloudServer;
    }
    public CloudPermissions getCloudPermissions() {
        return cloudPermissions;
    }
    public static MysticAPI getInstance() {
        return instance;
    }

    public MysticPlayer getMysticPlayer(final Player player){
        return new MysticPlayer() {
            public String getName() {
                return player.getName();
            }

            public UUID getUniqueID() {
                return player.getUniqueId();
            }

            @Override
            public GameMode getGameMode() {
                return player.getGameMode();
            }

            @Override
            public Location getLocation() {
                return player.getLocation();
            }

            @Override
            public World getWorld() {
                return player.getWorld();
            }

            @Override
            public Inventory getInventory() {
                return player.getInventory();
            }

            @Override
            public ItemStack getItemInHand() {
                return player.getItemInHand();
            }

            @Override
            public Vector getVelocity() {
                return player.getVelocity();
            }

            @Override
            public double getHealth() {
                return player.getHealth();
            }

            @Override
            public int getLevel() {
                return player.getLevel();
            }

            @Override
            public Server getServer(){
                return player.getServer();
            }

            @Override
            public CloudServer getCloudServer() {
                return MysticAPI.getInstance().getCloudServer();
            }

            @Override
            public MysticAPI getAPI() {
                return MysticAPI.getInstance();
            }

            @Override
            public Player getPlayer() {
                return player;
            }

            @Override
            public ICloudPlayer getCloudPlayer(){
                return BridgePlayerManager.getInstance().getOnlinePlayer(player.getUniqueId());
            }

            @Override
            public void teleport(Location location) {
                player.teleport(location);
            }

            @Override
            public void chat(String message) {
                player.chat(message);
            }

            @Override
            public void sendMessage(String message) {
                player.sendMessage(message);
            }

            @Override
            public void kick(String reason) {
                player.kickPlayer(reason);
            }

            @Override
            public void setGameMode(GameMode gameMode) {
                player.setGameMode(gameMode);
            }

            @Override
            public void updateInventory() {
                player.updateInventory();
            }

            @Override
            public void setItemInHand(ItemStack itemStack) {
                player.setItemInHand(itemStack);
            }

            @Override
            public void setVelocity(Vector velocity) {
                player.setVelocity(velocity);
            }

            @Override
            public void setScoreboard(Scoreboard scoreboard) {
                player.setScoreboard(scoreboard);
            }

            @Override
            public void setLevel(int level) {
                player.setLevel(level);
            }

            @Override
            public void kill() {
                player.setHealth(0);
            }

            @Override
            public void setHealth(int health) {
                player.setHealth(health);
            }

            @Override
            public void closeInventory() {
                player.closeInventory();
            }

            @Override
            public void openInventory(Inventory inventory) {
                player.openInventory(inventory);
            }

            @Override
            public boolean hasPermission(String permission) {
                return player.hasPermission(permission);
            }

            @Override
            public boolean isDead() {
                return player.isDead();
            }

            @Override
            public boolean isOp() {
                return player.isOp();
            }

            public PermissionsManager getPermissions() {
                return new PermissionsManager(this);
            }
        };
    }
}

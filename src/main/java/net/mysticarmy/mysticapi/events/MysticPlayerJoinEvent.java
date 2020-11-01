/*
 * Copyright (c) 2020 IIITobiasIII
 *
 * Should the code used in a project, the author of this code (IIITobiasIII) should be named in it.
 */


package net.mysticarmy.mysticapi.events;

import net.mysticarmy.mysticapi.entity.MysticPlayer;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Code by         / MysticArmy.net Owner
 * IIITobiasIII    / IIITobiasIII@mysticarmy.net
 * Created at 01.11.2020
 */
public class MysticPlayerJoinEvent extends Event {

    private static final HandlerList handlerList = new HandlerList();
    private final MysticPlayer player;
    private final Server server;
    private final World world;
    private String joinMessage;

    public MysticPlayerJoinEvent(MysticPlayer player, String joinMessage){
        this.player = player;
        this.server = player.getServer();
        this.world = player.getWorld();
        this.joinMessage = joinMessage;
    }

    public MysticPlayer getPlayer() {
        return player;
    }

    public Server getServer() {
        return server;
    }

    public World getWorld() {
        return world;
    }

    public String getJoinMessage() {
        return joinMessage;
    }

    public void setJoinMessage(String joinMessage){
        this.joinMessage = joinMessage;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}

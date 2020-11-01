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
public class MysticPlayerQuitEvent extends Event {

    private static final HandlerList handlerList = new HandlerList();
    private final MysticPlayer player;
    private final Server server;
    private final World world;
    private String quitMessage;

    public MysticPlayerQuitEvent(MysticPlayer player, String quitMessage){
        this.player = player;
        this.server = player.getServer();
        this.world = player.getWorld();
        this.quitMessage = quitMessage;
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

    public String getQuitMessage() {
        return quitMessage;
    }

    public void setQuitMessage(String quitMessage){
        this.quitMessage = quitMessage;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}

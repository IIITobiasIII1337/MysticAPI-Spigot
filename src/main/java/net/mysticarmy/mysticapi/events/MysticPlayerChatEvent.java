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
public class MysticPlayerChatEvent extends Event {

    private static final HandlerList handlerList = new HandlerList();
    private final MysticPlayer player;
    private final Server server;
    private final World world;
    private String message;

    public MysticPlayerChatEvent(MysticPlayer player, String message){
        this.player = player;
        this.server = player.getServer();
        this.world = player.getWorld();
        this.message = message;
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

    public String getMessage() {
        return message;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}

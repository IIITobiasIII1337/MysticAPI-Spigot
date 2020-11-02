/*
 * Copyright (c) 2020 IIITobiasIII
 *
 * Should the code used in a project, the author of this code (IIITobiasIII) should be named in it.
 */


package net.mysticarmy.mysticapi.events;

import net.mysticarmy.mysticapi.MysticAPI;
import net.mysticarmy.mysticapi.entity.MysticPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Code by         / MysticArmy.net Owner
 * IIITobiasIII    / IIITobiasIII@mysticarmy.net
 * Created at 01.11.2020
 */
public class Events implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        MysticPlayer mysticPlayer = MysticAPI.getInstance().getMysticPlayer(event.getPlayer());
        Bukkit.getPluginManager().callEvent(new MysticPlayerJoinEvent(mysticPlayer, event.getJoinMessage()));
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        MysticPlayer mysticPlayer = MysticAPI.getInstance().getMysticPlayer(event.getPlayer());
        Bukkit.getPluginManager().callEvent(new MysticPlayerQuitEvent(mysticPlayer, event.getQuitMessage()));
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event){
        MysticPlayer mysticPlayer = MysticAPI.getInstance().getMysticPlayer(event.getPlayer());
        Bukkit.getPluginManager().callEvent(new MysticPlayerChatEvent(mysticPlayer, event.getMessage()));
    }
}

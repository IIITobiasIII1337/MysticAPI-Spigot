/*
 * Copyright (c) 2020 IIITobiasIII
 *
 * Should the code used in a project, the author of this code (IIITobiasIII) should be named in it.
 */


package net.mysticarmy.mysticapi.events;

import net.mysticarmy.mysticapi.MysticAPI;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginManager;
import org.jetbrains.annotations.NotNull;

/**
 * Code by         / MysticArmy.net Owner
 * IIITobiasIII    / IIITobiasIII@mysticarmy.net
 * Created at 01.11.2020
 */
public class MysticAPIFinishStartEvent extends Event {

    private static HandlerList handlerList = new HandlerList();
    private final MysticAPI api;
    private final PluginManager pluginManager;

    public MysticAPIFinishStartEvent(MysticAPI api, PluginManager pluginManager){
        this.api = api;
        this.pluginManager = pluginManager;
    }

    public MysticAPI getApi() {
        return api;
    }

    public PluginManager getPluginManager() {
        return pluginManager;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlerList;
    }
}

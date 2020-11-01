/*
 * Copyright (c) 2020 IIITobiasIII
 *
 * Should the code used in a project, the author of this code (IIITobiasIII) should be named in it.
 */


package net.mysticarmy.mysticapi.events;

import net.mysticarmy.mysticapi.gamestate.GameState;
import org.bukkit.Server;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Code by         / MysticArmy.net Owner
 * IIITobiasIII    / IIITobiasIII@mysticarmy.net
 * Created at 01.11.2020
 */
public class MysticGameStateChangeEvent extends Event {

    private static HandlerList handlerList = new HandlerList();
    private final GameState oldGameState;
    private final GameState newGameState;
    private final Server server;


    public MysticGameStateChangeEvent(GameState oldGameState, GameState newGameState, Server server){
        this.oldGameState = oldGameState;
        this.newGameState = newGameState;
        this.server = server;
    }

    public GameState getNewGameState() {
        return newGameState;
    }

    public GameState getOldGameState() {
        return oldGameState;
    }

    public Server getServer() {
        return server;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlerList;
    }
}

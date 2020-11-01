/*
 * Copyright (c) 2020 IIITobiasIII
 *
 * Should the code used in a project, the author of this code (IIITobiasIII) should be named in it.
 */


package net.mysticarmy.mysticapi.gamestate;

import net.mysticarmy.mysticapi.events.MysticGameStateChangeEvent;
import org.bukkit.Bukkit;

/**
 * Code by         / MysticArmy.net Owner
 * IIITobiasIII    / IIITobiasIII@mysticarmy.net
 * Created at 01.11.2020
 */
public class GameStateManager {

    private GameState gameState;

    public void setGameState(GameState gameState){
        Bukkit.getPluginManager().callEvent(new MysticGameStateChangeEvent(getCurrentGameState(), gameState, Bukkit.getServer()));
        this.gameState = gameState;
    }

    public GameState getCurrentGameState() {
        return gameState;
    }
}

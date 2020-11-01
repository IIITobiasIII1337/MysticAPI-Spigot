/*
 * Copyright (c) 2020 IIITobiasIII
 *
 * Should the code used in a project, the author of this code (IIITobiasIII) should be named in it.
 */


package net.mysticarmy.mysticapi.logger;

import net.mysticarmy.mysticapi.MysticAPI;
import net.mysticarmy.mysticapi.events.MysticConsoleLogEvent;
import org.bukkit.Bukkit;

/**
 * Code by         / MysticArmy.net Owner
 * IIITobiasIII    / IIITobiasIII@mysticarmy.net
 * Created at 31.10.2020
 */
public class MysticLogger {

    public static void log(LogType type, String message){
        Bukkit.getPluginManager().callEvent(new MysticConsoleLogEvent(type, message));
        switch (type){
            case INFO:
                Bukkit.getConsoleSender().sendMessage(MysticAPI.getInstance().getPrefix() + "§aINFO §8» §c" + message);
                break;
            case WARN:
                Bukkit.getConsoleSender().sendMessage(MysticAPI.getInstance().getPrefix() + "§eWARN §8» §c" + message);
                break;
            case ERROR:
                Bukkit.getConsoleSender().sendMessage(MysticAPI.getInstance().getPrefix() + "§4ERROR §8» §c" + message);
                break;
            default:
                break;
        }
    }
}

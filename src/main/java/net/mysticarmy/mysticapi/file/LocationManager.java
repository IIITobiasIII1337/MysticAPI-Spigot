/*
 * Copyright (c) 2020 IIITobiasIII
 *
 * Should the code used in a project, the author of this code (IIITobiasIII) should be named in it.
 */


package net.mysticarmy.mysticapi.file;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.io.IOException;

/**
 * Code by         / MysticArmy.net Owner
 * IIITobiasIII    / IIITobiasIII@mysticarmy.net
 * Created at 02.11.2020
 */
public class LocationManager {

    public static void saveLocation(String filePath, String fileName, String path, Location location){
        FileManager fileManager = new FileManager(filePath, fileName);
        fileManager.createFileIfNotExits();
        fileManager.getConfiguration().set(path + ".World", location.getWorld().getName());
        fileManager.getConfiguration().set(path + ".X", location.getX());
        fileManager.getConfiguration().set(path + ".Y", location.getY());
        fileManager.getConfiguration().set(path + ".Z", location.getZ());
        fileManager.getConfiguration().set(path + ".Yaw", location.getYaw());
        fileManager.getConfiguration().set(path + ".Pitch", location.getPitch());

        try {
            fileManager.getConfiguration().save(fileManager.getFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Location getLocation(String filePath, String fileName, String path){
        FileManager fileManager = new FileManager(filePath, fileName);
        World world = Bukkit.getWorld(fileManager.getConfiguration().getString(path + ".World"));
        if (world == null)return null;
        double x = fileManager.getConfiguration().getDouble(path + ".X"),
                y = fileManager.getConfiguration().getDouble(path + ".Y"),
                z = fileManager.getConfiguration().getDouble(path + ".Z");
        float yaw = (float)fileManager.getConfiguration().getDouble(path + ".Yaw"),
                pitch = (float)fileManager.getConfiguration().getDouble(path + ".Pitch");

        return new Location(world, x, y, z, yaw, pitch);
    }
}

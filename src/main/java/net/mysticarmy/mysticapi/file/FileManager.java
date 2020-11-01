/*
 * Copyright (c) 2020 IIITobiasIII
 *
 * Should the code used in a project, the author of this code (IIITobiasIII) should be named in it.
 */


package net.mysticarmy.mysticapi.file;

import net.mysticarmy.mysticapi.MysticAPI;
import net.mysticarmy.mysticapi.logger.LogType;
import net.mysticarmy.mysticapi.logger.MysticLogger;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Code by         / MysticArmy.net Owner
 * IIITobiasIII    / IIITobiasIII@mysticarmy.net
 * Created at 01.11.2020
 */
public class FileManager {

    private final String path;
    private final String fileName;
    private final File file;
    private final File dir;
    private final FileConfiguration configuration;

    public FileManager(String path, String fileName){
        this.path = path;
        this.fileName = fileName;
        this.dir = new File(MysticAPI.getInstance().getDataFolder() + path);
        this.file = new File(MysticAPI.getInstance().getDataFolder() + path, fileName);
        this.configuration = YamlConfiguration.loadConfiguration(file);
    }
    public FileManager(File file){
        this.path = file.getPath();
        this.fileName = file.getName();
        this.dir = new File(MysticAPI.getInstance().getDataFolder() + path);
        this.file = file;
        this.configuration = YamlConfiguration.loadConfiguration(file);
    }

    public void createFileIfNotExits(){
        try {
            if (!dir.exists()){
                dir.mkdir();
            }
            if (!file.exists()){
                file.createNewFile();
            }
        }catch (IOException exception){
            MysticLogger.log(LogType.ERROR, "IOException has thrown in Method createFileIfNotExists()");
            MysticLogger.log(LogType.ERROR, "Couldn't create File §e" + fileName + "§c in Directory §e" + path);
        }
    }
    public File getFile() {
        return file;
    }

    public FileConfiguration getConfiguration() {
        return configuration;
    }
}

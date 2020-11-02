/*
 * Copyright (c) 2020 IIITobiasIII
 *
 * Should the code used in a project, the author of this code (IIITobiasIII) should be named in it.
 */


package net.mysticarmy.mysticapi.file;

import com.google.common.collect.Lists;
import net.mysticarmy.mysticapi.MysticAPI;
import net.mysticarmy.mysticapi.logger.LogType;
import net.mysticarmy.mysticapi.logger.MysticLogger;
import net.mysticarmy.mysticapi.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
            exception.printStackTrace();
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

    public void saveConfig(){
        try {
            getConfiguration().save(getFile());
        }catch (IOException exception){
            exception.printStackTrace();
            MysticLogger.log(LogType.ERROR, "IOException has thrown in Method saveConfig()");
            MysticLogger.log(LogType.ERROR, "Couldn't save File §e" + fileName + "§c in Directory §e" + path);
        }
    }


    public boolean getBoolean(String path){
        return getConfiguration().getBoolean(path);
    }
    public int getInt(String path){
        return getConfiguration().getInt(path);
    }
    public List getIntList(String path){
        return getConfiguration().getIntegerList(path);
    }
    public double getDouble(String path){
        return getConfiguration().getDouble(path);
    }
    public float getFloat(String path){
        return (float) getConfiguration().getDouble(path);
    }
    public List getList(String path){
        return getConfiguration().getList(path);
    }
    public String getString(String path){
        return getConfiguration().getString(path);
    }
    public List<String> getStringList(String path){
        return getConfiguration().getStringList(path);
    }
    public Object get(String path){
        return getConfiguration().get(path);
    }

    public void saveItemStack(String path, ItemStack itemStack){
        String displayName = itemStack.getItemMeta().getDisplayName();
        int amount = itemStack.getAmount();
        String material = itemStack.getType().toString();
        List<String> itemFlags = new ArrayList<>();
        itemStack.getItemMeta().getItemFlags().forEach(itemFlag -> {
            itemFlags.add(itemFlag.toString());
        });
        List<String> lore = itemStack.getItemMeta().getLore();
        HashMap<Enchantment, Integer> enchantments = new HashMap<>(itemStack.getEnchantments());
        getConfiguration().set(path + ".DisplayName", displayName);
        getConfiguration().set(path + ".Material", material);
        getConfiguration().set(path + ".Amount", amount);
        getConfiguration().set(path + ".Lore", lore);
        getConfiguration().set(path + ".ItemFlags", itemFlags);
        enchantments.forEach((enchantment, integer) -> getConfiguration().set(path + ".Enchantments." + enchantment.toString(), integer));
        saveConfig();
    }

    public ItemStack getItemStack(String path){
        Material material = Material.valueOf(getString(path + ".Material"));
        String displayName = getString(path + ".DisplayName");
        int amount = getInt(path + ".Amount");
        List<String> lore = getStringList(path + ".Lore");
        List<ItemFlag> itemFlags = new ArrayList<>();
        for (String string : getStringList(path + ".ItemFlags")){
            itemFlags.add(ItemFlag.valueOf(string));
        }
        //Init all Enchantments
        List<Enchantment> ent = new ArrayList<>();
        for (String string : getStringList(path + ".Enchantments")){
            ent.add(Enchantment.getByName(string));
        }
        //Init all Enchantments-LEVEL
        List<Integer> lvl = new ArrayList<>();
        for (int i = 0; i < ent.size(); i++){
            lvl.add(getInt(path + ".Entchantments." + ent.get(i)));
        }
        return new ItemBuilder(material).setDisplayName(displayName).setAmount(amount).setLore(lore).addEnchantments(ent, lvl).addItemFlags(itemFlags).build();
    }
}

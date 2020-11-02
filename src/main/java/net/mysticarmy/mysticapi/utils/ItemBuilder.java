/*
 * Copyright (c) 2020 IIITobiasIII
 *
 * Should the code used in a project, the author of this code (IIITobiasIII) should be named in it.
 */


package net.mysticarmy.mysticapi.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

/**
 * Code by         / MysticArmy.net Owner
 * IIITobiasIII    / IIITobiasIII@mysticarmy.net
 * Created at 02.11.2020
 */
public class ItemBuilder {

    private ItemStack itemStack;
    private ItemMeta itemMeta;

    public ItemBuilder(Material material){
        this.itemStack = new ItemStack(material);
        this.itemMeta = this.itemStack.getItemMeta();
        this.itemStack.setAmount(1);
    }

    public ItemBuilder setAmount(int amount){
        this.itemStack.setAmount(amount);
        return this;
    }

    public ItemBuilder setDisplayName(String displayName){
        this.itemMeta.setDisplayName(displayName);
        return this;
    }

    public ItemBuilder setLore(String... lore){
        this.itemMeta.setLore(Arrays.asList(lore));
        return this;
    }

    public ItemBuilder setLore(List<String> lore){
        this.itemMeta.setLore(lore);
        return this;
    }

    public ItemBuilder addEnchantments(List<Enchantment> enchantments, List<Integer> levels){
        for (int i = 0; i < enchantments.size(); i++) {
            this.itemMeta.addEnchant(enchantments.get(i), levels.get(i), true);
        }
        return this;
    }

    public ItemBuilder addItemFlags(List<ItemFlag> flag){
        flag.forEach(flag1 -> this.itemMeta.addItemFlags(flag1));
        return this;
    }

    public ItemStack build(){
        this.itemStack.setItemMeta(this.itemMeta);
        return this.itemStack;
    }
}

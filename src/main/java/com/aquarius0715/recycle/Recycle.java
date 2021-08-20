package com.aquarius0715.recycle;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.intellij.lang.annotations.RegExp;

import java.util.Objects;

public final class Recycle extends JavaPlugin implements Listener {

    Data data = new Data();
    ResisterItems resisterItems = new ResisterItems(this);
    Items items = new Items(this);

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ResisterItems(this), this);
        getServer().getPluginManager().registerEvents(new Items(this), this);
        getServer().getPluginManager().registerEvents(this, this);
        Objects.requireNonNull(getCommand("at")).setExecutor(new Command(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        data.setAutoTrashMap(e.getPlayer().getUniqueId(), Bukkit.createInventory(null, 18, "Resister your items"));
    }
}

package com.aquarius0715.recycle;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Objects;

public class ResisterItems implements Listener {

    Recycle plugin;
    public ResisterItems(Recycle plugin) {
        this.plugin = plugin;
    }

    public void openResisterUI(Player p) {
        Inventory inv = plugin.data.getAutoTrashMap().get(p.getUniqueId());
        p.openInventory(inv);
    }

    @EventHandler
    public void closeResisterUI(InventoryCloseEvent e) {
        Player p = (Player) e.getPlayer();
        if (!(e.getInventory().getType().getDefaultTitle().equals("Resister your items"))) {
            return;
        }
        plugin.data.setAutoTrashMap(p.getUniqueId(), e.getInventory());
        for (ItemStack item : e.getInventory().getContents()) {
            p.sendMessage(Objects.requireNonNull(item.getItemMeta()).getDisplayName() + "が追加されました。");
        }
    }
}

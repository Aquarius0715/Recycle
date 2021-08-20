package com.aquarius0715.recycle;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

public class Items implements Listener {

    Recycle plugin;
    public Items(Recycle plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void pickUpItem(PlayerPickupItemEvent e) {
        Material material = e.getItem().getItemStack().getType();
        ItemStack[] itemStack = plugin.data.getAutoTrashMap().get(e.getPlayer().getUniqueId()).getContents();
        Player p = e.getPlayer();
        for (ItemStack items : itemStack) {
            if (items.getType() == material) {
                e.setCancelled(true);
                e.getItem().remove();
                p.playSound(p.getLocation(), Sound.ENTITY_ITEM_PICKUP, 8.0F, 0);
            }
        }
    }
}

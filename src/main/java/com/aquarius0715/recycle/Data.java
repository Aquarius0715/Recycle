package com.aquarius0715.recycle;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Data {
    private final HashMap<UUID, Inventory> autoTrashMap = new HashMap<>();

    public HashMap<UUID, Inventory> getAutoTrashMap() {
        return autoTrashMap;
    }
    public void setAutoTrashMap(UUID uuid, Inventory inv) {
        this.autoTrashMap.put(uuid, inv);
    }
}

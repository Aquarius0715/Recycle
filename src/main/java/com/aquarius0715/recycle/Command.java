package com.aquarius0715.recycle;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command implements CommandExecutor {

    Recycle plugin;
    public Command(Recycle plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "あなたはこのコマンドを実行することはできません。");
            return false;
        }
        if (label.equalsIgnoreCase("at")) {
            if (args.length == 0) {
                plugin.resisterItems.openResisterUI((Player) sender);
                return true;
            }
        }
        return false;
    }
}

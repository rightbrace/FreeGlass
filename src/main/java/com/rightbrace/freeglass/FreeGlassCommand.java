package com.rightbrace.freeglass;

import static org.bukkit.Bukkit.getServer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class FreeGlassCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        
        if (!(sender instanceof Player)) {
            return false;
        }
        
        if (args.length == 0) {
            sender.sendMessage("Format is: /freeglass <player>");
            return false;
        }
        
        Player target = getServer().getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage("Cannot find player " + args[0]);
            return false;
        }
        
        PlayerInventory inv = target.getInventory();
        
        for (int i = 0; i < 36; i++) {
            ItemStack slotItem = inv.getItem(i);
            if (slotItem == null) {
                inv.setItem(i, GlassGenerator.getPane());
            }
        }
        
        return true;
        
    }
    
}

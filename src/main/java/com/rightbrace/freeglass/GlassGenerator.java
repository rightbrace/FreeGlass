package com.rightbrace.freeglass;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GlassGenerator {
    
    private static GlassGenerator instance;
    private static int progress = 0;
    
    public static ItemStack getPane() {
        
        String lower = "free glass";
        String upper = "FREE_GLASS";
        
        String name = "";
        for (int i = 0; i < 10; i++) {
            if (((progress >> i) & 1) == 1) {
                name += lower.substring(i, i+1);
            } else {
                name += upper.substring(i, i+1);
            }
        }
        
        progress ++;
        if (progress > 1023) {
            progress = 0;
        }
        
        ItemStack pane = new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS_PANE);
        ItemMeta meta = pane.getItemMeta();
        
        meta.setDisplayName(name);
        pane.setItemMeta(meta);
        
        return pane;
        
    }
}

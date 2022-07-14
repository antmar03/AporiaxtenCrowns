package me.uraniumape.crown;


import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

public class DisableCrafting implements Listener {

	
	@EventHandler
	public void onCraft(CraftItemEvent e) {
		ItemStack result = e.getRecipe().getResult();
		
		if(result.getType().equals(Material.GOLDEN_HELMET)) {
			e.setCancelled(true);
		}
	}
	

}

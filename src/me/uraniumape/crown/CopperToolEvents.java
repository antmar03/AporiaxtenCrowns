package me.uraniumape.crown;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CopperToolEvents implements Listener{

	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		if(e.getPlayer().getInventory().getItemInMainHand().hasItemMeta()) {
			ItemMeta meta = e.getPlayer().getInventory().getItemInMainHand().getItemMeta();
			
			if(meta.getLore().get(0).contains("Copper Pickaxe")) {
				e.getBlock().breakNaturally(new ItemStack(Material.IRON_PICKAXE));
			}
		}
	}
	
}

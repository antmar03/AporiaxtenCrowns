package me.uraniumape.crown;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

enum CrownType {
	COPPER,
	IRON,
	GOLD,
	DIAMOND,
	NETHERITE,
	VANILLA
}

public class CrownCreator implements CommandExecutor{

	private ItemMeta setCrownMeta(ItemMeta crownMeta, double armor, double toughness, double knockback, String name, List<String> crownLore) {
		String crownName = name;
		AttributeModifier modifier;

		//Defense
		
		//Set the defense of the crown into a variable
		modifier = new AttributeModifier(UUID.randomUUID(), "generic.armor", armor,
				Operation.ADD_NUMBER, EquipmentSlot.HEAD);
		
		//Add this to the crown meta
		crownMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
		
		
		//Toughness
		
		//Set the toughness of the crown into a variable
		modifier = new AttributeModifier(UUID.randomUUID(), "generic.armor_toughness", toughness,
				Operation.ADD_NUMBER, EquipmentSlot.HEAD);
		
		//Add this to the crown meta
		crownMeta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, modifier);
		
		
		
		//Knockback Resistance
		
		//Set the knockback of the crown into a variable
		modifier = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", knockback,
				Operation.ADD_NUMBER, EquipmentSlot.HEAD);
		
		//Add this to the crown meta
		crownMeta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, modifier);
		
		crownMeta.setLore(crownLore);
		crownMeta.setDisplayName(crownName);
		
		return crownMeta;

	}
	
	private ItemStack createCrown(CrownType type) {
		String crownName = "";
		List<String> crownLore = new ArrayList<String>();
		
		ItemStack crown = new ItemStack(Material.CHAINMAIL_HELMET);
		
		
		ItemMeta crownMeta = crown.getItemMeta();
		
		
		switch(type) {
		
		case COPPER:
			
			crownName = "§6Copper Crown";
			crownLore.add("§7A rare copper crown");
			
			crownMeta = setCrownMeta(crownMeta, 3.0, 3.0, 0.1, crownName, crownLore);
			
		break;
		
		case IRON:
			
			crownName = "§fIron Crown";
			crownLore.add("§7A rare iron crown");
			
			crownMeta = setCrownMeta(crownMeta, 6.0, 6.0, 0.2, crownName, crownLore);
		break;
		
		case GOLD:
			
			crownName = "§eGold Crown";
			crownLore.add("§7A rare golden crown");
			
			
			crownMeta = setCrownMeta(crownMeta, 9.0, 9.0, 0.3, crownName, crownLore);
			
		break;
		
		case DIAMOND:
			
			crownName = "§bDiamond Crown";
			crownLore.add("§7A rare diamond crown");
			
			crownMeta = setCrownMeta(crownMeta, 9.0, 9.0, 0.3, crownName, crownLore);
			
		break;
		
		case NETHERITE:
			
			crownName = "§5Netherite Crown";
			crownLore.add("§7A rare netherrite crown");
			
			
			crownMeta = setCrownMeta(crownMeta, 9.0, 9.0, 0.3, crownName, crownLore);
			
		
		break;
		
		case VANILLA:
			crownName = "§eCrown";
			crownLore.add("§7A rare crown");
			crownLore.add("§7(For those without optifine)");

			crown = new ItemStack(Material.GOLDEN_HELMET);
			
		}
		
		crownMeta.setUnbreakable(true);
		crownMeta.setDisplayName(crownName);
		crown.setItemMeta(crownMeta);
		
		return crown;
	}
	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender.isOp()) {
			if(args.length == 0) {
				sender.sendMessage("§2Usage: /ac give {crown} {user} ");
				return true;
			}
			
			switch(args[0]) 
			{
			
				case "give":
					
					if(args[1] == null) {
						sender.sendMessage("§2Usage: /ac give {crown} {user} ");
					}else {
						CrownType type;
						try {
							type = CrownType.valueOf(args[1].toUpperCase());
						}catch(IllegalArgumentException e){
							sender.sendMessage("§2 Invalid Crown Type: \n Copper \n Iron \n Gold \n Diamond \n Netherite \n Vanilla");
							return true;
						}
						
						
						//If player exists
						if(Bukkit.getPlayer(args[2]) != null) {
							Player target = Bukkit.getPlayer(args[2]);
							ItemStack crown = createCrown(type);
							
							target.getInventory().addItem(crown);	
							
						}else {
							sender.sendMessage("§2 Invalid player name: " + args[2]);
						}
							
						
						
						
					}
					
		
				break;
				
				default:
						sender.sendMessage("§2Usage: /ac give {crown} {user} ");
				break;
			}
		}else {
			sender.sendMessage("§2You need to be OP to perform this command");
		}
		

		
		
		
		return true;
	}
	
	
	
	

}

package me.uraniumape.crown;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GeneralCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender.isOp()) {
			if(args.length == 0) {
				sender.sendMessage("§2Usage: /am give {item} {user} ");
				return true;
			}
			
			switch(args[0]) 
			{
			
				case "give":
					
					if(args[1] == null) {
						sender.sendMessage("§2Usage: /am give {item} {user} ");
					}else {
						Item_Type type;
						
						try {
							type = Item_Type.valueOf(args[1].toUpperCase());
						}catch(IllegalArgumentException e){
							sender.sendMessage("§2 Invalid Item Type: \n Copper \n Royal");
							return true;
						}
						
						
						
						//If player exists
						if(Bukkit.getPlayer(args[2]) != null) {
							Player target = Bukkit.getPlayer(args[2]);
							ItemCreator.giveItemToPlayer(type, target);
						}else {
							sender.sendMessage("§2 Invalid player name: " + args[2]);
						}
							
						
						
						
					}
					
		
				break;
				
				default:
						sender.sendMessage("§2Usage: /am give {item} {user} ");
				break;
			}
		}else {
			sender.sendMessage("§2You need to be OP to perform this command");
		}
		
		return false;
	}

}

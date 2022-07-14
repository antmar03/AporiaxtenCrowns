package me.uraniumape.crown;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public class CrownCore extends JavaPlugin
{
	
	private static CrownCore instance;
	
	public void onEnable()
	{
		
		instance = this;
		this.getCommand("ac").setExecutor(new CrownCreator());
		this.getCommand("am").setExecutor(new GeneralCommand());
		getServer().getPluginManager().registerEvents(new DisableCrafting(),this);
		getServer().getPluginManager().registerEvents(new CopperToolEvents(),this);
		
		
		ItemCreator.initializeRecipes();
		
		Bukkit.getLogger().info("Aporiaxten Crowns enabled! Thank you for your custom purchase:)");
	}
	
	public void onDisable() {
		ItemCreator.removeRecipes();
	}
	
	public static CrownCore getPlugin() {
		return instance;
	}

}

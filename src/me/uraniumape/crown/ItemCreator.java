package me.uraniumape.crown;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemCreator {
	
	private static boolean arrayContains(String[] array, String s) {
		for(String index : array) {
			if(index.equals(s)) {
				return true;
			}
		}
		return false;
	}
	
	
	private static void createCopperArmorRecipe(ItemStack item, String[] shape, String name) {
		NamespacedKey key = new NamespacedKey(CrownCore.getPlugin(), name);
		
		ShapedRecipe recipe = new ShapedRecipe(key,item);
		
		recipe.shape(shape);
		
		recipe.setIngredient('C', Material.COPPER_INGOT);
		
		recipe.setIngredient('A', Material.AIR);
		
		Bukkit.addRecipe(recipe);
	}
	
	private static void createCopperRecipe(ItemStack item, String[] shape, String name) {
		NamespacedKey key = new NamespacedKey(CrownCore.getPlugin(), name);
		
		ShapedRecipe recipe = new ShapedRecipe(key,item);
		
		recipe.shape(shape);
		
		recipe.setIngredient('C', Material.COPPER_INGOT);
		
		recipe.setIngredient('S', Material.STICK);
		
		recipe.setIngredient('A', Material.AIR);
		
		Bukkit.addRecipe(recipe);
	}
	
	public static void removeRecipes() {
		String name;
		NamespacedKey key;
		
		name = "copper_sword";
		key = new NamespacedKey(CrownCore.getPlugin(), name);
		Bukkit.removeRecipe(key);
		
		name = "copper_pickaxe";
		key = new NamespacedKey(CrownCore.getPlugin(), name);
		Bukkit.removeRecipe(key);
		
		name = "copper_axe";
		key = new NamespacedKey(CrownCore.getPlugin(), name);
		Bukkit.removeRecipe(key);
		
		name = "copper_shovel";
		key = new NamespacedKey(CrownCore.getPlugin(), name);
		Bukkit.removeRecipe(key);
		
		name = "copper_hoe";
		key = new NamespacedKey(CrownCore.getPlugin(), name);
		Bukkit.removeRecipe(key);
		
		name = "copper_helmet";
		key = new NamespacedKey(CrownCore.getPlugin(), name);
		Bukkit.removeRecipe(key);
		
		name = "copper_chestplate";
		key = new NamespacedKey(CrownCore.getPlugin(), name);
		Bukkit.removeRecipe(key);
		
		name = "copper_leggings";
		key = new NamespacedKey(CrownCore.getPlugin(), name);
		Bukkit.removeRecipe(key);
		
		name = "copper_boots";
		key = new NamespacedKey(CrownCore.getPlugin(), name);
		Bukkit.removeRecipe(key);
		
	}
	
	public static void initializeRecipes() {
		String[] shape = new String[3];
		
		String name;
		
		//Copper Sword
		shape[0] = "ACA";
		shape[1] = "ACA";
		shape[2] = "ASA";
		
		name = "copper_sword";
		
		ItemStack copperSword = generateItem(Item_Type.COPPER_SWORD);
		createCopperRecipe(copperSword, shape, name);
		
		//Copper Pickaxe
		shape[0] = "CCC";
		shape[1] = "ASA";
		shape[2] = "ASA";

		
		name = "copper_pickaxe";
		
		ItemStack copperPick = generateItem(Item_Type.COPPER_PICKAXE);
		createCopperRecipe(copperPick, shape, name);
		
		
		//Copper Axe
		shape[0] = "CCA";
		shape[1] = "CSA";
		shape[2] = "ASA";

		
		name = "copper_axe";
		
		ItemStack copperAxe = generateItem(Item_Type.COPPER_AXE);
		createCopperRecipe(copperAxe, shape, name);
		
		//Copper Shovel
		shape[0] = "ACA";
		shape[1] = "ASA";
		shape[2] = "ASA";

		
		name = "copper_shovel";
		
		ItemStack copperShovel = generateItem(Item_Type.COPPER_SHOVEL);
		createCopperRecipe(copperShovel, shape, name);
		
		//Copper Hoe
		shape[0] = "CCA";
		shape[1] = "ASA";
		shape[2] = "ASA";
		
		
		name = "copper_hoe";
		
		ItemStack copperHoe = generateItem(Item_Type.COPPER_HOE);
		createCopperRecipe(copperHoe, shape, name);
		
		//Copper Armor
		
		//Copper Helmet
		shape[0] = "CCC";
		shape[1] = "CAC";
		shape[2] = "AAA";
		
		
		name = "copper_helmet";
		
		ItemStack copperHelmet = generateArmor(Item_Type.COPPER_HELMET);
		createCopperArmorRecipe(copperHelmet, shape, name);
		
		//Copper Chestplate
		shape[0] = "CAC";
		shape[1] = "CCC";
		shape[2] = "CCC";
		
		
		name = "copper_chestplate";
		
		ItemStack copperPlate = generateArmor(Item_Type.COPPER_CHESTPLATE);
		createCopperArmorRecipe(copperPlate, shape, name);
		
		
		//Copper Leggings
		shape[0] = "CCC";
		shape[1] = "CAC";
		shape[2] = "CAC";
		
		
		name = "copper_leggings";
		
		ItemStack copperLeggings = generateArmor(Item_Type.COPPER_LEGGINGS);
		createCopperArmorRecipe(copperLeggings, shape, name);
		
		//Copper Boots
		shape[0] = "CAC";
		shape[1] = "CAC";
		shape[2] = "AAA";
		
		
		name = "copper_boots";
		
		ItemStack copperBoots = generateArmor(Item_Type.COPPER_BOOTS);
		createCopperArmorRecipe(copperBoots, shape, name);
		
		
		
		
	}
	
	private static ItemStack generateItem(Item_Type type) {
		List<String> lore = new ArrayList<String>();
		String name = "";
		Material material = null;
		ItemStack item = null;
		ItemMeta meta = null;
		AttributeModifier modifier = null;

		
		switch(type) {
		
			case COPPER_SWORD:
				name = "§6Copper Sword";
				material = Material.IRON_SWORD;
				lore.add("Copper Sword");
				modifier = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", 5.5,
						Operation.ADD_NUMBER, EquipmentSlot.HAND);				
			break;
			
			case COPPER_AXE:
				name = "§6Copper Axe";
				material = Material.IRON_AXE;
				lore.add("Copper Axe");
			break;
			
			case COPPER_PICKAXE:
				name = "§6Copper Pickaxe";
				material = Material.STONE_PICKAXE;
				lore.add("Copper Pickaxe");
			break;
			
			case COPPER_SHOVEL:
				name = "§6Copper Shovel";
				material = Material.IRON_SHOVEL;
				lore.add("Copper Shovel");
			break;
			
			case COPPER_HOE:
				name = "§6Copper Hoe";
				material = Material.IRON_HOE;
				lore.add("Copper Hoe");
			break;
			
			default:
				return generateArmor(type);
				
			
		}
		
		item = new ItemStack(material);
		
		meta = item.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(lore);
		
		
		if(type == Item_Type.COPPER_SWORD) {
			meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
			modifier = new AttributeModifier(UUID.randomUUID(), "generic.attack_speed", 1.6,
					Operation.ADD_NUMBER, EquipmentSlot.HAND);		
			meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);	
		}
		
		item.setItemMeta(meta);

		
		return item;
	}
	
	private static ItemStack generateArmor(Item_Type type) {
		List<String> lore = new ArrayList<String>();
		String name = "";
		Material material = null;
		ItemStack item = null;
		ItemMeta meta = null;
		AttributeModifier modifier;
		double armor = 0;
		EquipmentSlot slot = null;

		
		switch(type) {
			case COPPER_HELMET:
				name = "§6Copper Helmet";
				material = Material.CHAINMAIL_HELMET;
				lore.add("Copper Helmet");
				armor = 2;
				slot = EquipmentSlot.HEAD;
			break;

			case COPPER_CHESTPLATE:
				name = "§6Copper Chestplate";
				lore.add("Copper Chestplate");
				material = Material.CHAINMAIL_CHESTPLATE;
				armor = 5;
				slot = EquipmentSlot.CHEST;
				
			break;
			
			case COPPER_LEGGINGS:
				name = "§6Copper Leggings";
				lore.add("Copper Leggings");
				material = Material.CHAINMAIL_LEGGINGS;
				armor = 4;
				slot = EquipmentSlot.LEGS;
			break;
			
			case COPPER_BOOTS:
				name = "§6Copper Boots";
				lore.add("Copper Boots");
				material = Material.CHAINMAIL_BOOTS;
				armor = 1;
				slot = EquipmentSlot.FEET;
			break;
			
			
			case ROYAL_HELMET:
				name = "§9Royal Helmet";
				lore.add("Royal Helmet");
				material = Material.NETHERITE_HELMET;
				armor = 3;
				slot = EquipmentSlot.HEAD;
			break;
			
			case ROYAL_CHESTPLATE:
				name = "§9Royal Chestplate";
				lore.add("Royal Chestplate");
				material = Material.NETHERITE_CHESTPLATE;
				armor = 8;
				slot = EquipmentSlot.CHEST;
			break;
			
			case ROYAL_LEGGINGS:
				name = "§9Royal Leggings";
				lore.add("Royal Leggings");
				material = Material.NETHERITE_LEGGINGS;
				slot = EquipmentSlot.LEGS;
				armor = 6;
			break;
			
			case ROYAL_BOOTS:
				name = "§9Royal Boots";
				lore.add("Royal Boots");
				material = Material.NETHERITE_BOOTS;
				slot = EquipmentSlot.FEET;
				armor = 3;
			break;
			

			
		}
		
		//Create the modifier
		modifier = new AttributeModifier(UUID.randomUUID(), "generic.armor", armor,
				Operation.ADD_NUMBER, slot);
		

		
		item = new ItemStack(material);
		
		meta = item.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(lore);
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
		
		item.setItemMeta(meta);
		
		
		return item;
	
	}
	
	
	public static void giveArmorToPlayer(Item_Type type, Player p) {
		ItemStack item = generateArmor(type);
		p.getInventory().addItem(item);
	}
	
	
	public static void giveItemToPlayer(Item_Type type, Player p) {
		ItemStack item = generateItem(type);
		p.getInventory().addItem(item);
	}
	
}

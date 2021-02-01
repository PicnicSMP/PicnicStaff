package me.Unweptpit.Features;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class StaffItems {
	//Constructor
	
	//Instances
	
	//Variables and Arrays
	
	//Methods
	
	public ItemStack Kill() {
		String itemLore = "Right click on a player to kill them";
		ItemStack CpsCounter = new ItemStack(Material.STICK);
		ItemMeta CpsCounterMeta = CpsCounter.getItemMeta();
		List<String> CpsCounterLore = new ArrayList<String>();
		
				
		CpsCounterLore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + itemLore);
		CpsCounterMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&8[&cPicnicStaff&8] &7Kill Stick"));
		CpsCounterMeta.setLore(CpsCounterLore);
		CpsCounter.setItemMeta(CpsCounterMeta);
		
		return  CpsCounter;
						
	}
	
	public ItemStack Examine() {
		String itemLore = "Right click on a player to examine them";
		ItemStack Examine = new ItemStack(Material.BLAZE_ROD);
		ItemMeta ExamineMeta = Examine.getItemMeta();
		List<String> ExamineLore = new ArrayList<String>();
		
				
		ExamineLore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + itemLore);
		ExamineMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&8[&cPicnicStaff&8] &7Examiner"));
		ExamineMeta.setLore(ExamineLore);
		Examine.setItemMeta(ExamineMeta);
		
		return  Examine;
						
	}
	
	public ItemStack Vanish() {
		String itemLore = "Right click to toggle vanish";
		ItemStack Vanish = new ItemStack(Material.FEATHER);
		ItemMeta VanishMeta = Vanish.getItemMeta();
		List<String> VanishLore = new ArrayList<String>();
		
				
		VanishLore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + itemLore);
		VanishMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&8[&cPicnicStaff&8] &7Vanish"));
		VanishMeta.setLore(VanishLore);
		Vanish.setItemMeta(VanishMeta);
		
		return  Vanish;
						
	}
	
	public ItemStack Gamemode() {
		String ItemLore = "Right click (ground) to toggle between creative mode and spectator mode";
		ItemStack Gamemode = new ItemStack(Material.IRON_NUGGET);
		ItemMeta GamemodeMeta = Gamemode.getItemMeta();
		List<String> GamemodeLore = new ArrayList<String>();
		
				
		GamemodeLore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + ItemLore);
		GamemodeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&8[&cPicnicStaff&8] &7Gamemode Toggler"));
		GamemodeMeta.setLore(GamemodeLore);
		Gamemode.setItemMeta(GamemodeMeta);
		
		return  Gamemode;
						
	}
	
	public ItemStack Clearinventory() {
		String itemLore = "Right click on a player to clear his/her inventory";
		ItemStack Clearinventory = new ItemStack(Material.FLINT);
		ItemMeta ClearinventoryMeta = Clearinventory.getItemMeta();
		List<String> ClearinventoryLore = new ArrayList<String>();
		
				
		ClearinventoryLore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + itemLore);
		ClearinventoryMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&8[&cPicnicStaff&8] &7ClearInventory"));
		ClearinventoryMeta.setLore(ClearinventoryLore);
		Clearinventory.setItemMeta(ClearinventoryMeta);
		
		return  Clearinventory;
						
	}
	
	public ItemStack Coreprotect() {
		String itemLore = "Right click to toggle /co i";
		ItemStack Coreprotect = new ItemStack(Material.SLIME_BALL);
		ItemMeta CoreprotectMeta = Coreprotect.getItemMeta();
		List<String> CoreprotectLore = new ArrayList<String>();
		
				
		CoreprotectLore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + itemLore);
		CoreprotectMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&8[&cPicnicStaff&8] &7Coreprotect Inspect"));
		CoreprotectMeta.setLore(CoreprotectLore);
		Coreprotect.setItemMeta(CoreprotectMeta);
		
		return  Coreprotect;
						
	}
	
	
}

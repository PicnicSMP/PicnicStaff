package me.Unweptpit.Picnicstaff;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import me.Unweptpit.Commands.Adminchat;
import me.Unweptpit.Commands.Builderchat;
import me.Unweptpit.Commands.PlayerInfo;
import me.Unweptpit.Commands.StaffMode;
import me.Unweptpit.Commands.Staffchat;
import me.Unweptpit.Features.XrayNotifier;
import me.Unweptpit.TabCompleters.PicnicstaffTabCompleter;
import me.Unweptpit.TabCompleters.StaffModeTabCompleter;



public class PicnicStaff extends JavaPlugin implements Listener {
	
	
	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		
		Bukkit.getServer().getPluginManager().registerEvents(new XrayNotifier(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new StaffMode(this), this);
		
		//On server startup / reload / plugin reloads
		this.getCommand("adminchat").setExecutor( new Adminchat(this));
		this.getCommand("staffchat").setExecutor( new Staffchat(this));
		this.getCommand("builderchat").setExecutor( new Builderchat(this));
		this.getCommand("getinfo").setExecutor( new PlayerInfo(this));
		this.getCommand("staffmode").setExecutor( new StaffMode(this));
		this.getCommand("staffmode").setTabCompleter(new StaffModeTabCompleter());
		this.getCommand("picnicstaff").setTabCompleter(new PicnicstaffTabCompleter());

	}
	
	@Override
	public void onDisable() {
		StaffMode staffmodeInst = new StaffMode(this);
		
		for (Player onlineplayer : getServer().getOnlinePlayers()) {  //Get everyone in staffmode outside of staffmode to prevent inventory loss
			PersistentDataContainer playerdata = onlineplayer.getPersistentDataContainer();
			if (playerdata.has(new NamespacedKey(this, "Staffmode"), PersistentDataType.INTEGER)){
				playerdata.remove(new NamespacedKey(this, "Staffmode"));
				ItemStack[] inventory = StaffMode.returnInventory(onlineplayer);	
					
				if (inventory != null) {
					onlineplayer.getInventory().setContents(inventory);
				}
				else {
					onlineplayer.sendMessage("Inventory couldn't be found");
				}
				staffmodeInst.setStaffmode(onlineplayer, false);
			}
		}
			
			
	}


	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) { 													//Reloading the config is done with this command
		if (label.equalsIgnoreCase("Picnicstaff")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (!(player.hasPermission(this.getConfig().getString("permissions.permissionStaff")))) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("permissions.nopermission")));
					return true;
				}
			}
			if (args.length == 0) {
				sender.sendMessage("Usage: /picnicstaff help");
				return true;
			}
			
			if (args.length > 0) {
				
				if (args[0].equalsIgnoreCase("reload")) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&cPicnicStaff&8] &fConfig reloaded!"));
					this.reloadConfig();
					this.saveDefaultConfig();
					
					return true;
				}
				
				if (args[0].equalsIgnoreCase("help")) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&cPicnicstaff&8]"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f/picnicstaff reload &8- &cReloads the config file"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f/picnicstaff help &8- &cShows this message"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f/sc <msg> &8- &cSend a message in staffchat"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f/ac <msg> &8- &cSend a message in adminchat"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f/getinfo <player> &8- &cGives some useful information about that player"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f/staffmode &8- &cToggles staffmode"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f/staffmode vanish &8- &cToggles vanish"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f/staffmode xray <on/off> &8- &cToggles vanish"));
					return true;
				}
				
				if (args[0].equalsIgnoreCase("xray")) {
					if (sender instanceof Player) {
						Player player = (Player) sender;
						if (args.length < 2) {
							player.sendMessage("Usage: /picnicstaff xraynotification <on/off>");
							return false;
						}
						else {
							PersistentDataContainer playerdata = player.getPersistentDataContainer();
							if (args[1].equalsIgnoreCase("off")) {
								sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&cPicnicStaff&8] &fXray notifications have been turned &coff"));
								playerdata.set(new NamespacedKey(this, "xray"), PersistentDataType.INTEGER ,  1);
								return true;
							}
							
							if (args[1].equalsIgnoreCase("on")) {
								sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&cPicnicStaff&8] &fXray notifications have been turned &aon"));
								playerdata.remove(new NamespacedKey(this, "xray"));
								return true;
							}
						}
						
					}
					else {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&cPicnicStaff&8] &fYou can't disable the consoles xray notifications!"));
						return false;
					}
				}

			}		
		}
		return false;
	} 
	
	
}//end of class
		
		




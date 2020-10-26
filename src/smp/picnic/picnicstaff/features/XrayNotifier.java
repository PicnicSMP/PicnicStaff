package smp.picnic.picnicstaff.features;


import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import net.md_5.bungee.api.ChatColor;
import smp.picnic.picnicstaff.PicnicStaff;



public class XrayNotifier implements Listener {
	private final PicnicStaff main;
	
	public XrayNotifier(PicnicStaff main){
		this.main = main;
	}
	
	
	public HashMap<UUID, HashMap<String, Integer>> map = new HashMap<>(); 
	
	@EventHandler()
	public void onBlockBreak(BlockBreakEvent e) { // Check the block mined, if there are no blocks of the same type in the surrounding area send a message saying how many blocks the player mined.
		Player player = (Player) e.getPlayer();
		String block = e.getBlock().getType().toString();
		UUID uuid = player.getUniqueId();
		
		if(!(player.hasPermission(main.getConfig().getString("permissions.permissionXray")))) { //Check if player needs to be checked for xray
			for (String j : main.getConfig().getStringList("Blocks")) {  //Loop through the blocks in the config
				if (j.equalsIgnoreCase(block)) {  // If mined block matches a block in config
					if (map.containsKey(uuid) == false) {
						HashMap<String, Integer> map2 = new HashMap<>();
						map.put(uuid, map2);

					}
					
					if (map.get(uuid).get(block) == null) {
						map.get(uuid).put(block, 1);
					}
					else {
						int count = map.get(uuid).get(block);
						map.get(uuid).put(block, (count + 1));
					}
				
					String name = main.getConfig().getString("Names." + block);
					Location loc = e.getBlock().getLocation();
					World world = loc.getWorld();
					
					if (LoopBlocks(e.getBlock(), loc, world)) {
						for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
							if (onlinePlayers.hasPermission(main.getConfig().getString("permissions.permissionStaff"))) {
								int i = map.get(uuid).get(block);
								onlinePlayers.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&4Xray&8] &f" + player.getDisplayName() + "&c has mined &f" + i + " " + name));
								Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&4Xray&8] &f" + player.getDisplayName() + "&c has mined &f" + i + " " + name));
								map.get(uuid).put(block, 0);
							}
						}
						int i = map.get(uuid).get(block);
						Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&4Xray&8] &f" + player.getDisplayName() + "&c has mined &f" + i + " " + name));
						map.get(uuid).put(block, 0);
					}
				}
			}   
		}
	}
	
	
	public Boolean LoopBlocks(Block block, Location loc, World world) { 
		//Check all blocks around block to see if they match
		/*	DP: There is a more efficient way of doing this; using a loop and bailing from the loop once you hit a match */
		int x = loc.getBlockX() - 1;
		int y = loc.getBlockY() - 1;
		int z = loc.getBlockZ() - 1;
		
		Block b;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				for(int k = 0; k < 3; k++) {
					//	Skip the origin
					if(i == 1 && i == j && j == k)
						continue;
					
					b = new Location(world, x + i, y + j, z + k).getBlock();
					if( b.getType() == block.getType() ) {
						return true;
					}
				}	
			}	
		}
				
		return false;
	}
}
































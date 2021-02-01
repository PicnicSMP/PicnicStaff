package me.Unweptpit.TabCompleters;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class PicnicstaffTabCompleter implements TabCompleter {

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
		List<String> l = new ArrayList<>();
		switch (args.length) {
		
		case 1:
			l.add("reload");
			l.add("help");
			l.add("xray");
			return l;
	
		case 2:
			l.add("on");
			l.add("off");
			return l;
			
		}
		return null;
	}

}

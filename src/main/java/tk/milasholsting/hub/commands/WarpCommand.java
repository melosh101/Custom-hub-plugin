package tk.milasholsting.hub.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import tk.milasholsting.hub.Main;
import tk.milasholsting.hub.UI.ServerSelector;

public class WarpCommand implements CommandExecutor {
	
	public Main plugin;
	public WarpCommand(Main plugin) {
		this.plugin = plugin;
		
		plugin.getCommand("Warp").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("sorry this command cant be used in the console");
		}
		
		Player player = (Player) sender;
		
		player.openInventory(ServerSelector.GUI(player));
		return true;
	}
}

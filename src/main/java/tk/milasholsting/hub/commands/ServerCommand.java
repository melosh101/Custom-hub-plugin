package tk.milasholsting.hub.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.milasholsting.hub.Main;
import tk.milasholsting.hub.utils.Utils;

public class ServerCommand implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main plugin;
	
	public ServerCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("server").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender Sender, Command cmd, String label, String[] args) {
		if(Sender instanceof Player) {
			Player player = (Player) Sender;
			
			player.sendMessage(String.format(Utils.chat("&7Sending you to &8%s"), args[0]));
		}
		return false;
	}
}

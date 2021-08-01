package tk.milasholsting.hub.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import tk.milasholsting.hub.Main;
import tk.milasholsting.hub.UI.ServerSelector;

public class inventoryClick implements Listener {

	public Main plugin;
	
	public inventoryClick(Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		String title = event.getView().getTitle();
		if(title.contentEquals(ServerSelector.inv_name)) {
			event.setCancelled(true);
			if(event.getCurrentItem() == null) {
				return;
			}
			ServerSelector.onClick((Player) event.getWhoClicked(), event.getSlot(), event.getCurrentItem(), event.getInventory());
		}
	}
}

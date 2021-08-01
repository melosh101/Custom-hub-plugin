package tk.milasholsting.hub.UI;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import tk.milasholsting.hub.utils.Item;
import tk.milasholsting.hub.utils.Utils;

import java.util.Objects;

public class ServerSelector {
	
	public static Inventory inv;
	public static String inv_name;
	public static int rows = 4 * 9;
	
	public static void initialize() {
		inv_name = Utils.chat("Select a server");
		
		inv = Bukkit.createInventory(null, rows);
	}
	
	public static Inventory GUI(Player p) {
		
		Inventory ui = Bukkit.createInventory(null, rows, inv_name);
		
		Item smpItem = new Item(Material.GRASS, 1, "&3SMP");
		smpItem.setLore("lore 1", "lore 2", "bruh this is getting boring");
		inv.setItem(10, smpItem);
		ui.setContents(inv.getContents());
		return ui;
	}
	
	public static void onClick(Player player, int slot, ItemStack item, Inventory inv) {
		if(Objects.requireNonNull(item.getItemMeta()).getDisplayName().equalsIgnoreCase(Utils.chat("&dSMP"))) {
			player.performCommand("server smp");
		}
	}
}

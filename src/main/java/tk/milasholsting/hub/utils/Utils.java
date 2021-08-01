package tk.milasholsting.hub.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class Utils {
	public static String chat(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}

	public static ItemStack createItem(Material block, int amount, String displayName, boolean glinsing, @Nullable String... loreString) {
		ItemStack item;

		List<String> lore = new ArrayList<String>();

		item = new ItemStack(block, amount);

		ItemMeta meta = item.getItemMeta();
		if(meta == null)
			throw new Error("ITEM META NULL");
		if(glinsing){
			meta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}


		meta.setDisplayName();
		meta.setLore(lore);

		item.setItemMeta(meta);
		return item;
	}


}

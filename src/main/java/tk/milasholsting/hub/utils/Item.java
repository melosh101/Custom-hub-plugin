package tk.milasholsting.hub.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item extends ItemStack {

    private final ItemMeta meta = this.getItemMeta();
    private String displayName;

    public Item(Material type, int amount, String displayName) {
        super(type, amount);
        this.displayName = Utils.chat(displayName);
        assert this.meta != null;
        this.meta.setDisplayName(Utils.chat(displayName));
    }

    public void addGlinsening() {
        if(this.getType() == Material.BOW) {
            assert this.meta != null;
            meta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
    }

    public void setLore(String... lore) {
        List<String> loreList = Arrays.asList(lore);
        assert this.meta != null;
        this.meta.setLore(loreList);
    }

    public void setDisplayName(String displayName) {
        assert this.meta != null;
        this.displayName = Utils.chat(displayName);
        this.meta.setDisplayName(Utils.chat(displayName));
    }

}

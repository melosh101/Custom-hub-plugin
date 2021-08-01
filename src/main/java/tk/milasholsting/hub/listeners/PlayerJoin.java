package tk.milasholsting.hub.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import tk.milasholsting.hub.Main;
import tk.milasholsting.hub.utils.Utils;

import java.util.Objects;

public class PlayerJoin implements Listener {

    public Main plugin;

    public PlayerJoin(Main plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGH)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Inventory inv = Bukkit.createInventory(player, 4 * 7);
        ItemStack compass = Utils.createItem( Material.COMPASS, 1, "directions", false);

        inv.setItem(0, compass);
    }
}

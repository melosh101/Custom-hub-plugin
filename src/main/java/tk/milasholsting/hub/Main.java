package tk.milasholsting.hub;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import tk.milasholsting.hub.UI.ServerSelector;
import tk.milasholsting.hub.commands.ServerCommand;
import tk.milasholsting.hub.commands.WarpCommand;
import tk.milasholsting.hub.listeners.inventoryClick;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		// Commands
		new ServerCommand(this);
		new WarpCommand(this);
		
		// Event Listeners
		new inventoryClick(this);
		
		// GUI initialisation
		ServerSelector.initialize();

		// bukkit initiators
		saveDefaultConfig();
	}

	private void setupMysql() throws ClassNotFoundException {
		Connection connection;
		FileConfiguration config = this.getConfig();
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(String.format("jdbc:postgresql://%s:%s/%s", config.get("postgres.host"), config.get("postgres.port"), config.get("postgres.db")),
					(String) config.get("postgres.user"),
					(String) config.get("postgres.password"));
		} catch (SQLException throwable) {
			throwable.printStackTrace();
		}
	}

}

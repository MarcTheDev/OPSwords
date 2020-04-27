package me.marcthedev.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if(getConfig().getString("Join-Message.enabled") == "true") {
            e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Join-Message")));
        }
        else {
            return;
        }
        if(e.getPlayer().isOp()) {
            e.setJoinMessage("You have admin");
        }
    }

    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        Logger log = Bukkit.getLogger();
        log.info("OPSword - Enabled");
    }
    public void onDisable() {
        Logger log = Bukkit.getLogger();
        log.info("OPSword - Disabled");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if(cmd.getName().equalsIgnoreCase("hello")) {

        }
        return true;
    }
}

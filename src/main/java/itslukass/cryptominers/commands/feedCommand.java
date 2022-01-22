package itslukass.cryptominers.commands;

import itslukass.cryptominers.Cryptominers;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.lang.module.Configuration;
import java.util.HashMap;
import java.util.UUID;

public class feedCommand implements CommandExecutor {
    Plugin plugin = Cryptominers.getPlugin(Cryptominers.class);
    // key = uuid of player
    // loong = epoch time of when they ran the command

    // hashmap and constructor
    private final HashMap<UUID, Long> cooldown;

    public feedCommand() {
        this.cooldown = new HashMap<>();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        boolean enabled = plugin.getConfig().getBoolean("FeedEnabled");


        if (sender instanceof Player p) {
            if (enabled) {
                if (!this.cooldown.containsKey(p.getUniqueId())) {
                    if (p.hasPermission("test.feed")) {
                        this.cooldown.put(p.getUniqueId(), System.currentTimeMillis());
                        p.setSaturation(20);
                        p.setFoodLevel(20);
                        p.sendMessage("Saturated");
                    } else {
                        p.sendMessage(ChatColor.RED + "No permissions. (test.feed)");
                    }
                } else{
                    //difference in miliseconds
                    long timeElapsed = System.currentTimeMillis() - cooldown.get(p.getUniqueId());
                    // 10 seconds
                    if(timeElapsed >= 10000){
                        if (p.hasPermission("test.feed")) {
                            this.cooldown.put(p.getUniqueId(), System.currentTimeMillis());
                            p.setSaturation(20);
                            p.setFoodLevel(20);
                            p.sendMessage("Saturated");
                        } else {
                            p.sendMessage(ChatColor.RED + "No permissions. (test.feed)");
                        }
                    } else{
                        p.sendMessage("Cant use /feed for another " + (10 - (timeElapsed / 1000 )) + " seconds");
                    }
                }
            } else {
                p.sendMessage(ChatColor.RED + "Feed is disabled in the config");
            }
        }
        return true;
    }
}

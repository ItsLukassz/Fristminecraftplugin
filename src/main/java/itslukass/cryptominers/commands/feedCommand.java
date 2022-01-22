package itslukass.cryptominers.commands;

import itslukass.cryptominers.Cryptominers;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.lang.module.Configuration;

public class feedCommand implements CommandExecutor {
    Plugin plugin = Cryptominers.getPlugin(Cryptominers.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        boolean enabled = plugin.getConfig().getBoolean("FeedEnabled");
            if(sender instanceof Player p){
                if(enabled){
                    if(p.hasPermission("test.feed")){
                        p.setSaturation(20);
                        p.setFoodLevel(20);
                        p.sendMessage("Saturated");
                    }else{
                        p.sendMessage(ChatColor.RED+ "No permissions. (test.feed)");
                    }
                }else{
                    p.sendMessage(ChatColor.RED + "Feed is disabled in the config");
                }
            }
        return true;
    }
}

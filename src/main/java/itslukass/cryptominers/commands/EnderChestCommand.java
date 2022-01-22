package itslukass.cryptominers.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnderChestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p){

            p.openInventory(p.getEnderChest());
            p.sendMessage(ChatColor.GREEN + "Opening Enderchest");
        }

        return true;
    }
}

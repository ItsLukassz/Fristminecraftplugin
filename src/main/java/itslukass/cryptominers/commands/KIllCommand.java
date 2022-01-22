package itslukass.cryptominers.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KIllCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p){

            if(args.length == 0){
                p.setHealth(0);
            } else {
                Player target = Bukkit.getPlayerExact(args[0]);
                if(target instanceof Player){
                    target.sendMessage("You got killed");
                    target.setHealth(0);
                    p.sendMessage(ChatColor.RED + "" + args[0] + ChatColor.RESET + " Killed");
                }else{
                    p.sendMessage("Player does not exist");
                }
            }

        }

        return true;
    }
}

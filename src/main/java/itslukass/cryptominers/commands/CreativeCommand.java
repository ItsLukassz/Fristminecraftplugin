package itslukass.cryptominers.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreativeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p){
            if(p.hasPermission("test.gmc")){
            p.setGameMode(GameMode.CREATIVE);
            p.sendMessage(ChatColor.GREEN + "Gamemode set to" + ChatColor.RED + " Creative");
            }else{
                p.sendMessage(ChatColor.RED + "No Permission. test.gmc");
            }

        }

        return true;
    }
}

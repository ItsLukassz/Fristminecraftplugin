package itslukass.cryptominers.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p){

            if(p.isInvulnerable()){
                p.setInvulnerable(false);
                p.sendMessage("God mode disabled");
            } else{
                p.setInvulnerable(true);
                p.sendMessage("God mode enabled");
            }

        }

        return true;
    }
}

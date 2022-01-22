package itslukass.cryptominers.commands;

import itslukass.cryptominers.Cryptominers;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p){

            Location location = Cryptominers.getPlugin().getConfig().getLocation("spawn");

            if(location != null) {
                p.teleport(location);
                p.sendMessage("Teleporting to spawn");
            }else{
                p.sendMessage("Spawn location isnt saved use /setspawn");
                System.out.println("Spawn location isnt saved use /setspawn");
            }


        }else{
            System.out.println("Execute this as a player");
        }

        return true;
    }
}

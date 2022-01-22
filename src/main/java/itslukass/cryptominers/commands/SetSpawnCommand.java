package itslukass.cryptominers.commands;

import itslukass.cryptominers.Cryptominers;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p){
            Location location = p.getLocation();


            // old obselete method
            /*Cryptominers.getPlugin().getConfig().set("spawn.x", location.getX());
            Cryptominers.getPlugin().getConfig().set("spawn.y", location.getY());
            Cryptominers.getPlugin().getConfig().set("spawn.z", location.getZ());
            Cryptominers.getPlugin().getConfig().set("spawn.worldname", location.getWorld().getName());
            */

            // 2nd method

            Cryptominers.getPlugin().getConfig().set("spawn", location);
            Cryptominers.getPlugin().saveConfig();
            p.sendMessage("Location saved");

        }else{
            System.out.println("You need to execute this as a player");
        }


        return true;
    }
}

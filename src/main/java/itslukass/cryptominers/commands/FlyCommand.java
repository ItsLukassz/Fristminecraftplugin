package itslukass.cryptominers.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p){
            if(p.hasPermission("test.fly")) {
                if(args.length == 0){
                    if (p.getAllowFlight()) {
                        p.setAllowFlight(false);
                        p.sendMessage("Flight disabled");
                    } else {
                        p.setAllowFlight(true);
                        p.sendMessage("Flight enabled");
                    }
                }else{
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if (target.getAllowFlight()) {
                        target.setAllowFlight(false);
                        target.sendMessage("Flight disabled");
                        p.sendMessage("Disabling flight");
                    } else {
                        target.setAllowFlight(true);
                        target.sendMessage("Flight enabled");
                        p.sendMessage("Enabling flight");
                    }
                }
            }else{
                p.sendMessage("No permission. (test.fly)");
            }
        }else{
            System.out.println("Only a player can execute this command");
        }

        return true;
    }
}

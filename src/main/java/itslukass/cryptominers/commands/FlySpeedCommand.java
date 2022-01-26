package itslukass.cryptominers.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlySpeedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p) {
            if (p.hasPermission("test.flyspeed")) {
                if (args.length > 0) {
                    Float speedamount = Float.valueOf(args[0]);
                    // speed amount convertion from int to float
                    // checking values of the entered speed ammount and converting it to working form
                    if (speedamount > 0.9f) {
                        if (speedamount > 10f) {
                            speedamount = 1f;
                        } else {
                                speedamount = speedamount / 10;
                        }
                        // setting the speed
                        p.setFlySpeed(speedamount);
                        p.sendMessage(ChatColor.DARK_GREEN + "You flying speed now is: "+ ChatColor.RED + speedamount);
                    } else {
                        p.setFlySpeed(Float.parseFloat(args[0]));
                        p.sendMessage(ChatColor.DARK_GREEN + "You flying speed now is: "+ ChatColor.RED + speedamount);
                    }
                } else {
                    p.sendMessage("Command usage /flyspeed <number>");
                }
            } else {
                p.sendMessage("No permission. (test.flyspeed)");
            }

        } else {
            System.out.println("Only a player can execute this command");
        }


        return true;
    }
}

package itslukass.cryptominers.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.concurrent.Executor;

public class privateMessageCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p){

            if(args.length > 1){
                //we get the playernname from the argument
                String potentialPlayer = args[0];
                // we convert the playername to player
                Player sendto = Bukkit.getPlayerExact(potentialPlayer);
                // we get the senders display name
                String Sender = p.getDisplayName();
                sendto.sendMessage(ChatColor.RED + Sender+ ">"+ ChatColor.GREEN + potentialPlayer + ChatColor.RESET + ": " + args[1]);
                p.sendMessage(ChatColor.RED + Sender + ">"+ ChatColor.GREEN + potentialPlayer + ChatColor.RESET + ": " + args[1]);

            }else{
                p.sendMessage("Command usage /pm <username> Message");
            }

        }else{
            System.out.println("Only Players can execute this command");
        }

        return true;
    }
}

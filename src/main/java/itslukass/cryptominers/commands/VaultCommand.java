package itslukass.cryptominers.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class VaultCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p){
            ItemStack item1 = new ItemStack(Material.CACTUS, 3);
            ItemStack item2 = new ItemStack(Material.OAK_LOG, 3);
            ItemStack[] items = {item1, item2};

            Inventory vault = Bukkit.createInventory(p,9, "Vault");

            vault.setItem(2, item1);
            vault.addItem(item1);

            // replaces everything and puts the items in
            vault.setContents(items);

            // from saved inventory
            ItemStack[] saveditems = vault.getContents();


            p.openInventory(vault);

        }else{
            System.out.println("Only a player can execute this command");
        }

        return true;
    }
}

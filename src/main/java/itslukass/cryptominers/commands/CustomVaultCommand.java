package itslukass.cryptominers.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class CustomVaultCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p){
            ItemStack item1 = new ItemStack(Material.CACTUS, 3);

            item1.addUnsafeEnchantment(Enchantment.CHANNELING, 1000);
            ItemMeta item1meta =  item1.getItemMeta();
            item1meta.setDisplayName(ChatColor.DARK_GRAY + "SET");
            item1meta.setUnbreakable(true);
            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.DARK_RED + "This is a red lore");
            lore.add(ChatColor.DARK_GRAY + "This is a gray lore");
            item1meta.setLore(lore);
            item1.setItemMeta(item1meta);

            Inventory vault = Bukkit.createInventory(p,9, "Vault");
            vault.addItem(item1);

            p.openInventory(vault);

        }else{
            System.out.println("Only a player can execute this command");
        }


        return true;
    }
}

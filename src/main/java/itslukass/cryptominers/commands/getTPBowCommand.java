package itslukass.cryptominers.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class getTPBowCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p){

            if(p.hasPermission("test.tpbow")){
                // creating the bow
                ItemStack tpbow = new ItemStack(Material.BOW, 1);
                ItemMeta meta = tpbow.getItemMeta();

                // setting meta data
                meta.setDisplayName(ChatColor.RED + "Teleport Bow");
                meta.setUnbreakable(true);
                ArrayList<String> lore = new ArrayList<>();
                lore.add(ChatColor.GREEN + "Shoot to teleport");
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                meta.setLore(lore);
                tpbow.setItemMeta(meta);
                // adding infinity enchant
                tpbow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 100);
                // giving the bow to player
                p.getInventory().addItem(tpbow);

            } else{
                p.sendMessage("No Permission. (test.tpbow)");
            }

        }else{
            System.out.println("Only a player can run this");
        }

        return true;
    }
}

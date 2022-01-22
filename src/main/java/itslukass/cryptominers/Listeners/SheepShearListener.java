package itslukass.cryptominers.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerShearEntityEvent;

import java.awt.*;

public class SheepShearListener implements Listener {

    @EventHandler
    public void onShearSheep(PlayerShearEntityEvent e){

        Entity entity = e.getEntity();
        Player player = e.getPlayer();
        if(entity.getType() == EntityType.SHEEP) {
            player.sendMessage("-9 social credits");
            entity.setCustomNameVisible(true);
            entity.setCustomName(ChatColor.BLUE + "John Xina");
            e.setCancelled(true);
        }else{
            player.sendMessage("+5 social credits");
        }

        }
    }


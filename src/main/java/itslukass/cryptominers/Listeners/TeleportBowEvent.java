package itslukass.cryptominers.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import java.util.ArrayList;

public class TeleportBowEvent implements Listener {

    @EventHandler
    public void onBowShoot(ProjectileHitEvent e) {
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.GREEN + "Shoot to teleport");

        if (e.getEntity() instanceof Arrow) {
            Player player = (Player) e.getEntity().getShooter();
            if (player.getInventory().getItemInMainHand().getItemMeta().getLore().equals(lore)) {

                Location location = e.getEntity().getLocation();
                player.teleport(location);
                player.sendMessage("Teleporting...");
                player.playSound(player.getLocation(), Sound.ENTITY_AXOLOTL_HURT, 1, 1);

            }
        }

    }
}

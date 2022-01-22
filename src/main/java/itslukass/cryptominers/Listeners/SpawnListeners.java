package itslukass.cryptominers.Listeners;

import itslukass.cryptominers.Cryptominers;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.net.http.WebSocket;

public class SpawnListeners implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Location location = Cryptominers.getPlugin().getConfig().getLocation("spawn");
        Player p = e.getPlayer();
        if(!p.hasPlayedBefore()){
            if(location != null) {
                p.teleport(location);
                p.sendMessage("Teleporting to spawn");

            }
        }

    }
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e){

        // respawn at spawn if spawn is set
        Location location = Cryptominers.getPlugin().getConfig().getLocation("spawn");
        Player p = e.getPlayer();
            if(location != null) {
               e.setRespawnLocation(location);
            }else{
                p.sendMessage("There is no spawn set");
            }
    }

}

package itslukass.cryptominers.Listeners;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExpBottleEvent;

public class XPBottleBreakListener  implements Listener {

    @EventHandler
    public void onXPBottleBreak(ExpBottleEvent e){

        e.setExperience(1000);
        e.setShowEffect(false);
    }


}

package itslukass.cryptominers;
import itslukass.cryptominers.Listeners.JoineaveMessages;
import itslukass.cryptominers.Listeners.SheepShearListener;
import itslukass.cryptominers.Listeners.XPBottleBreakListener;
import itslukass.cryptominers.commands.*;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Cryptominers extends JavaPlugin implements Listener {

    private static Cryptominers plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        System.out.println("Custom Crypto Miners Started!");
        // events
        getServer().getPluginManager().registerEvents(new XPBottleBreakListener(), this);
        getServer().getPluginManager().registerEvents(new SheepShearListener(), this);
        getServer().getPluginManager().registerEvents(new JoineaveMessages(), this);
        // commands
        getCommand("god").setExecutor(new GodCommand());
        getCommand("gmc").setExecutor(new CreativeCommand());
        getCommand("gms").setExecutor(new SurvivalCommand());
        getCommand("feed").setExecutor(new feedCommand());
        getCommand("pm").setExecutor(new privateMessageCommand());
        getCommand("kill").setExecutor(new KIllCommand());
        getCommand("enderchest").setExecutor(new EnderChestCommand());
        getCommand("setspawn").setExecutor(new SetSpawnCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());
        //config.yml
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Custom Crypto Miners Stopped!");
    }

    public static Cryptominers getPlugin() {
        return plugin;
    }
}

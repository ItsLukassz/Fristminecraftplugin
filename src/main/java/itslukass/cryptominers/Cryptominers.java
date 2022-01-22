package itslukass.cryptominers;
import itslukass.cryptominers.Listeners.*;
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
        getServer().getPluginManager().registerEvents(new SpawnListeners(), this);
        getServer().getPluginManager().registerEvents(new TeleportBowEvent(), this);
        // commands
        getCommand("god").setExecutor(new GodCommand());
        getCommand("gmc").setExecutor(new CreativeCommand());
        getCommand("gms").setExecutor(new SurvivalCommand());
        getCommand("feed").setExecutor(new feedCommand());
        getCommand("pm").setExecutor(new privateMessageCommand());
        getCommand("kill").setExecutor(new KIllCommand());
        getCommand("enderchest").setExecutor(new EnderChestCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("vault").setExecutor(new VaultCommand());
        getCommand("cvault").setExecutor(new CustomVaultCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("tpbow").setExecutor(new getTPBowCommand());
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

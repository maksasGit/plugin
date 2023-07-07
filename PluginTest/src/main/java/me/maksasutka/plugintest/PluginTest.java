package me.maksasutka.plugintest;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class PluginTest extends JavaPlugin implements Listener {

    private static List<PluginPlayer> pluginPlayersOnline;

    public static void addPluginPlayer(Player player){
        pluginPlayersOnline.add(new PluginPlayer(player));
    }

    public static void removePluginPlayer(Player player){pluginPlayersOnline.remove(PluginTest.getPluginPlayerByPlayer(player));}

    public static PluginPlayer getPluginPlayerByPlayer(Player player){
        for (PluginPlayer pluginPlayer : pluginPlayersOnline) {
            if (pluginPlayer.getPlayer() == player){
                return pluginPlayer;
            }
        }
        return null;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("[plugin] Plagin start...");

        getServer().getPluginManager().registerEvents(new JoinLeaveListener(), this);
        getCommand("sb").setExecutor(new OpenScoreboardController());

    }
    

    @Override
    public void onDisable() {
        System.out.println("[plugin] Plagin shut down.");
    }
    


}

package me.maksasutka.plugintest;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Collection;

import static org.bukkit.Bukkit.getServer;

public class JoinLeaveListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPlayedBefore()) { // новый

            PluginTest.addPluginPlayer(player);


            // send evrebody
            Collection<? extends Player> playersOnline = getServer().getOnlinePlayers();
            for (Player playerOnline : playersOnline) {
                if (playerOnline != player) {
                    playerOnline.sendMessage("У нас пополнение: " + player.getName());
                }
            }

            // send player
            player.sendMessage("Попутного вiтра тобi в сраку");
            // add start money
            PluginTest.getPluginPlayerByPlayer(player).addCash(100);

            // other
        } else {  // old

            Collection<? extends Player> playersOnline = getServer().getOnlinePlayers();
            for (Player playerOnline : playersOnline) {
                if (playerOnline != player) {
                    playerOnline.sendMessage(player.getName() + " снова с нами.");
                }
            }

            player.sendMessage("Снова и снова.");
            player.sendMessage("Лови на чай.");
            PluginTest.getPluginPlayerByPlayer(player).addCash(5);
        }
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event){
        Player player = event.getPlayer();
        PluginTest.removePluginPlayer(player);
    }

}



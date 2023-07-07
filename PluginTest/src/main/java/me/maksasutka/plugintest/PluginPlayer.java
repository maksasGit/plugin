package me.maksasutka.plugintest;

import org.bukkit.entity.Player;

import java.util.Date;

public class PluginPlayer {
    private int cash = 0;
    private Player player;

    private String status = null;

    private Date lastSeans = null;
    public PluginPlayer(Player player) {
        this.player = player;
        System.out.println("[plugin] PluginPlayer creted: " + player.toString());
    }

    public void addCash(int amount){
        this.cash += amount;
        this.player.sendMessage("Вам перечислено: " + amount + " шекелей.");
    }

    private void setCash(int cash){
        this.cash = cash;
    }

    public int getCash() {
        return cash;
    }

    public Player getPlayer() {
        return player;
    }

    public String getStatus() {
        return status;
    }
}

package me.maksasutka.plugintest;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class OpenScoreboardController implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player){
            Player player = (Player) commandSender;
            PluginPlayer pPlayer= PluginTest.getPluginPlayerByPlayer(player);

            ScoreboardManager manager = Bukkit.getScoreboardManager();
            Scoreboard scoreboard = manager.getNewScoreboard();

            Objective objective = scoreboard.registerNewObjective("Title", "dummy");
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);
            objective.setDisplayName(ChatColor.BLUE + "Твой Кошелёк");

            Score score = objective.getScore(ChatColor.GOLD + "Шекели: " + ChatColor.GREEN + pPlayer.getCash()); //create a line for the board
            Score s2 = objective.getScore(""); //blank space
            Score s3 = objective.getScore(""); //blank space

            score.setScore(3);
            s2.setScore(2);
            s3.setScore(1);

            player.setScoreboard(scoreboard);

        }

        return false;
    }
}

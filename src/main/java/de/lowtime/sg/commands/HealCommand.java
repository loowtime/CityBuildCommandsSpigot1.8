package de.lowtime.sg.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command,  final String CommandLabel, String[] args) {
        final Player player = (Player)sender;
        if (CommandLabel.equalsIgnoreCase("heal")) {
            if (args.length == 0) {
                player.setHealth(20.0);
                player.setFoodLevel(20);
                player.sendMessage("§7 CityBuild | §aDu wurdest geheilt!");
            }
            else if (args.length == 1) {
                final Player targetPlayer = player.getServer().getPlayer(args[0]);
                player.setHealth(20.0);
                player.setFoodLevel(20);
                for (String s : Arrays.asList(ChatColor.DARK_RED + "", String.valueOf(ChatColor.GREEN), ChatColor.GOLD + "§7CityBuild | §aDu wurdest geheilt von " + player.getName(),  String.valueOf(ChatColor.GREEN))) {
                    player.sendMessage(s);
                }
            }
        }

        return false;
    }
}

package de.lowtime.yt.commands;

import org.bukkit.command.*;
import org.bukkit.entity.*;

public class FlyCommand implements CommandExecutor
{
    private boolean flymode;

    public FlyCommand() {
        this.flymode = false;
    }

    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player)sender;
            if (player.hasPermission("Fly.Command")) {
                if (command.getName().equalsIgnoreCase("Fly")) {
                    if (!this.flymode) {
                        player.setAllowFlight(true);
                        this.flymode = true;
                        player.sendMessage("§7CityBuild | §aDu bist jetzt im Fly-Mode!");
                    }
                    else {
                        player.setAllowFlight(false);
                        this.flymode = false;
                        player.sendMessage("§7CityBuild | §2Flymode deaktiviert!");
                    }
                }
            }
            else {
                player.sendMessage("§7CityBuild | §cDir fehlt die Berechtigung dazu!");
            }
        }
        else {
            sender.sendMessage("§7CityBuild | §cDu bist kein Spieler!");
        }
        return false;
    }
}

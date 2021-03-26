package de.lowtime.sg;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class InvseeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(final CommandSender sender, final Command arg1, final String arg2, final String[] args) {
        final Player p = (Player)sender;
        if (p.hasPermission("invsee.use")) {
            if (args.length == 0) {
                p.sendMessage("§7CityBuild | §aNutze /invsee §7[§6Spieler§7]");
                return false;
            }
            if (args.length == 1) {
                if (Bukkit.getPlayer(args[0]) != null) {
                    final Player t = Bukkit.getPlayer(args[0]);
                    p.openInventory((Inventory)t.getInventory());
                    p.sendMessage("§7CityBuild | §aDas Inventar wurde für dich geöffnet!");
                }
                else {
                    p.sendMessage("§7CityBuild | §aDer Spieler §6" + args[0] + " §aist nicht online!");
                }
            }
        }
        else {
            p.sendMessage("§7CityBuild | §aDir fehlt die Berechtigung: §cinvsee.use!");
        }

        return false;
    }
}

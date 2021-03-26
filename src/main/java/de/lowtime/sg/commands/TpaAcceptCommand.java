package de.lowtime.sg.commands;


import de.lowtime.sg.BackEnd;
import de.lowtime.sg.TeleportType;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpaAcceptCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("§7CityBuild | §aDu musst ein Spieler sein!");
            return true;
        }

        Player p = (Player)sender;

        if (!BackEnd.tpRequest.containsKey(p.getUniqueId())) {
            p.sendMessage("§7CityBuild | §aDu hast noch keine Anfrage!");
            return true;
        }

        Player t = Bukkit.getPlayer(BackEnd.tpRequest.get(p.getUniqueId()));

        if (t == null) {
            p.sendMessage("§7CityBuild | §aDer Spieler ist offline gegangen!");
            BackEnd.tpRequest.remove(p.getUniqueId());
            BackEnd.tpType.remove(p.getUniqueId());
            return true;
        }

        TeleportType tpType = BackEnd.tpType.get(p.getUniqueId());

        if (tpType == TeleportType.NORMAL) {
            t.teleport(p);
            t.sendMessage("§7CityBuild | " + ChatColor.GOLD + p.getDisplayName() + " §ahat deine Anfrage angenommen.");
            p.sendMessage("§7CityBuild | §aDu hast die Anfrage von " + t.getDisplayName() + " §aangenommen!");
        } else {
            p.teleport(t);
            p.sendMessage("§7CityBuild | " + ChatColor.GOLD + p.getDisplayName() + " §7hat deine Anfrage angenommen.");
            t.sendMessage("§7CityBuild | §aDu hast die Anfrage von " + p.getDisplayName() + " §aangenommen!");
        }

        BackEnd.tpRequest.remove(p.getUniqueId());
        BackEnd.tpType.remove(p.getUniqueId());
        return false;
    }
}
package de.lowtime.sg.commands;


import de.lowtime.sg.TeleportType;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpaHereCommand implements CommandExecutor {
    private de.lowtime.sg.BackEnd BackEnd;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        TextComponent tc = new TextComponent();
        tc.setText("§7Akzeptieren ");

        TextComponent tc2 = new TextComponent();
        tc2.setText("§8[§6Bestätigen§8]");
        tc2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpaaccept"));
        tc.addExtra(tc2);

        if (!(sender instanceof Player)) {
            sender.sendMessage("§7CityBuild | §aDu musst ein Spieler sein!");
            return true;
        }

        Player p = (Player)sender;

        if (args.length == 0) {
            p.sendMessage("/" + label + " <spieler>");
            return true;
        }

        Player t = Bukkit.getPlayer(args[0]);

        if (t == null) {
            p.sendMessage("§7CityBuild | §aDer Spieler ist nicht online.");
            return true;
        }

        BackEnd.tpRequest.put(t.getUniqueId(), p.getUniqueId());
        BackEnd.tpType.put(t.getUniqueId(), TeleportType.HERE);

        p.sendMessage("§7CityBuild | §aDeine Teleportsanfrage wurde an " + t.getDisplayName() + " §avesendet!");
        t.sendMessage("§7CityBuild | " + ChatColor.GOLD + p.getDisplayName() + " §ahat dir eine Teleportationsanfrage zu ihm geschickt!");
        t.spigot().sendMessage(tc);

        return false;
    }
}
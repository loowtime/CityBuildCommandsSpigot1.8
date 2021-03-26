package de.lowtime.sg;

import de.lowtime.sg.commands.HealCommand;
import de.lowtime.sg.commands.TpaAcceptCommand;
import de.lowtime.sg.commands.TpaCommand;
import de.lowtime.sg.commands.TpaHereCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;

public final class Main extends JavaPlugin {


    public static boolean prefix;
    

    @Override
    public void onEnable() {
        // Plugin startup logic
        final ConsoleCommandSender console = Bukkit.getConsoleSender();
        Bukkit.getConsoleSender().sendMessage("§alowtimes Citybuild Plugin aktiviert!");
        this.getCommand("invsee").setExecutor((CommandExecutor)new InvseeCommand());
        this.getCommand("heal").setExecutor((CommandExecutor) new HealCommand());
        this.getCommand("tpa").setExecutor((CommandExecutor) new TpaCommand());
        this.getCommand("tpahere").setExecutor((CommandExecutor) new TpaHereCommand());
        this.getCommand("tpaaccept").setExecutor((CommandExecutor) new TpaAcceptCommand());
        this.getCommand("ping").setExecutor((CommandExecutor) new de.lowtime.yt.commands.FlyCommand());
    }




    @Override
    public void onDisable() {
        // Plugin shutdown logic
        final ConsoleCommandSender console = Bukkit.getConsoleSender();
        Bukkit.getConsoleSender().sendMessage("§alowtimes Citybuild Plugin deaktiviert!");
    }
}

package com.github.aimorris.minecraft_flaming_head;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class CommandHandler implements CommandExecutor {

  FireZeus plugin;

  public CommandHandler(FireZeus plugin) {
    this.plugin = plugin;
  }

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

    if (sender instanceof Player) {

      if (sender.hasPermission("firezeus.firezeus")) {
        UUID u = ((Player) sender).getUniqueId();

        if (plugin.enabledPlayers.contains(u)) {
          plugin.enabledPlayers.remove(u);
        } else {
          plugin.enabledPlayers.add(u);
        }

      } else {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou do not have permission to use this command!"));
      }
      return true;
    }

    sender.sendMessage("You must be a player to use this command!");
    return true;
  }

}

package com.github.aimorris.minecraft_flaming_head;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Set;
import java.util.UUID;

public class CommandHandler implements CommandExecutor {

  FlamingHead plugin;

  public CommandHandler(FlamingHead plugin) {
    this.plugin = plugin;
  }

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

    if (sender instanceof Player) {
      UUID u = ((Player) sender).getUniqueId();

      if (plugin.enabledPlayers.contains(u)) {
        plugin.enabledPlayers.remove(u);
      } else {
        plugin.enabledPlayers.add(u);
      }

      return true;
    }

    return false;
  }

}

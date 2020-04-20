package com.github.aimorris.minecraft_flaming_head;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class CommandHandler implements CommandExecutor {

  Set<UUID> enabledPlayers = new HashSet<>();

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

    if (sender instanceof Player) {
      UUID u = ((Player) sender).getUniqueId();

      if (enabledPlayers.contains(u)) {
        enabledPlayers.remove(u);
      } else {
        enabledPlayers.add(u);
      }

      return true;
    }

    return false;
  }

}

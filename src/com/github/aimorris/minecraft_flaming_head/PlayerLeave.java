package com.github.aimorris.minecraft_flaming_head;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeave implements Listener {

  FireZeus plugin;

  public PlayerLeave(FireZeus plugin) { this.plugin = plugin; }

  @EventHandler
  public void playerQuit(PlayerQuitEvent e) {
    plugin.enabledPlayers.remove(e.getPlayer().getUniqueId());
  }

}

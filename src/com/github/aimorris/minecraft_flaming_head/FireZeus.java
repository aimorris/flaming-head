package com.github.aimorris.minecraft_flaming_head;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class FireZeus extends JavaPlugin {

  Set<UUID> enabledPlayers = new HashSet<>();

  @Override
  public void onEnable() {
    Bukkit.getServer().getLogger().info("FlamingHead has been successfully enabled!");

    Bukkit.getServer().getPluginManager().registerEvents(new PlayerLeave(this), this);

    this.getCommand("firezeus").setExecutor(new CommandHandler(this));

    ParticleCreator particleCreator = new ParticleCreator(this);
    particleCreator.runTaskTimer(this, 0 ,1);
  }

  @Override
  public void onDisable() {
    Bukkit.getServer().getLogger().info("FlamingHead has been successfully disabled!");
  }
}

package com.github.aimorris.minecraft_flaming_head;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class FlamingHead extends JavaPlugin {

  @Override
  public void onEnable() {
    Bukkit.getServer().getLogger().info("FlamingHead has been successfully enabled!");
    this.getCommand("flaminghead").setExecutor(new CommandHandler());

    ParticleCreator particleCreator = new ParticleCreator();
    particleCreator.runTaskTimer(this, 0 ,20);
  }

  @Override
  public void onDisable() {
    Bukkit.getServer().getLogger().info("FlamingHead has been successfully disabled!");
  }
}

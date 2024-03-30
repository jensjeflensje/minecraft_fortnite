package dev.jensderuiter.minecraftfortnite;

import dev.jensderuiter.minecraftfortnite.listener.ItemClickListener;
import dev.jensderuiter.minecraftfortnite.listener.JoinListener;
import dev.jensderuiter.minecraftfortnite.listener.ItemHeldListener;
import dev.jensderuiter.minecraftfortnite.listener.MoveListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class FortniteBuildingPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new ItemHeldListener(), this);
        getServer().getPluginManager().registerEvents(new ItemClickListener(), this);
        getServer().getPluginManager().registerEvents(new MoveListener(), this);
    }

}

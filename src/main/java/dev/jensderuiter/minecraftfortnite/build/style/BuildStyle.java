package dev.jensderuiter.minecraftfortnite.build.style;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.util.Vector;

import java.util.List;

public interface BuildStyle {

    void preview();
    void removePreview();
    void build();
    void move(Vector offset);

    boolean isMovable(Location location);

    List<Location> getStructure();

    Location getLocation();
    void setLocation(Location location);
    void setMaterial(Material material);

}

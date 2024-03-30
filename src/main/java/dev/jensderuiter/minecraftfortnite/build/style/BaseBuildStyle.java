package dev.jensderuiter.minecraftfortnite.build.style;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

@Setter
public abstract class BaseBuildStyle implements BuildStyle {

    @Getter
    protected Location location;

    protected Material material;
    protected List<Entity> entities;

    @Override
    public void preview() {
        entities = new ArrayList<>(); // to be cleaned up later
        this.getStructure().forEach(partLocation -> {
            BlockDisplay display =
                    (BlockDisplay) partLocation.getWorld().spawnEntity(partLocation, EntityType.BLOCK_DISPLAY);
            display.setBlock(this.material.createBlockData());
            entities.add(display);
        });
    }

    public void removePreview() {
        entities.forEach(Entity::remove);
    }

    public boolean isMovable(Location newLocation) {
        // the direction didn't change, just the location
        return this.getForwardVector(newLocation).distance(this.getForwardVector()) == 0;
    }

    public void move(Vector offset) {
        // used when rendering again is not necessary
        this.location.add(offset);
        entities.forEach(e -> e.teleport(e.getLocation().add(offset)));
    }

    @Override
    public void build() {
        this.getStructure().forEach(partLocation -> partLocation.getBlock().setType(this.material));
    }

    protected Location getBaseLocation() {
        return this.location.clone().add(this.getForwardVector().multiply(3));
    }

    protected Vector getForwardVector(Location directionLocation) {
        float fullYaw = directionLocation.getYaw() + 180; // 0-360
        if (fullYaw > 45 && fullYaw <= 135) {
            return new Vector(1, 0, 0);
        } else if (fullYaw > 135 && fullYaw <= 225) {
            return new Vector(0, 0, 1);
        } else if (fullYaw > 225 && fullYaw <= 315) {
            return new Vector(-1, 0, 0);
        } else if (fullYaw > 315 || fullYaw <= 45) {
            return new Vector(0, 0, -1);
        }
        return new Vector(0, 0,0); // should never happen
    }

    protected Vector getForwardVector() {
        return this.getForwardVector(this.location);
    }

    protected Vector getRightVector(Location directionLocation) {
        float fullYaw = directionLocation.getYaw() + 180; // 0-360
        if (fullYaw > 45 && fullYaw <= 135) {
            return new Vector(0, 0, 1);
        } else if (fullYaw > 135 && fullYaw <= 225) {
            return new Vector(1, 0, 0);
        } else if (fullYaw > 225 && fullYaw <= 315) {
            return new Vector(0, 0, -1);
        } else if (fullYaw > 315 || fullYaw <= 45) {
            return new Vector(-1, 0, 0);
        }
        return new Vector(0, 0,0); // should never happen
    }

    protected Vector getRightVector() {
        return this.getRightVector(this.location);
    }

}

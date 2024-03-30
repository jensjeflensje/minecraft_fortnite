package dev.jensderuiter.minecraftfortnite.build.style;

import org.bukkit.Location;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class FloorBuildStyle extends BaseBuildStyle {

    @Override
    public List<Location> getStructure() {
        Vector rightVector = this.getRightVector();
        Vector leftVector = rightVector.clone().multiply(-1);
        Vector forwardVector = this.getForwardVector();
        Vector backWardVector = this.getForwardVector().multiply(-1);
        Location baseLocation = this.getBaseLocation().add(0, -2, 0);
        List<Location> locations = new ArrayList<>();
        locations.add(baseLocation.getBlock().getLocation().add(leftVector).add(forwardVector));
        locations.add(baseLocation.getBlock().getLocation().add(forwardVector));
        locations.add(baseLocation.getBlock().getLocation().add(rightVector).add(forwardVector));
        locations.add(baseLocation.getBlock().getLocation().add(leftVector));
        locations.add(baseLocation.getBlock().getLocation());
        locations.add(baseLocation.getBlock().getLocation().add(rightVector));
        locations.add(baseLocation.getBlock().getLocation().add(leftVector).add(backWardVector));
        locations.add(baseLocation.getBlock().getLocation().add(backWardVector));
        locations.add(baseLocation.getBlock().getLocation().add(rightVector).add(backWardVector));
        return locations;
    }
}

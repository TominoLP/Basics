package de.tomino.basics.listener;

import de.tomino.basics.commands.BlockBreakSwitch;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class BlockBreak implements Listener {

    @EventHandler()
    public void onBlockBreak(org.bukkit.event.block.BlockBreakEvent event) {
        Player breaker = event.getPlayer();

        if (breaker.hasPermission("basics.blockbreak")) {
            event.setCancelled(false);

        } else {
            if (BlockBreakSwitch.BBActive) {
                event.setCancelled(true);
            } else {
                event.setCancelled(false);
            }

        }

    }
}

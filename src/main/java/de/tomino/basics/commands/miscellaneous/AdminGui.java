package de.tomino.basics.commands.miscellaneous;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AdminGui implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            if (sender.hasPermission("basics.admin")) {
                Inventory inv = Bukkit.createInventory(null, 3 * 9, "Admin Gui");

                ItemStack BG = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                ItemMeta BGmeta = BG.getItemMeta();
                BGmeta.setDisplayName(" ");
                BG.setItemMeta(BGmeta);

                ItemStack stop = new ItemStack(Material.BARRIER);
                ItemMeta stopmeta = stop.getItemMeta();
                stopmeta.setDisplayName("§cStop Server");
                stop.setItemMeta(stopmeta);

                ItemStack reload = new ItemStack(Material.COMPASS);
                ItemMeta reloadmeta = reload.getItemMeta();
                reloadmeta.setDisplayName("§cReload Server");
                reload.setItemMeta(reloadmeta);

                ItemStack maintenance = new ItemStack(Material.TOTEM_OF_UNDYING);
                ItemMeta maintenancemeta = maintenance.getItemMeta();
                maintenancemeta.setDisplayName("§cMaintenance");
                maintenance.setItemMeta(maintenancemeta);

                inv.setItem(0, BG);
                inv.setItem(1, BG);
                inv.setItem(2, BG);
                inv.setItem(3, BG);
                inv.setItem(4, BG);
                inv.setItem(5, BG);
                inv.setItem(6, BG);
                inv.setItem(7, BG);
                inv.setItem(8, BG);
                inv.setItem(9, BG);
                inv.setItem(10, stop);
                inv.setItem(11, BG);
                inv.setItem(12, BG);
                inv.setItem(13, reload);
                inv.setItem(14, BG);
                inv.setItem(15, BG);
                inv.setItem(16, maintenance);
                inv.setItem(17, BG);
                inv.setItem(18, BG);
                inv.setItem(19, BG);
                inv.setItem(20, BG);
                inv.setItem(21, BG);
                inv.setItem(22, BG);
                inv.setItem(23, BG);
                inv.setItem(24, BG);
                inv.setItem(25, BG);
                inv.setItem(26, BG);


                Player player = (Player) sender;
                player.openInventory(inv);

            }
        }


        return false;
    }
}

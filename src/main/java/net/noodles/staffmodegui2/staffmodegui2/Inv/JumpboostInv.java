package net.noodles.staffmodegui2.staffmodegui2.Inv;

import net.noodles.staffmodegui2.staffmodegui2.Inv.InvItems.JumpboostInvItems;
import net.noodles.staffmodegui2.staffmodegui2.Inv.InvItems.MainInvItems;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import net.noodles.staffmodegui2.staffmodegui2.StaffModeGUI2;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class JumpboostInv implements Listener {
    @SuppressWarnings("unused")
    private StaffModeGUI2 main;
    public JumpboostInv(StaffModeGUI2 main) {
        this.main = main;
        main.getServer().getPluginManager().registerEvents(this, main);
    }
    private String getTitle() {
        return ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "Jump Boost Menu";
    }

    private int getSize() {
        return 9;
    }
    public Inventory getInventory() {
        Inventory inv = Bukkit.createInventory(null, getSize(), getTitle());

        inv.setItem(0, JumpboostInvItems.jump1());
        inv.setItem(1, JumpboostInvItems.jump2());
        inv.setItem(2, JumpboostInvItems.jump3());
        inv.setItem(3, JumpboostInvItems.jump4());
        inv.setItem(4, JumpboostInvItems.jump5());
        inv.setItem(5, JumpboostInvItems.jump6());
        inv.setItem(6, JumpboostInvItems.jump7());
        inv.setItem(7, JumpboostInvItems.jump8());
        inv.setItem(8, MainInvItems.mainMenuReturn());

        for (int i = 0; i < 9; ++i) {
            if (inv.getItem(i) == null) {
                inv.setItem(i, Glass());
            }
        }

        return inv;
    }


    private ItemStack Glass() {
        ItemStack stone = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)8);
        ItemMeta stonem = stone.getItemMeta();
        stonem.setDisplayName("");
        stone.setItemMeta(stonem);
        return stone;
    }


    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getClickedInventory() == null) return;
        if (!event.getClickedInventory().getTitle().equals(getTitle())) return;

        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getType() == Material.AIR) return;

        event.setCancelled(true);
        if (event.getCurrentItem().isSimilar(JumpboostInvItems.jump1())) {
            player.removePotionEffect(PotionEffectType.JUMP);
            player.addPotionEffect(new PotionEffect (PotionEffectType.JUMP, 180000000, 1));
            player.sendMessage(StaffModeGUI2.getPlugin().getConfig().getString("jumpboostMenu.messageItemJump1").replace("&", "§"));
            player.closeInventory();
        } else if (event.getCurrentItem().isSimilar(JumpboostInvItems.jump2())) {
            player.removePotionEffect(PotionEffectType.JUMP);
            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 180000000, 2));
            player.sendMessage(StaffModeGUI2.getPlugin().getConfig().getString("jumpboostMenu.messageItemJump2").replace("&", "§"));
            player.closeInventory();
        } else if (event.getCurrentItem().isSimilar(JumpboostInvItems.jump3())) {
            player.removePotionEffect(PotionEffectType.JUMP);
            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 180000000, 3));
            player.sendMessage(StaffModeGUI2.getPlugin().getConfig().getString("jumpboostMenu.messageItemJump3").replace("&", "§"));
            player.closeInventory();
        } else if (event.getCurrentItem().isSimilar(JumpboostInvItems.jump4())) {
            player.removePotionEffect(PotionEffectType.JUMP);
            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 180000000, 4));
            player.sendMessage(StaffModeGUI2.getPlugin().getConfig().getString("jumpboostMenu.messageItemJump4").replace("&", "§"));
            player.closeInventory();
        } else if (event.getCurrentItem().isSimilar(JumpboostInvItems.jump5())) {
            player.removePotionEffect(PotionEffectType.JUMP);
            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 180000000, 5));
            player.sendMessage(StaffModeGUI2.getPlugin().getConfig().getString("jumpboostMenu.messageItemJump5").replace("&", "§"));
            player.closeInventory();
        } else if (event.getCurrentItem().isSimilar(JumpboostInvItems.jump6())) {
            player.removePotionEffect(PotionEffectType.JUMP);
            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 180000000, 6));
            player.sendMessage(StaffModeGUI2.getPlugin().getConfig().getString("jumpboostMenu.messageItemJump6").replace("&", "§"));
            player.closeInventory();
        } else if (event.getCurrentItem().isSimilar(JumpboostInvItems.jump7())) {
            player.removePotionEffect(PotionEffectType.JUMP);
            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 180000000, 7));
            player.sendMessage(StaffModeGUI2.getPlugin().getConfig().getString("jumpboostMenu.messageItemJump7").replace("&", "§"));
            player.closeInventory();
        } else if (event.getCurrentItem().isSimilar(JumpboostInvItems.jump8())) {
            player.removePotionEffect(PotionEffectType.JUMP);
            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 180000000, 8));
            player.sendMessage(StaffModeGUI2.getPlugin().getConfig().getString("jumpboostMenu.messageItemJump8").replace("&", "§"));
            player.closeInventory();
        } else if (event.getCurrentItem().isSimilar(MainInvItems.mainMenuReturn())) {
            player.sendMessage(StaffModeGUI2.getPlugin().getConfig().getString("mainMenuReturn.message").replace("&", "§"));
            player.openInventory(StaffModeGUI2.getInstance().getMainInv().getInventory());

        }
    }


}
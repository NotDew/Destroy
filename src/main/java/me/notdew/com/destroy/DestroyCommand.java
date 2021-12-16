package me.notdew.com.destroy;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DestroyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {


        if (!(commandSender instanceof Player)){return true;}
        Player p = (Player) commandSender;
        if (args.length == 0) {
            TextComponent component = new TextComponent(TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', "&a&lClick to confirm.")));
            component.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/" + "destroy confirm"));

            commandSender.spigot().sendMessage(component);
            return true;
        }
        if (args[0].equalsIgnoreCase("confirm")) {

            if(p.getItemInHand().getType() == Material.AIR)
            {
                p.sendMessage(ChatColor.RED + "You are not holding anything.");
                return true;
            }


            p.getInventory().removeItem(p.getInventory().getItemInMainHand());
            p.sendMessage(ChatColor.BOLD + "" + ChatColor.GREEN + "Done.");
            return true;
        }




        return true;}
}

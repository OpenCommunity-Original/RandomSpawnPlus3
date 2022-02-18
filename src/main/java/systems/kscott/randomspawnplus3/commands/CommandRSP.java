package systems.kscott.randomspawnplus3.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import systems.kscott.randomspawnplus3.RandomSpawnPlus;
import systems.kscott.randomspawnplus3.util.Chat;

@CommandAlias("rsp|randomspawnplus")
@Description("Manage the plugin")
@CommandPermission("randomspawnplus.manage")
public class CommandRSP extends BaseCommand {

    private RandomSpawnPlus plugin;

    public CommandRSP(RandomSpawnPlus plugin) {
        this.plugin = plugin;
    }

    @Default
    @Subcommand("help|h")
    public void _main(CommandSender player) {
        Chat.msg(player, "  &3&lRandomSpawnPlus &7By OpenCommunity Original &bv" + plugin.getDescription().getVersion() + "&7, made with love &a:^)");
        Chat.msg(player, "");
        Chat.msg(player, "&b/rsp &8- &7The help menu.");
        Chat.msg(player, "&b/rsp reload &8- &7Reload the plugin configuration.");
        Chat.msg(player, "&b/wild &8- &7Randomly teleport yourself.");
        Chat.msg(player, "&b/wild <other> &8- &7Randomly teleport another player.");
        Chat.msg(player, "&7Need help? Check out &bdocs.randomspawnpl.us&7.");
    }

    @Subcommand("reload")
    public void _reload(CommandSender player) {
        plugin.getConfigManager().reload();
        plugin.getLangManager().reload();
        plugin.getSpawnsManager().reload();
        Chat.setLang(plugin.getLangManager().getConfig());
        Chat.msg(player, "  &3&lRandomSpawnPlus &7Reloaded.");
    }
}

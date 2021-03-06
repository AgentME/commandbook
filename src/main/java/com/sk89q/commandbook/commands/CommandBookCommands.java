// $Id$
/*
 * Copyright (C) 2010, 2011 sk89q <http://www.sk89q.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
*/

package com.sk89q.commandbook.commands;

import com.sk89q.commandbook.CommandBook;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import com.sk89q.minecraft.util.commands.CommandException;
import com.sk89q.minecraft.util.commands.CommandPermissions;

public class CommandBookCommands {
    
    @Command(aliases = {"version"}, usage = "", desc = "CommandBook version information", min = 0, max = 0)
    public static void version(CommandContext args, CommandSender sender) throws CommandException {
        sender.sendMessage(ChatColor.YELLOW + "CommandBook " + CommandBook.inst().getDescription().getVersion());
        sender.sendMessage(ChatColor.YELLOW + "http://www.sk89q.com");
    }
    
    @Command(aliases = {"reload"}, usage = "", desc = "Reload CommandBook's settings", min = 0, max = 0)
    @CommandPermissions({"commandbook.reload"})
    public static void reload(CommandContext args, CommandSender sender) throws CommandException {
        CommandBook.inst().populateConfiguration();
        CommandBook.inst().getComponentManager().reloadComponents();
        
        sender.sendMessage(ChatColor.YELLOW + "CommandBook's configuration has been reloaded.");
    }

    @Command(aliases = {"save"}, usage = "", desc = "Save CommandBook's settings", min = 0, max = 0)
    @CommandPermissions({"commandbook.save"})
    public static void save(CommandContext args, CommandSender sender) throws CommandException {
        CommandBook.inst().getGlobalConfiguration().save();

        sender.sendMessage(ChatColor.YELLOW + "CommandBook's configuration has been reloaded.");
    }
    
}

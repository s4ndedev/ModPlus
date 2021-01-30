package me.s4ndedev.modplus.commands;

import me.s4ndedev.modplus.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class TextCommand extends ListenerAdapter {

    String prefix = Main.prefix;

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {

        String[] message = e.getMessage().getContentRaw().split(" ");

        if (message[0].equalsIgnoreCase(prefix + "text")) {

            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setColor(Color.red);
            embedBuilder.setAuthor("ModPlus", null, "https://i.imgur.com/WY5fGD0.png");
            embedBuilder.setThumbnail(e.getGuild().getIconUrl());

            String message1 = "";
            for (int x = 1; x < message.length; x++) {
                if (x == message.length - 0)
                    message1 = message1 + message[x];
                else {
                    message1 = message1 + message[x] + " ";
                }
                embedBuilder.setDescription(message1);
                //embedBuilder.setTitle(message1);
            }

            e.getChannel().sendMessage(embedBuilder.build()).queue();
            e.getMessage().delete().queue();

            //e.getChannel().sendMessage(embedBuilder.build()).complete().addReaction("✉").queue();


        }

    }

}

package me.s4ndedev.modplus;

import me.s4ndedev.modplus.commands.TextCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static String prefix = "!";
    static String TOKEN = me.s4ndedev.modplus.TOKEN.TOKEN;

    public static void main(String[] args) {
        List<GatewayIntent> gatewayIntents = new ArrayList<>();
        gatewayIntents.add(GatewayIntent.GUILD_MEMBERS);

        // token
        JDABuilder jdaBuilder = JDABuilder.createDefault(TOKEN);
        jdaBuilder.enableIntents(gatewayIntents);
        JDA jda = null;

        // events
        //jdaBuilder.addEventListeners(new Help());
        jdaBuilder.addEventListeners(new TextCommand());

        jdaBuilder.setActivity(Activity.playing("!help"));

        try {
            jda = jdaBuilder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }

        try {
            assert jda != null;
            jda.awaitReady();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

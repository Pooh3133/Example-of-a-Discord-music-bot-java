import net.dv8tion.jda.api.JDA;

import net.dv8tion.jda.api.JDABuilder;

import net.dv8tion.jda.api.entities.Guild;

import net.dv8tion.jda.api.entities.TextChannel;

import net.dv8tion.jda.api.entities.VoiceChannel;

import net.dv8tion.jda.api.managers.AudioManager;

import javax.security.auth.login.LoginException;

import java.util.Scanner;

public class MusicBot

{

    private static JDA jda;

    private static final String BOT_TOKEN = "YOUR_BOT_TOKEN_HERE";

    public static void main(String[] args) throws LoginException

    {

        jda = JDABuilder.createDefault(BOT_TOKEN).build();

        Scanner scanner = new Scanner(System.in);

        while (true)

        {

            String line = scanner.nextLine();

            String[] parts = line.split(" ");

            String command = parts[0];

            if (command.equalsIgnoreCase("join"))

            {

                joinCommand(parts[1]);

            }

            else if (command.equalsIgnoreCase("leave"))

            {

                leaveCommand();

            }

        }

    }

    private static void joinCommand(String channelName)

    {

        Guild guild = jda.getGuilds().get(0); // Assuming the bot is only in one guild

        VoiceChannel channel = guild.getVoiceChannelsByName(channelName, true).get(0); // Assuming the channel exists

        AudioManager audioManager = guild.getAudioManager();

        audioManager.openAudioConnection(channel);

    }

    private static void leaveCommand()

    {

        Guild guild = jda.getGuilds().get(0); // Assuming the bot is only in one guild

        AudioManager audioManager = guild.getAudioManager();

        audioManager.closeAudioConnection();

    }

}


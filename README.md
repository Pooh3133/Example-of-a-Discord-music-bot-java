# Example-of-a-Discord-music-bot-java
Here is an example of a simple Discord music bot written in Java using the JDA (Java Discord API) library

``` import net.dv8tion.jda.api.JDA;

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
```

To use this bot, you will need to replace YOUR_BOT_TOKEN_HERE with your own Discord bot token, which you can obtain by creating a new bot in the Discord developer portal. You will also need to include the JDA library in your project.

To control the bot, you can send it commands by typing them into the console. For example, to have the bot join a voice channel called "Music", you would type join Music into the console. To have the bot leave the voice channel, you would type leave.

This is just a basic example to get you started. You can expand upon this code to add more functionality, such as the ability to play music, skip tracks, and more.

❤ https://github.com/Pooh3133 ❤

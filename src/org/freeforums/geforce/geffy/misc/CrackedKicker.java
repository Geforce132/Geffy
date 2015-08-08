package org.freeforums.geforce.geffy.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.freeforums.geforce.geffy.main.Bot;
import org.freeforums.geforce.geffy.main.Geffy;
import org.pircbotx.hooks.events.JoinEvent;

/**
 * Class that checks if a Minecraft user is using a premium account or not.
 * 
 * @author bl4ckscor3
 */
public class CrackedKicker {
	
	private static final HashMap<String, Boolean> scUsers = new HashMap<String, Boolean>(); 

	public static void check(JoinEvent<Bot> event) throws MalformedURLException, IOException {
		String name = event.getUser().getNick().split("_")[1];
		BufferedReader reader;
		String status;

		if(scUsers.containsKey(name)){
			if(!scUsers.get(name))
				Geffy.bot.sendRaw().rawLine("KICK " + event.getChannel().getName() + " SCUser_" + name + " :We don't need cracked accounts here.");
		}else{
			reader = new BufferedReader(new InputStreamReader(new URL("http://axis.iaero.me/accstatus?username=" + name + "&format=plain").openStream()));
			status = reader.readLine();
			reader.close();

			if(status.equalsIgnoreCase("free")){
				Geffy.bot.sendRaw().rawLine("KICK " + event.getChannel().getName() + " SCUser_" + name + " :We don't need cracked accounts here.");
				scUsers.put(name, false);
			}else if(status.equalsIgnoreCase("premium")){
				scUsers.put(name, true);
			}
		}
	}
}

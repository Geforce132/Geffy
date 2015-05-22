package org.freeforums.geforce.geffy.main;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.freeforums.geforce.geffy.listeners.MessageListener;
import org.pircbotx.Configuration;

public class Geffy {
	
	public static final String VERSION = "0.0.2";
	public static Bot bot;

	public static void main(String[] args) throws Exception {
		Logger.getLogger("").setLevel(Level.OFF);
		Configuration config = new Configuration.Builder().setVersion(VERSION).setName("Geffy").setServerHostname("irc.esper.net").addAutoJoinChannel("#Geforce").addListener(new MessageListener()).buildConfiguration();
		
	    bot = new Bot(config);
		bot.startBot();
	}

}

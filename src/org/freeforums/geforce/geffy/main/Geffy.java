package org.freeforums.geforce.geffy.main;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.freeforums.geforce.geffy.listeners.MessageListener;
import org.pircbotx.Configuration;

public class Geffy {
	
	public static final String VERSION = "v0.1.1";
	public static Bot bot;

	public static void main(String[] args) throws Exception {
		Logger.getLogger("").setLevel(Level.OFF);
		Configuration config = new Configuration.Builder().setVersion(VERSION).setName("Geffy").setRealName("Geforce's assistant, at your service!").setServerHostname("irc.esper.net").addAutoJoinChannel("#Geforce").addListener(new MessageListener()).buildConfiguration();
		
	    bot = new Bot(config);
		bot.startBot();
	}

}

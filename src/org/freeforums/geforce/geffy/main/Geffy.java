package org.freeforums.geforce.geffy.main;

import org.freeforums.geforce.geffy.listeners.MessageListener;
import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;

public class Geffy {

	public static void main(String[] args) throws Exception {
		Configuration config = new Configuration.Builder().setName("Geffy").setServerHostname("irc.esper.net").addAutoJoinChannel("#Geforce").addListener(new MessageListener()).buildConfiguration();
		
		PircBotX bot = new PircBotX(config);
		bot.startBot();
	}

}

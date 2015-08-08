package org.freeforums.geforce.geffy.main;

import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;

public class Bot extends PircBotX {

	public Bot(Configuration<? extends PircBotX> configuration) {
		super(configuration);
	}
	
	public void setNick(String nick){
		sendIRC().changeNick(nick);
	}

}

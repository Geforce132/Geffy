package org.freeforums.geforce.geffy.listeners;

import org.freeforums.geforce.geffy.main.Bot;
import org.freeforums.geforce.geffy.main.Reference;
import org.freeforums.geforce.geffy.utils.Utils;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

public class MessageListener extends ListenerAdapter<Bot> {

	public void onMessage(MessageEvent<Bot> event) {		
		if(!event.getUser().getNick().matches(event.getBot().getNick()) && (event.getMessage().toLowerCase().contains("hungry") || event.getMessage().toLowerCase().contains("cookie"))){
			event.respond("Here's a " + Reference.cookieTypes[Utils.getRandomNumber(Reference.cookieTypes.length)] + " cookie for you, " + event.getUser().getNick());
		}
	}

}

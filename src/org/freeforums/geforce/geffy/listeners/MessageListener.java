package org.freeforums.geforce.geffy.listeners;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

@SuppressWarnings("rawtypes")
public class MessageListener extends ListenerAdapter {

	public void onMessagePosted(MessageEvent<PircBotX> event) {
		if(!event.getUser().getNick().matches(event.getBot().getNick()) && (event.getMessage().toLowerCase().contains("hungry") || event.getMessage().toLowerCase().contains("cookie"))){
			event.getChannel().send().action("gives " + event.getUser().getNick() + " a chocolate chip cookie");
		}
	}

}

package org.freeforums.geforce.geffy.listeners;

import org.freeforums.geforce.geffy.commands.ICommand;
import org.freeforums.geforce.geffy.main.Bot;
import org.freeforums.geforce.geffy.main.Geffy;
import org.freeforums.geforce.geffy.main.Reference;
import org.freeforums.geforce.geffy.misc.CrackedKicker;
import org.freeforums.geforce.geffy.misc.MessageHandler;
import org.freeforums.geforce.geffy.utils.Utils;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.ConnectEvent;
import org.pircbotx.hooks.events.JoinEvent;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

public class EventListener extends ListenerAdapter<Bot> {

	public void onMessage(MessageEvent<Bot> event){		
		if(event.getUser().getNick().startsWith("SCUser_") && event.getMessage().startsWith("SecurityCraft version: "))
		{
			String scVersion = event.getMessage().split(": ")[1];
			
			if(!scVersion.contains("-beta") && Utils.compareVersions(scVersion.replace("v", ""), Reference.scVersion.replace("v", "")) == -1)
			{
				event.respond("Your version of SecurityCraft (" + scVersion + ") is outdated. The latest version (" + Reference.scVersion +") contains important bugfixes and new features you can't miss out on! - https://minecraft.curseforge.com/projects/securitycraft-mod");
				return;
			}
			
			if(!scVersion.contains("-beta") && Utils.compareVersions(scVersion.replace("v", ""), Reference.scBetaVersion.replace("v", "").replace("-beta", "")) == -1)
			{
				event.respond("You may also download the newest beta version of " + Reference.scBetaVersionOf.replace("-beta", "") + ", " + Reference.scBetaVersion + ". Beta link: " + Reference.scBetaDownloadLink);
				return;
			}
			
			if(scVersion.contains("-beta") && scVersion.substring(0, 4).matches(Reference.scVersion.substring(0, 4)))
			{
				event.respond("Your version of SecurityCraft (" + scVersion + ") is outdated. The latest version (" + Reference.scVersion +") contains important bugfixes and new features you can't miss out on! - https://minecraft.curseforge.com/projects/securitycraft-mod");
				return;
			}
			
			if(scVersion.contains("-beta") && Utils.compareVersions(scVersion.replace("v", "").replace("-beta", ""), Reference.scBetaVersion.replace("v", "").replace("-beta", "")) == -1)
			{
				event.respond("You may also download the newest beta version of " + Reference.scBetaVersionOf.replace("-beta", "") + ", " + Reference.scBetaVersion + ". Beta link: " + Reference.scBetaDownloadLink);
				return;
			}
		}
		
		String message = event.getMessage().split(" ")[0];
	
		if(Utils.arrayContains(Reference.ignoredUsers, event.getUser().getNick())){ return; }
		
		if(!event.getMessage().startsWith(Reference.commandPrefix)){
			MessageHandler.tryRespondingToMessage(event);
			return;
		}
		
		for(ICommand cmd : Reference.commands){
			for(String s : cmd.getAliases()){	
				if(message.equalsIgnoreCase(Reference.commandPrefix + s)){
					try{
						cmd.exeChan(event, Utils.getArgsFromCommand(event.getMessage()));
					}catch(Exception e){
						e.printStackTrace();
					}
					
					return;
				}
			}
		}
	}
	
	public void onPrivateMessage(PrivateMessageEvent<Bot> event){		
		String command = event.getMessage().split(" ")[0];
		
		if(Utils.arrayContains(Reference.ignoredUsers, event.getUser().getNick()) || !event.getMessage().startsWith(Reference.commandPrefix)){ return; }

		for(ICommand cmd : Reference.commands){
			for(String s : cmd.getAliases()){	
				if(command.equalsIgnoreCase(Reference.commandPrefix + s)){
					try{
						cmd.exePrivate(event, Utils.getArgsFromCommand(event.getMessage()));
					}catch(Exception e){
						e.printStackTrace();
					}
					
					return;
				}
			}
		}
	}
	
	/**
	 * When Geffy connects to IRC, join all channels listed in Reference.joinedChannels.
	 */
	public void onConnect(ConnectEvent event) throws Exception{
		for(String channel : Reference.joinedChannels){
			Geffy.bot.sendIRC().joinChannel(channel);
		}
	}
	
	public void onJoin(JoinEvent<Bot> event) throws Exception {
		if(event.getChannel().getName().equals("#GeforceMods") && event.getUser().getNick().startsWith("SCUser_")){
			CrackedKicker.check(event);
		}
	}

}

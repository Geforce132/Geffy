package org.freeforums.geforce.geffy.misc;

import org.freeforums.geforce.geffy.main.Geffy;

import com.github.theholywaffle.teamspeak3.api.event.ChannelCreateEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelDeletedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelDescriptionEditedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelEditedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelMovedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelPasswordChangedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ClientJoinEvent;
import com.github.theholywaffle.teamspeak3.api.event.ClientLeaveEvent;
import com.github.theholywaffle.teamspeak3.api.event.ClientMovedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ServerEditedEvent;
import com.github.theholywaffle.teamspeak3.api.event.TS3Listener;
import com.github.theholywaffle.teamspeak3.api.event.TextMessageEvent;

public class TS3ActionListener implements TS3Listener {

	public void onChannelCreate(ChannelCreateEvent event) {}

	public void onChannelDeleted(ChannelDeletedEvent event) {}

	public void onChannelDescriptionChanged(ChannelDescriptionEditedEvent event) {}

	public void onChannelEdit(ChannelEditedEvent event) {}

	public void onChannelMoved(ChannelMovedEvent event) {}

	public void onChannelPasswordChanged(ChannelPasswordChangedEvent event) {}

	public void onClientJoin(ClientJoinEvent event) {
		Geffy.bot.sendIRC().message("#BreakInBad", "[TS3] * " + event.getClientNickname() + " has joined breakinbad.net.");
	}

	public void onClientLeave(ClientLeaveEvent event) {
		Geffy.bot.sendIRC().message("#BreakInBad", "[TS3] * Someone has left breakinbad.net.");
	}

	public void onClientMoved(ClientMovedEvent event) {}

	public void onServerEdit(ServerEditedEvent event) {}

	public void onTextMessage(TextMessageEvent event) {}

}

package org.freeforums.geforce.geffy.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.freeforums.geforce.geffy.listeners.EventListener;
import org.freeforums.geforce.geffy.misc.MessageHandler;
import org.freeforums.geforce.geffy.misc.SecurityCraftUpdate;
import org.freeforums.geforce.geffy.misc.SuperSecretSecrets;
import org.freeforums.geforce.geffy.misc.TS3ActionListener;
import org.pircbotx.Configuration;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Geffy {

	public static final String VERSION = "v0.2.0";
	public static Bot bot;

	public static void main(String[] args) throws Exception {	
		Logger.getLogger("").setLevel(Level.OFF);
		Configuration config = new Configuration.Builder().setVersion(VERSION).setName("Geffy").setRealName("Geforce's assistant, at your service!").setServerHostname("irc.esper.net").addAutoJoinChannel("#Geforce").setNickservPassword(SuperSecretSecrets.nickservPassword).addListener(new EventListener()).buildConfiguration();
		bot = new Bot(config);
		
		MessageHandler.messagesToRespondTo.put("new commit to", MessageHandler.newCommitToMessages);
		
		//Get the newest SecurityCraft version from GitHub.
		Gson gson = new GsonBuilder().create();
		URL updateURL = new URL("https://www.github.com/Geforce132/SecurityCraft/raw/master/Updates/Geffy.json");
		BufferedReader in = new BufferedReader(new InputStreamReader(updateURL.openStream()));

		SecurityCraftUpdate update = gson.fromJson(in, SecurityCraftUpdate.class);

		Reference.scVersion = update.getVersion();
		Reference.scBetaVersion = update.getBetaVersion();
		Reference.scBetaVersionOf = update.getBetaVersionOf();
		Reference.scBetaDownloadLink = update.getBetaDownloadLink();

		//-----

		//Start the TS3 functionality of Geffy.
		TS3Config tsConfig = new TS3Config();
		tsConfig.setHost("breakinbad.net");

		Reference.ts3Query = new TS3Query(tsConfig);
		Reference.ts3Query.connect();

		TS3Api api = Reference.ts3Query.getApi();
		api.selectVirtualServerById(1);
		api.setNickname("GeffyBot");

		api.registerAllEvents();

		Reference.ts3EventListener = new TS3ActionListener();
		api.addTS3Listeners(Reference.ts3EventListener);

		//-----
		
		bot.startBot();
	}

}

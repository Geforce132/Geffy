package org.freeforums.geforce.geffy.main;

import org.freeforums.geforce.geffy.commands.CommandExplode;
import org.freeforums.geforce.geffy.commands.CommandGiveCookie;
import org.freeforums.geforce.geffy.commands.CommandHelp;
import org.freeforums.geforce.geffy.commands.CommandN3Quote;
import org.freeforums.geforce.geffy.commands.CommandRate;
import org.freeforums.geforce.geffy.commands.CommandSing;
import org.freeforums.geforce.geffy.commands.ICommand;
import org.freeforums.geforce.geffy.misc.TS3ActionListener;

import com.github.theholywaffle.teamspeak3.TS3Query;

public class Reference {
	
	//Important variables and arrays.
	public static final String commandPrefix = "~";
	
	public static ICommand[] commands = new ICommand[]{new CommandHelp(), new CommandRate(), new CommandGiveCookie(), new CommandExplode(), new CommandSing(), new CommandN3Quote()};
    public static String[] joinedChannels = new String[]{"#GeforceMods", "#Geforce", "#bl4ckscor3", "#Razz", "#Geffy", "#mancave"};
    public static String[] ignoredUsers = new String[]{"Geffy"};
        
    //Other things.
	public static String[] cookieTypes = new String[]{"chocolate chip", "peanut butter", "raisin", "oatmeal", "white fudge", "sugar", "frosted", "Oreo"};
	public static String scVersion = ""; 
	public static String scBetaVersion = ""; 
	public static String scBetaVersionOf = ""; 
	public static String scBetaDownloadLink = ""; 

	public static TS3Query ts3Query;
	public static TS3ActionListener ts3EventListener;

}

package org.freeforums.geforce.geffy.misc;

public class SecurityCraftUpdate {
	
	private String version;
	private String betaVersion;
	private String betaVersionOf;
	private String betaDownloadLink;

	public SecurityCraftUpdate(String version, String betaVersion, String betaVersionOf, String betaDownloadLink){
		this.version = version;
		this.betaVersion = betaVersion;
		this.betaVersionOf = betaVersionOf;
		this.betaDownloadLink = betaDownloadLink;
	}
	
	public String getVersion(){
		return version;
	}
	
	public String getBetaVersion(){
		return betaVersion;
	}
	
	public String getBetaVersionOf(){
		return betaVersionOf;
	}
	
	public String getBetaDownloadLink(){
		return betaDownloadLink;
	}
	
}
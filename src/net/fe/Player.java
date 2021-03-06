package net.fe;

import java.io.Serializable;

import net.fe.network.message.JoinTeam;

// TODO: Auto-generated Javadoc
/**
 * The Class Player.
 */
public class Player implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7461827659473965623L;
	
	/** The party. */
	private Party party;
	
	/** The client id. */
	private byte clientID;
	
	/** The nickname. */
	private String nickname;
	
	/** The team. */
	private int team;
	
	/** The ready. */
	public boolean ready;
	
	/** The Constant TEAM_NONE. */
	public static final int TEAM_NONE = -1;
	
	/** The Constant TEAM_SPECTATOR. */
	public static final int TEAM_SPECTATOR = 0;
	
	/** The Constant TEAM_BLUE. */
	public static final int TEAM_BLUE = 1;
	
	/** The Constant TEAM_RED. */
	public static final int TEAM_RED = 2;
	
	/**
	 * Instantiates a new player.
	 *
	 * @param name the name
	 * @param id the id
	 */
	public Player(String name, byte id) {
		party = new Party();
		clientID = id;
		nickname = name;
		team = 0;
		ready = false;
	}
	
	/**
	 * Checks if is spectator.
	 *
	 * @return true, if is spectator
	 */
	public boolean isSpectator() {
		return team == TEAM_SPECTATOR;
	}
	
	/**
	 * Gets the party.
	 *
	 * @return the party
	 */
	public Party getParty() {
		return party;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public byte getID() {
		return clientID;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return nickname;
	}

	/**
	 * Sets the client id.
	 *
	 * @param id the new client id
	 */
	public void setClientID(byte id) {
		clientID = id;
	}

	/**
	 * Gets the team.
	 *
	 * @return the team
	 */
	public int getTeam() {
		return team;
	}

	/**
	 * Sets the team.
	 *
	 * @param team2 the new team
	 */
	public void setTeam(int team2) {
		team = team2;
	}

	/**
	 * Join team.
	 *
	 * @param team the team
	 */
	public void joinTeam(int team) {
		FEMultiplayer.getClient().sendMessage(new JoinTeam(clientID, team));
	}
	
	/**
	 * Equals.
	 *
	 * @param p the p
	 * @return true, if successful
	 */
	public boolean equals(Player p) {
		return p.clientID == clientID;
	}

	/**
	 * Sets the name.
	 *
	 * @param nickname the new name
	 */
	public void setName(String nickname) {
		this.nickname = nickname;
	}
}

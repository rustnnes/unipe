package br.unipe.mlpIII.Locadora.Model;

import java.util.Date;

public class User implements Comparable <User> {
	protected String	id;
	protected String	usr;
	protected String	pwd;
	protected Date		dateCreated;
	protected Date		dateModified;

	public String	getId() 			{ return id; }
	public String	getUsr() 			{ return usr; }
	public String	getPwd() 			{ return pwd; }
	public Date		getDateCreated() 	{ return dateCreated; }
	public Date		getDateModified() 	{ return dateModified; }
	public void		setUsr(String usr) 	{ this.usr = usr; }
	public void		setPwd(String pwd) 	{ this.pwd = pwd; }

	public User(String id, String usr, String pwd, Date dateCreated, Date dateModified) {
		this.id = id;
		this.usr = usr;
		this.pwd = pwd;
		this.dateCreated = dateCreated;
		this.dateModified = dateModified;
	}

	public User(String usr, String pwd) { this(null, usr, pwd, null, null); }
	public User(String usr)				{ this(null, usr, null, null, null); }

	@Override
	public int compareTo(User usr)		{ return this.usr.compareToIgnoreCase(usr.usr); }
}

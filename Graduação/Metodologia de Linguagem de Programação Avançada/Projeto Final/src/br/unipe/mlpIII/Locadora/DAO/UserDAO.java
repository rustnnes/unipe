package br.unipe.mlpIII.Locadora.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.unipe.mlpIII.Locadora.Model.User;
import br.unipe.mlpIII.Locadora.Model.UserJDBC;
import br.unipe.mlpIII.Locadora.View.Main;

public class UserDAO {
	private static final String stdQry = "select * from users";
	
	public static Map<String, User> getUsers() {
		Map<String, User> USERS = new HashMap<String, User>();
		UserJDBC connUsers = new UserJDBC(Main.getProperties());
		
		if(connUsers.getConnection()){
			List<User> listaUsers = new ArrayList<User>(connUsers.select(stdQry));
			listaUsers.forEach(u -> USERS.put(u.getUsr(), u));
		}
		
		return USERS;
	}
}

package br.unipe.mlpIII.Locadora.Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.unipe.mlpIII.Locadora.Controller.Inicial;
import br.unipe.mlpIII.Locadora.Controller.Login;
import br.unipe.mlpIII.Locadora.DAO.UserDAO;
import br.unipe.mlpIII.Locadora.Model.User;
import br.unipe.mlpIII.Locadora.View.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginManager {
	private Scene scene;
	private Stage stage;
	private User loggedUser = null;
	private static final Map<String, User> USERS = new HashMap<String, User>();
	//private static final Map<String, Credentials> LUSERS = new HashMap<String, Credentials>();
	private static final Map<String, User> LUSERS = new HashMap<String, User>();

	@SuppressWarnings("unused")
	private static int sessionID = 0;

	public LoginManager(Stage stage) {
		USERS.putAll(UserDAO.getUsers());
		this.stage = stage;
		// AnchorPane root = new AnchorPane();
		scene = new Scene(new AnchorPane());
		showLoginScreen();
	}

	public void authenticated() {
		showMainView();
	}

	public void logout() {
		showLoginScreen();
	}

	public void showLoginScreen() {
		FXMLLoader loader = goStage("Login.fxml", "Locadora - Login", "file:res/img/key.png", false);
		Login controller = loader.<Login> getController();
		controller.init(this);
	}

	private void showMainView() {
		FXMLLoader loader = goStage("Inicial.fxml", "Tela Principal", "file:res/img/logo.png", true);
		Inicial controller = loader.<Inicial> getController();
		controller.init(this);
	}

	/* authorize com Credentials
	public boolean authorize(Credentials cr) {
		User validUser = USERS.get(cr.Usr());
		if (validUser != null)
			if (validUser.getPwd().equals(cr.Pwd())) {
				loggedUser = this.of(cr.Usr());
				return true;
			} else {
				return false;
			}
		else
			return false;
	} */

	public boolean authorize(String u, String p) {
		User validUser = USERS.get(u);
		if (validUser != null)
			if (validUser.getPwd().equals(p)) {
				loggedUser = validUser;
				LUSERS.put(u, validUser);
				return true;
			} else {
				return false;
			}
		else
			return false;
	}
	
	/* public User of(String id) {
		User user = USERS.get(id);
		if (user == null) {
			user = new User(id);
			LUSERS.put(id, user);
		}
		return user;
	}
	*/
	
	public User getLoggedUser() { return loggedUser; }

	public void userLogout() { loggedUser = null; }

	private FXMLLoader goStage(String screen, String title, String icon, boolean sizable) {
		FXMLLoader loader = null;
		try {
			loader = new FXMLLoader(Main.class.getResource(screen));
			scene.setRoot((Parent) loader.load());

			stage.hide();
			stage.setScene(scene);
			stage.setTitle(title);
			stage.getIcons().add(new Image(icon));
			stage.sizeToScene();
			stage.centerOnScreen();
			stage.setResizable(sizable);
			stage.show();
		} catch (IOException e) {
			Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, e);
		}
		return loader;
	}

	@SuppressWarnings("unused")
	private String generateSessionID() {
		sessionID++;
		return null;
	}


}

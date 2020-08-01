package br.unipe.mlpIII.Locadora.Utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Windows {

	public static Stage open(Class<?> cl, Stage priStage, String fxml, String css, String title, String icon,
			boolean modal, boolean usePriStage) {
		Stage secStage = null;
		try {
			FXMLLoader loader = new FXMLLoader(cl.getResource(fxml));
			AnchorPane root = (AnchorPane) loader.load();
			Scene scene = new Scene(root);
			if (!css.equals(""))
				scene.getStylesheets().add(cl.getResource(css).toExternalForm());
			secStage = usePriStage ? priStage : new Stage();
			secStage.setTitle(title);
			if (!icon.equals(""))
				secStage.getIcons().add(new Image("file:res/img/" + icon));
			if (secStage != priStage && priStage != null){
				secStage.initOwner(priStage);
				secStage.initModality(modal ? Modality.APPLICATION_MODAL : Modality.NONE);	
			}
			secStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return secStage;
	}
}

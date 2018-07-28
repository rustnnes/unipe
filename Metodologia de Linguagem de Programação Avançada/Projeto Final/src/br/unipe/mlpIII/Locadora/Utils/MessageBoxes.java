package br.unipe.mlpIII.Locadora.Utils;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class MessageBoxes {
	public static ButtonType MsgBox(Alert.AlertType type, String title, String msg, String header,
			ButtonType[] buttons) {
		Alert dialog = new Alert(type, msg, buttons);
		// Java Alerts modal default
		// dialog.initModality(Modality.APPLICATION_MODAL);
		dialog.setTitle(title);
		dialog.setHeaderText(header);
		Optional <ButtonType> result = dialog.showAndWait();
		if (result.isPresent()) return result.get();
		else
			return ButtonType.OK;
	}

	public static void Info(String title, String msg, String header) {
		MsgBox(Alert.AlertType.INFORMATION, title, msg, header, new ButtonType[] {ButtonType.OK});
	}

	public static void Crit(String title, String msg, String header) {
		MsgBox(Alert.AlertType.ERROR, title, msg, header, new ButtonType[] {ButtonType.OK});
	}

	public static void Warn(String title, String msg, String header) {
		MsgBox(Alert.AlertType.WARNING, title, msg, header, new ButtonType[] {ButtonType.OK});
	}

	public static ButtonType OkCancel(String title, String msg, String header) {
		return MsgBox(Alert.AlertType.CONFIRMATION, title, msg, header,
				new ButtonType[] {ButtonType.OK, ButtonType.CANCEL});
	}

	public static ButtonType YesNo(String title, String msg, String header) {
		return MsgBox(Alert.AlertType.CONFIRMATION, title, msg, header,
				new ButtonType[] {ButtonType.OK, ButtonType.CANCEL});
	}
}

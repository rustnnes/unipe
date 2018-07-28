package central;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Observable;
import java.util.Observer;
import java.util.Properties;

public class SMSSender implements Observer {
	private static Properties props = getProperties();
	private static Properties getProperties() {
		try {
			if (props == null) {
				props = new Properties();
				props.loadFromXML(new FileInputStream("sms.properties"));
			}
		} catch (InvalidPropertiesFormatException e) {
			//Propriedades inv�lidas
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			//Arquivo n�o encontrado
			e.printStackTrace();
		} catch (IOException e) {
			//Falha I/O
			e.printStackTrace();
		}
		return props;
	}
	
	private void enviarSms(String msg, String proprietario, String telefone) {
		/*Twilio.init(getProperties().getProperty("ACCOUNT_SID"),
					getProperties().getProperty("AUTH_TOKEN"));
		Message message = Message.creator(new PhoneNumber("+55" + telefone), 
										  new PhoneNumber("+447481338865"), msg)
								 .create();*/
		//System.out.println(message.getSid());
		System.out.println("SMS enviado para " + proprietario + 
						   " no telefone +55" + telefone + 
						   " com mensagem \n" + msg);
	}

	public void update(Observable o, Object arg) {
		Central c = (Central) o;
		enviarSms("Movimentacao suspeita em sua residencia. Seguranca a caminho.",
				c.getProprietario(), c.getTelefone());
	}

}

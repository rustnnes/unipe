package Data;
import java.io.IOException;

public class Utils {

	public static boolean yesNo() throws IOException{
		char ch = (char) System.in.read();
		return ( (ch == 'Y') || (ch == 'y') || (ch == 'S') || (ch == 's') );
	}
}

import java.util.Arrays;
import java.util.List;

public class Utils {

	public static boolean isWindows() {
		return System.getProperty("os.name").toLowerCase().contains("win");
	}
	
	public static List<String> sh(String cmd){
		
		return isWindows() ? Arrays.asList("cmd" , "/c", cmd)
						   : Arrays.asList("sh", "-c", cmd);
		
	}
	
	public static void imprimeArgs(String[] args) {
		
		for(String arg : args) {
			System.out.println(arg + " ");
		}
	}
	
}

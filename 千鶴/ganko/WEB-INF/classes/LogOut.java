import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

public class LogOut {
	public static void logOut(HttpServletRequest req) {
		System.out.println("--LogOut.logOut--");
		
		HttpSession session = req.getSession();
			
		session.removeAttribute("login");
	}
}
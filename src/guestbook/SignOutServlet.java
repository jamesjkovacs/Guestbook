package guestbook;

import java.io.IOException;
import javax.servlet.http.*;
//import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;


@SuppressWarnings("serial")
public class SignOutServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
      UserService userService = UserServiceFactory.getUserService();
      resp.sendRedirect(userService.createLogoutURL("/index.html"));
	}
}

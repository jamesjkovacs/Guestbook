package guestbook;

import java.io.IOException;
import javax.servlet.http.*;
import org.json.rpc.*;

@SuppressWarnings("serial")
public class JsonRpcServlet extends HttpServlet {

    private final JsonRpcExecutor executor;

    public JsonRpcServlet() {
        executor = bind();
    }

    private JsonRpcExecutor bind() {
        JsonRpcExecutor executor = new JsonRpcExecutor();

        Calculator calcImpl = new CalculatorImpl();
        executor.add("calc", calcImpl, Calculator.class);
        // add more services here

        return executor;
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        executor.execute(new JsonRpcServletTransport(req, resp));
    }

}
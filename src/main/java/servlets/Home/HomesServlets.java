package servlets.Home;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/home")
public class HomesServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String top =
                "<head><title>Hello</title></head>"
                + "<body>"
                + "<nav>"
                +   "<a href=/>HOME</a>"
                +   "<a href=/personchooser>Show Person Classes</a>"
                +   "<a href=/home>Servlet Redirect</a>"
                + "</nav>"
                + "<h2>Hello from Java Servlet!</h2>"
                +"<a href= http://localhost:8080/kurser> kurser</a>"
                +"<a href= http://localhost:8080/narvaro> narvaro</a>";

        String bottom =
                "</body>"
                        + "</html>";
        PrintWriter out = resp.getWriter();
        out.println(top);
        out.println(bottom);
    }
}

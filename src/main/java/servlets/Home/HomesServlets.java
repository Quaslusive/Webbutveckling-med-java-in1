package servlets.Home;

import models.MysqlConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/home")
public class HomesServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head><title>Veporwere School of Awesomeness</title>");
        out.println("<link rel=stylesheet type=text/css href=style.css />");
        out.println("</head>");
        out.println("<body>");

        out.println("<header>");
        out.println("<nav>");
        out.println("<ul>");
        out.println("<li><a href= kurser> Kurser</a></li>");
        out.println("<li><a href= studenter> Studenter</a>");
        out.println("<li><a href= narvaro> Närvaro</a>");
        out.println("</ul>");
        out.println("</nav>");
        out.println("</header>");

        out.println("<br>");

        out.println("<div >");
        out.println("<h1>Veporwere School of Awesomeness</h1>");
        out.println("</div>");

        out.println("<h2> Attendance List</h2>");
        out.println("<main>");

        out.println("</main>");
        out.println("<br>");
        out.println("</body>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}

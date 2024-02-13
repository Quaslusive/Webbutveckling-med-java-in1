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

@WebServlet(name = "home", urlPatterns = "/home")
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
        out.println("<li><a href= home>| Home |</a></li>");
        out.println("<li><a href= courses>| Courses |</a></li>");
        out.println("<li><a href= students>| Students |</a>");
        out.println("<li><a href= attendance>| Attendance |</a></li>");
        out.println("</ul>");
        out.println("</nav>");
        out.println("</header>");

        out.println("<br>");
        out.println("<div class=top-titel fadeInAnimation >");
        out.println("<h1>Veporwere School of Awesomeness</h1>");
        out.println("</div>");

        out.println("<main>");
        out.println("<h1> School Info </h1>");
        out.println("<span id=spacer></span>");

        out.println("<section id=om_oss-p>");

        out.println("<h2> Vår Historia <h2>");
        out.println("<p>");
        out.println("Lorem ipsum dolor sit amet consectetur adipisicing elit. Vitae velit consectetur corrupti inventore fugit.");
        out.println("earum porro consequuntur error veritatis, velit cupiditate hic itaque! Totam molestiae blanditiis nesciunt");
        out.println("deserunt voluptates.");
        out.println("Facere beatae impedit expedita nam illo accusamus, eveniet nihil vitae id? Veniam atque quae laboriosam ab in,");
        out.println("eserunt eaque necessitatibus eius libero earum? Accusamus, molestias error. Ullam quia quasi in.");
        out.println("</p>");

        out.println("</section>");
        out.println("<section id=om_oss-p>");
        out.println("<h2> Nu och Framtiden<h2>");
        out.println("<p>");
        out.println("Lorem ipsum dolor sit amet consectetur adipisicing elit. Vitae velit consectetur corrupti inventore fugit.");
        out.println("earum porro consequuntur error veritatis, velit cupiditate hic itaque! Totam molestiae blanditiis nesciunt");
        out.println("deserunt voluptates.");
        out.println("Facere beatae impedit expedita nam illo accusamus, eveniet nihil vitae id? Veniam atque quae laboriosam ab in,");
        out.println("eserunt eaque necessitatibus eius libero earum? Accusamus, molestias error. Ullam quia quasi in.");
        out.println("</p>");

        out.println("</section>");
        out.println("</main>");
        out.println("<br>");

        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}

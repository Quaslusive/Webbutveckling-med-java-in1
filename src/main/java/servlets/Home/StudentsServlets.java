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

@WebServlet(urlPatterns = "/students")
public class StudentsServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head><title>Student Info</title>");
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
        out.println("<h1>Students List</h1>");
        out.println("</div>");

        out.println("<main>");
        out.println("<div id=data-table>");
        out.println("<table border=1>");
        out.println("<tr><th>Name</th><th>City</th><th>Hobbies</th></tr>");
        ArrayList<String> students = MysqlConnector.students();
        for (String studentInfo : students) {
            String[] fields = studentInfo.split(",");
            out.println("<tr><td>" + fields[0] + " " + fields[1] + "</td><td>" + fields[2] + "</td><td>" + fields[3] + "</td></tr>");
        }
        out.println("</table>");
        out.println("</div>");
        out.println("</main>");
        out.println("<br>");
        out.println("</body>");
        out.println("</html>");

        out.close();

        System.out.println("Get request students ");
    }
}

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

@WebServlet(urlPatterns = "/kurser")
public class CoursesServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

/*
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head><title>Student List</title></head>");
        out.println("<style>");
        out.println("table {border-collapse: collapse; width: 100%;}");
        out.println("td,\n" +
                "        th {\n" +
                "            border: 1px solid #000000;\n" +
                "            text-align: left;\n" +
                "            padding: 8px;\n" +
                "        }");
        out.println("</style>");
        out.println("<h2> Courses List </h2>");
        out.println("<div id=\"data-table\">");
        out.println("<table border=\"1\">");
        out.println("<tr><th>Name</th><th>YHP</th><th>Description</th><th>Lector</th></tr>");
        ArrayList<String> courses = MysqlConnector.courses();
        for(String coursesInfo : courses){
            String[] fields = coursesInfo.split(",");
            out.println("<tr><td>"+fields[0]+"</td><td>"+fields[1]+"</td><td>"+fields[2]+"</td><td>"+fields[3]+"</td></tr>");
        }
        out.println("</table>");
        out.println("</div>");
        out.println("<br>");
        out.println("</body>");
        out.println("<a href= http://localhost:9090/Attendance> Attendance</a>");
        out.println("<a href= http://localhost:9090/Students> Students</a>");
        out.println("</body>");
        out.println("</html>");
        System.out.println("Get request Kurser ");
        // super.doGet(req, resp);

 */

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head><title>Kurs List</title></head>");
        out.println("<style>");
        out.println("table { width: 70%; border-collapse: collapse; margin-bottom: 20px; }");
        out.println("th, td { border: 1px solid black; padding: 8px; text-align: left; }");
        out.println("</style>");
        out.println("<h2> Courses List </h2>");
        out.println("<table border=\"1\">");
        out.println("<tr><th>Name</th><th>YHP</th><th>info</th></tr>");
        ArrayList<String> courses = MysqlConnector.courses();
        for(String coursesInfo : courses){
            String[] fields = coursesInfo.split(",");
            out.println("<tr><td>"+fields[0]+"</td><td>"+fields[1]+"</td><td>"+fields[2]+"</td></tr>");
        }
        out.println("</table>");
        out.println("<br>");
        out.println("<a href= http://localhost:8080/narvaro> närvaro</a>");
        out.println("<a href= http://localhost:8080/Students> Students</a>");
        out.println("</body>");
        out.println("</html>");
    }
}

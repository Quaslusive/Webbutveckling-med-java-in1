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
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head><title>Courses List</title>");
        out.println("<link rel=stylesheet type=text/css href=styleCourses.css />");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2> Courses List </h2>");
        out.println("<div> id=data-table");
        out.println("<table border=1>");
        out.println("<tr><th>Name</th><th>YHP</th><th>Info</th></tr>");
        ArrayList<String> courses = MysqlConnector.courses();
        for(String coursesInfo : courses){
            String[] fields = coursesInfo.split(",");
            out.println("<tr><td>"+fields[0]+"</td><td>"+fields[1]+"</td><td>"+fields[2]+"</td></tr>");
        }
        out.println("</table>");
        out.println("</div>");
        out.println("<br>");
        out.println("<a href= \"kurser\">kurser</a>");
        out.println("<a href= \"studenter\">studenter</a>");
        out.println("</body>");
        out.println("</html>");
        out.close();

        System.out.println("Get request courses ");

    }
}

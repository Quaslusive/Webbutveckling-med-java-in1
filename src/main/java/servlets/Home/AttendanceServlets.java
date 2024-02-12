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

@WebServlet(urlPatterns = "/narvaro")
public class AttendanceServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head><title>Attendance Info List </title>");
        out.println("<link rel=stylesheet type=text/css href=style.css />");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Veporvere School of Crindge Awsomness </h1>");
        out.println("<h2> Attendance List </h2>");
        out.println("<div id=\"data-table\">");
        out.println("<table border=\"1\">");
        out.println("<tr><th>Name</th><th>Course</th></tr>");
        ArrayList<String> attendance = MysqlConnector.attendance();
        for(String attendanceInfo : attendance ){
            String[] fields = attendanceInfo.split(",");
            out.println("<tr><td>" + fields[0] + " " + fields[1] + "</td><td>" + fields[2] + "</td></tr>");
        }
        out.println("</table>");
        out.println("</div>");
        out.println("<br>");
        out.println("</body>");
        out.println("<a href= http://localhost:8080/kurser> Courses</a>");
        out.println("<a href= http://localhost:8080/Students> Students</a>");
        out.println("</body>");
        out.println("</html>");

        System.out.println("Get request Närvaro ");
        // super.doGet(req, resp);
    }
}

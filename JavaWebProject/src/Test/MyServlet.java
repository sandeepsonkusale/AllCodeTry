package Test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myservlet")
public class MyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	MConnector m = new MConnector();
    	
        String button = request.getParameter("button");

        if ("button1".equals(button)) {
        	m.call();
        } else if ("button2".equals(button)) {
        	m.call();
        } else if ("button3".equals(button)) {
        	m.call();
        } else {
            // ???
        }

        request.getRequestDispatcher("/WEB-INF/FirstJsp.jsp").forward(request, response);
    }

}
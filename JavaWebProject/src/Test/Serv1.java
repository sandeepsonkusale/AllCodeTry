package Test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello-world")
public class Serv1 extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, 
                  HttpServletResponse response) throws IOException {
		MConnector m = new MConnector();
		m.call();
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
   out.println("Hello World");
   out.flush();
  }
}
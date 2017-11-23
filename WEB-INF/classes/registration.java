import bean.student;
//import dao.studentdao;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/register")
public class registration extends HttpServlet
{
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String i = request.getParameter("id");
      String n = request.getParameter("name");
      String e = request.getParameter("email");
      String message = null;
      
      studentdao sd = new studentdao();
      int flag = sd.checkId(i);
      
      if(flag == 1)
      {
      
        student s = new bean.student();
        s.setId(i);
        s.setName(n);
        s.setEmail(e);
        s.setScore(0);
        
        sd.insertStudent(s);
        
        out.write(i+"-"+n);
        
        //request.setAttribute("id",i);
        //request.setAttribute("name",n);
        //RequestDispatcher rd = request.getRequestDispatcher("rules.jsp");
        //rd.forward(request,response);
      }
      
      else
      {
        out.write("exists");
        //message = "Invalid ID! ID already exists!";
        //request.setAttribute("error","message");
        //RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        //rd.forward(request,response);
        //out.println("<h1>Invalid ID! ID already exists!</h1><br><a href=\"index.jsp\">Back to Home Page</a>");
      }
      
      
      
  }
  
}
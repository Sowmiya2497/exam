import bean.student;
import bean.question;
//import dao.studentdao;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.*;

@WebServlet("/exam")
public class exam extends HttpServlet
{
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
      String id = request.getParameter("id");
      String name = request.getParameter("name");
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      questiondao qd = new questiondao();
      List<question> qlist = new ArrayList<question>();
      qlist = qd.getQuestions();
      request.setAttribute("id",id);
      request.setAttribute("name",name);
      request.setAttribute("qlist",qlist);
      RequestDispatcher rd = request.getRequestDispatcher("exam.jsp");
      rd.forward(request,response);
  }
}
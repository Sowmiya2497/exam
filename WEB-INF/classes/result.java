import bean.student;
import bean.question;
//import dao.studentdao;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.*;

@WebServlet("/score")
public class result extends HttpServlet
{
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
    /*String ans1 = request.getParameter("a1");
    String ans2 = request.getParameter("a2");
    String ans3 = request.getParameter("a3");
    String ans4 = request.getParameter("a4");
    String ans5 = request.getParameter("a5");*/
    String id = request.getParameter("studid");
    String name = request.getParameter("sname");
    PrintWriter out = response.getWriter();
    HashMap<Integer,String> hm=new HashMap<Integer,String>();
    hm.put(Integer.parseInt(request.getParameter("qno1")),request.getParameter("a1"));
    hm.put(Integer.parseInt(request.getParameter("qno2")),request.getParameter("a2"));
    hm.put(Integer.parseInt(request.getParameter("qno3")),request.getParameter("a3"));
    hm.put(Integer.parseInt(request.getParameter("qno4")),request.getParameter("a4"));
    hm.put(Integer.parseInt(request.getParameter("qno5")),request.getParameter("a5"));
    /*ArrayList<String> anslist = new ArrayList<String>();
    anslist.add(request.getParameter("a1"));
    anslist.add(request.getParameter("a2"));
    anslist.add(request.getParameter("a3"));
    anslist.add(request.getParameter("a4"));
    anslist.add(request.getParameter("a5"));*/
    studentdao sd = new studentdao();
    questiondao qd = new questiondao();
    int result = qd.getScore(hm);
    //studentdao sd = new studentdao();
    sd.updateScore(id,result);
    out.write(result+"-"+name+"-"+id);
    /*for(int i = 0;i<5;i++)
    {
      String ans = anslist.get(i);
      out.println("<p>"+ans);
    }
    request.setAttribute("result",result);
    RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
    rd.forward(request,response);*/
    
    
    
  }
 
   
  

}
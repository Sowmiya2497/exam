import bean.question;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.*;
import java.util.Collections;

public class questiondao
{
  public List<question> getQuestions()
  {
    final String Driver = "com.mysql.jdbc.Driver";
    final String DBUrl = "jdbc:mysql://localhost:3306/TEST";
    final String USER = "root";
    final String pass = "sowmiya";
    //question[] list = new question[5];
    List<question> list = new ArrayList<question>();
    //employees.add(new Employee());
    try{
      Class.forName(Driver);
      Connection conn = DriverManager.getConnection(DBUrl,USER,pass);
      Statement stmt = conn.createStatement();
      String sql = "SELECT * FROM QUESTION";
      ResultSet rs = stmt.executeQuery(sql);
      //int i = 0;
      while(rs.next())
      {
        question q = new question();
        q.setQno(rs.getString(1));
        q.setQues(rs.getString(2));
        q.setChA(rs.getString(3));
        q.setChB(rs.getString(4));
        q.setChC(rs.getString(5));
        q.setChD(rs.getString(6));
        //list[i] = q;
        //i++;
        list.add(q);
        }
    }
    
    catch(Exception e)
    {
      System.out.println(e);
    }
    
    int[] q_index = new int[5];
    
     ArrayList<Integer> list2 = new ArrayList<Integer>();
      for (int i=0; i<10; i++) {
          list2.add(new Integer(i));
      }
      Collections.shuffle(list2);
      for (int i=0; i<5; i++) {
          q_index[i] = list2.get(i);
      }
      
      List<question> qlist = new ArrayList<question>();
      for(int i = 0;i<5;i++)
      {
        qlist.add(list.get(q_index[i]));
      }
    
    
    return qlist;
  }
  
  public int getScore(HashMap<Integer,String> mp)
  {
    final String Driver = "com.mysql.jdbc.Driver";
    final String DBUrl = "jdbc:mysql://localhost:3306/TEST";
    final String USER = "root";
    final String pass = "sowmiya";
    int score = 0;
    try{
      Class.forName(Driver);
      Connection conn = DriverManager.getConnection(DBUrl,USER,pass);
      Statement stmt = conn.createStatement();
      Iterator it = mp.entrySet().iterator();
      while (it.hasNext()) {
      Map.Entry pair = (Map.Entry)it.next();
      String sql = "SELECT answer from question where qno="+pair.getKey();
      ResultSet rs = stmt.executeQuery(sql);
      int i = 0;
      if(rs.next())
      {
        String answer = rs.getString(1);
        if((pair.getValue()).equals(answer))
          score += 10;
        i++;
      }
    }
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
    
    return score;
  }
  
  
  
}
    
      
      
  
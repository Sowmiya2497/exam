import bean.student;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;


public class studentdao
{
  
  public int checkId(String id)
  {
    final String Driver = "com.mysql.jdbc.Driver";
    final String DBUrl = "jdbc:mysql://localhost:3306/TEST";
    final String USER = "root";
    final String pass = "sowmiya";
    int flag = 0;
    try{
      Class.forName(Driver);
      Connection conn = DriverManager.getConnection(DBUrl,USER,pass);
      Statement stmt = conn.createStatement();
      String query = "SELECT * FROM student WHERE id=\""+id+"\";";
      ResultSet rs = stmt.executeQuery(query);
      if(rs.next())
      {
        flag = 0;
      }
      
      else
      {
        flag = 1;
      }
      
      conn.close();
    }
    
    catch(Exception e)
    {
      System.out.println(e);
    }
    
    return flag;
    
  }

  public void insertStudent(student s)
  {
    String id = s.getId();
    String name = s.getName();
    String email = s.getEmail();
    int score = s.getScore();
    final String Driver = "com.mysql.jdbc.Driver";
    final String DBUrl = "jdbc:mysql://localhost:3306/TEST";
    final String USER = "root";
    final String pass = "sowmiya";
 
    try{
      Class.forName(Driver);
      Connection conn = DriverManager.getConnection(DBUrl,USER,pass);
      Statement stmt = conn.createStatement();
      String query = "INSERT INTO student(id,name,email,score) values(?,?,?,?)";
      PreparedStatement ps = conn.prepareStatement(query);
      ps.setString(1,id);
      ps.setString(2,name);
      ps.setString(3,email);
      ps.setInt(4,score);
      
      ps.execute();
      
      conn.close();
    }
    
    catch(Exception e)
    {
      System.out.println(e);
    }
    
   
    
  }
  
  public void updateScore(String id,int result)
  {
    final String Driver = "com.mysql.jdbc.Driver";
    final String DBUrl = "jdbc:mysql://localhost:3306/TEST";
    final String USER = "root";
    final String pass = "sowmiya";
    try{
      Class.forName(Driver);
      Connection conn = DriverManager.getConnection(DBUrl,USER,pass);
      Statement stmt = conn.createStatement();
      //String sql = "UPDATE student SET score="+result+" WHERE id = \""+id+"\";";
      String sql = "UPDATE student set score = ? where id = ?";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1,result);
      ps.setString(2,id);
      
      //stmt.executeQuery(sql);
      ps.execute();
    
  }
  
  catch(Exception e)
    {
      System.out.println(e);
    }
  }
  
  /*public int checkSubmission(String id)
  {
    final String Driver = "com.mysql.jdbc.Driver";
    final String DBUrl = "jdbc:mysql://localhost:3306/TEST";
    final String USER = "root";
    final String pass = "sowmiya";
    int flag = 0;
    try{
      Class.forName(Driver);
      Connection conn = DriverManager.getConnection(DBUrl,USER,pass);
      Statement stmt = conn.createStatement();
      String query = "SELECT has_sub FROM student WHERE id=\""+id+"\";";
      ResultSet rs = stmt.executeQuery(query);
      if(rs.next())
      {
        if((rs.getString(1)).contentEquals("submitted"))
          flag = 1;
        else
          flag = 0;
      }
      
      conn.close();
    }
    
    catch(Exception e)
    {
      System.out.println(e);
    }
    
    return flag;
    
  }*/
  
  
}
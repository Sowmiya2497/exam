package bean;
public class question
{
  public int qno;
  public String ques,chA,chB,chC,chD,ans;
  
  public void setQno(String q)
  {
	int no = Integer.parseInt(q);
    qno = no;
  }
  
  public void setQues(String q)
  {
    ques = q;
  }
  
  public void setChA(String a)
  {
    chA = a;
  }
  
  public void setChB(String b)
  {
    chB = b;
  }
  
  public void setChC(String c)
  {
    chC = c;
  }
  
  public void setChD(String d)
  {
    chD = d;
  }
  
  public void setAnswer(String an)
  {
    ans = an;
  }
  
  public String getQues()
  {
    return ques;
  }
  
  public int getQno()
  {
    return qno;
  }
  
  public String getChA()
  {
    return chA;
  }
  
  public String getChB()
  {
    return chB;
  }
  
  public String getChC()
  {
    return chC;
  }
  
  public String getChD()
  {
    return chD;
  }
  
  
  public String getAnswer()
  {
    return ans;
  }
  
}
  
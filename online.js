function submit_ans()
{
  var i,ans1,ans2,ans3,ans4,ans5,q1,q2,q3,q4,q5;
  var flag = 0;
  var id = document.getElementById('id').innerHTML;
  var name = document.getElementById('name').innerHTML;
  /*ans1 = document.querySelector('input[name=ans1]:checked').value;
  ans2 = document.querySelector('input[name=ans2]:checked').value;
  ans3 = document.querySelector('input[name=ans3]:checked').value;
  ans4 = document.querySelector('input[name=ans4]:checked').value;
  ans5 = document.querySelector('input[name=ans5]:checked').value;*/
  
  q1 = document.getElementById('qno1').value;
  q2 = document.getElementById('qno2').value;
  q3 = document.getElementById('qno3').value;
  q4 = document.getElementById('qno4').value;
  q5 = document.getElementById('qno5').value;
  
  
  if(document.getElementById('A1').checked)
    ans1 = document.getElementById('A1').value;
  else if(document.getElementById('B1').checked)
    ans1 = document.getElementById('B1').value;
  else if(document.getElementById('C1').checked)
    ans1 = document.getElementById('C1').value;
  else if(document.getElementById('D1').checked)
    ans1 = document.getElementById('D1').value;
  else
    flag = 1;
  
  if(document.getElementById('A2').checked)
    ans2 = document.getElementById('A2').value;
  else if(document.getElementById('B2').checked)
    ans2 = document.getElementById('B2').value;
  else if(document.getElementById('C2').checked)
    ans2 = document.getElementById('C2').value;
  else if(document.getElementById('D2').checked)
    ans2= document.getElementById('D2').value;
  else
    flag = 1;
  
  if(document.getElementById('A3').checked)
    ans3 = document.getElementById('A3').value;
  else if(document.getElementById('B3').checked)
    ans3 = document.getElementById('B3').value;
  else if(document.getElementById('C3').checked)
    ans3 = document.getElementById('C3').value;
  else if(document.getElementById('D3').checked)
    ans3 = document.getElementById('D3').value;
  else
    flag = 1;
  
  if(document.getElementById('A4').checked)
    ans4 = document.getElementById('A4').value;
  else if(document.getElementById('B4').checked)
    ans4 = document.getElementById('B4').value;
  else if(document.getElementById('C4').checked)
    ans4 = document.getElementById('C4').value;
  else if(document.getElementById('D4').checked)
    ans4 = document.getElementById('D4').value;
  else
    flag = 1;
  
  if(document.getElementById('A5').checked)
    ans5 = document.getElementById('A5').value;
  else if(document.getElementById('B5').checked)
    ans5 = document.getElementById('B5').value;
  else if(document.getElementById('C5').checked)
    ans5 = document.getElementById('C5').value;
  else if(document.getElementById('D5').checked)
    ans5 = document.getElementById('D5').value;
  else
    flag = 1;
  
  if(flag == 0)
  {
  
  var request = new XMLHttpRequest();
  request.onreadystatechange = function(){
    if(request.readyState==4 && request.status == 200)
    {
      var val=request.responseText;
      var word = new Array();
      word=val.split("-");
      window.location = 'result.jsp?score='+word[0]+"&name="+word[1]+"&id="+word[2];
      //document.getElementById('resp').innerHTML=val;
    }
    
  };
  var url="score?studid="+id+"&sname="+name+"&qno1="+q1+"&qno2="+q2+"&qno3="+q3+"&qno4="+q4+"&qno5="+q5+"&a1="+ans1+"&a2="+ans2+"&a3="+ans3+"&a4="+ans4+"&a5="+ans5;
	request.open("GET",url,true);
  request.send();
  }
  
  else
  {
    window.alert("Please answer all questions!!");
  }
}

var total_seconds=60*15;
var c_minutes=parseInt(total_seconds/60);
var c_seconds=parseInt(total_seconds%60);
function CheckTime()
{
	document.getElementById("quiz-time-left").innerHTML='Time Left: ' + c_minutes + ' : ' + c_seconds;
if(total_seconds <=0)
{
 setTimeout("submit_ans()",1);
}
else {
total_seconds=total_seconds-1;
c_minutes=parseInt(total_seconds/60);
c_seconds=parseInt(total_seconds%60);
setTimeout("CheckTime()",1000);
}}
setTimeout("CheckTime()",1000);
  
  
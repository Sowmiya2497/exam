<html>
<head>
<link rel="stylesheet" href="styles.css">
</head>
<body class="bd">
<div id = "dr">
<br>
<div style="background-color:#E5E7E9;height:100px;background: linear-gradient(to right,#808B96, #D7DBDD);"><h1>Aptitude Test</h1></div>
<br>

<form>
  <p class="iptext">Enter your name:</p> <br><input type ="text" name="name" id="t1" >
  <p class="iptext">Enter your student id:</p><br><input type ="text" name="id" id = "t2">
  <p class="iptext">Enter your email:</p> <br><input type ="text" name="email" id = "t3" ><br><br><br>
  <input type = "button" class = "b" value="REGISTER" onclick="return check()">
</form>
</div>
</body>
<script>

  function check()
  {
    var Name = document.getElementById("t1").value;
    var Id = document.getElementById("t2").value;
    var Email = document.getElementById("t3").value;
    if(Name == ""||Id == "" ||Email == "")
    {
      window.alert("Please enter valid details in all textfields!");
      return false;
    }
    
    var re = /\S+@\S+\.\S+/;
    var n = re.test(Email);
    if(!n)
    {
      window.alert("Invalid Email Address!");
      return false;
    }
    
    
    
    
    
    
    var request = new XMLHttpRequest();
    request.onreadystatechange = function(){
    if(request.readyState==4 && request.status == 200)
    {
      var val=request.responseText;
      var n = val.localeCompare("exists");
      if(n==0)
      {
        window.alert("Invalid ID!ID already exists!");
        location.reload(true);
      }
      else
      {
        var word = new Array();
        word = val.split("-");
        window.location = 'rules.jsp?id='+word[0]+"&name="+word[1];
      }
      
      
      //document.getElementById('resp').innerHTML=val;
    }
    };
    /*if(flag == 1)
      return(false);*/
    
    var url="register?id="+Id+"&name="+Name+"&email="+Email;
    request.open("GET",url,true);
    request.send();
   
   return(true);
    
  }

</script>
</html>
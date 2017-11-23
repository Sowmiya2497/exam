<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<body style = "background-color:#AED6F1";>
<head>
  <link rel="stylesheet" href="styles.css">
</head>

<div style = "font-family:Lucida Console, Monaco, monospace;color:#1B2631;">Welcome,<c:out value = "${param.name}"/></div><br>
<div id = "id" style = "font-family:Lucida Console, Monaco, monospace;color:#1B2631;">Your id is:<c:out value = "${param.id}"/></div> 

<h1>Instructions</h1>
<ul class = "rules">
  <li>Each question carries 10 marks.There are a total of 5 questions.</li>
  <li>Attend all the questions.</li>
  <li>Do not use unfair means to pass the test.</li>
  <li>Maintain silence during the test.</li>
</ul>
<form action ="exam" method ="GET">
  <input type = "hidden" name="id" value="${param.id}">
  <input type = "hidden" name="name" value="${param.name}">
  <input type ="submit" value ="START QUIZ!" class="b">
</form>

</body>
</html>
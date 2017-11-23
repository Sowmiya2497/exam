<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
<style>
  div{
    font-family:Lucida Console, Monaco, monospace;
    color:#E5E7E9;
    font-size:150%;
    margin-top:40px;
    text-align:center;
  }
  
  body
  {
    background-color:#AED6F1;
  }
  
  #d
  {
    position:relative;
    top:150px;
    left:10px;
    height:300px;
    width:500px;
    margin:auto;
    background-color:#34495E;
  }
  .b
  {
    color: white;
    padding: 15px 32px;
    text-align: center;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    background-color: #555555;
    position:relative;
    top:150px;
    left:570px;
    text-decoration:none;
  }
</style>
</head>
<body>
<div id = "d">
<br>
<div>Result:<c:out value="${param.score}"/></div>
<div>Name:<c:out value="${param.name}"/></div>
<div>ID:<c:out value="${param.id}"/></div>
</div>
<a href = "index.jsp" class = "b">Back to Home</a>
</body>
<script type="text/javascript" src="online.js"></script>
</html>
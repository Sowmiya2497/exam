<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
  <link rel="stylesheet" href="styles.css">
</head>
<body style = "background-color:#AED6F1";>

<div style = "font-family:Lucida Console, Monaco, monospace;color:#1B2631;">Student Name:</div><div id = "name" style = "font-family:Lucida Console, Monaco, monospace;color:#1B2631;"><c:out value = "${param.name}"/></div><br>
<div style = "font-family:Lucida Console, Monaco, monospace;color:#1B2631;">Student id:</div><div id="id" style = "font-family:Lucida Console, Monaco, monospace;color:#1B2631;"><c:out value = "${param.id}"/></div>
<div id = "quiz-time-left" style = "position:relative;left:800px;bottom:50px;font-family:Lucida Console, Monaco, monospace;color:#1B2631;" = "quiz-time-left"></div>
<c:set var="i" scope = "session" value="${1}"/>
<c:forEach var="row" items="${qlist}">

<br>
<br>
<br>

<div id = "question${i}" style = "font-family:Lucida Console, Monaco, monospace;color:#154360;font-size:200%;"><input type = "hidden" id = "qno${i}" value = "${row.qno}"><c:out value = "${i}"/>. <c:out value = "${row.ques}"/></div>
<div id = "options${i}" style = "font-family:Lucida Console, Monaco, monospace;color:#2874A6;height:100px;width:700px;font-size:150%;"><input type="radio" id="A${i}" name="ans${i}" value = "${row.chA}" required><c:out value = "${row.chA}"/>
<input type="radio" id="B${i}" name="ans${i}" value = "${row.chB}" required /><c:out value = "${row.chB}"/>
<input type="radio" id="C${i}" name="ans${i}" value = "${row.chC}" required /><c:out value = "${row.chC}"/>
<input type="radio" id="D${i}" name="ans${i}" value = "${row.chD}" required /><c:out value = "${row.chD}"/></div>
<c:set var="i" scope = "session" value="${i+1}"/>
</c:forEach>
<input type = "submit" value = "SUBMIT" onclick="submit_ans()" class="b" style = "margin-left:300px;">
<div id = "resp"></div>
</form>
</body>
<script type="text/javascript" src="online.js"></script>
</html>
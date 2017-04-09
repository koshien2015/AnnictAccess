<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>AnnictAccess</title>
<link rel="stylesheet" href="${f:url('/css/style.css') }" type="text/css" media="print, projection, screen"/>
<link href="${f:url('/css/bootstrap/bootstrap.min.css') }" rel="stylesheet">
<script src="${f:url('/js/jquery-latest.js')}" type="text/javascript"></script>
<script src="${f:url('/js/bootstrap/bootstrap.min.js')}" type="text/javascript"></script>
</head>
<body>
<h1>${username}さんのアニメ消化状況</h1>
<table border=1>
<tr>
<th>放送日時</th>
<th>作品名</th>
</tr>
<c:forEach var="programs" items="${resultDto.programs}">
<tr>
	<td><fmt:formatDate value="${programs.started_at}" pattern="MM/dd HH:mm" />～
	<br>
	<c:choose>
		<c:when test="${programs.dayDiff > 0}">(${programs.dayDiff}日遅れ)</c:when>
		<c:when test="${programs.dayDiff < 0}">(${programs.dayDiff * -1}日後)</c:when>
		<c:otherwise></c:otherwise>
	</c:choose></td>
	<td>${programs.work.title}
	<br>#${programs.episode.number} ${programs.episode.title}</td>

</tr>

</c:forEach>

</table>


</body>
</html>
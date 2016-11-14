<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>AnnictAccess</title>
</head>
<body>
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
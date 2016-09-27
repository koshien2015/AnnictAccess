<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Dolteng Auto Generated</title>
</head>
<body>
<table>

<c:forEach var="programs" items="${resultDto.programs}">
<tr>
	<td>${programs.work.title}</td>
	<td>#${programs.episode.number}</td>
	<td>${programs.episode.title}</td>
	<td><fmt:formatDate value="${programs.started_at}" pattern="yyyy年MM月dd日 HH:mm" /></td>
</tr>

</c:forEach>

</table>


</body>
</html>
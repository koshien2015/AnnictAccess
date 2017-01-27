<%@page pageEncoding="UTF-8"%>
<html>
<head>
	<script type="text/javascript" src="//d3js.org/d3.v3.min.js"></script>
	<script type="text/javascript" src="//cdn.jsdelivr.net/cal-heatmap/3.3.10/cal-heatmap.min.js"></script>
	<link rel="stylesheet" href="//cdn.jsdelivr.net/cal-heatmap/3.3.10/cal-heatmap.css" />
	<link rel="stylesheet" href="${f:url('/css/style.css') }" type="text/css" media="print, projection, screen"/>
	<link href="${f:url('/css/bootstrap/bootstrap.min.css') }" rel="stylesheet">
	<script src="${f:url('/js/jquery-latest.js')}" type="text/javascript"></script>
	<script src="${f:url('/js/bootstrap/bootstrap.min.js')}" type="text/javascript"></script>
</head>
<body>
<table border=1>
<tr>
<th>消化日時</th>
<th>作品名</th>
</tr>
<c:forEach var="list" items="${list}" begin="0" end="20">
<tr>
	<td>
		<fmt:formatDate value="${list.created_at}" pattern="yyyy/MM/dd HH:mm" />
	</td>
	<td>${list.work.title}
	<br>${list.episode.number} ${list.episode.title}</td>
</tr>
</c:forEach>

</table>
<br><br><br>
<div id="cal-heatmap">
<script>
		var startDate = new Date();
		startDate.setMonth(startDate.getMonth() -6);
		var parser = function(data) {
		    return eval("(" + data + ")");
		  };

		var cal = new CalHeatMap();
		cal.init({
			data: ${json2},
			//afterLoadData: parser,
			domain: 'month',
			subDomain: "day",
			dataType: "json",
			itemSelector: "#cal-heatmap",
			displayLegend: true,
			subDomain: "day",
			domainLabelFormat: "%b",
			legend: [1,2,3,5],
			start: startDate,
			itemName: ["record", "records"],
			legendColors: {
				min: "#EEEBF3",
				max: "#FF0000"
			},
		    tooltip: true,
		});
	</script>
</div>
</body>
</html>
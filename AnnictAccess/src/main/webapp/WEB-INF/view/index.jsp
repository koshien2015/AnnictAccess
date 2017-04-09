<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>AnnictAccess</title>
<link href="${f:url('/css/bootstrap/bootstrap.min.css') }" rel="stylesheet">
<script src="${f:url('/js/jquery-latest.js')}" type="text/javascript"></script>
<script src="${f:url('/js/bootstrap/bootstrap.min.js')}" type="text/javascript"></script>
<script src="${f:url('/js/highcharts.src.js')}" type="text/javascript"></script>
<script>
$(function(){
	$('#graph').highcharts({
		chart: {
			type: 'column',
		},
		title: {
			text: "アニメ未消化状況"
		},
		xAxis: {
			categories: [
				<c:forEach var="dateList" items="${dateList}">
							"${dateList}",
				</c:forEach>
				],
			labels: {
				style: {
					color: '#000000'
				}
			}
		},
		yAxis: {
			title: {
				text: null
			},
				labels: {
					style: {
						color: '#000000'
					}
				},
				floor: 0,
				allowDecimals:true,
				startOnTick: false
		},
		plotOptions: {
			line: {
				events: {
					legendItemClick: function () {
						return false;
					}
				}
			}
		},
		tooltip: {
			shared: true,
			pointFormat: '<span style="color:{series.color}">{series.name}: <b>{point.y}</b><br/>',
			backgroundColor: '#FFFFFF',
			style: {
				color: '#000000'
			}
		},
		series: [{
			name: '未消化数',
			data: [
				<c:forEach var="countList" items="${countList}" varStatus="i">
					<c:choose>
						<c:when test="${i.index==todayIndex}">{color:'#ff0000',y:${countList}},</c:when>
						<c:otherwise>${countList},</c:otherwise>
					</c:choose>
				</c:forEach>
			]
			}]
		});
	});
</script>
</head>
<body>
<h1>${username}さんのアニメ未消化状況</h1>
<div id="graph"></div>
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
	<td><a href="https://annict.com/works/${programs.work.id}" target=_blank>${programs.work.title}</a>
	<br><a href="https://annict.com/works/${programs.work.id}/episodes/${programs.episode.id}" target=_blank>#${programs.episode.number} ${programs.episode.title}</a></td>

</tr>

</c:forEach>

</table>


</body>
</html>
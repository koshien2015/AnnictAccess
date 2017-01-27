<%@page pageEncoding="UTF-8"%>
<html>
<head>
	<script type="text/javascript" src="//d3js.org/d3.v3.min.js"></script>
	<script type="text/javascript" src="//cdn.jsdelivr.net/cal-heatmap/3.3.10/cal-heatmap.min.js"></script>
	<link rel="stylesheet" href="//cdn.jsdelivr.net/cal-heatmap/3.3.10/cal-heatmap.css" />
</head>
<body>
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
			legend: [1,3,5,7],
			start: startDate,
			itemName: ["record", "records"],
		    //range: 13,
		    tooltip: true,
		});
	</script>
</div>
</body>
</html>
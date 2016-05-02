<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@page contentType="text/html;charset=UTF-8"%>
	<meta charset="utf-8" />
	<script src="<c:url value="/resources/3party/js/jquery-2.1.3.min.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/3party/js/jquery-ui.min.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/3party/js/grid.locale-ru.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/3party/js/jquery.jqGrid.min.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/dataview.js"/>" type="text/javascript"></script>

	<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/3party/css/jquery-ui.min.css"/>"/>
	<link rel="stylesheet" type="text/css" media="screen"href="<c:url value="/resources/3party/css/ui.jqgrid.css"/>"/>
	<link rel="stylesheet" type="text/css" media="screen"href="<c:url value="/resources/3party/css/jquery-ui.theme.min.css"/>"/>
	<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/common.css"/>" />
	<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/3party/css/pure-min.css"/>" />

<title></title>

</head>
<body>
	<div class="line-container">
		<%@include file="menu.jsp" %>
		<div style="width: 100%; margin: 12px">
			<legend class="legend">Просмотр:</legend>
			<table id="jqGrid"></table>
			<div id="jqGridPager"></div>	
		</div>
    </div>
</body>
</html>


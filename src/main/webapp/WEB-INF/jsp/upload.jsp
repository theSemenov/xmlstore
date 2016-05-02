<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@page contentType="text/html;charset=UTF-8"%>
	<meta charset="utf-8" />
	<!-- script src="<c:url value="/resources/3party/js/jquery-ui.min.js"/>" type="text/javascript"></script-->
	<script src="<c:url value="/resources/3party/js/jquery-2.1.3.min.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/3party/js/jquery.form.js"/>" type="text/javascript"></script>
	
	
	<script src="<c:url value="/resources/js/upload.js"/>" type="text/javascript"></script>
	
	<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/3party/css/pure-min.css"/>" />
	<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/upload.css"/>" />
	<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/common.css"/>" />
	
	<title></title>
</head>
<body>
	<div class="line-container">
		<%@include file="menu.jsp" %>
		<div>
			<form id="send-form" class="pure-form"
				action=${requestScope['javax.servlet.forward.request_uri']}
				enctype="multipart/form-data" method="post">
				<fieldset>
					<legend>Загрузить:</legend>
					<input id="uploadFile" placeholder="Выберите файл:" disabled="disabled"/>
					<div class="fileUpload pure-button">
		    			<span>Upload</span>
		    			<input type="file" id="uploadBtn" class="upload" name="datafile"/>
					</div>
					<label></label>
					<button class="pure-button pure-button-primary" id="saveBtn" disabled="disabled" type="submit">Сохранить</button>
				</fieldset>
			</form>
			<div id="upload-result"></div>
		</div>	
	</div>
</body>
</html>


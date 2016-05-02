<%@page import="org.xmlstore.model.PropHolder"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%
String pageId = (String)request.getAttribute("pageId");
%>
<jsp:useBean id="menu" scope="page" class="org.xmlstore.page.MenuHelper">
	<jsp:setProperty name="menu" property="menuItemId"
                    value="<%=pageId%>"/>
</jsp:useBean>

<div class="menu pure-menu pure-menu-open">
	<a class="pure-menu-heading">XML Store</a>

	<ul>
		<li class=<%=menu.getStyle(PropHolder.PAGE_UPLOAD_VAL) %>><a href="./upload">Загрузить</a></li>
		<li class=<%=menu.getStyle(PropHolder.PAGE_VIEW_VAL) %>><a href="./view">Просмотр</a></li>
		<li class=<%=menu.getStyle(PropHolder.PAGE_DOWNLOAD_VAL) %>><a href="./download">Скачать</a></li>
	</ul>
	
</div>
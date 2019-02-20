<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!-- 引入jstl core库 ，使用 循环标签-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 引入jstl fmt库，格式化时间标签 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- 开启 EL 表达式支持 -->
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <jsp:include page="/WEB-INF/views/share/header.jsp"></jsp:include>
    
    <title>Hello World!</title>
</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <jsp:include page="/WEB-INF/views/share/navigation.jsp"></jsp:include>

        <!-- page content -->
        <div class="right_col" role="main">
            <form method="POST" action="/file/upload" enctype="multipart/form-data">
                File to upload: <input type="file" name="file">
                <input type="submit" value="Upload"> Press here to upload the file!
            </form>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <jsp:include page="/WEB-INF/views/share/footer.jsp"></jsp:include>
        <!-- /footer content -->
    </div>
</div>
<jsp:include page="/WEB-INF/views/share/script.jsp"></jsp:include>
</body>
</html>

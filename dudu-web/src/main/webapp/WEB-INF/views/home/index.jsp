<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!-- 引入jstl core库 ，使用 循环标签-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 引入jstl fmt库，格式化时间标签 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- 开启 EL 表达式支持 -->
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h2>Hello World!</h2>
<a href="/home/paramByServletRequest?paramByServletRequest=123">paramByServletRequest</a><br/>

<h5>新增数据</h5>
<table>
    <form action="/home/add">
    <tr>
        <td>code</td>
        <td><input name="code"/></td>
    </tr>
    <tr>
        <td>name</td>
        <td><input name="name"/></td>
    </tr>
    <tr>
        <td>age</td>
        <td><input name="age"/></td>
    </tr>
    <tr>
        <td></td>
        <td><input type="submit" value="add"></td>
    </tr>
    </form>
</table>

<table>
    <tr>
        <td>code</td>
        <td>name</td>
        <td>age</td>
    </tr>
<c:forEach var="x" items="${list}">
    <tr>
        <td><a href="/home/delete?code=${x.code}"> ${x.code}</a></td>
        <td>${x.name }</td>
        <td>${x.age }</td>
    </tr>
</c:forEach>
</table>

</body>
</html>

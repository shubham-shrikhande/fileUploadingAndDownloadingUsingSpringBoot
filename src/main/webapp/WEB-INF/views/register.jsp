<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<div align="center">
   <form:form action="result" enctype="multipart/form-data" modelAttribute="model" method="POST">
     <table>
        <tr>
           <td>Name::</td>
           <td><form:input path="appName"/></td>
        </tr>  
        <tr>
           <td>Select Resume::</td>
           <td><form:input path="appResume" type="file"/></td>
        </tr>  
        <tr>
           <td>Select Photo::</td>
           <td><form:input path="appPhoto" type="file"/></td>
        </tr>  
        <tr>
           <td><input type="submit"/></td>
        </tr>  
     </table>
     
   </form:form>
</div>
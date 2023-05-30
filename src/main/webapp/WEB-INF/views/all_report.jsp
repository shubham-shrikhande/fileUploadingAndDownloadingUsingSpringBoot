<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body bgcolor="biege">
	<div align="center">
		<table>
				<tr>
					<td>Id</td>
					<td>Name</td>
					<td>Resume</td>
					<td>Photo</td>
				</tr>
				<c:choose>
				<c:when test="${!empty applicant  }">
					<c:forEach var="appli" items="${applicant}">

						<tr>
							<td>${appli.id }</td>
							<td>${appli.name }</td>
							<td><a href="download?id=${appli.id }&type='resume'">Download</a></td>
							<td><a href="download?id=${appli.id }&type='photo'">Download</a></td>
						</tr>

					</c:forEach>

				</c:when>
			</c:choose>
		</table>
	</div>
</body>
</html>
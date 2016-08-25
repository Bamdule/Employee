<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회사 프로젝트 리스트</title>

<script type="text/javascript" src="/project/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		<jsp:include page="../../js/header.js"></jsp:include>
		$("#search").css("width","100px");
		
		$("#project_write").click(function(){
			$(location).attr("href","/project/jsp/company/projectWrite.jsp")
		});
	});
</script>

<link type="text/css" rel="stylesheet" href="../../css/common.css"  ></link>
<style type="text/css">

#main .top{height:10%;}
#main .middle{height:80%;}
#main .bottom{height:10%;}


#main .top .title{line-height: 80px;}

#main .middle .search {height:20%; text-align: center;}
#main .middle .list {height:80%;}
#main .middle .search strong{display: inline-block; width: 70px;}
#main .bottom .navi{height:50%; text-align: center;}
#main .bottom .addbtn{height:50%; text-align: right; padding-top:20px;}
.navi strong { width:30px; display: inline-block;}


#main td {border: 1px solid #D5D5D5;}
#main table {width: 100%; height: 100%; border-collapse: collapse; text-align: center;}
#main th { background-color: #E4F7BA; border: 1px solid #D5D5D5;}

</style>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>


	<div id="main">
		<div class="container">
			<div class="top">
				<div class="title">
					<h2>회사 프로젝트</h2>
				</div>
			</div>
			<div class="middle">
			<div class="search">
				<table>
					<tr>
						<th><strong>ID</strong></th>
						<td><input type="text" name="projectid" style="width: 100%;height: 100%; border: none;"/></td>
						<th>등록일</th>
						<td>
						  <input type="text" name="beforedate"/> ~ 
						  <input type="text" name="afterdate"/>
						</td>
					</tr>
					<tr>
						<th>프로젝트 명</th>
						<td colspan="3"><input type="text" name="projectname" style="width: 100%;height: 100%; border: none;"/></td>
						
					</tr>
					<tr>
						<td colspan="4" style="border: none;">
							<input type="button" value="조회" id="search"/>
						</td>
					</tr>
				</table>
			</div>
		
			<div class="list">
				<table>
					<tr>
						<th style="width:10%">번호</th>
						<th style="width:10%">ID</th>
						<th style="width:60%">프로젝트명</th>
						<th style="width:20%">등록일</th>
					</tr>
					<c:forEach begin="1" end="15" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>ID${status.count}</td>
						<td><a href="projectDetail.jsp">프로젝트 ${status.count}</a></td>
						<td>2016-04-12</td>
					</tr>
					</c:forEach>
					
				</table>
			</div>
			</div>
			<div class="bottom">
				<div class="addbtn">
					<input type="button" value="프로젝트 등록" id="project_write"/>
				</div>
				<div class="navi">
					<p><strong>1</strong><strong>2</strong><strong>3</strong><strong>4</strong><strong>5</strong><strong>6</strong></p>
				</div>
			</div>
		</div>
	</div>

<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항</title>

<script type="text/javascript" src="/project/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">

$(function(){	
	<jsp:include page="../../js/header.js"></jsp:include>
	$(".notice_list th").each(function(i,k){
		switch(i)
		{
		case 0:
			$(k).css("width","100px");
			break;
		case 1:
			$(k).css("width","600px");
			break;
		case 2:
			$(k).css("width","100px");
			break;
		case 3:
			$(k).css("width","100px");
			break;
		case 4:
			$(k).css("width","100px");
			break;
		}
	});
});
</script>
<link type="text/css" rel="stylesheet" href="../../css/common.css"  ></link>
<style type="text/css">
	#main .top{width:100%; height:10%;}
	#main .middle{width:100%; height:80%;}
	#main .bottom{width:100%; height:10%;}
	
	
	.notice_btn {height:33%; text-align: right;}
	.notice_number_navi {height:33%; text-align: center;}
	.notice_number_navi strong{width:30px; display: inline-block;} 
	.notice_search {height:33%; text-align: center;}
	
	.middle table{width:100%; height:100%;border-collapse:collapse;}
	.middle tr{height:30px; text-align: center;}
	.middle td{border:1px solid #eee;}
	.middle th{background-color: #E4F7BA; border:1px solid black;}
	
	

</style>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
	<div id="main">
	    <div class="container">
	      <div class="top">
	        <div class="title">
		      <h2>공지사항</h2>
		      <hr>
		    </div>
		  </div>
		  <div class="middle">
		  <table>
		    <tr><th>번호</th>  <th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th></tr>
	        <c:forEach varStatus="status" begin="1" end="15">
		      <tr>
		        <td style="width:10%;">${status.count}</td>
	            <td style="width:60%;"><a href="noticeDetail.jsp">제목${status.count}</a></td>
		        <td style="width:10%;">작성자${status.count}</td>
		        <td style="width:10%;">작성일${status.count}</td>
		        <td style="width:10%;">0</td>
	  	      </tr>
		    </c:forEach>
		  </table>
		  </div>
		  <div class="bottom">
			  <div class="notice_btn">
				  <hr>
				  <form action="noticeWrite.jsp">
					  <input type="submit"value="글쓰기"/>
				  </form>
			  </div>
			  <div class="notice_number_navi">
		    	  <p> <strong>1</strong><strong>2</strong><strong>3</strong><strong>4</strong><strong>5</strong><strong>6</strong><strong>7</strong><p>
		      </div>
			  <div class="notice_search">
				  <form action="#" method="get">
				      <select id="search_option" name="search_option">
					      <option value="0">제목</option>
						  <option value="1">내용</option>
						  <option value="2">글작성자</option>
						  <option value="3">댓글내용</option>
						  <option value="4">댓글작성자</option>
					  </select>
					  <input type="text" id="search_txt" name="search_txt"/>
				      <input type="submit" value="검색"/>
				  </form>
			  </div>
	    </div>
	    </div>
	  </div>	  
	<jsp:include page="/footer.jsp"></jsp:include>
</body>

</html>
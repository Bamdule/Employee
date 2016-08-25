<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 상세화면</title>

<script type="text/javascript" src="/project/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		<jsp:include page="../../js/header.js"></jsp:include>
		$("#golist").css("width","100px");
		$("#golist").click(function(){
			$(location).attr("href","/project/jsp/company/noticeList.jsp")
		});
	});
</script>
<link type="text/css" rel="stylesheet" href="../../css/common.css"  ></link>
<style type="text/css">

#main .top{height:10%;}
#main .middle{height:80%;}
#main .bottom{height:10%;}
#main .top h2 {line-height: 80px;}

#main .middle .notice{}

.notice table{width:100%; border-collapse:collapse;}
.notice tr{width:100%; height:40px;}
.notice td{text-align: center; border:1px solid #eee; }
.notice th{width:100px;text-align: center; border:1px solid #eee;background-color:#E4F7BA; }
.notice textarea{border:0;}

#bottom button {}
</style>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
<div id="main">
	<div class="container">
		<div class="top">
		<h2>공지사항 상세</h2>
		</div>
		<div class="middle">
		  <div class="notice">
		    <table>
		      <tr>
		        <th>제목</th>
		        <td></td>
		        <th>조회수</th>
		        <td width="100px"></td>
		      </tr>
		       <tr>
		        <th>작성자</th>
		        <td></td>
		        <th>작성일</th>
		        <td width="150px"></td>
		      </tr>
		      <tr>
		        <td colspan="4">
		          <textarea rows="25" cols="145"></textarea>
		        </td>
		      </tr>
		    </table>
		  </div>
	
		</div>
		<div class="bottom" style="text-align: right;">
			<button  id="golist">목록</button>
			<button style="width:100px; display: none;">수정</button>
		</div>
	</div>
</div>
<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>
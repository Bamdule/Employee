<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script>
	$(function() {
		window.scroll(0, 200);
		$(".notice_list th").each(function(i, k) {
			switch (i) {
			case 0:
				$(k).css("width", "10%");
				break;
			case 1:
				$(k).css("width", "40%");
				break;
			case 2:
				$(k).css("width", "10%");
				break;
			case 3:
				$(k).css("width", "20%");
				break;
			case 4:
				$(k).css("width", "20%");
				break;
			}
		});

		/* $(".notice .noticeRow").click(function() {
			//선택한 유저의 id를 히든 값에 넣어서 보낸다.
			alert(message)
			$("#notice_id").val($(this).children().eq(1).text());
			$("#frm").submit();
		}); */

		$(".noticeRow").hover(function() {
			$(this).css("background-color", "#eee");
		}, function() {

			$(this).css("background-color", "white");
		});
	});
</script>
<script type="text/javascript" src="js/header.js"></script>
<link type="text/css" rel="stylesheet" href="css/common.css"></link>
<link type="text/css" rel="stylesheet" href="css/header.css"></link>
<style type="text/css">
.black {
	height: 10%;
}

.notice {
	height: 90%;
}

.notice th {
	height: 25px;
	background-color: #F6F6F6;
	font-weight: bold;
}

.notice td {
	height: 35px;
	border-bottom: 1px solid #eee;
}

.notice tr {
	text-align: center;
}

form {
	height: 100%;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin: 0 auto;
}
.bottom .btnArea{ height:33%; text-align: right;}
.btnArea input {width : 100px;}
.bottom .pageBlock{height:33%; text-align: center;}
.bottom .searchArea{height:33%; text-align: center;}


</style>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<div id="main">
		<div class="container">
			<form action="#" method="post" id="frm">
				<!-- <input type="hidden" name="command" value="notice_info">
				<input type="hidden" name="notice_id" >
				 -->
				 <div class="top">
					<div class="title">
						<h2>공지사항</h2>
						<hr>
					</div>
				</div>
				<div class="middle">
					<div class="black"></div>
					<div class="notice">
						<table>
							<thead class="notice_list">
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>작성자</th>
									<th>작성일자</th>
									<th>조회수</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${paging.isEmpty !=0}">
								<c:forEach var="notice" items="${noticeList}">
									<tr class="noticeRow">
										<td>${notice.seq }</td>
										<td><a href="NoticeServlet?command=notice_info&notice_id=${notice.notice_id }">${notice.notice_title }</a></td>
										<td><a href="NoticeServlet?command=notice_info&notice_id=${notice.notice_id }">${notice.emp_name }</a></td>
										<td>${notice.register_dt }</td>
										<td>${notice.readcount }</td>
									</tr>
								</c:forEach>
								</c:if>
								<c:if test="${paging.isEmpty == 0}">
									<tr>
										<td colspan="5">공지사항이 없습니다.</td>
									</tr>
								</c:if>
							</tbody>
						</table>
					</div>
				</div>

				<div class="bottom">
					<div class="btnArea">
					
						<c:if test="${sessionScope.isManager==true}">
						<a href="NoticeServlet?command=notice_addform"><input type="button" value="글 쓰기"></a>
						</c:if>
					</div>
					<div class="pageBlock">
						<p>
							<c:if test="${paging.prevPage !=0 }">
								<strong>
								<a href="NoticeServlet?command=notice_list&curPage=${paging.prevPage}">[<]</a></strong>
							</c:if>
							<c:forEach var="block" begin="${paging.firstBlock}"
								end="${paging.lastBlock }">
								<strong><a href="NoticeServlet?command=notice_list&curPage=${block}">${block}</a></strong>
							</c:forEach>
							<c:if test="${paging.nextPage !=0 }">
								<strong><a href="NoticeServlet?command=notice_list&curPage=${paging.nextPage}">[>]</a></strong>
							</c:if>
						</p>
					</div>
					<div class="searchArea">
						<p>
							<input type="text">
						</p>
					</div>
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>
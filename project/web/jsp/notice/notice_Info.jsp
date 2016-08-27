<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/header.js"></script>
<script type="text/javascript">
	$(function(){

	});
	function replyAdd(){
		var reply =$("#reply_inputform");
		if(reply.val().length>1){
			
			var replyJson= new Object();
			replyJson.notice_id = ${notice.notice_id};
			replyJson.emp_id=${notice.emp_id};
			replyJson.reply_content=reply.val();
			//jsonStr=JSON.stringify(replyJson);
			//alert(jsonStr);
			
			$.ajax({
				url: "NoticeServlet?command=notice_replyadd"
					  , type:"post"
					  , data:replyJson
					  , datatype : "json"
					  , success:function(result){
						  $(".replyArea").html("");
						  for(var index=0;index<result.length;index++)
					      {
							  var replyStrArray = JSON.stringify(result[index]);
							  
							 // alert(replyStrArray);
							  var replyStr=JSON.parse(replyStrArray);
							 // alert(replyStr.reply_content);
								$(".replyArea").append(
										"<div class='reply'>"+
											"<div class='reply_img'></div>"
										   +"<div class='reply_delete'>"
										        +"<span>삭제</span>"
										   +"</div>"
										   +"<div class='reply_top'>"
										   		+"<b>"+replyStr.emp_name+"</b><span>"+replyStr.register_dt+"</span>"
										   +"</div>"
										   +"<div class='reply_bottom'>"
										  		 +"<p>"+replyStr.reply_content+"</p></div>"
										   +"</div>"
								);
								reply.val("");
								$('html, body').scrollTop(document.body.scrollHeight);
							  
							  
							  
					      }
						  
					  }
			}); 
				
		}
		else{
			alert('댓글을 한 글자 이상 써주세요!');
		}
	}

</script>
<link type="text/css" rel="stylesheet" href="css/common.css"></link>
<link type="text/css" rel="stylesheet" href="css/header.css"></link>
<style type="text/css">
.btnArea {
	text-align: right;margin-top: 30px;
}
#main {height: auto;}
#main .middle{height: auto;}
.btnArea input {
	width: 100px;
}

.middle .noticeArea {
	
	text-align: center;
}

.noticeArea table {
	border-collapse: collapse;
}

.noticeArea tr {
	height: 35px;
}

.noticeArea th {
	background-color: #eee;
}

.noticeArea td {
	border: 1px solid #eee;
}

.noticeArea textarea {
	resize: none;
	outline: none;
}
.middle .replyArea {
	height: 20%;
	margin-bottom: 30px; background-color: #F9F9F9;
}

.reply_inputArea {height:100px;width:100%; line-height:50px; margin-top: 20px; }

.replyArea .reply_contentArea{}

.replyArea .reply{height:70px; width:100%; margin-top: 10px;}

.reply .reply_img {width:1%; height:100%; float: left; }
.reply .reply_top {width:94%; height:50%; float: right; line-height: 35px;}
.reply .reply_bottom {width:94%; height:50%;  float: right; line-height: 35px; border-bottom:1px dotted #BDBDBD; }
.reply .reply_delete {width:5%;height:100%; float: right; font-size: 10px; line-height: 30px;border-bottom:1px dotted #BDBDBD; }
.reply_top span {margin-left:8px;font-size: 10px;}
.reply_bottom p {font-size: 13px;}

.reply_inputArea .reply_input {width:90%;height:100%;float:left; }
.reply_input textarea {resize:none;}
.reply_inputArea .reply_send{width:10%;height:100%;float:right; }
.reply_send input { width:80px;}

</style>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<div id="main">
		<div class="container">
			<div class="top">
				<div class="title">
					<h2>공지사항 내용</h2>
				</div>
			</div>

			<div class="middle">
				<div class="noticeArea">
					<table class="notice">
						<tr>
							<th>작성자</th>
							<td>${notice.emp_name}</td>

							<th>작성일</th>
							<td>${notice.register_dt }</td>
							<th>조회수</th>
							<td>${notice.readcount }</td>
						</tr>
						<tr>
							<th>제목</th>
							<td colspan="5">${notice.notice_title}</td>

						</tr>
						<tr>
							<td colspan="6"><textarea cols="145" rows="20"
									readonly="readonly">${notice.notice_content }</textarea></td>
						</tr>
					</table>
				</div>
		
				<div class="replyArea">
					<c:forEach var="reply" items="${replyList}">
					 <div class="reply">
						<div class="reply_img">
						</div>
						<div class="reply_delete">
							<span>삭제</span>
						</div>
						<div class="reply_top">
							<b>${reply.emp_name }</b>
							<span>${reply.register_dt }</span>
						</div>
						<div class="reply_bottom">
							<p>${reply.reply_content }</p>
						</div>
					</div>	
				
 					</c:forEach>
					
				</div> <!--replyArea End-->
				<div class="reply_inputArea">
						<div class="reply_input">
							<textarea rows="3" cols="130" id="reply_inputform"></textarea>
						</div>
						<div class="reply_send">
							<input type="button" value="댓글입력" onclick="replyAdd();">
						</div>
					</div>
				
				
			</div>
			<div class="bottom">
				<div class="btnArea">
					<input type="submit" value="수정"
						onclick="location.href='NoticeServlet?command=notice_updateform&notice_id=${notice.notice_id}';">
					<input type="button" value="삭제"> 
					<input type="button" value="목록"
						onclick="location.href='NoticeServlet?command=notice_list';">
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>
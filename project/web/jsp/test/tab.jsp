<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Tabs - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#tabs" ).tabs();
  } );
  </script>
</head>
<body>
 
<div id="tabs">
  <ul>
    <li><a href="#tabs-1">자격증</a></li>
    <li><a href="#tabs-2">학력사항</a></li>
    <li><a href="#tabs-3">경력사항</a></li>
  </ul>
  <div id="tabs-1">
  <p>tab1</p>
  </div>
  <div id="tabs-2">
  <p>tab2</p>
  </div>
  <div id="tabs-3">
  <p>tab3	</p>
  </div>
</div>
 
 
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<%
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
	
		if (id == null) {
	%>
		<jsp:forward page="login.jsp" />
	<%
		} else {
			session.setAttribute("uid", id);
		}
	%>
	<div>
		사용자 아이디 : <%= id %>
	</div>
	<div>
		<input type="text" id="messageinput" />
	</div>
	<div>
		<button type="button" onclick="openSocket();">Open</button>
		<button type="button" onclick="send();">Send</button>
		<button type="button" onclick="closeSocket();">Close</button>
	</div>
	<!-- Server responses get written here -->
	<div id="messages"></div>
	
	<!-- Script to utilise the WebSocket -->
	<script type="text/javascript">
		var webSocket;
		var messages = document.getElementById("messages");
		
		function openSocket() {
			// Ensures only one connection is open at a time
			if (webSocket !== undefined && webSocket.readyState !== WebSocket.CLOSED) {
				writeResponse("WebSocket is already opened.");
				return;
				
			}
			
			// Create a new instance of the websocket
			// webSocket = new WebSocket("ws://localhost/ *ProjectName* /echo");
			// 나중에 localhost를 도메인 이름으로 바꾸기
			webSocket = new WebSocket("ws://localhost:8081/WebSockets/websocketendpoint2");
			
			/**
			* Binds functions to the listeners for the websocket.
			*/
			webSocket.onopen = function(event) {
				// For reasons I can't determine, onopen gets called twice
				// and the first time event.data is undefined.
				// Leave a comment if you know the answer.
				if (event.data === undefined)
					return;
				
				// event.data말고 원하는 것을 적어도 됨.
				writeResponse(event.data);
			};
			// 서버로부터 메세지가 왔을때 -> onmessage
			webSocket.onmessage = function(event) {
				writeResponse(event.data);
			};
			
			webSocket.onclose = function(event) {
				writeResponse("Connection closed");
			};
		}
		
		/**
		* Sends the value of the text input to the server
		*/
		function send() {
			var id = "<%= id%>";
			var text = document.getElementById("messageinput").value;
			webSocket.send(id + "|" + text);
		}
		
		function closeSocket() {
			webSocket.close();
		}
		
		function writeResponse(text) {
			// 기존에 있는 것에다 더해서 쓰는 것.
			messages.innerHTML += "<br/>" + text;
		}
	</script>
	
</body>
</html>
package bgm.bgmaster.ex;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@RequestMapping("/echo")
public class EchoHandler extends TextWebSocketHandler{
	 //세션 리스트
    private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();

    private static Logger logger = LoggerFactory.getLogger(EchoHandler.class);
    

    //클라이언트가 연결 되었을 때 실행
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessionList.add(session);
        logger.info("{} 연결됨", session.getId()); 
        logger.info("sessionLIst:{}", sessionList); 
        System.out.println("sessionList:"+sessionList);
        System.out.println("sessionList[0]:"+sessionList.get(0));
        System.out.println("sessionList3333:"+session.getAttributes().get("userid"));
        
        String userid = (String)session.getAttributes().get("userid");  
        logger.info("!!!userid: {}", userid); 
        
        if(userid != null) {	// null님이 입장하셨습니다! 를 방지하기위해..
    	// 모든 세션에 채팅 전달(접속한 유저의 아이디를 화면에 띄움->HttpSession의 로그인 정보를 가져옴)
		for (int i = 0; i < sessionList.size(); i++) {
			WebSocketSession s = sessionList.get(i);
			//s.sendMessage(new TextMessage("["+session.getId() + "님이 입장 했습니다.]"));
			s.sendMessage(new TextMessage("["+session.getAttributes().get("userid") + "님이 입장 했습니다.]"));
			
			}
		}
    }

    //클라이언트가 웹소켓 서버로 메시지를 전송했을 때 실행
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        logger.info("{}로 부터 {} 받음", session.getId(), message.getPayload());
        //모든 유저에게 메세지 출력
        for(WebSocketSession sess : sessionList){
            sess.sendMessage(new TextMessage(message.getPayload()));
        }
    }

    //클라이언트 연결을 끊었을 때 실행
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessionList.remove(session);
        logger.info("{} 연결 끊김.", session.getId());
        
    	// 모든 세션에 채팅 전달
		for (int i = 0; i < sessionList.size(); i++) {
			WebSocketSession s = sessionList.get(i);
			s.sendMessage(new TextMessage("["+session.getAttributes().get("userid") + "님이 퇴장 했습니다.]"));
		}
    }
}

package bgm.bgmaster.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WaringSocketServer extends HttpServlet implements Runnable{

	private static final Logger logger = LoggerFactory.getLogger(WaringSocketServer.class);
	private Thread deamon;
	
	public void init() throws ServletException{
		
		deamon= new Thread(this); // deamon.setPriority(Thread.MIN_PRIORITY);
		deamon.start();
	}
	public void destroy() {
		deamon.interrupt();
	}
	public void run() {
		try {
			logger.info("========================");
			logger.info("WaringSocketServer RUN");
			logger.info("========================");
			warningInit();
		}catch (Exception e) {
			logger.info("ServerSocket failed : "+e.getMessage());
			return;
		}
	}
	public void warningInit() {
		try {
			ServerSocket warningServer = new ServerSocket(8081);
			while(true) {
				try {
					logger.info("Traffic Client Request Waiting!");
					Socket warningSocket = warningServer.accept();	//클라이언트 접속떄까지 대기
					
					logger.info("Traffic Socket Client Access IP: "+warningSocket.getInetAddress());
					
					BufferedReader in = new BufferedReader(new InputStreamReader(warningSocket.getInputStream()));
					PrintWriter out = new PrintWriter(new OutputStreamWriter(warningSocket.getOutputStream()));
					
					//클라이언트 소켓으로부터 받은 메시지를 화면에 출력
					String reqMsg = in.readLine();
					//System.out.println("클라이언트로 부터 받은 메시지:"+in.readLine());
					logger.info("Client Request Message : "+ reqMsg);
					
					//클라이언트 소켓에 메시지전송
					//out,println(reqMsg);
					//out.flush();
					
					warningSocket.close();
				}catch (IOException ie) {
					ie.printStackTrace();
				}
			}
		}catch (MalformedURLException e) {
			logger.info(e.toString());
		}catch(IOException e) {
			logger.info(e.toString());
		}
	}
}

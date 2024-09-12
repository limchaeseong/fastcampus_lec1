package org.example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomWebApplicationServer {

    private final int port;
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);
    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);

    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("[CustomWebApplicationServer] started {} port.", port);

            Socket clientSocket;
            logger.info("[CustomWebApplicationServer] Waiting for client connection...");

            while ((clientSocket = serverSocket.accept()) != null) {
                logger.info("[CustomWebApplicationServer] client connected!");

                /**
                 * Step3 - Thread Pool을 적용해 안정적인 서비스가 가능하도록 한다.
                 */
                executorService.execute(new ClientRequestHandler(clientSocket));

                /**
                 * Step2 - 사용자 요청이 들어올 때마다 Thread를 새로 생성해서 사용자 요청을 처리하도록 한다. => ClientRequestHandler.java
                 * => 한계 : 요청이 들어올 때마다 Thread를 생성하기 때문에 비용이 많이 들고, 생성할 수 있는 Thread 갯수를 넘어서면 서버가 다운된다.
                 */
                /*
                new Thread(new ClientRequestHandler(clientSocket)).start();
                 */

                /**
                 * Step1 - 사용자 요청을 메인 Thread가 처리하도록 한다.
                 * => 한계 : 메인 Thread에서 로직을 차례대로 처리하기 때문에 이전 로직이 처리되지 않으면 다음 로직을 수행할 수 없다.
                 * /

                 /*
                try(InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()) {

                    // 프로토콜에 맞는 <Reqeust 객체 생성>
                    // BufferedReader의 역할 : 라인별로 input을 읽을 수 있음
                    BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                    DataOutputStream dos = new DataOutputStream(out);

                    // Request protocol 확인 로직
                    // String line;
                    // while((line = br.readLine()) != "") {
                    //    System.out.println(line);
                    // }

                    HttpRequest httpRequest = new HttpRequest(br);
                    if(httpRequest.isGetRequest() && httpRequest.matchPath("/calculate")){
                        QueryStrings queryStrings = httpRequest.getQueryStrings();

                        int operand1 = Integer.parseInt(queryStrings.getValue("operand1"));
                        String operator = queryStrings.getValue("operator");
                        int operand2 = Integer.parseInt(queryStrings.getValue("operand2"));
                        int result = Calculator.calculate(operand1, operator, operand2);
                        byte[] body = String.valueOf(result).getBytes();

                        // 프로토콜에 맞는 <Response 객체 생성>
                        // GET /calculate?operand1=11&operator=*&operand2=55 HTTP/1.1
                        HttpResponse response = new HttpResponse(dos);
                        response.response200Header("application/json", body.length);
                        response.responseBody(body);
                    }
                }
                */
            }
        }
    }
}

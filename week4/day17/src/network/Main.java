package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) {

        /*
            사람들끼리 정보를 교환하기 위해서 인터넷에 접속
            호스트는 사용자(Client)를 뜻한다

            라우터
             -호스트에서 생성된 데이터를 여러 네트워크를 거쳐 전송함으로써 다른 네트워크에 데이터를 교환할 수 있다.



             클라이언트 client -> 나
             서버 server -> 네이버, 구글, 다음 등의 사이트

             통신 프로토콜
               - 호스트가 라우터와 라우터를 통신하기 위한 규칙.
             인터넷을 이용하려면 규칙(프로토콜)이 필요하다
             ip 주소  (ipv4)32bit로 주소를 생성하느냐  (ipv6)64bit로 주소를 생성하느냐의 차이.

             TCP / IP 계층 구조
               - 물리적 네트워크 통한 데이터 송수신
               - 구성요소 : 네트워크 하드웨어 + 장치 드라이버
               - 주소 저장 방식 : 물리 주소 이더넷 48비트

             인터넷에 접속하기 위해서는 공인 ip 중복을 할 수 없다.
             일반적으로 우리가 사용하는 ip는 공인 ip이다.

             포트
               -연결 통로 (통신을 연결하는 번호)

             자바에서는 ip 주소를 나타내는 클래스가 있다 -> InetAddress
             ip 번호랑 URL을 조사할 때 사용

             DNS 서버 (Domain Name Server)

                URL을 찾아서 ip주소로 변환하는 서버.
                문자로 들어온 주소값을 ip 주소인 ipv4로 변경

             TCP/UDP
                tcp -> 전화라고 생각하면 된다. 즉 내가 요청을 했을 때 응답이 오는 형식이다. 프로세스 간에 통신을 하려면
                소켓이라는 것이 필요하다. 1:1 통신방식에 해당한다. 통신이 잘 안돼 전달에 어려움이 있을 경우 바로 확인이 가능하다. 따라서 파일 전송 신뢰성이 높다.
                udp -> 오류 발생시에 데이터를 전달 하느냐 안하느냐  ,  우편 (소포)

            url
                인터넷 상의 파일이나 데이터베이스 같은 자원에 대한 주소를 지정하는 방법
                http:// wwww.naver.com/index.html:80
                프로토콜 이름 : http: 는 프로토콜은 의미하며 사용하는 통신방식을 뜻한다
                호스트 이름 : www.naver.com
                파일이름 : 웹문서 index.html
                포트 번호 : 80

         */

        // getHostAddress() -> ip주소를 String 타입으로 변환한다.
        String hostname = "www.naver.com";

        try {
            InetAddress address = InetAddress.getByName(hostname); // 문자열로 입력된 주소를 ip형태로 변환
            System.out.println("ip 주소 : " + address.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println(hostname + "의 ip를 찾을 수 없습니다");
            throw new RuntimeException(e);
        }

        // 통신하려면 Sockey 연결통로
        // 두 컴퓨터 간에 통신하는 끝 부분을 의미

        //Socket(InetAddress, int port);
    }
}

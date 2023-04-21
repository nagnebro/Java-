package network;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class SocketAddressMain {

    public static void main(String[] args) {
        //SocketAddress
        //ip주소 (호스트 이름) + port번호를 관리하는 추상클래스 -> 호스트 이름은 내 단말기에 부여된 고유의 명칭이다.
        //InetSocketAddess 클래스로 사용이 가능하다.

        //InetSocketAddress(포트번호)
        // -ip 주소없이 내부의 포트 정보단 지정


        try {
            int port = 20000;
            InetAddress ia1 = InetAddress.getByName("www.google.com");
            // getbyname 이랑 문자열로 입력받는거랑 뭐가다르지 getbyname은 실제 그 ip에 할당된 도메인을 갖고 오는건가.
            InetSocketAddress isa1 = new InetSocketAddress(port);
            InetSocketAddress isa2 = new InetSocketAddress("www.google.com",port);
            InetSocketAddress isa3 = new InetSocketAddress(ia1,port);

            System.out.println(isa1);
            System.out.println(isa2);
            System.out.println(isa3);

            System.out.println(isa1.getPort());
        } catch (UnknownHostException e) {
            System.out.println("주소가 없습니다");
        }

    }

}

package network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddressMain {

    // 네트워크의 기본개념
    // 통신을 1:1로 하느냐, 1대다로 하느냐, 1대다이지만 특정 그룹끼리 하느냐

    // 유니캐스트
    // - 두 장치간 1:1로 통신한다.
    // 특정 대상이랑만 통신, 같은 네트워크 대역에서 사용할 수 있다.
    // -잔디 디엠 (카카오톡 1:1 대화)

    // 브로드 캐스트
    // 네트워크에 있는 모든 대상과 통신하는 것
    // -유튜브

    // 멀티캐스트
    // - 여러명이 같은 네트워크에 있지만
    //  특정 지정한 몇명과 통신하는 것.
    //  카카오톡 그룹 채팅??

    // 네트워크의 분류[크기]
    // LAN ( Local Area Network)
    // - 가까운 지역을 하나로 묶는 네트워크 -> 우리가 일반적으로 사용하는 네트워크
    // - 같은 PC방 통신(스타크래프트 UDP), 같은 강의장
    // - 관리를 해서 다른 강의장이나 다른 pc방으로 보내고, 그걸 관리하는 장치가 스위치다.


    // WAN (Wide Area Network)
    // - 멀리 있는 지역을 한데 묶은 네트워크
    // - Lan과 Lan을 하나로 묶는 것.



    // 네트워크에 따른 연결 형태가

    // 노드 : 인터넷에 연결된 시스템의 가장 기본적인 용어 -> 데이터를 구별하는 기본적인 단위? 의 개념
    // star형 - 중앙 장비에게 모든 노드가 연결된
    // 단점 : 중앙 장치(스위치)가 오류가 생기면 모든 네트워크들은 통신을 할 수 없다. ex) 공유기, 강의장의 스위치
    // 비용절감의 효과가 있는만큼 리스트가 있는 방식

    // Mesh형
    // - 여러 노드들이 서로 그물처럼 연결돼있음. 따라서 1대1 단말간 통신이 아니기 떄문에 경유해서라도 통신할 수 있음.
    // - star형의 단점을 없애준다.

    // Ip주소 (호스트) 저장 및 관리를 하는 클래스
    // getByName()의 매개변수로 도메인주소를 넘길때는 항상 문자열을 보내줘야한다.
    // - Host의 이름과 해당 ip주소를 저장 (객체로 리턴)
    // -인터넷통신을 하기 위해서는 ip가 꼭 필요하다.
    // 도메인을 변경하는 것, 즉 도메인네임을 ip주소로 변경해주는 것 -> DNS 서버 ( KT
    // DNS의 사전적 정의 : 네트워크에서 도메인이나 호스트 이름을 숫자로 된 IP주소로 해석해주는 TCP,IP네트워크 서비스이다.

    //getByAddress(byte[])
    // getByAddress(String,byte[])
    // 입력한 문자옇과 (호스트), ip주소를 저장하는 객체 리턴.
    // 입력한 주소를 저장해서 객체를 리턴(

    //통신을 하기 위해서는 원격자(나)와 상대의 ip와 호스트이름이 있어야한다.


    // ** 호스트이름과 도메인이름은 구분돼야한다. 호스트 네임은 도메인 네임의 일부로 생각하면 된다.
    // 그러나 개인 pc가 가지고있는 호스트네임은 그 호스트의 장치명이 맞고 일반적으로 우리가 알고 있는 웹의
    // blog.naver.com이라 했을 떄 blog는 호스트네임, naver는 도메인네임에 속한다.
    public static void main(String[] args) {
        InetAddress ia1 = null;
        try {
            ia1 = InetAddress.getByName("blog.naver.com");
            InetAddress ia2 = InetAddress.getByAddress(new byte[]{
                    (byte)273,(byte)328,(byte)262,(byte)43
            });
            InetAddress ia3 = InetAddress.getByAddress("www.google.com",new byte[]{
                    (byte)273,(byte)328,(byte)262,(byte)43
            });


            System.out.println("ia2 getbyaddress: " + ia2);
            System.out.println("ia3 getbyaddress 매개변수 호스트네임: " + ia3);

            // 로컬 / 루프팩 IP
            // 자기 자신을 나타내는 가상적인 주소
            // -LocalHost / 127.0.0.1
            InetAddress ia4 = InetAddress.getLocalHost();
            InetAddress ia5 = InetAddress.getLoopbackAddress();

            // InetAddress는 ip만 관리해준다.
            System.out.println("ia4 : "+ ia4);
            System.out.println("ia5 : " + ia5);

            //getAllByName()메서드는 하나의 호스트가 여러개 ip를 가지고 있을 경우
            //모든 호스트의 ip를 리턴한다.
            InetAddress[] ia6 = InetAddress.getAllByName("www.youtube.com");
            System.out.println(Arrays.toString(ia6));

            System.out.println();

            //호스트와 ip 알아내기
            byte [] address = ia1.getAddress(); // byte의 저장범위는 -128~127이기 떄문에 아이피 번호가 이 범위를 벗어나면 음수가 저장되게 된다
            System.out.println(Arrays.toString(address));

            System.out.println("get host name " + ia1.getHostName());
            System.out.println("get host address"+ia1.getHostAddress());
            System.out.println(InetAddress.getLoopbackAddress());

            // 멀티캐스트 영역, cmd에서 ping 네트워크 접속 확인
            System.out.println(ia1.isMulticastAddress());
            System.out.println(ia1.isReachable(1000));

        } catch (UnknownHostException e) {
            System.out.println("없는 주소입니다.");
        }catch(IOException e){} // recahable 메서드 예외처리
    }


}


class InetAddressTest{
    public static void main(String[] args)  {

        InetAddress ia = null;
        InetAddressTest [] Arr = null;

        try {
            ia = InetAddress.getByName("www.naver.com");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        System.out.println(ia.getHostName());
        System.out.println(ia.getHostAddress());
        System.out.println(ia.toString());
    }
}

class InetAddressTest2{
    public static void main(String[] args) {
        InetAddress ia = null;
        InetAddressTest2 [] Arr = null;
        try {
            ia = InetAddress.getByName("www.naver.com");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        System.out.println(ia.getHostName());
        System.out.println(ia.getHostAddress());
        System.out.println(ia.getAddress());
    }
}
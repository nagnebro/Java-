package network;

import java.net.InetAddress;
import java.net.NetworkInterface;

public class InetAddressForMac {

    public static void main(String[] args)throws Exception {

        InetAddress ip = InetAddress.getLocalHost();
        // 결과 : john-PC/192.168.206.1
        System.out.println(ip);

        NetworkInterface mac = NetworkInterface.getByInetAddress(ip);
        // 결과 : name:eth4 (VMware Virtual Ethernet Adapter for VMnet1)
        System.out.println(mac);


        if(ip != null) {
            byte[] mc = mac.getHardwareAddress();

            String macAddress = "";

            for (int i = 0; i < mc.length; i++) {
                macAddress += (String.format("%02x", mc[i]) + ":");
            }

            // 결과 : 00:50:56:c0:00:01
            System.out.println(
                    macAddress.substring(0, macAddress.length()-1)
            );
        }
    }
}

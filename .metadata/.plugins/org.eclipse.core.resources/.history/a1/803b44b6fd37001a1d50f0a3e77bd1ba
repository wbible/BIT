package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress naver = InetAddress.getByName("www.naver.com");
		System.out.println("NAVER IP = " + naver.getHostAddress());
		
		InetAddress local = InetAddress.getLocalHost();
		System.out.println("LOCALHOST IP = " + local.getHostAddress());
		
		InetAddress[] ar = InetAddress.getAllByName("www.daum.net");
		int count = 0;
		for (InetAddress ip : ar) System.out.printf("다음 아이피 %d = %s\n", ++count, ip);
		
		
	}

}

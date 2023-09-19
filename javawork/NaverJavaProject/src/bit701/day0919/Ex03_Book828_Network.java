package bit701.day0919;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ex03_Book828_Network {

  public static void main(String[] args) throws UnknownHostException {

    // in, out스트림 
    InetAddress local = Inet4Address.getLocalHost();
    System.out.println("내 컴퓨터의 ip 주소 : " + local.getHostAddress());
    System.out.println("내 컴퓨터의 이름 : " + local.getHostName());

    // naver 서버의 ip
    InetAddress[] naverArr = Inet4Address.getAllByName("www.naver.com");
    for(InetAddress inet : naverArr)
      System.out.println("Naver의 서버 ip : " + inet.getHostAddress());
    // google 서버의 ip
    InetAddress[] ggArr = Inet4Address.getAllByName("www.google.com");
    for(InetAddress inet : ggArr)
      System.out.println("google의 서버 ip : " + inet.getHostAddress());
    // nate 서버의 ip
    InetAddress[] nateArr = Inet4Address.getAllByName("www.nate.com");
    for(InetAddress inet : nateArr)
      System.out.println("nate의 서버 ip : " + inet.getHostAddress());
  }

}

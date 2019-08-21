/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3;

import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 *
 * @author KOSTA
 */
public interface Ex1_InetAddressInter {
    //1.도메인을 받아서 찾아오는 메서드
    //2.받아온 도메인의 값을 배열로 반환 해주는
    //메서드
    
    public void searchDomain(String ns)throws UnknownHostException;
    public ArrayList<String> getDomainList();
    
}

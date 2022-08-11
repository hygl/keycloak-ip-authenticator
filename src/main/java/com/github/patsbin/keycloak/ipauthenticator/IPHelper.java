package com.github.patsbin.keycloak.ipauthenticator;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.security.web.util.matcher.IpAddressMatcher;


public class IPHelper {
    public static long ipToLong(InetAddress ip) {
		byte[] octets = ip.getAddress();
		long result = 0;
		for (byte octet : octets) {
			result <<= 8;
			result |= octet & 0xff;
		}
		return result;
	}

	public static boolean isValidRange(String ipStart, String ipEnd,
			String ipToCheck) {
		try {
			long ipLo = ipToLong(InetAddress.getByName(ipStart));
			long ipHi = ipToLong(InetAddress.getByName(ipEnd));
			long ipToTest = ipToLong(InetAddress.getByName(ipToCheck));
			return (ipToTest >= ipLo && ipToTest <= ipHi);
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return false;
		}
	}

    public static boolean isValidCIDR(String CIDR, String ipToCheck){
        IpAddressMatcher matcher = new IpAddressMatcher(CIDR);
        return matcher.matches(ipToCheck);
    }
}

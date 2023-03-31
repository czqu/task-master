package net.czqu.taskmaster.common.utils;


import javax.servlet.http.HttpServletRequest;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-23 23:33
 **/
public class IPUtils {
    public static String getUserIP(HttpServletRequest request) {
        if (request == null) {
            return "";
        }
        String ipAddress = request.getHeader("X-Forwarded-For");
        if (!(ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress))) {

            return ipAddress;
        }
        return request.getRemoteAddr();


    }

    public static int ipv4ToUnsignedInt(String ipv4) {
        String[] octets = ipv4.split("\\.");
        int unsignedInt = 0;
        for (int i = 0; i < octets.length; i++) {
            int octet = Integer.parseInt(octets[i]);
            unsignedInt |= octet << (24 - (8 * i));
        }
        return unsignedInt;
    }

    public static String unsignedIntToIpv4(int unsignedInt) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int octet = (unsignedInt >> (24 - (8 * i))) & 0xff;
            sb.append(octet);
            if (i < 3) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    public static boolean isValidIpv4Address(String ip) {
        int n = ip.length(), cnt = 0;
        char[] cs = ip.toCharArray();
        for (int i = 0; i < n && cnt <= 3; ) {

            int j = i, x = 0;
            while (j < n && cs[j] >= '0' && cs[j] <= '9' && x <= 255) {
                x = x * 10 + (cs[j++] - '0');
            }

            if (i == j) {
                return false;
            }

            if ((j - i > 1 && cs[i] == '0') || (x > 255)) {
                return false;
            }
            i = j + 1;
            if (j == n) {
                continue;
            }

            if (cs[j] != '.') {
                return false;
            }
            cnt++;
        }

        return cnt == 3 && cs[0] != '.' && cs[n - 1] != '.';
    }

    public static boolean isValidIpv6Address(String ip) {
        int n = ip.length(), cnt = 0;
        char[] cs = ip.toCharArray();
        for (int i = 0; i < n && cnt <= 7; ) {
            int j = i;
            while (j < n && ((cs[j] >= 'a' && cs[j] <= 'f') || (cs[j] >= 'A' && cs[j] <= 'F') || (cs[j] >= '0' && cs[j] <= '9'))) {
                j++;
            }

            if (i == j || j - i > 4) {
                return false;
            }
            i = j + 1;
            if (j == n) {
                continue;
            }

            if (cs[j] != ':') {
                return false;
            }
            cnt++;
        }

        return cnt == 7 && cs[0] != ':' && cs[n - 1] != ':';
    }


}

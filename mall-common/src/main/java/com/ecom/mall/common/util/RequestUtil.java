package com.ecom.mall.common.util;

import jakarta.servlet.http.HttpServletRequest;

import java.net.InetAddress;
import java.net.UnknownHostException;

/* class Util xử lý request */
public class RequestUtil {

    /* Lấy IP của request */
    public static String getRequestIp(HttpServletRequest request){
        // Thêm khi chuyển tiếp qua máy chủ proxy HTTP
        String ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            /* Khi truy cập từ local chạy trên cùng một mạng LAN (local network) hoặc chạy trực tiếp trên cùng một máy chủ (localhost),
             lấy IP được cấu hình trên card mạng */
            if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
                InetAddress inetAddress = null;
                try {
                    inetAddress = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inetAddress.getHostAddress();
            }
        }
        // Trong trường hợp thông qua nhiều proxy để chuyển tiếp, IP đầu tiên là IP thật của client, nhiều IP sẽ được phân cách bằng dấu ','
        if (ipAddress != null && ipAddress.length() > 15) {
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }
}

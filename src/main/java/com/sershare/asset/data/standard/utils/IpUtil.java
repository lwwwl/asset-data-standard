package com.sershare.asset.data.standard.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * 获取IP工具类
 * @author xiaomudong
 */
@Slf4j
public class IpUtil {

    /**增加日志*/
    private final static Logger logger = LoggerFactory.getLogger(IpUtil.class);
    private static final String LOCAL_IPV4 = "127.0.0.1";
    private static final String LOCAL_IPV6 = "0:0:0:0:0:0:0:1";
    private static final String IP_UNKNOWN = "unknown";
    private static String      ip         = null;

    public static String getLocalIp() {
        if (ip == null) {
            ip = localIp();
        }
        return ip;
    }

    /**
     *  获取本地ip字符串
     * @return 本地的ip字符
     */
    private static String localIp() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface
                    .getNetworkInterfaces();
            NetworkInterface network;
            Enumeration<InetAddress> inetAddresses;
            while (networkInterfaces.hasMoreElements()) {
                network = networkInterfaces.nextElement();
                if (network.getName().startsWith("eth") && !network.isLoopback()
                        && !network.isVirtual()) {
                    inetAddresses = network.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddress = inetAddresses.nextElement();
                        String hostAddress = inetAddress.getHostAddress();
                        if (!hostAddress.contains(":")){
                            return hostAddress;
                        }

                    }
                }
            }
        } catch (Exception ex) {
        }

        return "127.0.0.1";
    }

    /***
     * 获取客户端IP地址;这里通过了Nginx获取;X-Real-IP,
     * @param request 客户端请求的对象
     * @return 返回客户端ip字符串
     */
    public static String getClientIP(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");

        // 先获取代理机传过来的客户端IP by trentluo
        if (StringUtils.isBlank(ip) || IP_UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (StringUtils.isBlank(ip) || IP_UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip) || IP_UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip) || IP_UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        if (LOCAL_IPV4.equals(ip) || LOCAL_IPV6.equals(ip)) {
            //获取本机真实IP
            ip = getLocalIp();
        }

        return ip;
    }
}

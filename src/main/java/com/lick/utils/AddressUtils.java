package com.lick.utils;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 获取地址类
 *
 */
public class AddressUtils
{
    private static final Logger log = LoggerFactory.getLogger(AddressUtils.class);

    public static final String IP_URL = "http://ip.taobao.com/service/getIpInfo.php";

    public static String getRealAddressByIP(String ip)
    {
        String address = "XX XX";
        // 内网不查询
        if (IpUtils.internalIp(ip))
        {
            return "内网IP";
        }
        /**
         * 1. 请求接口（GET）：
         *
         * /service/getIpInfo.php?ip=[ip地址字串]
         *
         * 2. 响应信息：
         *
         * （json格式的）国家 、省（自治区或直辖市）、市（县）、运营商
         *
         * 3. 返回数据格式：
         *
         * {"code":0,"data":{"ip":"210.75.225.254","country":"\u4e2d\u56fd","area":"\u534e\u5317",
         * "region":"\u5317\u4eac\u5e02","city":"\u5317\u4eac\u5e02","county":"","isp":"\u7535\u4fe1",
         * "country_id":"86","area_id":"100000","region_id":"110000","city_id":"110000",
         * "county_id":"-1","isp_id":"100017"}}
         * 其中code的值的含义为，0：成功，1：失败。
         */
        String rspStr = HttpUtils.sendPost(IP_URL, "ip=" + ip);
        if (StringUtils.isEmpty(rspStr))
        {
            log.error("获取地理位置异常 {}", ip);
            return address;
        }
        JSONObject obj = JSONObject.parseObject(rspStr);
        JSONObject data = obj.getObject("data", JSONObject.class);
        String region = data.getString("region");
        String city = data.getString("city");
        address = region + " " + city;
        return address;
    }
}

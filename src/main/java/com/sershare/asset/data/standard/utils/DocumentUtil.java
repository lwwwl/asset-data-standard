package com.sershare.asset.data.standard.utils;

/**
 * Project: abs-common
 * <p>
 * File Created at 2017年5月16日 by trentluo
 * <p>
 * Copyright 2017 Tencent.com Croporation Limited.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * Tencent Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Tencent.com.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * 证件相关的方法 *
 * <p>
 * 身份证合法性校验
 * </p>
 *
 * <pre>
 *
 * 15位身份证号码：第7、8位为出生年份(两位数)，第9、10位为出生月份，第11、12位代表出生日期，第15位代表性别，奇数为男，偶数为女。
 * 18位身份证号码：第7、8、9、10位为出生年份(四位数)，第11、第12位为出生月份，第13、14位代表出生日期，第17位代表性别，奇数为男，偶数为女。
 * 最后一位为校验位
 * </pre>
 *
 * @author xiaomudong
 */
public class DocumentUtil {
    /**
     * 身份证位数15
     */
    private static final int CARD_ID_15 = 15;
    /**
     * 身份证位数18
     */
    private static final int CARD_ID_18 = 18;

    private static final String MAN = "男";

    private static final String WOMAN = "女";
    /**
     * <pre>
     *
     * 省、直辖市代码表：
     *     11 : 北京  12 : 天津  13 : 河北       14 : 山西  15 : 内蒙古
     *     21 : 辽宁  22 : 吉林  23 : 黑龙江  31 : 上海  32 : 江苏
     *     33 : 浙江  34 : 安徽  35 : 福建       36 : 江西  37 : 山东
     *     41 : 河南  42 : 湖北  43 : 湖南       44 : 广东  45 : 广西      46 : 海南
     *     50 : 重庆  51 : 四川  52 : 贵州       53 : 云南  54 : 西藏
     *     61 : 陕西  62 : 甘肃  63 : 青海       64 : 宁夏  65 : 新疆
     *     71 : 台湾
     *     81 : 香港  82 : 澳门
     *     91 : 国外
     * </pre>
     */
    private static String[] cityCode = {"11", "12", "13", "14", "15", "21", "22", "23", "31", "32",
            "33", "34", "35", "36", "37", "41", "42", "43", "44", "45", "46", "50", "51", "52",
            "53", "54", "61", "62", "63", "64", "65", "71", "81", "82", "91"};

    /**
     * 每位加权因子
     */
    private static int[] power = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};

    /**
     * 验证所有的身份证的合法性
     *
     * @param idcard 身份证
     * @return 合法返回true，否则返回false
     */
    public static boolean isValidatedAllIdcard(String idcard) {
        if (idcard == null || "".equals(idcard)) {
            return false;
        }
        if (idcard.length() == CARD_ID_15) {
            return validate15IDCard(idcard);
        }
        return validate18Idcard(idcard);
    }


    /**
     * <p>
     * 判断18位身份证的合法性
     * </p>
     * 根据〖中华人民共和国国家标准GB11643-1999〗中有关公民身份号码的规定，公民身份号码是特征组合码，由十七位数字本体码和一位数字校验码组成。
     * 排列顺序从左至右依次为：六位数字地址码，八位数字出生日期码，三位数字顺序码和一位数字校验码。
     * <p>
     * 顺序码: 表示在同一地址码所标识的区域范围内，对同年、同月、同 日出生的人编定的顺序号，顺序码的奇数分配给男性，偶数分配 给女性。
     * </p>
     * <p>
     * 1.前1、2位数字表示：所在省份的代码； 2.第3、4位数字表示：所在城市的代码； 3.第5、6位数字表示：所在区县的代码；
     * 4.第7~14位数字表示：出生年、月、日； 5.第15、16位数字表示：所在地的派出所的代码；
     * 6.第17位数字表示性别：奇数表示男性，偶数表示女性；
     * 7.第18位数字是校检码：也有的说是个人信息码，一般是随计算机的随机产生，用来检验身份证的正确性。校检码可以是0~9的数字，有时也用x表示。
     * </p>
     * <p>
     * 第十八位数字(校验码)的计算方法为： 1.将前面的身份证号码17位数分别乘以不同的系数。从第一位到第十七位的系数分别为：7 9 10 5 8 4
     * 2 1 6 3 7 9 10 5 8 4 2
     * </p>
     * <p>
     * 2.将这17位数字和系数相乘的结果相加。
     * </p>
     * <p>
     * 3.用加出来和除以11，看余数是多少
     * </p>
     * 4.余数只可能有0 1 2 3 4 5 6 7 8 9 10这11个数字。其分别对应的最后一位身份证的号码为1 0 X 9 8 7 6 5 4 3
     * 2。
     * <p>
     * 5.通过上面得知如果余数是2，就会在身份证的第18位数字上出现罗马数字的Ⅹ。如果余数是10，身份证的最后一位号码就是2。
     * </p>
     *
     * @param idCard 身份证
     * @return 校验结果 true  false
     */
    public static boolean validate18Idcard(String idCard) {
        if (idCard == null) {
            return false;
        }

        // 非18位为假
        if (idCard.length() != CARD_ID_18) {
            return false;
        }
        // 获取前17位
        String idcard17 = idCard.substring(0, 17);

        // 前17位全部为数字
        if (!isDigital(idcard17)) {
            return false;
        }

        String provinceid = idCard.substring(0, 2);
        // 校验省份
        if (!checkProvinceid(provinceid)) {
            return false;
        }

        // 校验出生日期
        String birthday = idCard.substring(6, 14);


        if (!birthCheck(birthday)) {
            return false;
        }

        // 获取第18位
        String idcard18Code = idCard.substring(17, 18);

        char[] c = idcard17.toCharArray();

        int[] bit = converCharToInt(c);

        int sum17 = getPowerSum(bit);


        // 将和值与11取模得到余数进行校验码判断
        String checkCode = getCheckCodeBySum(sum17);
        if (null == checkCode) {
            return false;
        }
        // 将身份证的第18位与算出来的校码进行匹配，不相等就为假
        return idcard18Code.equalsIgnoreCase(checkCode);
    }


    /**
     * 校验15位身份证
     *
     * <pre>
     *
     * 只校验省份和出生年月日
     * </pre>
     *
     * @param idCard 身份证
     * @return 校验结果 true false
     */
    public static boolean validate15IDCard(String idCard) {
        if (idCard == null) {
            return false;
        }
        // 非15位为假
        if (idCard.length() != CARD_ID_15) {
            return false;
        }

        // 15全部为数字
        if (!isDigital(idCard)) {
            return false;
        }

        String provinceid = idCard.substring(0, 2);
        // 校验省份
        if (!checkProvinceid(provinceid)) {
            return false;
        }
        String birthday = idCard.substring(6, 12);
        return birthCheck(birthday);
    }

    private static boolean birthCheck(String birthday) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        try {
            Date birthDate = sdf.parse(birthday);
            String tmpDate = sdf.format(birthDate);
            // 身份证日期错误
            return tmpDate.equals(birthday);
        } catch (ParseException e1) {
            return false;
        }
    }


    /**
     * 将15位的身份证转成18位身份证
     *
     * @param idCard 身份证编号
     * @return 转换后的身份证
     */
    public static String convertIdcarBy15bit(String idCard) {
        if (idCard == null) {
            return null;
        }

        // 非15位身份证
        if (idCard.length() != CARD_ID_15) {
            return null;
        }

        // 15全部为数字
        if (!isDigital(idCard)) {
            return null;
        }

        String provinceid = idCard.substring(0, 2);
        // 校验省份
        if (!checkProvinceid(provinceid)) {
            return null;
        }

        String birthday = idCard.substring(6, 12);

        if (!birthCheck(birthday)) {
            return null;
        }
        LocalDate localDate = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("yyMMdd"));

        int year = localDate.getYear();

        String idCard17 = idCard.substring(0, 6) + year + idCard.substring(8);

        char[] c = idCard17.toCharArray();

        // 将字符数组转为整型数组
        int[] bit = converCharToInt(c);

        int sum17 = getPowerSum(bit);

        // 获取和值与11取模得到余数进行校验码
        String checkCode = getCheckCodeBySum(sum17);

        // 获取不到校验位
        if (null == checkCode) {
            return null;
        }
        // 将前17位与第18位校验码拼接
        idCard17 += checkCode;
        return idCard17;
    }

    /**
     * 校验省份
     *
     * @param provinceId 省份id
     * @return 合法返回TRUE，否则返回FALSE
     */
    private static boolean checkProvinceid(String provinceId) {
        for (String id : cityCode) {
            if (id.equals(provinceId)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 数字验证
     *
     * @param str 待要校验的字符串
     * @return 是否都为数字
     */
    private static boolean isDigital(String str) {
        return str.matches("^[0-9]*$");
    }

    /**
     * 将身份证的每位和对应位的加权因子相乘之后，再得到和值
     *
     * @param bit 身份证前17位数字
     * @return 身份证加权后的值
     */
    private static int getPowerSum(int[] bit) {

        int sum = 0;

        if (power.length != bit.length) {
            return sum;
        }

        for (int i = 0; i < bit.length; i++) {
            for (int j = 0; j < power.length; j++) {
                if (i == j) {
                    sum = sum + bit[i] * power[j];
                }
            }
        }
        return sum;
    }

    /**
     * 将和值与11取模得到余数进行校验码判断
     *
     * @param sum17 前17位的和
     * @return 校验位
     */
    private static String getCheckCodeBySum(int sum17) {
        String checkCode = null;
        switch (sum17 % 11) {
            case 10:
                checkCode = "2";
                break;
            case 9:
                checkCode = "3";
                break;
            case 8:
                checkCode = "4";
                break;
            case 7:
                checkCode = "5";
                break;
            case 6:
                checkCode = "6";
                break;
            case 5:
                checkCode = "7";
                break;
            case 4:
                checkCode = "8";
                break;
            case 3:
                checkCode = "9";
                break;
            case 2:
                checkCode = "x";
                break;
            case 1:
                checkCode = "0";
                break;
            case 0:
                checkCode = "1";
                break;
            default:
                checkCode = "-99";
                break;
        }
        return checkCode;
    }

    /**
     * 将字符数组转为整型数组
     *
     * @param c 字符串
     * @return 转换后的结果
     * @throws NumberFormatException
     */
    private static int[] converCharToInt(char[] c) throws NumberFormatException {
        int[] a = new int[c.length];
        int k = 0;
        for (char temp : c) {
            a[k++] = Integer.parseInt(String.valueOf(temp));
        }
        return a;
    }

    /**
     * 根据日期获取年龄
     *
     * @param birthDay
     * @return
     * @throws Exception
     */
    public static int getAge(Date birthDay) {
        Calendar cal = Calendar.getInstance();

        if (cal.before(birthDay)) {
            return -1;
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);

        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                }
            } else {
                age--;
            }
        }
        return age;
    }

    public static int getAgeByIdNo(String idNo) {
        if (idNo.length() == 15) {
            idNo = get18Ic(idNo);
        }
        String date = idNo.substring(6, 14);
        return getAge(DateUtils.stringConvert2Date(date, DateUtils.DATEPATTERN_YYYYMMDD));
    }


    /**
     * 将15位身份证号转化为18位返回，非15位身份证号原值返回
     *
     * @param identityCard
     * @return
     */
    public static String get18Ic(String identityCard) {
        String retId = "";
        String id17 = "";
        int sum = 0;
        int y = 0;
        // 定义数组存放加权因子（weight factor）
        int[] wf = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        // 定义数组存放校验码（check code）
        String[] cc = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
        if (identityCard.length() != 15) {
            return identityCard;
        }
        int year = Integer.valueOf(identityCard.substring(7, 9));
        int currentYear = Integer.valueOf(DateUtils.getCurrentDate(DateUtils.DATEPATTERN_YYYYMMDD).substring(3));
        if (year > currentYear) {
            // 加上两位年19
            id17 = identityCard.substring(0, 6) + "19" + identityCard.substring(6);
        } else {
            // 加上两位年20
            id17 = identityCard.substring(0, 6) + "20" + identityCard.substring(6);
        }
        // 十七位数字本体码加权求和
        for (int i = 0; i < 17; i++) {
            sum = sum + Integer.valueOf(id17.substring(i, i + 1)) * wf[i];
        }

        // 计算模
        y = sum % 11;
        // 通过模得到对应的校验码 cc[y]
        retId = id17 + cc[y];
        return retId;
    }

    public static String getSexByIdNo(String idNo) {
        if (idNo.length() == 15) {
            idNo = get18Ic(idNo);
        }
        int sexFlag = Integer.valueOf(idNo.substring(idNo.length() - 2, idNo.length()-1));
        return sexFlag % 2 == 0 ? WOMAN : MAN;
    }

}

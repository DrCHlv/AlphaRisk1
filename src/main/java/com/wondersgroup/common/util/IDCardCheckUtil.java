package com.wondersgroup.common.util;

/**
 * Created by 319 on 2020/2/26.
 */
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 单例模式,用于检测用户身份证信息的工具
 * @author 319
 */
public class IDCardCheckUtil {

    private IDCardCheckUtil(){}

    private static class SingletonInstance{
        private static final IDCardCheckUtil INSTANCE = new IDCardCheckUtil();
    }

    /**
     * 省、直辖市代码表：
     *     11:北京  12 : 天津  13 : 河北       14 : 山西  15 : 内蒙古
     *     21 : 辽宁  22 : 吉林  23 : 黑龙江  31 : 上海  32 : 江苏
     *     33 : 浙江  34 : 安徽  35 : 福建       36 : 江西  37 : 山东
     *     41 : 河南  42 : 湖北  43 : 湖南       44 : 广东  45 : 广西      46 : 海南
     *     50 : 重庆  51 : 四川  52 : 贵州       53 : 云南  54 : 西藏
     *     61 : 陕西  62 : 甘肃  63 : 青海       64 : 宁夏  65 : 新疆
     *     71 : 台湾
     *     81 : 香港  82 : 澳门
     *     91 : 国外
     */
    private static String[] cityCode = {"11","12","13","14","15","21","22","23","31","32","33","34","35","36","37",
            "41","42","43","44","45","46","50","51","52","53","54","61","62","63","64","65","71","81","82","91"};

    /**
     * 身份证号码校验码权重
     */
    private static String[] power = {"7","9","10","5","8","4","2","1","6","3"};

    /**
     * 身份证号码加权取余后取值表
     */
    private static String[] checkNum = {"1","0","X","9","8","7","6","5","4","3","2"};

    /**
     * 检查身份证号码出生日期是否为有效日期,且在合理时间范围内
     * @param birthday 出生日期,YYYYMMDD
     * @return 非有效日期返回true,有效日期返回false;且出生日期<(当前日期-120year)
     */
    private boolean IDCardBirthDayCheck(String birthday){
        boolean result = false;
        if(birthday.length() == 8){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            try{
                //用于校验是否为有效日期
                Date birthDate = dateFormat.parse(birthday);
                //用于校验日期是否合理
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date());
                calendar.add(Calendar.YEAR, -120);
                Date beginDate = calendar.getTime();
                Date endDate = new Date();
                if(dateFormat.format(beginDate).compareTo(birthday)<0
                        && dateFormat.format(endDate).compareTo(birthday)>0
                        && birthday.equals(dateFormat.format(birthDate))){
                    result = true;
                }
            } catch(Exception e){
                result = false;
            }
        }
        return result;
    }

    /**
     * 校验身份证各个位置上的字符是否合理:前n-1位为数字,第n位为字符x或数字
     * @param IDCard 身份证号码
     * @return 符合规则返回true,不符合规则返回false
     */
    private boolean IDCardIsDigitalCheck(String IDCard){
        if(IDCard.substring(0, IDCard.length()-1).matches("^[0-9]*$")
                && IDCard.substring(IDCard.length()-1, IDCard.length()).matches("[0-9Xx]$")){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 校验身份证前两位的省市代码
     * @param IDCard 身份证号码
     * @return 符合规则返回true,不符合规则返回false
     */
    private boolean IDCardCityCodeCheck(String IDCard){
        String provinceid=IDCard.substring(0,2);
        for(String id : cityCode){
            if(id.equals(provinceid)){
                return true;
            }
        }
        return false;
    }

    /**
     * 校验身份证号码最后一位验证码是否合理;
     * 15位身份证号码没有最后一位验证码的校验规则
     * @param IDCard 身份证号码
     * @return 符合规则返回true,不符合规返回false
     */
    private boolean IDCardCheckCodeCheck(String IDCard){
        int checkResult = 0;
        //18位身份证号校验
        if(IDCard.length() == 18){
            //检查身份证校验位是否正确
            for(int i = 0;i < IDCard.length()-1;i++){
                checkResult += Integer.parseInt(IDCard.substring(i, i+1)) * Integer.parseInt(power[i%10]);
            }
            //判断身份证最后一位校验码是否正确
            if(IDCard.substring(17, 18).equalsIgnoreCase(checkNum[checkResult%11])){
                return true;
            }
        }
        return false;
    }

    /**
     * 根据18位身份证的前17位号码,计算出最后一位校验码;
     * 需要保证无以下错误:1.省市代码正确;2.出生日期正确;3.各个位置上都是数字;
     * @param IDCard 18位身份证号码
     * @return 返回18位错误身份证号码应有的校验码
     */
    private String getIDCardCheckCode(String IDCard){
        int checkResult = 0;
        String checkCode = null;
        //18位身份证号校验
        if(IDCard.length() == 18 && IDCardCityCodeCheck(IDCard)
                && IDCardBirthDayCheck(IDCard.substring(6, 14))
                && IDCardIsDigitalCheck(IDCard)){
            //检查身份证校验位是否正确
            for(int i = 0;i < IDCard.length()-1;i++){
                checkResult += Integer.parseInt(IDCard.substring(i, i+1)) * Integer.parseInt(power[i%10]);
            }
            checkCode = checkNum[checkResult%11];
        }
        return checkCode;
    }

    /**
     * 检验身份证号码是否合法
     * @param IDCard 15位或18位身份证号码
     * @return 符合规则返回true,不符合规则返回false
     */
    public static boolean isLegal(String IDCard){
        IDCardCheckUtil util = SingletonInstance.INSTANCE;
        if(IDCard.length() == 18){
            return util.IDCardIsDigitalCheck(IDCard)
                    && util.IDCardCityCodeCheck(IDCard)
                    && util.IDCardBirthDayCheck(IDCard.substring(6, 14))
                    && util.IDCardCheckCodeCheck(IDCard);
        } else if(IDCard.length() == 15){
            return util.IDCardIsDigitalCheck(IDCard)
                    && util.IDCardCityCodeCheck(IDCard)
                    && util.IDCardBirthDayCheck("19" + IDCard.substring(6, 12));
        }else{
            return false;
        }
    }

    public static String isLegelMsg(String IDCard){
        IDCardCheckUtil util = SingletonInstance.INSTANCE;
        if(IDCard.length() == 18){
            if(!util.IDCardIsDigitalCheck(IDCard)){
                return "非数字";
            } else if(!util.IDCardCityCodeCheck(IDCard)){
                return "省市代码错误";
            }else if(!util.IDCardBirthDayCheck(IDCard.substring(6, 14))){
                return "出生日期错误";
            } else if(!util.IDCardCheckCodeCheck(IDCard)){
                return "校验位错误";
            }  else{
                return null;
            }
        }
        if(IDCard.length() == 15){
            if(!util.IDCardIsDigitalCheck(IDCard)){
                return "非数字";
            } else if(!util.IDCardCityCodeCheck(IDCard)){
                return "省市代码错误";
            }else if(!util.IDCardBirthDayCheck("19" + IDCard.substring(6, 12))){
                return "出生日期错误";
            }  else{
                return null;
            }
        }
        return "身份证位数错误";
    }

    public static void main(String[] args) {
        String sfzh = "140724199009190156";
        IDCardCheckUtil util = SingletonInstance.INSTANCE;
        System.out.println("非数字"+util.IDCardIsDigitalCheck(sfzh));
        System.out.println("城市"+util.IDCardCityCodeCheck(sfzh));
        System.out.println("校验位"+util.IDCardCheckCodeCheck(sfzh));
        System.out.println("生日"+util.IDCardBirthDayCheck(sfzh.substring(6, 14)));
        System.out.println(util.getIDCardCheckCode(sfzh));
    }
}

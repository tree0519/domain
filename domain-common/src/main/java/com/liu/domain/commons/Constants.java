package com.liu.domain.commons;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author zhuyanwei
 */
public class Constants {
    /**
     * 状态正常
     */
    public static final Integer STATUS_NORMAL = 1;
    /**
     * 开票失败
     */
    public static final Integer STATUS_FAIL = 3;

    /**
     * 没有分隔符的年月日
     */
    public static final String YYYYMMdd = "YYYYMMdd";
    /**
     * 没有分隔符的年月日时分秒毫秒
     */
    public static final String YYYYMMddHHmmssSSS = "YYYYMMddHHmmssSSS";
    public static final String YYYY_MM_DD_HH_MM_SS = "YYYY-MM-dd HH:mm:ss";
    /**
     * 文件路径分隔符，windows
     */
    public static final String PATH_SEPARATOR_WIN = "\\";
    /**
     * 文件路径分隔符 linux
     */
    public static final String PATH_SEPARATOR_LINUX = "/";
    /**
     * 状态正常
     */
    public static final Integer STATUE_NORMAL = 1;
    /**
     * 状态删除
     */
    public static final Integer STATUE_DEL = -1;
    /**
     * 状态不可用
     */
    public static final Integer STATUE_ABNORMAL = 0;
    /**
     * 已处理
     */
    public static final Integer RESOLVE_STATUS = 2;

    /**
     * 顶级父节点
     */
    public static final Integer TOP_PARENT = 0;

    /**
     * 白名单变化状态添加
     */
    public static final String CHANGE_STATUS_ADD = "0";
    /**
     * 白名单变化状态删除
     */
    public static final String CHANGE_STATUS_DELETE = "1";

    /**
     * 车辆状态。 0-正常  1-无支付方式 2-无收费车型  3-限制使用   4-有未结算订单 5-解绑中 6-暂停使用
     */
     public static final Integer VE_STATUS_NORMAL = 0;
     public static final Integer VE_STATUS_NO_PAY = 1;
     public static final Integer VE_STATUS_NO_VEHICLE_TYPE = 2;
     public static final Integer VE_STATUS_NO_USE = 3;
     public static final Integer VE_STATUS_NO_ORDER = 4;
     public static final Integer VE_STATUS_UNBINGING = 5;
     public static final Integer VE_STATUS_PAUSE = 6;

    /**
     * 用户状态，1 未删除，0 禁用，-1 删除，2 启用
      */
    public static final Integer USER_STATUS_DISABLE = 0; //禁用
    public static final Integer USER_STATUS_NO_DETELE = 1; //未删除
    public static final Integer USER_STATUS_OK = 2; //启用
    public static final Integer USER_STATUS_DELETE = -1; //删除

    /**
     * 用户与车辆解绑与未解绑
     */
    public static final Integer VE_BIND = 0; //绑定中
    public static final Integer VE_UN_BIND = 1;//已解绑
    public static final Integer VE_UN_BINDING = 2;//解绑中

    /**
     * 用户与车辆状态表 车辆状态. 0-正常  1-未生效（未审核，审核中）  2-暂停使用  3-结算失败
     */
    public static final Integer USER_VE_OK = 0; //正常
    public static final Integer USER_VE_UN_USE = 1;//未生效（未审核，审核中）
    public static final Integer USER_VE_STOP = 2; //暂停使用
    public static final Integer USER_VE_UN_ORDER_FILED = 3;//结算失败

    /**
     * 用户支付通道状态。0-失效  1-生效
     */
    public static final Integer PAY_UN_BIND = 0; //0-失效
    public static final Integer PAY_BIND = 1;//1-生效


    /**
     * 车辆审核状态
     */
    public static final Integer VEH_AUDIT_STATUS_OK = 1;
    public static final Integer VEH_AUDIT_STATUS_NO = 0;

    //收费车型信息来源. 1-人工审核  2-车管所  3-其他机构 4-收费历史数据
    public static final Integer VEH_CLASS_SRC_AUDIT = 1;
    public static final Integer VEH_CLASS_SRC_ORG = 2;
    public static final Integer VEH_CLASS_SRC_ORTHER = 3;
    public static final Integer VEH_CLASS_SRC_HISTORY = 4;


    //退款状态. 0-未处理  1-退款完毕 2-退款失败  3-退款中 4-拒绝
    public static final Integer REFUND_STATUS_UNTREATED = 0;
    public static final Integer REFUND_STATUS_TRUE = 1;
    public static final Integer REFUND_STATUS_FALSE = 2;
    public static final Integer REFUND_STATUS_RUNING = 3;
    public static final Integer REFUND_STATUS_REFUSE = 4;

    //退款类型. 1-交易争议退款  2-其他退款（待补充）
    public static final Integer REFUND_TYPE_DISPUTE = 1;
    public static final Integer REFUND_TYPE_ORTHER = 2;



    //订单争议解决状态。0-待处理  1-处理中  2-已处理
    public static final Integer DISPUTE_STATUS_WAIT = 0;
    public static final Integer DISPUTE_STATUS_RUNING = 1;
    public static final Integer DISPUTE_STATUS_FINISH = 2;

    //消息类型. 0-系统通知  1-驶入通知 2-驶出通知 3-结算通知 4-下线通知  5-注册验证码  6-登录验证码
    public static final Integer MSG_TYPE_SYSTEM = 0;
    public static final Integer MSG_TYPE_ENTRY = 1;
    public static final Integer MSG_TYPE_EXIT = 2;
    public static final Integer MSG_TYPE_ORDER = 3;
    public static final Integer MSG_TYPE_DOWNLOAD = 4;
    public static final Integer MSG_TYPE_REGION = 5;
    public static final Integer MSG_TYPE_LOGIN = 6;
    public static final Integer MSG_TYPE_REFUND_SUCCESS = 7;
    public static final Integer MSG_TYPE_INVOICE = 8;
    public static final Integer MSG_TYPE_DISPUTE_ORDER = 9;
    //消息介质 1-app通知  2-SMS短信,3-电子邮件，4-站内消息
    public static final Integer MSG_MEDIA_APP = 1;
    public static final Integer MSG_MEDIA_SMS = 2;
    public static final Integer MSG_MEDIA_EMAL = 3;
    public static final Integer MSG_MEDIA_INNER = 4;

  //  黑名单解除原因  解除原因。 1-系统自动解除  2-强制解除
    public static final Integer BLACK_REMOVE_AUTO = 1;
    public static final Integer BLACK_REMOVE_FORCE = 2;


   // 选中发送状态，1 已选中，0 未选中
   public static final Integer MSG_CHOICE_OK = 1;
    public static final Integer MSG_CHOICE_OFF = 0;

    //对账状态：0未对账，1已对账，2异常，3已冲正
    public static final Integer PAY_CHACK_NO= 0;
    public static final Integer PAY_CHACK_OK = 1;
    public static final Integer PAY_CHACK_EXECPTION=2;
    public static final Integer PAY_CHACK_UPDATE= 3;


    /**
     * 支付类型
     */
    //支付类型  1.支付宝 2.微信 3.现金结算
    public static final Integer PAY_TYPE_ZHIFUBAO= 1;
    public static final Integer PAY_TYPE_WEIXIN = 2;
    public static final Integer PAY_TYPE_MONEY=3;

    /**
     * 签名类型.
     */
    public static class SignType {
        public static final String HMAC_SHA256 = "HMAC-SHA256";
        public static final String MD5 = "MD5";
        public static final List<String> ALL_SIGN_TYPES = Lists.newArrayList(HMAC_SHA256, MD5);
    }

    /**
     * 一年的12个月
     */
    public static final String[] YEAR_MONTH = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"};
    /**
     * 消费段
     */
    public static final Object[] CONSUME_SEGMENT = new String[]{"0-50元","50-100元","100-200元","200-500元","500-1000元","1000-5000元","5000-10000元","10000以上"};
    /**
     * 端口来源
     */
    public static final String[] SOURCE = new String[]{"APP","小程序"};
    /**
     * 新老客户交易构成
     */
    public static final String[] NEW_OLD_USER = new String[]{"新客户","老客户"};

    /**
     * 微信免密
     */
    public static final String WX_CONTRACT = "WX_CONTRACT";

    public static final String CHANGE_TYPE_ADD = "ADD";

    /**
     * 交易统计-订单来源
     * 就是调用微信和支付宝的客户端的支付形式，条码支付（特殊的一种预下单）
     * 术语定义--->产品@张旭
     */
    public static final String[] ORDER_SOURCE = new String[]{"预下单","免密","扫码","现金结算"};

    public static final String VEHICLE_DRIVE_IN_TOPIC = "vehicle-drive-in-topic";
    public static final String VEHICLE_DRIVE_OUT_TOPIC = "vehicle-drive-out-topic";
    public static final String VEHICLE_WHITE_TOPIC = "vehicle-white-topic";
    public static final String VEHICLE_BLACK_TOPIC = "vehicle-black-topic";

    public static final String ADD_WHITE_KEY = "add_white";
    public static final String DEL_WHITE_KEY = "del_white";
    public static final String ADD_BLACK_KEY = "add_black";
    public static final String DEL_BLACK_KEY = "del_black";


    /*天山行卡绑定状态  2：解绑，1:正常，0：禁用，-1：删除，*/
    public static final Integer ETC_BINDING_STATUS_BIND = 1;
    public static final Integer ETC_BINDING_STATUS_UNBIND = 2;
    public static final Integer ETC_BINDING_STATUS_DISABLE = 0;
    public static final Integer ETC_BINDING_STATUS_DELETE = -1;

    /* ETC客户状态  状态。1：在用，2：注销*/
    public static final Integer ETC_USER_STATUS_OK = 1;
    public static final Integer ETC_USER_STATUS_OUT = 2;


    /*ETC车辆信息  数据标志。1：新增未绑定卡:2、新增已绑定卡，3修改：4删除*/
    public static final Integer ETC_VEHICLE_FLAG_ADD_UNBIND = 1;
    public static final Integer ETC_VEHICLE_FLAG_ADD_BIND = 2;
    public static final Integer ETC_VEHICLE_FLAG_UPDATE = 3;
    public static final Integer ETC_VEHICLE_FLAG_DELETE = 4;

    /*ETC停车场 flag 1：新增：2修改：3删除*/
    public static final Integer ETC_PARK_FLAG_ADD = 1;
    public static final Integer ETC_PARK_FLAG_UPDATE = 2;
    public static final Integer ETC_PARK_FLAG_DELETE = 3;
    //手机端用户车辆信息以及位置redis缓存key
    public static final String USER_LOCATION_CARS = "user_location_cars:";
    /**
     * 无收费车型
     */
    public static final Integer VEHICLE_STATUS_NO_VEHICLE_TYPE = 1;
    /**
     * 审核中
     */
    public static final Integer VEHICLE_STATUS_AUDITING = 2;
    /**
     * 审核通过
     */
    public static final Integer VEHICLE_STATUS_AUDITED = 3;
    /**
     * 未审核
     */
    public static final Integer VEHICLE_STATUS_NO_AUDIT= 4;
    /**
     * 车辆审核成功
     */
    public static final Integer VEHICLE_AUDIT_SUCCESS =  1;
    /**
     * 车辆审核失败
     */
    public static final Integer VEHICLE_AUDIT_FAIL =  2;
    /**
     * 限制使用
     */
    public static final Integer VEHICLE_LIMIT_OK = 1;
    /**
     * 解除限制使用
     */
    public static final Integer VEHICLE_LIMIT_NO = 2;
    /**
     * 发票状态 未开票
     */
    public static final Integer INVOICE_FLAG_NOT = 0;
    /**
     * 发票状态 已开票
     */
    public static final Integer INVOICE_FLAG_OK = 1;

    /**
     * 收费车型
     */



    public static final String VEHICLE_VEHCLASS_ID_01 = "01";
    public static final String VEHICLE_VEHCLASS_ID_02 = "02";
    public static final String VEHICLE_VEHCLASS_ID_03 = "03";
    public static final String VEHICLE_VEHCLASS_ID_04 = "04";
    public static final String VEHICLE_VEHCLASS_ID_05 = "05";
    public static final String VEHICLE_VEHCLASS_ID_06 = "06";
    public static final String VEHICLE_VEHCLASS_ID_07 = "07";
    public static final String VEHICLE_VEHCLASS_ID_08 = "08";
    public static final String VEHICLE_VEHCLASS_ID_09 = "09";


    /**
     * 支付类型
     * 支付类型,支付宝：ALI_PAY,微信：TENCENT_PAY,银联：UNION
     */
    public static final String PAY_TYPE_ALI_PAY = "ALI_PAY";
    public static final String PAY_TYPE_TENCENT_PAY = "TENCENT_PAY";
    public static final String PAY_TYPE_UNION = "UNION";

    /**
     * 极光推送消息发送队列名称
     */
    public static final String VEHICLE_MSG_SEND_TOPIC = "vehicle-msg-send-topic";
    public static final String VEHICLE_MSG_SEND_QUEUE = "vehicle-msg-send-queue";
}

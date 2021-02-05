package com.sershare.asset.data.standard.common;

import java.math.BigInteger;

public class SysConstant {

    public static final int KEY_DES3_DIGEST_LENGTH = 24;  // max size of key for DES3 encrypt

    public static final int KEY_AES128_DIGEST_LENGTH = 16; // max size of key for AES128 encrypt

    public static final String RANDOM_NUMBER_ALGORITHM = "SHA1PRNG";

    public static final String RANDOM_NUMBER_ALGORITHM_PROVIDER = "SUN";

    public static final BigInteger MAXPRIVATEKEY = new BigInteger("00FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364140", 16);

    /**quartz*/
    public final static String JOBGROUP = "taskActuator";

    public static final String ENCODING = "UTF-8";

    public static final String FILE_TYPE = "IMPORTFILETYPE";

    public static final String ORDER_BY_CREATE_TIME_DESC ="CREATE_TIME DESC";

    public static final String  ORDER_BY_CREATE_TIME_ASC = "CREATE_TIME ASC";


    public static final String ABS_DATA = "data";

    public static final String FILENAMEIMPORT_DEFAULT = "DEFAULT";

    /** CVS文件命名规范连接符 */
    public static final String CVS_NAME_SPECIFICATION_CONNECTER = "_";

    /** 下划线 */
    public static final String UNDERLINE = "_";

    public static final String SPRIT = "/";

    public static final String POINT = ".";

    /** 空jsonObject */
    public static final String EMPTY_JSON = "{}";
    /** 空jsonArray */
    public static final String EMPTY_JSONARRAY = "[]";
    /** zip后缀 */
    public static final String ZIP_SUFFIX = ".zip";
    /** 数据库JSON标志 */
    public static final String DB_JOSN_SIGN = "$.";
    /**file11*/
    public static final String FILE11 = "file11";
    /**脚本约定 start*/
    /**脚本 head 方法*/
    public static final  String HEAD_METHOD = "head";
    /**脚本 trans 方法*/
    public static final  String TRANS_METHOD = "trans";
    /**脚本 main 方法*/
    public static final  String CHECK_METHOD = "main";
    /**脚本命名前缀*/
    public final static String SCRIPT_CHECK = "check_";
    public final static String SCRIPT_HANDLE = "hanle_";
    public final static String SCRIPT_TRANS = "trans_";
    public final static String SCRIPT_V1TOV2 = "v1tov2_";
    /**脚本命名后缀*/
    public final static String SCRIPT_SUFFIX = ".js";
    /**脚本返回标识符字段*/
    public static final String SCRIPT_RESULT = "result";
    /**脚本返回数据字段*/
    public static final String SCRIPT_DATA = "data";
    /** 脚本传入json 项目类型 key */
    public static final String PROJECTTYPE = "projecttype";
    /** 脚本传入json 资产 key */
    public static final String ASERT = "asert";
    /**任务脚本约定 end*/


    /**v2.0 json格式 start*/
    /** json 文件类型key*/
    public final static String IMPORTFILETYPE = "IMPORTFILETYPE";
    /** json 时间戳命名key */
    public static final String TIMESTAMPNAME = "TIMESTAMP";
    /** json 批次号命名key */
    public static final String IMPORTID = "IMPORTID";
    /** json uuid命名key */
    public static final String UUID = "UUID";
    /**导入文件类型前缀 value*/
    public final static String FILE = "file";
    /**v2.0 json格式 end*/


    /**file1 2 abs处理状态 "SUCCESS"*/
    public static final String ABS_DEAL_SUCCESS= "SUCCESS";
    /**file1 2 abs处理状态 "INIT"*/
    public static final String INIT= "INIT";
    /**file1 2 abs处理状态 "FAIL"*/
    public static final String FAIL= "FAIL";


    public final static String SERIALNUMBER = "借据号";

    public final static String PROJECTID = "项目编号";

    public final static String PROJECTID_EN = "projectId";

    public final static String AGENCYID = "机构编号";

    public final static String AGENCYID_EN = "agencyId";

    public final static String SERIALNUMBER_EN = "serialNumber";


    /**区块链约定 start */
    public final static String STARTHHMMSS = " 00:00:00";
    public final static String ENDHHMMSS = " 23:59:59";
    public final static String BLOCKCODE = "code";
    public final static String BLOCKMSG = "message";
    public final static String BLOCKOK = "200";
    public final static String BLOCKDATA = "data";
    public final static String BLOCKSING = "BLOCK";
    /**区块链约定 end */

    /**脚本默认文件夹名称*/
    public static final String DEFAULT_SIGN = "default";

    /**加密字段 身份证号*/
    public static final String ENCRYPT_ID_NUMBER = "身份证号";
    public static final String ENCRYPT_PHONE_NUMBER = "手机号";
    public static final String ENCRYPT_CUSTOMER_NAME = "客户姓名";

    /**部分密钥*/
    public static final String  SECRET_KEY = "123456";
    /**starlink abs 字段对应表默认符*/
    public static final String FIELDCONTRASTDICT_STR = "-";
    public static final Integer FIELDCONTRASTDICT_INT = 0;

    /**等同于FileNameImportEnum.ASSETTRADE*/
    public static final String ASSETTRADE_BACK = "file14";
    public static final String LOANCONTRACT = "file01";
    public static final String MAINBORROWER = "file02";
    public static final String RELATIONBORROWER = "file03";
    public static final String CARGUARANTY = "file04";
    public static final String REPAYMENTPLAN = "file05";
    public static final String ASSETTRADE = "file06";
    public static final String REALREPAYMENT = "file07";
    public static final String ASSETDISPOSALPROCESS = "file08";
    public static final String ASSETTRADEADDITIONAL = "file09";
    public static final String ASSETRECONCILIATION = "file10";
    public static final String PROJECTRECONCILIATION = "file11";
    public static final String ENTERPRISENAME = "file12";
    public static final String HOUSEGUARANTY = "file13";
    /**SCENE:合同变更信息 保存由版本一转化过来的数据*/
    public static final String SCENE = "file15";

    /**statistics*/
    public static final String TOTALSIZE = "totalSize";
    public static final String SUCCESSSIZE = "successSize";
    public static final String FAILSIZE = "failSize";

    public static final String NA = "N/A";

    /**ftp*/
    public static final String FTPNAME = "ftpname";
    public static final String FTPPATH = "ftppath";
    public static final String SAVEFTPPATH = "saveftppath";

    public static final String CSV_SUFFIX = ".csv";
    /**全局项目id */
    public static final String GLOBAL_ID = "GLOBAL";


    public static final String XLSX_SUFFIX = ".xlsx";

    public static final String XLS_SUFFIX = ".xls";

    public final static String WESHARE = "_WESHARE_";

    public static final String CHANGE_PLAN = "是否变更还款计划";

    public static final String CHANGE_TIME = "变更时间";

    public static final String SETTLE_REASON = "结清原因";

    public static final String ABS_VIDEO_CODE = "1";

    public static final String NO_PUSH = "NOPUSH";

    public static final String PUSHED = "PUSHED";

    public static final String MSG = "msg";
}

package com.ljl.sample;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 词库，从数据库内拷贝查出来的
 */
public class Dic {
    private static String DIC="编码\tcode\tcode\n" +
            "号\t_no\t_no\n" +
            "接受\taccept\taccept\n" +
            "账户\taccount\tacct\n" +
            "动作\taction\taction\n" +
            "活动\tactivity\tact\n" +
            "实际\tactual \tactual\n" +
            "适用\tadapt\tadapt\n" +
            "新增\tadd\tadd\n" +
            "地址\taddress\taddr\n" +
            "核算\tadjust\tadjust\n" +
            "广告\tadvertisement\tad\n" +
            "建议\tadvice\tadvice\n" +
            "后\tafter\tafter\n" +
            "售后\tafter_sale\taftSal\n" +
            "售后单\tafter_sale_order\taso\n" +
            "税后\tafter_tax\taftTax\n" +
            "重新\tagain\tagain\n" +
            "聚合\taggregate\tagg\n" +
            "别名\talias\talias\n" +
            "全部\tall\tall\n" +
            "分配\tallot\tallot\n" +
            "允许\tallow\tallow\n" +
            "已经\talready\talr\n" +
            "数量\tamount\tamt\n" +
            "金额\tmoney\tmoney\n" +
            "和\tand\tand\n" +
            "回答\tanswer\tansw\n" +
            "回答人\tanswerer\tanswr\n" +
            "APP\tapp\tapp\n" +
            "追加\tappend\tappe\n" +
            "申请人\tapplicant\tapplic\n" +
            "应用\tapplication\tappl\n" +
            "申请\tapply\tapply\n" +
            "预约\tappoint\tapot\n" +
            "资质\taptitude\tapti\n" +
            "区域\tarea\tarea\n" +
            "批次\tarray\tarray\n" +
            "送达\tarrive\tarrive\n" +
            "货号\tart_no\tart_no\n" +
            "项目\tarticle\tarti\n" +
            "人工\tartificial\tartfc\n" +
            "指定\tassign\tassign\n" +
            "承担\tassume\tassume\n" +
            "首先\tat_first\tatFir\n" +
            "附加\tattach\tattach\n" +
            "附件\tattachment\tatt\n" +
            "属性\tattribute\tattr\n" +
            "审核人\tauditor \taud\n" +
            "自动\tautomatic\tauto\n" +
            "平均\tavg\tavg\n" +
            "返回\tback\tback\n" +
            "后台\tbackstage\tbs\n" +
            "余额\tbalance\tbal\n" +
            "银行\tbank\tbank\n" +
            "条码\tbarcode\tbrcode\n" +
            "特价\tbargain\tbrg\n" +
            "基础\tbase\tbase\n" +
            "基本\tbasic\tbasic\n" +
            "批量\tbatch\tbatch\n" +
            "前\tbefore\tbef\n" +
            "所属\tbelong\tbelong\n" +
            "单据\tbill\tbill\n" +
            "账单\tbilling\tbillng\n" +
            "绑定\tbind\tbind\n" +
            "保证金\tbond\tbond\n" +
            "品牌\tbrand\tbrand\n" +
            "业务\tbusiness\tbusi\n" +
            "按钮\tbutton\tbutton\n" +
            "购买\tbuy\tbuy\n" +
            "按距离\tby_distance\tbyDist\n" +
            "按件数\tby_piece\tbyPce\n" +
            "计件\tcal_piece\tcalPce\n" +
            "按金额\tby_money\tbyMny\n" +
            "按体积\tby_volume\tbyVo\n" +
            "按重量\tby_weight\tbyWt\n" +
            "自行\tbyself\tbyself\n" +
            "可\tcan\tcan\n" +
            "取消\tcancel\tcancel\n" +
            "资金\tcapital\tcapitl\n" +
            "运输\tcarriage\tcarri\n" +
            "收银员\tcashier\tcasher\n" +
            "类目\tcategory\tcatg\n" +
            "中心\tcenter\tcen\n" +
            "证书\tcertificate\tcert\n" +
            "改价\tchange_price\tchaPri\n" +
            "渠道\tchannel\tchann\n" +
            "计费\tcharge\tcharge\n" +
            "检查\tcheck\tcheck\n" +
            "子\tchild\tchild\n" +
            "选择\tchoose\tchoose\n" +
            "全选\tchoose_all\tcholl\n" +
            "流转\tcirculation\tcircl\n" +
            "类别\tclasses\tclsses\n" +
            "分类\tclassify\tclassf\n" +
            "清除\tclear\tclear\n" +
            "客户\tclient\tclient\n" +
            "关闭\tclose\tclose\n" +
            "已关闭\tclosed\tclosed\n" +
            "云\tcloud\tcloud\n" +
            "代码\tcoding\tcoding\n" +
            "收藏\tcollect\tcollct\n" +
            "收票\tcollect_ticket\tcolTic\n" +
            "收款\tcollection\tcoll\n" +
            "冒号\tcolon\tcolon\n" +
            "组合\tcombine\tcomb\n" +
            "提交\tcommit\tcomt\n" +
            "公司\tcompany\tcompy\n" +
            "补偿\tcompensate\tcompst\n" +
            "综合\tcomprehensive\thensiv\n" +
            "条件\tcondition\tcond\n" +
            "配置\tconfig\tconf\n" +
            "确认\tconfirm\tconfir\n" +
            "连接符\tconnector\tconn\n" +
            "收件\tconsignee\tconsig\n" +
            "咨询\tconsult\tconsu\n" +
            "咨询人\tconsultant\tcnsant\n" +
            "联系\tcontact\tconta\n" +
            "联系电话\tcontact_phone\tconPho\n" +
            "内容\tcontent\tcont\n" +
            "续件数\tconti_piece_amount\tcPAmt\n" +
            "续费\tconti_piece_cost\tcPCost\n" +
            "继续\tcontinue\tconti\n" +
            "续重\tcontinue_weight\tcontiW\n" +
            "控制\tcontrol\tctrl\n" +
            "复制\tcopy\tcopy\n" +
            "角标\tcorn\tcorn\n" +
            "法人\tcorporation\tcor\n" +
            "成本\tcost\tcost\n" +
            "优惠券\tcoupon\tcoupon\n" +
            "券码\tcoupon_code \tcouCod\n" +
            "覆盖\tcover\tcover\n" +
            "创建\tcreate\tcreate\n" +
            "创建人\tcreate_by\tcreaby\n" +
            "信用\tcredit\tcredit\n" +
            "币种\tcurrency\tcur\n" +
            "自定义\tcustom\tcustom\n" +
            "客服\tcustom_service\tcS\n" +
            "周期\tcycle\tcycle\n" +
            "数据\tdata\tdata\n" +
            "日期\tdate\tdate\n" +
            "天\tday\tday\n" +
            "交易\tdeal\tdeal\n" +
            "默认\tdefault\tdeft\n" +
            "定义\tdefinition\tdef\n" +
            "删除\tdelete\tdel\n" +
            "交货\tdelivery\tdely\n" +
            "交货行\tdelivery_line\tdline\n" +
            "交货单\tdelivery_order\tdelyOr\n" +
            "描述\tdescribe\tdesc\n" +
            "说明\tdescription\tdesct\n" +
            "明细\tdetail\tdetail\n" +
            "清单\tdetail_list\tdtlLs\n" +
            "维度\tdimension\tdimen\n" +
            "停用\tdisable\tdisa\n" +
            "派单\tdispatch\tdisp\n" +
            "距离\tdistance\tdtan\n" +
            "配送\tdistribute\tdist\n" +
            "配送商\tdistributor\tdtb\n" +
            "营业\tdo_business\tdoBus\n" +
            "上门\tdoor_to_door\tdTod\n" +
            "下载\tdownload\tdload\n" +
            "开票人\tdrawer\tdrawer\n" +
            "应付\tdue\tdue\n" +
            "保质到期日\tdue_date\td_date\n" +
            "编辑\tedit\tedit\n" +
            "生效\teffect\teffect\n" +
            "邮件\temail\temail\n" +
            "邮箱\temailbox\tebox\n" +
            "EMS\tems\tems\n" +
            "启用\tenable\tenable\n" +
            "结束\tend\tend\n" +
            "已结束\tended\tended\n" +
            "英文\tenglish\ten\n" +
            "进入\tenter\tenter\n" +
            "回车\tenter_key\tenKey\n" +
            "企业\tenterprise\tee\n" +
            "录入\tentry\tentry\n" +
            "预计\testimated\test\n" +
            "评论\tevaluate\teval\n" +
            "每\tevery\tevery\n" +
            "验\texamine\texa\n" +
            "异常\texception\texptn\n" +
            "专营\texclusion\texclu\n" +
            "存在\texist\texist\n" +
            "保质期\texp\texp\n" +
            "展开\texpand\texpand\n" +
            "费用\texpense\texpnse\n" +
            "到期\texpire\texpire\n" +
            "导出\texport\texpo\n" +
            "快递\texpress\texps\n" +
            "外部\texternal\textern\n" +
            "因子\tfactor\tfactor\n" +
            "失败\tfail\tfail\n" +
            "粉丝\tfans\tfans\n" +
            "文件\tfile\tfile\n" +
            "财务\tfinance\tfin\n" +
            "查找\tfind\tfind\n" +
            "完成\tfinish\tfinish\n" +
            "已完成\tfinished\tfined\n" +
            "首件\tfirst_piece\tfirPce\n" +
            "首费\tfirst_piece_cost\tfPCost\n" +
            "初次\tfirst_time\tfirT\n" +
            "首重\tfirst_weight\tfirWt\n" +
            "固定电话\tfixed_phone\tfixPh\n" +
            "流水\tflow\tflow\n" +
            "流水号\tflow_no\tflowNo\n" +
            "关注\tfocus\tfocus\n" +
            "免费\tfree\tfree\n" +
            "包邮\tfree_delivery\tfDeli\n" +
            "免邮\tfree_shipping\tfShip\n" +
            "运费\tfreight\tfre\n" +
            "冻结\tfrozen\tfrozen\n" +
            "满\tfull\tfull\n" +
            "满量\tfull_amount\tfAmt\n" +
            "姓名\tfull_name\tfName\n" +
            "满额\tfull_quota\tfQuota\n" +
            "模糊\tfuzzy\tfuzzy\n" +
            "生成\tgenerate\tgenera\n" +
            "提货\tget_delivery\tgDely\n" +
            "依据\tgist\tgist\n" +
            "商品\tgoods\tgoods\n" +
            "毛利率\tgprofit\tgpro\n" +
            "等级\tgrade\tgrade\n" +
            "分组\tgroup\tgroup\n" +
            "保障\tguarantee\tgrnt\n" +
            "处理\thandle\thandle\n" +
            "已处理\thandled\thanded\n" +
            "挂起\thang_up\thangUp\n" +
            "发生\thappen\thappen\n" +
            "负责人\theadman\thMan\n" +
            "高\thigh\thigh\n" +
            "高危\thigh_risk\th_risk\n" +
            "送货上门\thome_delivery\tdelyHo\n" +
            "时\thour\thour\n" +
            "小时\thour_unit\thourUn\n" +
            "ID\tID\tID\n" +
            "图片\timg\timg\n" +
            "导入\timport\timport\n" +
            "入\tin\tin\n" +
            "入库\tin_stock\ti_sck\n" +
            "包含\tinclude\tinclud\n" +
            "信息\tinfo\tinfo\n" +
            "进行中\ting\ting\n" +
            "发起\tinitiate\tinitia\n" +
            "站内信\tinMail\tinMail\n" +
            "输入\tinput\tinput\n" +
            "验货\tinspection\tinspec\n" +
            "站内\tinstation\tinst\n" +
            "侮辱性\tinsulting\tinsu\n" +
            "接口\tinterface\tinter\n" +
            "内购\tinternal_purchase\tiPurch\n" +
            "发票\tinvoice \tinvoic\n" +
            "开发票\tinvoicing\tinvcg\n" +
            "条\titem\titem\n" +
            "参与\tjoin\tjoin\n" +
            "跳转\tjump\tjump\n" +
            "标签\tlabel\tlabel\n" +
            "阶梯\tladder\tladder\n" +
            "最后\tlast\tlast\n" +
            "最新\tlatest\tlst\n" +
            "信\tletter\tletter\n" +
            "层级\tlevel\tlevel\n" +
            "执照\tlicense \tlice\n" +
            "点赞\tlike\tlike\n" +
            "行号\tline_no\tlino\n" +
            "联系人\tlinkman\tlinkma\n" +
            "列表\tlist\tlist\n" +
            "加载\tload\tload\n" +
            "定位\tlocation\tloc\n" +
            "日志\tlog\tlog\n" +
            "物流\tlogistics\tlogist\n" +
            "logo\tlogo\tlogo\n" +
            "长\tlong\tlong\n" +
            "批号\tlot_no\tlot_no\n" +
            "产地\tmade_in\tmad_in\n" +
            "主条码\tmain_bar_code\tbarCod\n" +
            "主图\tmain_picture\tmp\n" +
            "制造\tmake\tmake\n" +
            "开票\tmake_out_invoice\tmOutIn\n" +
            "商城\tmall\tmall\n" +
            "管理\tmanage\tmag\n" +
            "经营\tmanagement\tmana\n" +
            "手动\tmanual\tmanual\n" +
            "制造商\tmanufacturer\tmanuf\n" +
            "标识\tmark\tmark\n" +
            "市场\tmarket\tmarket\n" +
            "匹配\tmatch\tmatch\n" +
            "素材\tmaterial\tmater\n" +
            "最高\tmax\tmax\n" +
            "餐盒\tmeal_box\tmBox\n" +
            "会员\tmember\tmem\n" +
            "菜单\tmenu\tmenu\n" +
            "商家\tmerchant\tmercha\n" +
            "短信\tmessage\tmsg\n" +
            "消息云\tmessage_cloud\tmsgCl\n" +
            "计量\tmetering\tmeter\n" +
            "最低\tmin\tmin\n" +
            "起订量\tmin_num\tmi_num\n" +
            "手机号\tmobile_phone_no\tmbPN\n" +
            "移动高清\tmobile_hd\tmbHd\n" +
            "方式\tmode\tmode\n" +
            "修改\tmodify\tmodify\n" +
            "转移\tmove\tmove\n" +
            "下移\tmove_down\tm_down\n" +
            "上移\tmove_up\tm_up\n" +
            "倍数\tmulti\tmulti\n" +
            "互斥\tmutex\tmutex\n" +
            "名称\tname\tname\n" +
            "负\tnegative\tneg\n" +
            "重量\tnet_weight\tnetWt\n" +
            "新建\tnew\tnew\n" +
            "消息\tnews\tnews\n" +
            "下一步\tnext\tnext\n" +
            "昵称\tnickname\tnName\n" +
            "否\tno\tno\n" +
            "不\tno_\tno_\n" +
            "不通过\tno_pass\tnoPass\n" +
            "节点\tnode\tnode\n" +
            "普通\tnormal\tnor\n" +
            "通知\tnotice\tnotice\n" +
            "号码\tnumber\tnum\n" +
            "对象\tobject\tobj\n" +
            "禁用\toff\toff\n" +
            "线下\toffline\tofline\n" +
            "线上\tonline\tonline\n" +
            "O+O\tonline_offline\tO+O\n" +
            "打开\topen\topen\n" +
            "开户\topen_account\topenac\n" +
            "开户行\topening_bank\t\n" +
            "操作\toperate\topera\n" +
            "运算\toperation\tops\n" +
            "操作人\toperator\toper\n" +
            "运算符\toperator_sign\toSign\n" +
            "订单\torder\torder\n" +
            "订单行\torder_line\tol\n" +
            "订单号\torder_no\to_no\n" +
            "订购\tordering\torderg\n" +
            "组织\torganization\torg\n" +
            "组织机构代码\torganization_code\toCode\n" +
            "原始\toriginal \torig\n" +
            "其他\tother\tother\n" +
            "对方\tother_side\to_side\n" +
            "出\tout\t\n" +
            "出入库\tout_in_stock\toi_sck\n" +
            "出库\tout_stock\to_sck\n" +
            "超过\tover\tover\n" +
            "已过期\tover_date\tovDate\n" +
            "超限\tover_limit\toLimit\n" +
            "过期\toverdue\toDue\n" +
            "叠加\toverlying\toverly\n" +
            "超时\tovertime\tovtime\n" +
            "所有人\towner\towner\n" +
            "收起\tpack_up\tpackUp\n" +
            "包裹\tpackage\tpack\n" +
            "页面\tpage\tpage\n" +
            "已付\tpaid\tpaid\n" +
            "参数\tparameter\tparm\n" +
            "父\tparent\tparent\n" +
            "部分\tpart\tpart\n" +
            "详情\tparticulars\tprtilr\n" +
            "通过\tpass\tpass\n" +
            "密码\tpassword\tpwd\n" +
            "支付\tpay\tpay\n" +
            "付款\tpayment\tpayme\n" +
            "%\tpercentage\tper\n" +
            "期限\tperiod\tperiod\n" +
            "有效期\tperiod_of_validiy\tpov\n" +
            "人\tperson\t\n" +
            "个人\tpersonal\tpers\n" +
            "手机\tmobile_phone\tmbP\n" +
            "拣货\tpick\tpick\n" +
            "取件\tpick_up\tpickUp\n" +
            "拣货员\tpicker\tpicker\n" +
            "拣货单\tpicking_list\tpl\n" +
            "件\tpiece\tpiece\n" +
            "件数\tpiece_amount\tpAmnt\n" +
            "下单\tplace_order\tplaOrd\n" +
            "计划\tplan\tplan\n" +
            "平台\tplatform\tplat\n" +
            "请选择\tplease_choose\tpChoo\n" +
            "添加\tplus\tplus\n" +
            "扣点\tpoints_down\tpDown\n" +
            "政治\tpolitics\tpoli\n" +
            "pos\tpos\tpos\n" +
            "位置\tposition\tposi\n" +
            "岗位\tpost\tpost\n" +
            "邮政编码\tpostalcode\tpCode\n" +
            "权限\tpower\tpower\n" +
            "上一步\tpre\tpre\n" +
            "税前\tpre_tax\tpreTax\n" +
            "优惠\tpreferential\tpref\n" +
            "预览\tpreview\tprev\n" +
            "价格\tprice\tprice\n" +
            "打印\tprint\tprint\n" +
            "预先\tprior\tprior\n" +
            "优先\tpriority\tpri\n" +
            "优先级\tpriority_level\tpriLvl\n" +
            "专业\tprofession\tpro\n" +
            "流程\tprocess\tproces\n" +
            "产品\tproduct\tprod\n" +
            "生产日期\tproduction_date\tp_date\n" +
            "进度\tprogress\tprog\n" +
            "促进\tpromotion\tprotn\n" +
            "促销\tpromotion_sell\tpSell\n" +
            "面积\tproportion\tpropo\n" +
            "发表\tpublish\tpubl\n" +
            "下架\tpull\tpull\n" +
            "撤回\tpull_back\tpBack\n" +
            "撤出\tpull_out\tpOut\n" +
            "采退\tpur_back\tpuBack\n" +
            "采购\tpurchase\tpurch\n" +
            "PO\tpurchase_order\tPO\n" +
            "用途\tpurpose\tpurp\n" +
            "投放\tput\tput\n" +
            "上架\tputaway\tputawy\n" +
            "QQ\tqq\tqq\n" +
            "查询\tquery\tquery\n" +
            "提问\tquestion\tques\n" +
            "提问人\tquestioner\tqueser\n" +
            "快速\tquick\tquick\n" +
            "范围\trange\trange\n" +
            "级别\trank\trank\n" +
            "率\trate\trate\n" +
            "至\treach\treach\n" +
            "待发送\tready_send\trSend\n" +
            "原因\treason\treason\n" +
            "应收\treceivable\trece\n" +
            "接收\treceive\trec\n" +
            "收件人\treceiver\trecver\n" +
            "前台\treception\trecp\n" +
            "充值\trecharge\trech\n" +
            "对账\treconciliations\trecon\n" +
            "记录\trecord\trecord\n" +
            "应退\trecoverable\trecov\n" +
            "退款\trefund\trefund\n" +
            "拒绝\trefuse\trefuse\n" +
            "报名\tregist\tregist\n" +
            "注册\tregister\treg\n" +
            "驳回\treject\treject\n" +
            "关联\trelation\trelat\n" +
            "备注\tremark\tremark\n" +
            "备注人\tremarker\tremker\n" +
            "提醒\tremind\tremind\n" +
            "移除\tremove\tremove\n" +
            "重复\trepeat\tre\n" +
            "重新派单\trepeat_dispatch\treDisp\n" +
            "回复\treply\treply\n" +
            "排斥\trepulsion\trepul\n" +
            "请求\trequest\treq\n" +
            "重置\treset\treset\n" +
            "剩余\tresidue\tresd\n" +
            "休息\trest\trest\n" +
            "限购\trestrictions\trestri\n" +
            "结果\tresult\tresult\n" +
            "零售\tretail\tretail\n" +
            "零售价\tretail_price\tr_pri\n" +
            "退回\treturn\treturn\n" +
            "退换货\treturn_and_exchange\treExch\n" +
            "退货\treturn_goods\treGood\n" +
            "可退\treturnable\treb\n" +
            "返件\treturned\tred\n" +
            "税收\trevenue\trev\n" +
            "审核\taudit\taudit\n" +
            "撤销\trevoke\trevoke\n" +
            "打赏\treward\treward\n" +
            "角色\trole\trole\n" +
            "毛重\trough_weight\trw\n" +
            "行\trow\trow\n" +
            "单行\trow_num\tr_num\n" +
            "规则\trule\trule\n" +
            "运营\trun\trun\n" +
            "出售\tsale\tsale\n" +
            "销退\tsale_back\ts_back\n" +
            "销售员\tsalesman\tsman\n" +
            "保存\tsave\tsave\n" +
            "作用域\tscope\tscope\n" +
            "评分\tscore\tscore\n" +
            "筛选\tscreen\tscr\n" +
            "搜索\tsearch\tsearch\n" +
            "安全\tsecurity\tsec\n" +
            "安全码\tsecurity_code\tsCode\n" +
            "选取\tselect\tselect\n" +
            "选中\tselected\tsele\n" +
            "自提\tself\tself\n" +
            "自提点\tself_taking\tselTak\n" +
            "销售\tsell\tsell\n" +
            "销售商家\tsell_business\tselBus\n" +
            "卖家\tseller\tseller\n" +
            "发送\tsend\tsend\n" +
            "寄回\tsend_back\tsenBac\n" +
            "高级\tsenior\tsenior\n" +
            "敏感词\tsensitive\tsensi\n" +
            "已发送\tsent\tsent\n" +
            "序列\tsequence\tseq\n" +
            "系列\tser\tser\n" +
            "顺序\tserial\tserial\n" +
            "序列号起\tserial_num_begin\ts_beg\n" +
            "序列号止\tserial_num_end\ts_end\n" +
            "序号\tserial_no\tserNo\n" +
            "序列号\tserial_num\ts_num\n" +
            "服务\tservice\tserv\n" +
            "设置\tset\tset\n" +
            "结算\tsettlement\tsettle\n" +
            "屏蔽\tshield\tshield\n" +
            "发货\tshipment\tshipmt\n" +
            "发货仓\tshipment_warehouse\tshpWH\n" +
            "发运\tshipping\tshipp\n" +
            "店铺\tshop\tshop\n" +
            "招牌\tshop_sign\tsSign\n" +
            "显示\tshow\tshow\n" +
            "歇业\tshut\tshut\n" +
            "有货先发\tsifia\tsfia\n" +
            "标记\tsign\tsign\n" +
            "单一\tsingle\tsin\n" +
            "大小\tsize\tsize\n" +
            "来源\tsource\tsrc\n" +
            "座机\tspecial_phone\tsPhone\n" +
            "规格\tspecifications\tspecif\n" +
            "员工\tstaff\tstaff\n" +
            "开始\tstart\tstart\n" +
            "站\tstation\tstat\n" +
            "状态\tstatus\tstatus\n" +
            "步骤\tstep\tstep\n" +
            "库存\tstock\tstock\n" +
            "仓库\tstorage\tstrg\n" +
            "门店\tstore\tstore\n" +
            "故事\tstory\tstory\n" +
            "形式\tstyle\tstyle\n" +
            "副标题\tsubhead\tsubhd\n" +
            "主题\tsubject\tsubj\n" +
            "减\tsubtract\tsub\n" +
            "成功\tsuccess\tsucc\n" +
            "总\tsum\tsum\n" +
            "总数\tsum_total\tst\n" +
            "杂项\tsundry\tsundry\n" +
            "上级\tsuperior\tsuper\n" +
            "供应商\tsupplier\tsupr\n" +
            "供应\tsupply\tsup\n" +
            "支持\tsupport\tsuppo\n" +
            "符号\tsymbol\tsymbol\n" +
            "系统\tsystem\tsys\n" +
            "收货\ttake_delivery\ttDeli\n" +
            "外卖\ttakeaway\tta\n" +
            "收票人\ttaker\ttaker\n" +
            "价目表\ttariff\ttariff\n" +
            "任务\ttask\ttask\n" +
            "税\ttax\ttax\n" +
            "税费\ttax_cost\ttaxC\n" +
            "税号\ttax_no\ttaxNo\n" +
            "电话\ttelephone\ttel\n" +
            "模板\ttemplate\ttempla\n" +
            "终端\tterminal\tterm\n" +
            "测试\ttest\ttest\n" +
            "文本\ttext\ttext\n" +
            "第三方\tthird\tthird\n" +
            "本次\tthis_time\tthiTim\n" +
            "本次发货\tthis_time_delivered\ttTDely\n" +
            "门槛\tthreshold\tthold\n" +
            "缩略图\tthumbnail\tthumb\n" +
            "时间\ttime\ttime\n" +
            "提示\ttips\ttips\n" +
            "标题\ttitle\ttitle\n" +
            "-\tto\tto\n" +
            "置顶\ttop\ttop\n" +
            "合计\ttotal\ttotal\n" +
            "跟踪\ttrack\ttrack\n" +
            "传统\ttradition\ttra\n" +
            "传输\ttransfer\ttrans\n" +
            "树\ttree\ttree\n" +
            "转\tturn\tturn\n" +
            "转入\tturn_in\tturnIn\n" +
            "转出\tturn_out\ttOut\n" +
            "类型\ttype\ttype\n" +
            "未\tun\tun\n" +
            "未发货\tundelivered\tunDeiy\n" +
            "未完成\tunfinished\tunfns\n" +
            "唯一\tunique\tunique\n" +
            "单位\tunit\tunit\n" +
            "未发送\tunsend\tunsend\n" +
            "更新人\tupd_by\tupd_by\n" +
            "更新\tupdate\tupdate\n" +
            "升级\tupgrade\tupg\n" +
            "上传\tupload\tupload\n" +
            "路径\turl\turl\n" +
            "可用\tusable\tusable\n" +
            "用户\tuser\tuser\n" +
            "有效\tvalid\tvalid\n" +
            "值\tvalue\tvalue\n" +
            "变量名\tvariable_name\tvn\n" +
            "变量\tvariate\tvar\n" +
            "详细\tverbose\tverbse\n" +
            "验证\tverify\tverify\n" +
            "视频\tvideo\tvideo\n" +
            "查看\tview\tview\n" +
            "词汇\tvocabulary\tvoca\n" +
            "体积\tvolume\tvol\n" +
            "凭证\tvoucher\tvcer\n" +
            "凭证号\tvoucher_no\tvouch\n" +
            "等待\twait\twait\n" +
            "温馨提示\twarm_prompt\twarmPt\n" +
            "途径\tway\tway\n" +
            "运单\twaybill\twb\n" +
            "称重\tweighing\tweigh\n" +
            "权重\tweight\tweight\n" +
            "是否\twhether\twheth\n" +
            "宽\twide\twide\n" +
            "无\twithout\twout\n" +
            "WMS\tWMS\tWMS\n" +
            "字数\tword_count\tWcount\n" +
            "工作\twork\twork\n" +
            "工号\twork_no\twNo\n" +
            "工单\twork_order\two\n" +
            "是\tyes\tyes\n" +
            "元\tyuan\tyuan\n" +
            "邮编\tzip_code\tzipCd\n" +
            "库区\tzone\tzone\n" +
            "排序\tsort\tsort\n" +
            "起始\tbegin\tbegin\n" +
            "终止\tfinal\tfinal\n" +
            "编号\tnumeration\tnumeri\n" +
            "分值\tpoint_value\tpValue\n" +
            "强制\tforce\tforce\n" +
            "主\tmain_\tmain_\n" +
            "辅\tsub_\tsub_\n" +
            "关系\trelationship\trela\n" +
            "请输入内容\tremark_holder\treHod\n" +
            "所需成长值\tneed_grown_value\tngv\n" +
            "单价\tprice_per_unit\tppu\n" +
            "商标\ttrademark\ttramrk\n" +
            "账户\taccount\tacct\n" +
            "账号\taccount_no\tacctNo\n" +
            "开具\tissue\tissue\n" +
            "抬头\ttitle_hud\thud\n" +
            "达成\tconclude\tconcl\n" +
            "基准\tstandard\tstnd\n" +
            "及\tas_well_as\tawa\n" +
            "发单\tsend_order\tsendO\n" +
            "拦截\tintercept\tintpt\n" +
            "次数\tnum_of_time\tnmot\n" +
            "问答\tqa\tqa\n" +
            "模式\tpattern\tpatt\n" +
            "生日\tbirthday\tbir\n" +
            "标准\tcriterion\tcritn\n" +
            "积分\tintegral  \tingrl\n" +
            "获取\tget\tget\n" +
            "消耗\texpend\texpend\n" +
            "已发货\tdelivered\tdelid\n" +
            "到货\tarrival\tarr\n" +
            "达到\tachieve\tach\n" +
            "立即\timmediately\timdtly\n" +
            "消费\tconsume\tcnsm\n" +
            "当前\tcurrent?\tcurr\n" +
            "变动\talteration\talt\n" +
            "成长\tgrown\tgrown\n" +
            "扣减\tdeduction\tdeduct\n" +
            "永久\talways\talys\n" +
            "按照\taccord\taccord\n" +
            "赠送\tpresented\tpresd\n" +
            "根据\taccording\tacding\n" +
            "价值\tworth\tworth\n" +
            "上限\tup_limit\tulmt\n" +
            "0.01元（1分钱）\tper_fen\tpFen\n";

    private  static Map<String,Token> dicMap=new HashMap<String,Token>();
    private Dic(){
        initDic();
       // System.out.println(this.toString());
    }
    private static Dic instance;
    public static void initDic(){
        dicMap.clear();
        String[] ss = DIC.split("\\n");
        for(int i=0;i<ss.length;i++){
            String[] sss = ss[i].split("\\t");
            if(sss.length<3){
                System.out.println("eeoor:"+sss[0]);
                Token t = new Token(sss[0],sss[1],sss[1]);
                dicMap.put(sss[0],t);
                cumputedWeight(t);
            }else{
                Token t = new Token(sss[0],sss[1],sss[2]);
                dicMap.put(sss[0],t);
                cumputedWeight(t);
            }
        }
    }

    private static void cumputedWeight(Token token){
     JSONObject dic  = ExistPairDic.getInstance().getDic();
        recursiveComputed(dic,token);
    }
    private static void recursiveComputed(JSONObject dic,Token token){
        if(dic.size()>0){
            for(String yw:dic.keySet()){
               Object ot = dic.get(yw);
               if(ot instanceof JSONObject){
                   JSONObject o =(JSONObject)ot;
                   if(o.size()>0){
                       recursiveComputed(o,token);
                   }
               }else if(ot instanceof String){
                   String zw = dic.getString(yw);
                   if(zw.contains(token.getZhName())){
                       int curAdd=-1;
                       if(yw.toLowerCase().contains(transEng(token.getEnName()))){
                           token.setEnWeight(token.getEnWeight()+1);
                           curAdd=1;
                       }else if(yw.toLowerCase().contains(transEng(token.getAbName()))){
                           token.setAbWeight(token.getAbWeight()+1);
                           curAdd=1;
                       }
                       token.setWeight(token.getWeight()+curAdd);
                   }
               }
            }
        }
    }

    public static void main(String[] args) {
        String s = transEng("zzz_bb_cc");
        System.out.println(s);
    }
    private static String transEng(String eng){
        java.util.regex.Pattern p = Pattern.compile("_([A-Za-z]{1})");
        Matcher m = p.matcher(eng);
        StringBuffer sb  = new StringBuffer();
        while(m.find()){
            m.appendReplacement(sb,m.group(1));
        }
        m.appendTail(sb);
        return sb.toString().toLowerCase();
    }


    private static synchronized void syncInit() {
        if (instance == null) {
            instance = new Dic();
        }
    }
    public static Dic getInstance(){
        if(instance==null){
            syncInit();
        }
        return instance;
    }

    public  Map<String, Token> getDicMap() {
        return dicMap;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(String key:dicMap.keySet()){
            sb.append(dicMap.get(key).toString()).append(',');
            sb.append("\r\n");
        }
        return sb.toString();
    }
}

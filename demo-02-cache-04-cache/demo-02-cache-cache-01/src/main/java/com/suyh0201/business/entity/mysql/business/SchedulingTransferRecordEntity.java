package com.suyh0201.business.entity.mysql.business;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.suyh0201.sys.constant.enums.OrderAuditStatusEnums;
import com.suyh0201.sys.constant.enums.OrderOriginEnums;
import com.suyh0201.sys.constant.enums.PayTypeEnums;
import com.suyh0201.sys.constant.enums.TransferStatusEnums;
import com.suyh0201.validation.groups.ValidationGroups;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author suyh
 * @since 2024-09-02
 */
@Data
@TableName(value = "scheduling_transfer_record", autoResultMap = true)
public class SchedulingTransferRecordEntity {

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @Schema(description = "主键id")
    @NotNull(groups = ValidationGroups.Req.Update.class)
    private Long id;

    @TableField("code")
    private String code;

    @TableField("pnum")
    private String pnum;

    /**
     * 支付类型【1:tpp支付｜2:银行卡支付】
     */
    @TableField("pay_type")
    @Schema(description = "支付类型")
    private PayTypeEnums payType;

    /**
     * tpp
     */
    @TableField("tpp")
    private String tpp;

    /**
     * 银行卡号
     */
    @TableField("card_no")
    @Schema(description = "银行卡号")
    private String cardNo;

    /**
     * 银行账号
     */
    @TableField("account")
    @Schema(description = "银行账号")
    private String account;

    @TableField(exist = false)
    @Schema(description = "金融账号：TPP/银行卡号")
    private String financialAccount;

    /**
     * swift
     */
    @TableField("swift")
    private String swift;

    /**
     * 买家uid
     */
    @TableField("receiver_uid")
    @Schema(description = "买家uid")
    private String receiverUid;

    /**
     * 购买信息 [{"sku":"SKU123","quantity":10,"price":99.99},{"sku":"SKU456","quantity":5,"price":59.99}]
     */
    @TableField("order_info")
    @Schema(description = "购买信息 [{\"sku\":\"SKU123\",\"quantity\":10,\"price\":99.99},{\"sku\":\"SKU456\",\"quantity\":5,\"price\":59.99}]")
    private String orderInfo;

    /**
     * 物流信息 [{"carrier":"usps","trackingNumber":"123456"},{"carrier":"ups","trackingNumber":"789012"}]
     */
    @TableField("logistics_info")
    @Schema(description = "物流信息 [{\"carrier\":\"usps\",\"trackingNumber\":\"123456\"},{\"carrier\":\"ups\",\"trackingNumber\":\"789012\"}]")
    private String logisticsInfo;

    /**
     * 金额
     */
    @TableField("amount")
    @Schema(description = "金额")
    private BigDecimal amount;

    /**
     * 订单真实金额
     */
    @TableField("real_amount")
    @Schema(description = "订单真实金额")
    private BigDecimal realAmount;

    /**
     * cp订单号
     */
    @TableField("cp_order")
    @Schema(description = "cp订单号")
    private String cpOrder;

    /**
     * 我方生成订单号(= mchnt_order_no)
     */
    @TableField("svip_order_no")
    @Schema(description = "我方生成订单号(= mchnt_order_no)")
    private String svipOrderNo;

    /**
     * 我方生成订单号
     */
    @TableField("mchnt_order_no")
    @Schema(description = "我方生成订单号")
    private String mchntOrderNo;

    /**
     * vip的uid信息
     */
    @TableField("uid")
    @Schema(description = "vip的uid信息")
    private String uid;

    /**
     * 商户号
     */
    @TableField("pn")
    @Schema(description = "商户号")
    private String pn;

    @TableField("pkg")
    private String pkg;

    /**
     * 渠道号
     */
    @TableField("channel")
    @Schema(description = "渠道号")
    private String channel;

    /**
     * 状态（【1-等待中、2-成功（已付款已发货）、3-付款失败，4-已提交、 5-未发货， 6-代理商异常】）<br/>
     * 修改为： 1-调度中、2-成功（已付款已发货）、3-调度失败，4-已付款未发货, 5-审核中<br/>
     * 修改(20241029)：调度状态（1-调度中、2-成功（已付款已发货）、3-调度失败，4-已付款未发货, 5-审核中,6-黑名单uid订单,7-重复下单,订单失效）
     */
    @TableField("status")
    @Schema(description = "状态")
    private TransferStatusEnums status;

    /**
     * 权重分
     */
    @TableField("score")
    @Schema(description = "权重分")
    private Integer score;

    /**
     * 完成时间
     */
    @TableField("mtime")
    @Schema(description = "完成时间")
    private Date mtime;

    /**
     * 创建时间
     */
    @TableField("created")
    @Schema(description = "创建时间")
    private Date created;

    /**
     * 更新时间
     */
    @TableField("updated")
    @Schema(description = "更新时间")
    private Date updated;

    /**
     * 过期时间
     */
    @TableField("expire_time")
    @Schema(description = "过期时间")
    private Date expireTime;

    /**
     * 日期
     */
    @TableField("dates")
    @Schema(description = "日期")
    private Integer dates;

    /**
     * 赠品订单号
     */
    @TableField("transfer_order_no")
    @Schema(description = "赠品订单号")
    private String transferOrderNo;

    /**
     * UTR
     */
    @TableField("utr")
    private String utr;

    @TableField("order_audit_status")
    @Schema(description = "订单审计状态")
    private OrderAuditStatusEnums orderAuditStatus;

    @TableField("audit_user_id")
    @Schema(description = "订单审核用户主键ID")
    private Long auditUserId;

    @TableField("audit_user_nick")
    @Schema(description = "订单审核用户昵称")
    private String auditUserNick;

    @TableField("audit_remark")
    @Schema(description = "备注")
    private String auditRemark;

    @TableField("reason")
    @Schema(description = "派单失败原因：code 值为空时，认为派单失败。")
    private String reason;

    @TableField("scheduling_count")
    @Schema(description = "code当前额度单位时间调度的第几笔")
    private Integer schedulingCount;

    @TableField("origin")
    @Schema(description = "订单命中来源[1:短信,2:邮件,3:人工审核]")
    private OrderOriginEnums origin;

    @TableField("origin_id")
    @Schema(description = "命中来源表主键id")
    private Long originId;
}

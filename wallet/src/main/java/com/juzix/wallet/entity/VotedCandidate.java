package com.juzix.wallet.entity;


import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.alibaba.fastjson.annotation.JSONField;
import com.juzhen.framework.util.NumberParserUtils;
import com.juzix.wallet.utils.LanguageUtil;

import java.util.Locale;

public class VotedCandidate implements Parcelable, Comparable<VotedCandidate> {
    /**
     * 节点ID
     */
    private String nodeId;
    /**
     * 节点名称
     */
    private String name;
    /**
     * 国家代码
     */
    private String countryCode;

    /**
     * 国家区域信息
     */
    @JSONField(deserialize = false, serialize = false)
    private Country countryEntity;

    /**
     * 有效票数
     */
    private String validNum;
    /**
     * 总票数
     */
    private String totalTicketNum;
    /**
     * 投票锁定,单位Energon
     */
    private String locked;
    /**
     * 投票解除锁定
     */
    private String unLocked;
    /**
     * 投票收益,单位Energon
     */
    private String earnings;
    /**
     * 最新投票时间，单位-毫秒
     */
    private String transactionTime;
    /**
     * 当时的购票价格，单位Energon
     */
    private String deposit;
    /**
     * 投票人钱包地址
     */
    private String owner;

    /**
     * 实际过期时间
     */
    private String deadLine;
    /**
     * 排列序号：由区块号和交易索引拼接而成
     */
    private int sequence;

    /**
     * 当时的购票价格
     */
    private String price;

    /**
     * 投票人钱包地址(接口为准)
     */
    private String walletAddress;

    /**
     * 是否有效：0-无效，1-有效
     */
    private String isValid;


    public VotedCandidate() {
    }

    protected VotedCandidate(Parcel in) {
        nodeId = in.readString();
        name = in.readString();
        countryCode = in.readString();
        validNum = in.readString();
        totalTicketNum = in.readString();
        locked = in.readString();
        unLocked = in.readString();
        earnings = in.readString();
        transactionTime = in.readString();
        deposit = in.readString();
        owner = in.readString();
        deadLine = in.readString();
        sequence = in.readInt();
        price = in.readString();
        walletAddress = in.readString();
        isValid = in.readString();
        countryEntity = in.readParcelable(countryEntity.getClass().getClassLoader());
    }

    public static final Creator<VotedCandidate> CREATOR = new Creator<VotedCandidate>() {
        @Override
        public VotedCandidate createFromParcel(Parcel in) {
            return new VotedCandidate(in);
        }

        @Override
        public VotedCandidate[] newArray(int size) {
            return new VotedCandidate[size];
        }
    };

    public Country getCountryEntity() {
        return countryEntity;
    }

    public void setCountryEntity(Country countryEntity) {
        this.countryEntity = countryEntity;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getValidNum() {
        return validNum;
    }

    public void setValidNum(String validNum) {
        this.validNum = validNum;
    }

    public String getTotalTicketNum() {
        return totalTicketNum;
    }

    public void setTotalTicketNum(String totalTicketNum) {
        this.totalTicketNum = totalTicketNum;
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }

    public String getUnLocked() {
        return unLocked;
    }

    public void setUnLocked(String unLocked) {
        this.unLocked = unLocked;
    }

    public String getEarnings() {
        return earnings;
    }

    public void setEarnings(String earnings) {
        this.earnings = earnings;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nodeId);
        dest.writeString(name);
        dest.writeString(countryCode);
        dest.writeString(validNum);
        dest.writeString(totalTicketNum);
        dest.writeString(locked);
        dest.writeString(unLocked);
        dest.writeString(earnings);
        dest.writeString(transactionTime);
        dest.writeString(deposit);
        dest.writeString(owner);
        dest.writeString(deadLine);
        dest.writeInt(sequence);
        dest.writeString(price);
        dest.writeString(walletAddress);
        dest.writeString(isValid);
        dest.writeParcelable(countryEntity, flags);

    }

    @Override
    public int compareTo(VotedCandidate o) {
        //按时间排序
//        return Long.compare(DateUtil.parse(o.transactionTime,DateUtil.DATETIME_FORMAT_PATTERN_WITH_SECOND),DateUtil.parse(transactionTime,DateUtil.DATETIME_FORMAT_PATTERN_WITH_SECOND));
        return Long.compare(NumberParserUtils.parseLong(transactionTime), NumberParserUtils.parseLong(o.transactionTime));

    }

    public String getCountryName(Context context) {
        if (countryEntity == null) {
            return null;
        }
        if (Locale.CHINESE.getLanguage().equals(LanguageUtil.getLocale(context).getLanguage())) {
            return countryEntity.getZhName();
        } else {
            return countryEntity.getEnName();
        }
    }
}

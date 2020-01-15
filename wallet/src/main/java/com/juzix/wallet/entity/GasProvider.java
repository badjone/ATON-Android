package com.juzix.wallet.entity;

import com.juzix.wallet.utils.BigIntegerUtil;

import org.web3j.tx.gas.ContractGasProvider;

public class GasProvider {

    private String gasLimit;

    private String gasPrice;

    public GasProvider() {
    }

    public String getGasLimit() {
        return gasLimit;
    }

    public void setGasLimit(String gasLimit) {
        this.gasLimit = gasLimit;
    }

    public String getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(String gasPrice) {
        this.gasPrice = gasPrice;
    }

    @Override
    public String toString() {
        return "GasProvider{" +
                "gasLimit='" + gasLimit + '\'' +
                ", gasPrice='" + gasPrice + '\'' +
                '}';
    }

    public org.web3j.tx.gas.GasProvider toSdkGasProvider() {
        return new ContractGasProvider(BigIntegerUtil.toBigInteger(gasPrice), BigIntegerUtil.toBigInteger(gasLimit));
    }
}
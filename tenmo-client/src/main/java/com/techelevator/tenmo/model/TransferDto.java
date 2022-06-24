package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class TransferDto {

    private Long transferId;
    private int transferTypeId;
    private int transferStatusId;
    private Long accountFrom;
    private Long accountTo;
    private BigDecimal amount;

    public TransferDto() {
    }

    public TransferDto(Long transferId, int transferTypeId, int transferStatusId, Long accountFrom, Long accountTo, BigDecimal amount) {
        this.transferId = transferId;
        this.transferTypeId = transferTypeId;
        this.transferStatusId = transferStatusId;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
    }

    public Long getTransferId() {
        return transferId;
    }

    public void setTransferId(Long transferId) {
        this.transferId = transferId;
    }

    public int getTransferTypeId() {
        return transferTypeId;
    }

    public void setTransferTypeId(int transferTypeId) {
        this.transferTypeId = transferTypeId;
    }

    public int getTransferStatusId() {
        return transferStatusId;
    }

    public void setTransferStatusId(int transferStatusId) {
        this.transferStatusId = transferStatusId;
    }

    public Long getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(Long accountFrom) {
        this.accountFrom = accountFrom;
    }

    public Long getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(Long accountTo) {
        this.accountTo = accountTo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTransferTypeDescription() {
        switch(this.transferTypeId) {
            case 1: return "Request";
            case 2: return "Send";
            default: return "No Transfer Type Given";
        }
    }

    public String getTransferStatusDescription() {
        switch(this.transferStatusId) {
            case 1: return "Pending";
            case 2: return "Approved";
            case 3: return "Rejected";
            default: return "No Transfer Status Given";
        }
    }

    @Override
    public String toString() {
        return "\nID: " + transferId +
                "\nFrom: " + accountFrom +
                "\nTo: " + accountTo +
                "\nType: " + transferTypeId +
                "\nStatus: " + transferStatusId +
                "\nAmount: $" + amount;
    }

}

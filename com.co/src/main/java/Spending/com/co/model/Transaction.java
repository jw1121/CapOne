package Spending.com.co.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"amount",
"is-pending",
"aggregation-time",
"account-id",
"clear-date",
"transaction-id",
"raw-merchant",
"categorization",
"merchant",
"transaction-time"
})
public class Transaction {

@JsonProperty("amount")
private long amount;
@JsonProperty("is-pending")
private boolean isPending;
@JsonProperty("aggregation-time")
private long aggregationTime;
@JsonProperty("account-id")
private String accountId;
@JsonProperty("clear-date")
private long clearDate;
@JsonProperty("transaction-id")
private String transactionId;
@JsonProperty("raw-merchant")
private String rawMerchant;
@JsonProperty("categorization")
private String categorization;
@JsonProperty("merchant")
private String merchant;
@JsonProperty("transaction-time")
private String transactionTime;

@JsonProperty("amount")
public long getAmount() {
return amount;
}

@JsonProperty("amount")
public void setAmount(long amount) {
this.amount = amount;
}

@JsonProperty("is-pending")
public boolean isIsPending() {
return isPending;
}

@JsonProperty("is-pending")
public void setIsPending(boolean isPending) {
this.isPending = isPending;
}

@JsonProperty("aggregation-time")
public long getAggregationTime() {
return aggregationTime;
}

@JsonProperty("aggregation-time")
public void setAggregationTime(long aggregationTime) {
this.aggregationTime = aggregationTime;
}

@JsonProperty("account-id")
public String getAccountId() {
return accountId;
}

@JsonProperty("account-id")
public void setAccountId(String accountId) {
this.accountId = accountId;
}

@JsonProperty("clear-date")
public long getClearDate() {
return clearDate;
}

@JsonProperty("clear-date")
public void setClearDate(long clearDate) {
this.clearDate = clearDate;
}

@JsonProperty("transaction-id")
public String getTransactionId() {
return transactionId;
}

@JsonProperty("transaction-id")
public void setTransactionId(String transactionId) {
this.transactionId = transactionId;
}

@JsonProperty("raw-merchant")
public String getRawMerchant() {
return rawMerchant;
}

@JsonProperty("raw-merchant")
public void setRawMerchant(String rawMerchant) {
this.rawMerchant = rawMerchant;
}

@JsonProperty("categorization")
public String getCategorization() {
return categorization;
}

@JsonProperty("categorization")
public void setCategorization(String categorization) {
this.categorization = categorization;
}

@JsonProperty("merchant")
public String getMerchant() {
return merchant;
}

@JsonProperty("merchant")
public void setMerchant(String merchant) {
this.merchant = merchant;
}

@JsonProperty("transaction-time")
public String getTransactionTime() {
return transactionTime;
}

@JsonProperty("transaction-time")
public void setTransactionTime(String transactionTime) {
this.transactionTime = transactionTime;
}

}


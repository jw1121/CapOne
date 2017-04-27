package Spending.com.co.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "error", "uid", "token", "onboarding-stage", "agg-status",
		"has-accounts-linked" })
public class LoginResponse {

	@JsonProperty("error")
	private String error;
	@JsonProperty("uid")
	private Integer uid;
	@JsonProperty("token")
	private String token;
	@JsonProperty("onboarding-stage")
	private String onboardingStage;
	@JsonProperty("agg-status")
	private String aggStatus;
	@JsonProperty("has-accounts-linked")
	private Boolean hasAccountsLinked;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("error")
	public String getError() {
		return error;
	}

	@JsonProperty("error")
	public void setError(String error) {
		this.error = error;
	}

	@JsonProperty("uid")
	public Integer getUid() {
		return uid;
	}

	@JsonProperty("uid")
	public void setUid(Integer uid) {
		this.uid = uid;
	}

	@JsonProperty("token")
	public String getToken() {
		return token;
	}

	@JsonProperty("token")
	public void setToken(String token) {
		this.token = token;
	}

	@JsonProperty("onboarding-stage")
	public String getOnboardingStage() {
		return onboardingStage;
	}

	@JsonProperty("onboarding-stage")
	public void setOnboardingStage(String onboardingStage) {
		this.onboardingStage = onboardingStage;
	}

	@JsonProperty("agg-status")
	public String getAggStatus() {
		return aggStatus;
	}

	@JsonProperty("agg-status")
	public void setAggStatus(String aggStatus) {
		this.aggStatus = aggStatus;
	}

	@JsonProperty("has-accounts-linked")
	public Boolean getHasAccountsLinked() {
		return hasAccountsLinked;
	}

	@JsonProperty("has-accounts-linked")
	public void setHasAccountsLinked(Boolean hasAccountsLinked) {
		this.hasAccountsLinked = hasAccountsLinked;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}

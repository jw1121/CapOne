package Spending.com.co.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "uid", "token", "api-token", "json-strict-mode",
		"json-verbose-response" })
public class Args {

	@JsonProperty("uid")
	private long uid;
	@JsonProperty("token")
	private String token;
	@JsonProperty("api-token")
	private String apiToken;
	@JsonProperty("json-strict-mode")
	private boolean jsonStrictMode;
	@JsonProperty("json-verbose-response")
	private boolean jsonVerboseResponse;

	@JsonProperty("uid")
	public long getUid() {
		return uid;
	}

	@JsonProperty("uid")
	public void setUid(long uid) {
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

	@JsonProperty("api-token")
	public String getApiToken() {
		return apiToken;
	}

	@JsonProperty("api-token")
	public void setApiToken(String apiToken) {
		this.apiToken = apiToken;
	}

	@JsonProperty("json-strict-mode")
	public boolean isJsonStrictMode() {
		return jsonStrictMode;
	}

	@JsonProperty("json-strict-mode")
	public void setJsonStrictMode(boolean jsonStrictMode) {
		this.jsonStrictMode = jsonStrictMode;
	}

	@JsonProperty("json-verbose-response")
	public boolean isJsonVerboseResponse() {
		return jsonVerboseResponse;
	}

	@JsonProperty("json-verbose-response")
	public void setJsonVerboseResponse(boolean jsonVerboseResponse) {
		this.jsonVerboseResponse = jsonVerboseResponse;
	}

}

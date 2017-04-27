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
@JsonPropertyOrder({ "email", "password", "args", "demo-account-type" })
public class LoginRequest {

	@JsonProperty("email")
	private String email;
	@JsonProperty("password")
	private String password;
	@JsonProperty("args")
	private LoginArgs args;
	@JsonProperty("demo-account-type")
	private String demoAccountType;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("password")
	public String getPassword() {
		return password;
	}

	@JsonProperty("password")
	public void setPassword(String password) {
		this.password = password;
	}

	@JsonProperty("args")
	public LoginArgs getArgs() {
		return args;
	}

	@JsonProperty("args")
	public void setArgs(LoginArgs args) {
		this.args = args;
	}

	@JsonProperty("demo-account-type")
	public String getDemoAccountType() {
		return demoAccountType;
	}

	@JsonProperty("demo-account-type")
	public void setDemoAccountType(String demoAccountType) {
		this.demoAccountType = demoAccountType;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({ "uid", "token", "api-token", "json-strict-mode",
			"json-verbose-response" })
	public class LoginArgs {
		@JsonProperty("uid")
		private Integer uid;
		@JsonProperty("token")
		private String token;
		@JsonProperty("api-token")
		private String apiToken;
		@JsonProperty("json-strict-mode")
		private Boolean jsonStrictMode;
		@JsonProperty("json-verbose-response")
		private Boolean jsonVerboseResponse;
		@JsonIgnore
		private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

		@JsonProperty("api-token")
		public String getApiToken() {
			return apiToken;
		}

		@JsonProperty("api-token")
		public void setApiToken(String apiToken) {
			this.apiToken = apiToken;
		}

		@JsonProperty("json-strict-mode")
		public Boolean getJsonStrictMode() {
			return jsonStrictMode;
		}

		@JsonProperty("json-strict-mode")
		public void setJsonStrictMode(Boolean jsonStrictMode) {
			this.jsonStrictMode = jsonStrictMode;
		}

		@JsonProperty("json-verbose-response")
		public Boolean getJsonVerboseResponse() {
			return jsonVerboseResponse;
		}

		@JsonProperty("json-verbose-response")
		public void setJsonVerboseResponse(Boolean jsonVerboseResponse) {
			this.jsonVerboseResponse = jsonVerboseResponse;
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
}

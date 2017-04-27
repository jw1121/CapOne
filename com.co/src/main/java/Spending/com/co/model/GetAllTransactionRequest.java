package Spending.com.co.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "args" })
public class GetAllTransactionRequest {

	@JsonProperty("args")
	private Args args;

	@JsonProperty("args")
	public Args getArgs() {
		return args;
	}

	@JsonProperty("args")
	public void setArgs(Args args) {
		this.args = args;
	}

}

package server.service.dummy.util;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class MailgunRequestParam {

	@Getter @Setter @JsonProperty("from")
	private String from;

	@Getter @Setter @JsonProperty("to")
	private String to;

	@Getter @Setter @JsonProperty("cc")
	private String cc;

	@Getter @Setter @JsonProperty("bcc")
	private String bcc;

	@Getter @Setter @JsonProperty("subject")
	private String subject;

	@Getter @Setter @JsonProperty("text")
	private String text;

	@Getter @Setter @JsonProperty("html")
	private String html;

	@Getter @Setter @JsonProperty("attachment")
	private String attachment;

	@Getter @Setter @JsonProperty("inline")
	private String inline;

	@Getter @Setter @JsonProperty("o:tag")
	private String o_tag;

	@Getter @Setter @JsonProperty("o:dkim")
	private String o_dkim;

	@Getter @Setter @JsonProperty("o:deliverytime")
	private String o_deliverytime;

	@Getter @Setter @JsonProperty("o:testmode")
	private String o_testmode;

	@Getter @Setter @JsonProperty("o:tracking")
	private String o_tracking;

	@Getter @Setter @JsonProperty("o:tracking-clicks")
	private String o_trackingClicks;

	@Getter @Setter @JsonProperty("o:tracking-opens")
	private String o_trackingOpens;

	@Getter @Setter @JsonProperty("o:require-tls")
	private String o_requireTls;

	@Getter @Setter @JsonProperty("o:skip-verification")
	private String o_skipVerification;

	@Getter @Setter @JsonProperty("h:X-My-Header")
	private String h_XMyHeader;

	@Getter @Setter @JsonProperty("v:my-var")
	private String v_myVar;
}

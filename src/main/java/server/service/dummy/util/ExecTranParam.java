package server.service.dummy.util;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ExecTranParam {

	@Getter @Setter
	private String version;

	@Getter @Setter
	private String accessId;

	@Getter @Setter
	private String accessPass;

	@Getter @Setter
	private String orderId;

	@Getter @Setter
	private String method;

	@Getter @Setter
	private String payTimes;

	@Getter @Setter
	private String cardNo;

	@Getter @Setter
	private String expire;

	@Getter @Setter
	private String secuityCode;

	@Getter @Setter
	private String token;

	@Getter @Setter
	private String pin;

	@Getter @Setter
	private String clientField1;

	@Getter @Setter
	private String clientField2;

	@Getter @Setter
	private String clientField3;

	@Getter @Setter
	private String clientFieldFlag;

	@Getter @Setter
	private String tokenType;
}

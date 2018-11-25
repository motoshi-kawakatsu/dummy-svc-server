package server.service.dummy.util;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class EntryTranParam {

	@Getter @Setter
	private String version;

	@Getter @Setter
	private String shopId;

	@Getter @Setter
	private String shopPass;

	@Getter @Setter
	private String orderId;

	@Getter @Setter
	private String jobCd;

	@Getter @Setter
	private String itemCode;

	@Getter @Setter
	private String amount;

	@Getter @Setter
	private String tax;

	@Getter @Setter
	private String tdFlag;

	@Getter @Setter
	private String tdTenantName;
}

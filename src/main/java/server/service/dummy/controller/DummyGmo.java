package server.service.dummy.controller;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class DummyGmo {

    @Value("${gmo.sleep}")		long sleepTime;
    @Value("${gmo.acs}")		String acs;
    @Value("${gmo.forward}")	String forward;
    @Value("${gmo.approve}")	String approve;
    @Value("${gmo.password}")	String shopPassword;

	@RequestMapping(value="/payment/EntryTran.idPass", method=RequestMethod.POST)
	@ResponseBody
	public String entryTran(@RequestParam(name="VerSion", required=false) String version,
							 @RequestParam(name="ShopID", required=true) String shopId,
							 @RequestParam(name="ShopPass", required=true) String shopPass,
							 @RequestParam(name="OrderID", required=true) String orderId,
							 @RequestParam(name="JobCd", required=true) String jobCd,
							 @RequestParam(name="ItemCode", required=false, defaultValue="0000990") String itemCode,
							 @RequestParam(name="Amount", required=false) String amount,
							 @RequestParam(name="Tax", required=false) String tax,
							 @RequestParam(name="TdFlag", required=false) String tdFlag,
							 @RequestParam(name="TdTenantName", required=false) String tdTenantName) throws Exception {
		String	accessId = createSecureRandomString();
		String	accessPass = createSecureRandomString();

		Thread.sleep(sleepTime);

		return accessId + "&" + accessPass;
	}

	@RequestMapping(value="/payment/ExecTran.idPass", method=RequestMethod.POST)
	@ResponseBody
	public String execTran(@RequestParam(name="VerSion", required=false) String version,
							@RequestParam(name="AccessID", required=true) String accessId,
							@RequestParam(name="AccessPass", required=true) String accessPass,
							@RequestParam(name="OrderID", required=true) String orderId,
							@RequestParam(name="Method", required=false) String method,
							@RequestParam(name="PayTimes", required=false) String payTimes,
							@RequestParam(name="CardNo", required=false) String cardNo,
							@RequestParam(name="Expire", required=false) String expire,
							@RequestParam(name="SecurityCode", required=false) String secutiryCode,
							@RequestParam(name="Token", required=false) String token,
							@RequestParam(name="PIN", required=false) String pin,
							@RequestParam(name="ClientField1", required=false) String clientField1,
							@RequestParam(name="ClientField2", required=false) String clientField2,
							@RequestParam(name="ClientField3", required=false) String clientField3,
							@RequestParam(name="ClientFieldFlag", required=false) String clientFieldFlag,
							@RequestParam(name="TokenType", required=false) String tokenType) throws Exception {
		String	tranId = RandomStringUtils.randomAlphanumeric(28);
		LocalDateTime nowDate = LocalDateTime.now();
		DateTimeFormatter	df = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		String	tranDate = df.format(nowDate);

		StringBuilder	buf = new StringBuilder(orderId);
		buf.append(forward);
		buf.append(method);
		buf.append(payTimes);
		buf.append(approve);
		buf.append(tranId);
		buf.append(tranDate);

		String	checkString = DigestUtils.md5Hex(buf.toString() + shopPassword);

		Thread.sleep(sleepTime);

		return acs + buf.toString() + checkString;
	}

	private static String createSecureRandomString() throws NoSuchAlgorithmException {
	    byte token[] = new byte[16];
	    StringBuilder buf = new StringBuilder();
	    SecureRandom random = null;

	    random = SecureRandom.getInstance("SHA1PRNG");
	    random.nextBytes(token);

	    for (int i = 0; i < token.length; i++) {
	        buf.append(String.format("%02x", token[i]));
	    }

	    return buf.toString();
	}

}

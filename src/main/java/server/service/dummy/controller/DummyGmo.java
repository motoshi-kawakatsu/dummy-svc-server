package server.service.dummy.controller;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import server.service.dummy.util.EntryTranParam;
import server.service.dummy.util.ExecTranParam;


@Controller
public class DummyGmo {

    @Value("${gmo.sleep}")		long sleepTime;
    @Value("${gmo.acs}")		String acs;
    @Value("${gmo.forward}")	String forward;
    @Value("${gmo.approve}")	String approve;
    @Value("${gmo.password}")	String shopPassword;

	@RequestMapping("/payment/EntryTran.idPass")
	@ResponseBody
	public String entryTran(@RequestBody EntryTranParam param) throws Exception {
		String	accessId = createSecureRandomString();
		String	accessPass = createSecureRandomString();

		Thread.sleep(sleepTime);

		return accessId + "&" + accessPass;
	}

	@RequestMapping("/payment/ExecTran.idPass")
	@ResponseBody
	public String execTran(@RequestBody ExecTranParam param) throws Exception {
		String	tranId = RandomStringUtils.randomAlphanumeric(28);
		LocalDateTime nowDate = LocalDateTime.now();
		DateTimeFormatter	df = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		String	tranDate = df.format(nowDate);

		StringBuilder	buf = new StringBuilder(param.getOrderId());
		buf.append(forward);
		buf.append(param.getMethod());
		buf.append(param.getPayTimes());
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

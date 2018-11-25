package server.service.dummy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import server.service.dummy.util.MailgunRequestParam;
import server.service.dummy.util.MailgunResponse;

@Controller
public class DummyMailgun {

	@Autowired
	private MailgunResponse		response;

    @Value("${mailgun.sleep}")	long sleepTime;

	@RequestMapping("/messages")
	@ResponseBody
	public MailgunResponse messages(@RequestBody MailgunRequestParam param) throws Exception {
		Thread.sleep(sleepTime);
		return response;
	}

}

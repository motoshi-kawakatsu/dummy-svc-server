package server.service.dummy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import server.service.dummy.util.MailgunResponse;

@Controller
public class DummyMailgun {

	@Autowired
	private MailgunResponse		response;

    @Value("${mailgun.sleep}")	long sleepTime;

	@RequestMapping(value="/messages", method=RequestMethod.POST)
	@ResponseBody
	public MailgunResponse messages(@RequestParam(name="to", required=true) String to,
									 @RequestParam(name="cc", required=false) String cc,
									 @RequestParam(name="bcc", required=false) String bcc,
									 @RequestParam(name="from", required=true) String from,
									 @RequestParam(name="h:Reply-To", required=false) String replyTo,
									 @RequestParam(name="subject", required=false) String subject,
									 @RequestParam(name="text", required=false) String text) throws Exception {
		Thread.sleep(sleepTime);
		return response;
	}

}

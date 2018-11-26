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

	@RequestMapping(path="/messages", method=RequestMethod.POST)
	@ResponseBody
	public MailgunResponse messages(@RequestParam("to") String to,
									 @RequestParam("cc") String cc,
									 @RequestParam("bcc") String bcc,
									 @RequestParam("from") String from,
									 @RequestParam("h:Reply-To") String replyTo,
									 @RequestParam("subject") String subject,
									 @RequestParam("text") String text) throws Exception {
		Thread.sleep(sleepTime);
		return response;
	}

}

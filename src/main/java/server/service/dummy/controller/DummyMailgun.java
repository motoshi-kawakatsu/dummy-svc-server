package server.service.dummy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import server.service.dummy.util.MailgunResponse;

@RestController
public class DummyMailgun {

	@Autowired
	private MailgunResponse		response;

    @Value("${mailgun.sleep}")	long sleepTime;

	@RequestMapping(path="/messages", method=RequestMethod.POST)
	@ResponseBody
	public MailgunResponse messages(@RequestParam("to") String to) throws Exception {
		Thread.sleep(sleepTime);
		return response;
	}

}

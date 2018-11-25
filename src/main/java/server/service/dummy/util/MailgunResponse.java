package server.service.dummy.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Component
@ConfigurationProperties(prefix = "mailgun")
public class MailgunResponse {

	@Getter @Setter
	private String message;

	@Getter @Setter
	private String id;
}

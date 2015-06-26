package axq.grape.mvc;

import axq.grape.message.EngineMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/engine")
public class EngineController {
	@Autowired
	JmsTemplate jmsTemplate;

	@RequestMapping("/run")
	public String startEngines(Model model) throws JMSException {
		jmsTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage(new EngineMessage("TERMINATE"));
			}
		});
		model.addAttribute("message", "引擎启动指令已发送");
		return "index";

	}
	@RequestMapping("/addquery")
	public String uploadFile(@RequestParam("file") final MultipartFile file, Model model) throws JMSException,IOException {
		InputStream inputStream=file.getInputStream();
		final EngineMessage engineMessage = new EngineMessage(inputStream);
		jmsTemplate.send(new MessageCreator() {
							 public Message createMessage(Session session) throws JMSException {
								 return session.createObjectMessage(engineMessage);
							 }
						 }
		);
		if (!file.isEmpty()) {
			model.addAttribute("message", file.getSize());
		}
		return "hello";
	}

}
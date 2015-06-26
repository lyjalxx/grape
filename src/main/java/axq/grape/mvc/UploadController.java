package axq.grape.mvc;

import axq.grape.message.EngineMessage;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by ace <arthur4it@gmail.com> on 26, 06, 2015.
 */
@Controller
@RequestMapping("/upload")
public class UploadController {
    @RequestMapping(method = RequestMethod.GET)
    public String startSetting(){
        return "addfile";
    }

}

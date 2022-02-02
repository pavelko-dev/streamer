package com.ppv.streamer.controllers;

import com.ppv.streamer.services.WebCamService;
import org.bytedeco.javacv.FrameGrabber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebCamController {
    @Autowired
    private WebCamService webCamService;

    @GetMapping(value = "getSelfie")
    public String getSelfie() {
        try {
            webCamService.getSelfie();
        } catch (FrameGrabber.Exception e) {
            e.printStackTrace();
        }

        return "pictures";
    }
}

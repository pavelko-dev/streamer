package com.ppv.streamer.services;

import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;
import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.IplImage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WebCamService {
    @Value("${resource.path}")
    private String resourcePath;

    private void saveImg(Frame frame) {
        OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
        IplImage img = converter.convert(frame);

        opencv_imgcodecs.cvSaveImage(resourcePath + "/selfie.jpg", img);
    }

    public void getSelfie() throws FrameGrabber.Exception {
        FrameGrabber grabber = new OpenCVFrameGrabber(0);
        grabber.start();
        saveImg(grabber.grab());
        grabber.close();
    }
}

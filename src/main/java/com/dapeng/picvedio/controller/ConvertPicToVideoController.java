package com.dapeng.picvedio.controller;

import com.dapeng.picvedio.service.ConvertPicToVideoService;
import com.dapeng.picvedio.utils.ConvertPicToVedio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
public class ConvertPicToVideoController {

    @Autowired
    ConvertPicToVideoService convertPicToVideoService;

    @RequestMapping(value = "convertPicToVideo")
    @ResponseBody
    public Map<String,Object> convertPicToVideo(@RequestBody ConvertPicToVedio convertPicToVedio) throws IOException {
        return convertPicToVideoService.convertToVedio(convertPicToVedio);
    }



    @RequestMapping(value = "testMessage")
    public String getMessage(){
        return "this is a test message";
    }
}

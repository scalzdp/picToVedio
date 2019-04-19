package com.dapeng.picvedio.service.impl;

import com.dapeng.picvedio.service.ConvertPicToVideoService;
import com.dapeng.picvedio.utils.ConvertPicToVedio;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ConvertPicToVideoServiceImpl implements ConvertPicToVideoService {

    private static boolean checkfile(String path) {
        File file = new File(path);
        if (!file.isFile()) {
            return false;
        }
        return true;
    }

    @Override
    public Map<String,Object> convertToVedio(ConvertPicToVedio convertPicToVedio) throws IOException {
        Map<String,Object> errorMap = new HashMap<>();
        Map<String,Object> resultMap = new HashMap<>();
        //首先对参数进行验证传入的参数是否正确
        //调用参数完成执行命令的拼接
        //执行ffmpeg命令
        if(!checkfile(convertPicToVedio.getFfmpegPath())){
            errorMap.put("error_ffmpegPath","传入的ffmpegPath错误");
        }
        if(!checkfile(convertPicToVedio.getTextpath())){
            errorMap.put("error_textpath","传入的textpath错误");
        }
        if(!checkfile(convertPicToVedio.getMp3path())){
            errorMap.put("error_mp3path","传入的mp3path错误");
        }
        if(errorMap.keySet().size()<=0){
            Runtime runtime = Runtime.getRuntime();
            Process proce = null;
            //视频截图命令，封面图。  8是代表第8秒的时候截图
            String cmd = "";
            String cut = convertPicToVedio.getFfmpegPath()+" -f concat -safe 0 -i "+convertPicToVedio.getTextpath()+" -i "+convertPicToVedio.getMp3path()+" -s 440x900 -pix_fmt yuvj420p -t 930 -vcodec mpeg4 "+convertPicToVedio.getOutputpath();
            String cutCmd = cmd + cut;
            proce = runtime.exec(cutCmd);
            proce.destroy();
            resultMap.put("result",convertPicToVedio.getOutputpath());
        }else{
            return errorMap;
        }
        return resultMap;
    }


}

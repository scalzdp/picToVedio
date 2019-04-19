package com.dapeng.picvedio;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PicTests {

    @Test
    public void testLoads() throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process proce = null;
        //视频截图命令，封面图。  8是代表第8秒的时候截图
        String cmd = "";

        String cut = "E:\\03environment\\ffmpeg\\bin\\ffmpeg.exe  -f concat -safe 0 -i E:\\03environment\\ffmpeg\\bin\\test.txt -i E:\\03environment\\ffmpeg\\bin\\test3.mp3 -s 440x900 -pix_fmt yuvj420p -t 930 -vcodec mpeg4 D:\\test4.mp4";
        String cutCmd = cmd + cut;
        proce = runtime.exec(cutCmd);
    }
}

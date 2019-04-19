package com.dapeng.picvedio;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mountcloud.ffmepg.operation.ffmpeg.vidoe.FFMpegVideoFormatM3u8;
import org.mountcloud.ffmepg.operation.ffmpeg.vidoe.FFMpegVideoInfo;
import org.mountcloud.ffmepg.result.defaultResult.FFVideoInfoResult;
import org.mountcloud.ffmepg.task.bean.FFTaskStateEnum;
import org.mountcloud.ffmepg.task.bean.tasks.FFMepgVideoFormatM3u8Task;
import org.mountcloud.ffmepg.task.bean.tasks.FFMepgVideoInfoTask;
import org.mountcloud.ffmepg.task.context.FFTaskContext;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PicvedioApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void convertM3u8() {

        //create result bean
        FFVideoInfoResult result = new FFVideoInfoResult();

        //find video info
        FFMpegVideoInfo ffMpegVideoInfo = new FFMpegVideoInfo();
        ffMpegVideoInfo.setVideoUrl("D:\\cma_15307640036trzll1p.mp4");
        FFMepgVideoInfoTask videoInfoTask = new FFMepgVideoInfoTask(result,ffMpegVideoInfo);

        FFTaskContext.getContext().submit(videoInfoTask,null);

        String bitrate = "5286k";

        //create to m3u8 operation
        FFMpegVideoFormatM3u8 m3u8Operation = new FFMpegVideoFormatM3u8();
        m3u8Operation.setVideoFileName("D:\\cma_15307640036trzll1p.mp4");
        m3u8Operation.setBitrate(bitrate);
        m3u8Operation.setTimes(5);
        m3u8Operation.setM3u8File("D:\\cma_15307640036trzll1p\\cma_15307640036trzll1p.m3u8");
        m3u8Operation.setTsFiles("D:\\cma_15307640036trzll1p\\cma_15307640036trzll1p%5d.ts");

        //to m3u8 task
        FFMepgVideoFormatM3u8Task task = new FFMepgVideoFormatM3u8Task(m3u8Operation);

        //add task
        FFTaskContext.getContext().addTask(task);

        while(!task.getProgress().getState().equals(FFTaskStateEnum.COMPLETE)){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("COMPLETE");
    }


}

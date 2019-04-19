package com.dapeng.picvedio.service;

import com.dapeng.picvedio.utils.ConvertPicToVedio;

import java.io.IOException;
import java.util.Map;

public interface ConvertPicToVideoService {

    Map<String,Object> convertToVedio(ConvertPicToVedio convertPicToVedio) throws IOException;
}

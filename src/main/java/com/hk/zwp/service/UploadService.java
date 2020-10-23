package com.hk.zwp.service;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

/**
 * 上传服务
 */
public interface UploadService {

    /**
     * 上传文件
     */
    public boolean uploadFile(MultipartFile file) throws IOException;
}

package com.hk.zwp.service.impl;

import com.hk.zwp.service.UploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
@Service
public class UploadServiceImpl implements UploadService {
    @Override
    /**
     * 1.确定文件的目的地
     * 2.上传文件
     */
    public boolean uploadFile(MultipartFile file) throws IOException {
        File newFile = new File("E:\\upFile\\" + file.getOriginalFilename());
        file.transferTo(newFile);
        return true;
    }
}

package com.karthik.upload.service;

import com.karthik.upload.entity.Attachment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {
    Attachment saveAttachment(MultipartFile multipartFile) throws Exception;

    Attachment getAttachment(String fileId) throws Exception;
}

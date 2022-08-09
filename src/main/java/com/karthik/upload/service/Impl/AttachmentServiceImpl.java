package com.karthik.upload.service.Impl;

import com.karthik.upload.entity.Attachment;
import com.karthik.upload.repository.AttachmentRepository;
import com.karthik.upload.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    AttachmentRepository attachmentRepository;

    @Override
    public Attachment saveAttachment(MultipartFile multipartFile) throws Exception {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
    try {
        if(fileName.contains("..")){
            throw  new Exception("Invalid Path " +fileName);
        }
        Attachment attachment = new Attachment(fileName,multipartFile.getContentType(), multipartFile.getBytes());
        return attachmentRepository.save(attachment);
    }
    catch (Exception ex) {
        throw  new Exception("Could not save file" + fileName);
    }
    }

    @Override
    public Attachment getAttachment(String fileId) throws Exception {
        return attachmentRepository.findById(fileId)
                .orElseThrow(()-> new Exception("File not found "+fileId));
    }

}

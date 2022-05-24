package com.example.demo.service;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.UserFile;

/**
 * @ClassName: fileService
 * @Description:
 * @Author
 * @Date 2022/1/19
 * @Version 1.0
 */
public interface FileService {
    /**
     * 但文件上传
     *
     * @param file
     * @return String
     */
    UserFile fileUpload(MultipartFile file) throws IOException;

    /**
     * 文件查看
     *
     * @return
     * @throws IOException
     */
    List<UserFile> fileList(String userId);

    /**
     * 文件删除
     *
     * @param userFileList
     * @return int
     */
    int deleteFile(List<UserFile> userFileList);

    /**
     * 多文上传
     *
     * @param request
     * @return String
     */
    String fileUploads(HttpServletRequest request);

    /**
     * 文件下载
     *
     * @param userFileList
     * @return HttpEntity
     * @throws IOException
     */
    HttpEntity<? extends Object> down(List<UserFile> userFileList) throws IOException;
}

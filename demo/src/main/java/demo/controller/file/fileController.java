package demo.controller.file;

import demo.entity.UserFile;
import demo.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @ClassName: fileController
 * @Description:
 * @Author
 * @Date 2022/1/19
 * @Version 1.0
 */
@Api(tags = "test")
@RestController
@RequestMapping("fileUpload")
public class fileController {
    @Autowired
    FileService fileService;

    @PostMapping("/upload")
    public UserFile uploadFileHandler(@RequestParam("file") MultipartFile file) throws IOException {
        return fileService.fileUpload(file);
    }

    /**
     * 多文件上传
     *
     * @return
     */
    @PostMapping("/uploads")
    @ResponseBody
    public String uploadFiles(HttpServletRequest request) {
        return fileService.fileUploads(request);
    }

    /**
     * 文件查看
     *
     * @param userId
     * @return
     */
    @ApiOperation("nation")
    @GetMapping("/fileList")
    @ResponseBody
    public List<UserFile> fileList(@RequestParam("userId") String userId) {
        return fileService.fileList(userId);
    }


    /**
     * 文件下载
     * .doc .docx .pdf .xls· .xlsx .jpg .png .gif .txt .js .css .html .java的文件均可下载成功
     *
     * @return
     * @throws UnsupportedEncodingException
     */
    @PostMapping("/downFile")
    public HttpEntity<? extends Object> down(@RequestBody List<UserFile> userFileList) throws IOException {
        return fileService.down(userFileList);
    }

    @PostMapping("delete")
    public int deleteFile(@RequestBody List<UserFile> userFileList) {
        return fileService.deleteFile(userFileList);
    }
}

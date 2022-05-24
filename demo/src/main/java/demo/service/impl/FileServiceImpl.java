package demo.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import demo.entity.UserFile;
import demo.service.FileService;
import demo.service.UserFileService;

/**
 * @ClassName: fileServiceImpl
 * @Description:
 * @Author
 * @Date 2022/1/19
 * @Version 1.0
 */
@Service
public class FileServiceImpl implements FileService {
    private static final Logger log = LoggerFactory.getLogger(FileServiceImpl.class);
    @Autowired
    UserFileService userFileService;

    @Override
    public UserFile fileUpload(MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            UUID uuid = UUID.randomUUID();
            try {
                UserFile userFile = new UserFile();
                userFile.setUserId(1L);
                // 文件存放服务端的位置
                String rootPath = "d:/tmp" + "/" + userFile.getUserId();
                File dir = new File(rootPath + File.separator);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                StringBuffer str = new StringBuffer(file.getOriginalFilename());
                int num = str.lastIndexOf(".");
                String srt2;
                srt2 = str.insert(num, "_" + uuid).toString();
                // 写文件到服务器
                File serverFile = new File(dir.getAbsolutePath() + File.separator + srt2);
                file.transferTo(serverFile);
                userFile.setFilePath(serverFile.getPath());
                userFile.setFileUuid(uuid.toString());
                userFileService.insert(userFile);
                return userFile;
            } catch (IOException e) {
                throw (e);
            }
        } else {
            return null;
        }
    }

    @Override
    public String fileUploads(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        String filePath = " d:/tmp";
        for (int i = 0; i < files.size(); i++) {
            UUID uuid = UUID.randomUUID();
            MultipartFile file = files.get(i);
            if (file.isEmpty()) {
                System.out.println("未找到附件。。。");
                System.out.println("上传第" + (++i) + "个文件失败");
                i--; // 需要判断下一个附件是否可以进行上传，把上一行+1的下标减回去
                continue;
            }
            String fileName = file.getOriginalFilename();
            StringBuffer str = new StringBuffer(file.getOriginalFilename());
            int num = str.lastIndexOf(".");
            String srt2;
            srt2 = str.insert(num, "_" + uuid).toString();
            // 写文件到服务器
            File dest = new File(filePath + fileName + File.separator + srt2);
            UserFile userFile = new UserFile();
            userFile.setUserId(1L);
            userFile.setFilePath(dest.getPath());
            userFile.setFileUuid(uuid.toString());
            try {
                file.transferTo(dest);
                userFileService.insert(userFile);
                log.info("第" + (i + 1) + "个文件上传成功");
            } catch (IOException e) {
                log.error(e.toString(), e);
                return "上传第" + (++i) + "个文件失败";
            }
        }

        return "上传成功";
    }

    @Override
    public HttpEntity<? extends Object> down(List<UserFile> userFileList) throws IOException {
        if (userFileList.size() < 2) {
            for (UserFile userFile : userFileList) {
                String realimgurl = userFile.getFilePath();
                System.out.println(realimgurl);
                File file = new File(realimgurl);
                if (file == null) {
                    return null;
                }
                String suffixType = realimgurl.substring(realimgurl.lastIndexOf("."));
                HttpHeaders headers = new HttpHeaders();
                String filename = new String(realimgurl.getBytes("utf-8"), "iso-8859-1");
                headers.setContentDispositionFormData("attachment", filename);
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);

            }
        } else {
            //需要压缩的文件
            List<String> list = userFileList.stream().map(UserFile::getFilePath).collect(Collectors.toList());
            //压缩后的文件
            String resourcesName = "test.zip";
            ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream("D:/" + resourcesName));
            InputStream input = null;

            for (String str : list) {
                input = new FileInputStream(new File(str));
                zipOut.putNextEntry(new ZipEntry(str));
                int temp = 0;
                while ((temp = input.read()) != -1) {
                    zipOut.write(temp);
                }
                input.close();
            }
            zipOut.close();
            File file = new File("D:/" + resourcesName);
            HttpHeaders headers = new HttpHeaders();
            String filename = new String(resourcesName.getBytes("utf-8"), "iso-8859-1");
            headers.setContentDispositionFormData("attachment", filename);
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
            file.delete();
            return responseEntity;
        }
        return null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteFile(List<UserFile> userFileList) {
        for (UserFile userFile : userFileList) {
            try {
                String filePath = userFile.getFilePath();
                filePath = filePath.toString();
                File myDelFile = new java.io.File(filePath);
                myDelFile.delete();
            } catch (Exception e) {
                System.out.println("删除文件操作出错");
                e.printStackTrace();
                return -1;
            }
        }
        userFileService.deleteByUser(userFileList);
        return 0;
    }

    /**
     * 文件查看
     *
     * @param userId
     * @return
     */
    @Override
    public List<UserFile> fileList(String userId) {
        return userFileService.fileList(userId);
    }
}

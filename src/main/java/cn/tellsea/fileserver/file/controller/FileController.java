package cn.tellsea.fileserver.file.controller;

import cn.tellsea.fileserver.common.entity.ResponseResult;
import cn.tellsea.fileserver.file.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * 文件 控制器
 *
 * @author Tellsea
 * @date 2020/4/11
 */
@Api("文件操作")
@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @ApiOperation("文件上传")
    @PostMapping("/upload")
    public ResponseResult upload(@RequestParam("file") MultipartFile file,
                                 @RequestParam(value = "folder", defaultValue = "default") String folder) {
        return ResponseResult.success(fileService.upload(file, folder));
    }

    @ApiOperation("多文件上传")
    @PostMapping("/uploadMore")
    public ResponseResult uploadMore(@RequestParam("file") MultipartFile[] files,
                                     @RequestParam(value = "folder", defaultValue = "default") String folder) {
        return ResponseResult.success(fileService.uploadMore(files, folder));
    }

    @ApiOperation("图片上传并压缩")
    @PostMapping("/uploadByThumbnail")
    public ResponseResult uploadByThumbnail(@RequestParam("file") MultipartFile[] files,
                                            @RequestParam(value = "folder", defaultValue = "default") String folder,
                                            @RequestParam(value = "saveOld", defaultValue = "true") boolean saveOld) {
        return ResponseResult.success(fileService.uploadByThumbnail(files, folder, saveOld));
    }

    @ApiOperation("将指定文件夹打包为zip")
    @PostMapping("/folderToZip")
    public ResponseResult folderToZip(String folderPath, String zipPath, String fileName) {
        return ResponseResult.success(fileService.folderToZip(folderPath, zipPath, fileName));
    }

    @ApiOperation("生成二维码")
    @PostMapping("/createQrCode")
    public ResponseResult createQrCode(@RequestParam(value = "content", defaultValue = "默认二维码内容")String content,
                                       @RequestParam(value = "folder", defaultValue = "default") String folder) {
        return ResponseResult.success(fileService.createQrCode(content, folder));
    }

    @ApiOperation("下载文件")
    @PostMapping("downloadFile")
    public void downloadFile(String filePath, String fileName, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        fileService.downloadFile(filePath, fileName, request, response);
    }
}

package cn.tellsea.fileserver.file.service.impl;

import cn.tellsea.fileserver.common.consts.FilePathConst;
import cn.tellsea.fileserver.common.enums.FileEnums;
import cn.tellsea.fileserver.common.exception.FileSaveException;
import cn.tellsea.fileserver.common.exception.FileVerifyException;
import cn.tellsea.fileserver.file.service.FileService;
import cn.tellsea.fileserver.file.util.FileUtils;
import cn.tellsea.fileserver.file.util.QrCodeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 文件 接口实现类
 *
 * @author Tellsea
 * @date 2020/4/11
 */
@Service
public class FileServiceImpl implements FileService {

    @Override
    public String upload(MultipartFile file, String folder) {
        if (file.isEmpty()) {
            throw new FileVerifyException(FileEnums.NOT_FOUND.getInfo());
        }
        return FileUtils.upload(file, folder).getRelativePath();
    }

    @Override
    public String uploadMore(MultipartFile[] files, String folder) {
        if (files.length == 0) {
            throw new FileVerifyException(FileEnums.NOT_FOUND.getInfo());
        }
        List<String> list = new ArrayList<>();
        for (MultipartFile file : files) {
            list.add(FileUtils.upload(file, folder).getRelativePath());
        }
        if (CollectionUtils.isEmpty(list)) {
            throw new FileSaveException(FileEnums.SAVE_ERROR.getInfo());
        }
        return StringUtils.join(list, FilePathConst.SEPARATOR);
    }

    @Override
    public String uploadByThumbnail(MultipartFile[] files, String folder, boolean saveOld) {
        if (files.length == 0) {
            throw new FileVerifyException(FileEnums.NOT_FOUND.getInfo());
        }
        List<String> list = new ArrayList<>();
        for (MultipartFile file : files) {
            list.add(FileUtils.uploadByThumbnail(file, folder, saveOld).getRelativePath());
        }
        if (CollectionUtils.isEmpty(list)) {
            throw new FileSaveException(FileEnums.SAVE_ERROR.getInfo());
        }
        return StringUtils.join(list, FilePathConst.SEPARATOR);
    }

    @Override
    public String folderToZip(String folderPath, String zipPath, String fileName) {
        boolean flag = FileUtils.folderToZip(folderPath, zipPath, fileName);
        if (flag) {
            return zipPath + File.separator + fileName + ".zip";
        }
        throw new FileSaveException(FileEnums.FILE_ZIP_ERROR.getInfo());
    }

    @Override
    public String createQrCode(String content, String folder) {
        try {
            String datePath = FileUtils.getDatePath(folder, FileUtils.DATE_TYPE_SLASH);
            String fileName = String.valueOf(UUID.randomUUID()).concat(".jpg");
            // 详情查看工具类，功能非常强大
            QrCodeUtils.encode(content, null, FilePathConst.SAVE_POSITION + datePath, fileName, false);
            return datePath + fileName;
        } catch (Exception e) {
            e.printStackTrace();
            throw new FileSaveException(FileEnums.QRCODE_CREATE_ERROR.getInfo());
        }
    }
}

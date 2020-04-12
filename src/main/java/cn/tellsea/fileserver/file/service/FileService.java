package cn.tellsea.fileserver.file.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件 接口
 *
 * @author Tellsea
 * @date 2020/4/11
 */
public interface FileService {

    String upload(MultipartFile file, String folder);

    String uploadMore(MultipartFile[] files, String folder);

    String uploadByThumbnail(MultipartFile[] files, String folder, boolean saveOld);

    String folderToZip(String folderPath, String zipPath, String fileName);

    String createQrCode(String content, String folder);
}

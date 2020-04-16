package cn.tellsea.fileserver.common.enums;

import lombok.AllArgsConstructor;
import lombok.Setter;

/**
 * 异常枚举类
 *
 * @author Tellsea
 * @date 2019/7/13
 */
@AllArgsConstructor
public enum FileEnums implements BaseEnums {

    OK(200, "OK"),
    NOT_FOUND(404, "文件未找到，请选择上传文件"),
    SAVE_ERROR(500, "文件保存错误"),
    THUMBNAILS_ERROR(500, "图片压缩错误"),
    FILE_ZIP_ERROR(500, "文件打包zip错误"),
    DOWNLOAD_ERROR(500, "下载文件错误"),
    DOWNLOAD_NOT_FOUND_ERROR(500, "下载文件错误，未找到文件"),
    QRCODE_CREATE_ERROR(500, "二维码生成错误"),
    SERVER_ERROR(500, "服务器错误，请稍后重试"),
    ;

    @Setter
    private int code;

    @Setter
    private String info;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getInfo() {
        return info;
    }
}

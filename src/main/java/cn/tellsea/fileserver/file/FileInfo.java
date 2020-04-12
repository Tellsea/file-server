package cn.tellsea.fileserver.file;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 文件信息 实体类
 *
 * @author Tellsea
 * @date 2020/4/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class FileInfo {

    /**
     * 相对路径
     */
    private String relativePath;
    /**
     * 绝对路径
     */
    private String destFile;
    /**
     * 时间文件夹
     */
    private String datePath;
    /**
     * 文件名
     */
    private String fileName;
    /**
     * 文件类型
     */
    private String fileType;
}

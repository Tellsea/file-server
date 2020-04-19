package cn.tellsea.fileserver.common.consts;

/**
 * 文件路径常量
 *
 * @author Tellsea
 * @date 2020/4/11
 */
public interface FilePathConst {

    String PROJECT_LOCATION = System.getProperty("user.dir");
    /**
     * 保存位置（当前项目运行的相对根路径）
     */
    String SAVE_POSITION = PROJECT_LOCATION.concat("/file-static");
    /**
     * 访问前缀
     */
    String ACCESS_PREFIX = "http://localhost:9000/file-static";
    /**
     * 分隔符
     */
    String SEPARATOR = ",";

    String THUMBNAIL_SUFFIX = "_thumbnail";

    String THUMBNAIL_SEPARATOR = "|";
}

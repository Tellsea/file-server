package cn.tellsea.fileserver.common.exception;

/**
 * 文件未找到异常
 *
 * @author Tellsea
 * @date 2020/4/11
 */
public class FileVerifyException extends BaseException {

    public FileVerifyException() {
        super();
    }

    public FileVerifyException(String message) {
        super(message);
    }
}

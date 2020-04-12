package cn.tellsea.fileserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 静态资源服务器
 * 文件上传、文件下载、文件夹打包、删除某个文件或文件夹、文件夹解压、生成二维码、批量生成二维码
 *
 * @author Tellsea
 * @date 2020/4/11
 */
@SpringBootApplication
public class FileServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileServerApplication.class, args);
    }
}

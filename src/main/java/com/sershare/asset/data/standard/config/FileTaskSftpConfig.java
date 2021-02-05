package com.sershare.asset.data.standard.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @author: i_laowei
 * @date: 2021/2/2  15:07
 */

@Data
@Configuration
public class FileTaskSftpConfig {

    @Value("${fileTask.sftp.host}")
    private String host;
    @Value("${fileTask.sftp.port}")
    private int port;
    @Value("${fileTask.sftp.username}")
    private String username;
    @Value("${fileTask.sftp.password}")
    private String password;
    @Value("${fileTask.sftp.timeout}")
    private int timeout;
    @Value("${fileTask.remotePath}")
    private String remotePath;
    @Value("${fileTask.localDownPath}")
    private String localDownPath;//下载，之前的folder
    @Value("${fileTask.localUnzipPath}")
    private String unZipPath;//解压,之前的down
    @Value("${lxgm.zipPrefix}")
    private String zipPrefix;

}

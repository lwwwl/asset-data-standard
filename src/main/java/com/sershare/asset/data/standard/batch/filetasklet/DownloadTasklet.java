package com.sershare.asset.data.standard.batch.filetasklet;


import com.jcraft.jsch.ChannelSftp;
import com.sershare.asset.data.standard.config.FileTaskSftpConfig;
import com.sershare.asset.data.standard.utils.SftpUtils;
import jodd.io.ZipUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *@description  文件下载
 *@author laowei
 *@date 2021/2/2 14:57
 */

@Slf4j
@StepScope
@Component
public class DownloadTasklet implements Tasklet {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("#{jobParameters[batchDate]}")
    private String batchDate;

    @Resource
    private FileTaskSftpConfig fileTaskSftpConfig;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        String dateStr = LocalDate.parse(batchDate).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String remotePath = fileTaskSftpConfig.getRemotePath() + "/" + dateStr + "/";
        String localDownPath = fileTaskSftpConfig.getLocalDownPath();
        logger.info("开始下载zip文件,远程路径:{}", remotePath);
        ChannelSftp channelSftp = null;
        try {
            channelSftp = (ChannelSftp) SftpUtils.connectServer(fileTaskSftpConfig.getHost(), fileTaskSftpConfig.getPort(),
                    fileTaskSftpConfig.getUsername(), fileTaskSftpConfig.getPassword(), fileTaskSftpConfig.getTimeout());
            List<ChannelSftp.LsEntry> files = SftpUtils.getDirList(channelSftp, remotePath);
            if (files != null && !files.isEmpty()) {
                for (ChannelSftp.LsEntry file : files) {
                    if (file.getFilename().endsWith(ZipUtil.ZIP_EXT)) {
                        logger.info("开始下载sftp文件，文件名:{}", file.getFilename());
                        SftpUtils.copyFile(channelSftp, remotePath + file.getFilename(), localDownPath);
                    }
                }
            }
        } catch (Exception e) {
            logger.error("backup image file fail, {}", e.getMessage());
            throw new Exception("下载zip异常");
        } finally {
            SftpUtils.close(channelSftp);
        }
        return RepeatStatus.FINISHED;
    }
}

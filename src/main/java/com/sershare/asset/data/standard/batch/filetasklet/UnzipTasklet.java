package com.sershare.asset.data.standard.batch.filetasklet;

import com.sershare.asset.data.standard.config.FileTaskSftpConfig;
import jodd.io.ZipUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
@StepScope
@Component
public class UnzipTasklet implements Tasklet {

    @Value("#{jobParameters[batchDate]}")
    private String batchDate;

    @Resource
    private FileTaskSftpConfig fileTaskSftpConfig;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
        String dateStr = LocalDate.parse(batchDate).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        log.info("开始解压文件,dateStr:{}", dateStr);
        try {
            String localDownPath = fileTaskSftpConfig.getLocalDownPath();
            String zipPrefix = fileTaskSftpConfig.getZipPrefix();
            String zipFullName = localDownPath + "/" + zipPrefix + "/" + dateStr + ".zip";
            log.info("待解压的zip文件路径：{}", zipFullName);
            String unZipPath = fileTaskSftpConfig.getUnZipPath() + "/" + zipPrefix + "/" + dateStr + "/";
            log.info("解压到zip文件路径：{}", unZipPath);
            ZipUtil.unzip(zipFullName, unZipPath);
            log.info("解压成功：{}", unZipPath);
        } catch (IOException e) {
            log.info("解压失败：" + e.getMessage());
        }
        return RepeatStatus.FINISHED;
    }
}

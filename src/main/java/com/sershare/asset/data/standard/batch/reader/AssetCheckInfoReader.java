package com.sershare.asset.data.standard.batch.reader;

import com.sershare.asset.data.standard.config.FileTaskSftpConfig;
import com.sershare.asset.data.standard.enums.FileTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.PassThroughLineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @Description:
 * @author: i_laowei
 * @date: 2021/2/3  15:02
 */
@Configuration
public class AssetCheckInfoReader {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FileTaskSftpConfig fileTaskSftpConfig;

    @Bean(name = "assetCheckInfoReader")
    @StepScope
    public synchronized FlatFileItemReader<String> loanContractReader(
            @Value("#{jobParameters[batchDate]}") String batchDate) throws Exception {
        String dateStr = LocalDate.parse(batchDate).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String fullFileName = fileTaskSftpConfig.getUnZipPath() + "/" + fileTaskSftpConfig.getZipPrefix() + "_" +
                FileTypeEnum.ASSET_CHECK_INFO + "_WS_" + dateStr + ".csv";
        Resource resource = new FileSystemResource(fullFileName);
        logger.info("读取AssetCheckInfo文件:{}", fullFileName);
        return new FlatFileItemReaderBuilder<String>()
                .resource(resource)
                .name("读取10.csv")
                .linesToSkip(1)
                // 读取一行直接返回不做任何处理
                .lineMapper(new PassThroughLineMapper())
                .build();
    }

}

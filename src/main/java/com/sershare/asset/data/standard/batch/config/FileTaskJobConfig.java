package com.sershare.asset.data.standard.batch.config;

import com.google.gson.JsonObject;
import com.sershare.asset.data.standard.batch.filetasklet.DownloadTasklet;
import com.sershare.asset.data.standard.batch.filetasklet.UnzipTasklet;
import com.sershare.asset.data.standard.batch.processor.AssetCheckInfoProcessor;
import com.sershare.asset.data.standard.entity.AssetCheckInfo;
import com.sershare.asset.data.standard.utils.SpringContextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description: batch
 * @author: i_laowei
 * @date: 2021/1/26  15:44
 */
@SuppressWarnings("unchecked")
@EnableBatchProcessing
@Configuration
public class FileTaskJobConfig {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private JobBuilderFactory jobBuilderFactory;

    @Resource
    private StepBuilderFactory stepBuilderFactory;

    @Bean(name = "tempStorageQueue")
    public Queue<JsonObject> initQueue() {
        return new LinkedBlockingQueue<>();
    }

    @Bean
    public Job fileTaskJob() {
        logger.info("批处理开始");
        return jobBuilderFactory.get("fileTaskJob")
                .incrementer(new RunIdIncrementer())
                .flow(downZipStep())
                .next(unzipStep())
                .next(assetCheckInfoStep())
                .end().build();
    }

    @Bean
    public Step downZipStep() {
        return stepBuilderFactory.get("downLoadZip")
                .tasklet(SpringContextUtils.getBean(DownloadTasklet.class))
                .allowStartIfComplete(true)
                .build();
    }

    @Bean
    public Step unzipStep() {
        return stepBuilderFactory.get("unzipZip")
                .tasklet(SpringContextUtils.getBean(UnzipTasklet.class))
                .allowStartIfComplete(true)
                .build();
    }

    @Bean
    public Step assetCheckInfoStep() {
        return stepBuilderFactory.get("assetCheckInfoStep")
                .<String, AssetCheckInfo>chunk(100)
                .reader(SpringContextUtils.getBean("assetCheckInfoReader", FlatFileItemReader.class))
                .processor(SpringContextUtils.getBean(AssetCheckInfoProcessor.class))
                .writer(SpringContextUtils.getBean("assetCheckInfoItemWriter", ItemWriter.class))
                .build();
    }

}

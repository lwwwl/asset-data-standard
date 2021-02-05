package com.sershare.asset.data.standard.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@ConfigurationProperties(prefix = "mq")
public class MqConfig {
    private String tasktopic;
    private String taskgroup;
    private String file01topic;
    private String file02topic;
    private String file03topic;
    private String file04topic;
    private String file05topic;
    private String file06topic;
    private String file07topic;
    private String file08topic;
    private String file09topic;
    private String file10topic;
    private String file11topic;
    private String file12topic;
    private String file13topic;

    private boolean contol;

    private String newfile01topic;
    private String newfile02topic;
    private String newfile03topic;
    private String newfile04topic;
    private String newfile05topic;
    private String newfile06topic;
    private String newfile07topic;
    private String newfile08topic;
    private String newfile09topic;
    private String newfile10topic;
    private String newfile11topic;
    private String newfile12topic;
    private String newfile13topic;

    private String taskApiTaskTopic;
    private String ddzhCreditTopic;

    @Value("${env.profile:}")
    private String envProfile;

    public final static String ZH_CREDIT_TOPIC_APPLY_TAG = "apply_tag";

    public String getTasktopic() {
        return tasktopic;
    }

    public void setTasktopic(String tasktopic) {
        this.tasktopic = tasktopic;
    }

    public String getTaskgroup() {
        return taskgroup;
    }

    public void setTaskgroup(String taskgroup) {
        this.taskgroup = taskgroup;
    }

    public String getFile01topic() {
        return file01topic;
    }

    public void setFile01topic(String file01topic) {
        this.file01topic = file01topic;
    }

    public String getFile02topic() {
        return file02topic;
    }

    public void setFile02topic(String file02topic) {
        this.file02topic = file02topic;
    }

    public String getFile03topic() {
        return file03topic;
    }

    public void setFile03topic(String file03topic) {
        this.file03topic = file03topic;
    }

    public String getFile04topic() {
        return file04topic;
    }

    public void setFile04topic(String file04topic) {
        this.file04topic = file04topic;
    }

    public String getFile05topic() {
        return file05topic;
    }

    public void setFile05topic(String file05topic) {
        this.file05topic = file05topic;
    }

    public String getFile06topic() {
        return file06topic;
    }

    public void setFile06topic(String file06topic) {
        this.file06topic = file06topic;
    }

    public String getFile07topic() {
        return file07topic;
    }

    public void setFile07topic(String file07topic) {
        this.file07topic = file07topic;
    }

    public String getFile08topic() {
        return file08topic;
    }

    public void setFile08topic(String file08topic) {
        this.file08topic = file08topic;
    }

    public String getFile09topic() {
        return file09topic;
    }

    public void setFile09topic(String file09topic) {
        this.file09topic = file09topic;
    }

    public String getFile10topic() {
        return file10topic;
    }

    public void setFile10topic(String file10topic) {
        this.file10topic = file10topic;
    }

    public String getFile11topic() {
        return file11topic;
    }

    public void setFile11topic(String file11topic) {
        this.file11topic = file11topic;
    }

    public String getFile12topic() {
        return file12topic;
    }

    public void setFile12topic(String file12topic) {
        this.file12topic = file12topic;
    }

    public String getFile13topic() {
        return file13topic;
    }

    public void setFile13topic(String file13topic) {
        this.file13topic = file13topic;
    }

    public boolean isContol() {
        return contol;
    }

    public void setContol(boolean contol) {
        this.contol = contol;
    }

    public String getNewfile01topic() {
        return newfile01topic;
    }

    public void setNewfile01topic(String newfile01topic) {
        this.newfile01topic = newfile01topic;
    }

    public String getNewfile02topic() {
        return newfile02topic;
    }

    public void setNewfile02topic(String newfile02topic) {
        this.newfile02topic = newfile02topic;
    }

    public String getNewfile03topic() {
        return newfile03topic;
    }

    public void setNewfile03topic(String newfile03topic) {
        this.newfile03topic = newfile03topic;
    }

    public String getNewfile04topic() {
        return newfile04topic;
    }

    public void setNewfile04topic(String newfile04topic) {
        this.newfile04topic = newfile04topic;
    }

    public String getNewfile05topic() {
        return newfile05topic;
    }

    public void setNewfile05topic(String newfile05topic) {
        this.newfile05topic = newfile05topic;
    }

    public String getNewfile06topic() {
        return newfile06topic;
    }

    public void setNewfile06topic(String newfile06topic) {
        this.newfile06topic = newfile06topic;
    }

    public String getNewfile07topic() {
        return newfile07topic;
    }

    public void setNewfile07topic(String newfile07topic) {
        this.newfile07topic = newfile07topic;
    }

    public String getNewfile08topic() {
        return newfile08topic;
    }

    public void setNewfile08topic(String newfile08topic) {
        this.newfile08topic = newfile08topic;
    }

    public String getNewfile09topic() {
        return newfile09topic;
    }

    public void setNewfile09topic(String newfile09topic) {
        this.newfile09topic = newfile09topic;
    }

    public String getNewfile10topic() {
        return newfile10topic;
    }

    public void setNewfile10topic(String newfile10topic) {
        this.newfile10topic = newfile10topic;
    }

    public String getNewfile11topic() {
        return newfile11topic;
    }

    public void setNewfile11topic(String newfile11topic) {
        this.newfile11topic = newfile11topic;
    }

    public String getNewfile12topic() {
        return newfile12topic;
    }

    public void setNewfile12topic(String newfile12topic) {
        this.newfile12topic = newfile12topic;
    }

    public String getNewfile13topic() {
        return newfile13topic;
    }

    public void setNewfile13topic(String newfile13topic) {
        this.newfile13topic = newfile13topic;
    }

    public String getTaskApiTaskTopic() {
        return taskApiTaskTopic;
    }

    public void setTaskApiTaskTopic(String taskApiTaskTopic) {
        this.taskApiTaskTopic = taskApiTaskTopic;
    }

    public String getDdzhCreditTopic() {
        return ddzhCreditTopic;
    }

    public void setDdzhCreditTopic(String ddzhCreditTopic) {
        this.ddzhCreditTopic = ddzhCreditTopic;
    }

    public String getTopicWithEnv(String topic) {
        if(StringUtils.isEmpty(envProfile)) {
            return topic;
        }
        return topic + envProfile;
    }
}

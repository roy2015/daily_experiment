package com.roy.research.targetObject;


/**
 * @Author: jun.guo
 * @Email: jun.guo@rograndec.com
 * @CreateDate: 2019/2/19
 * @Version: 1.0
 *
 *  与前端交互的websocket 消息格式, 数据部分用泛型，扩展时新增VO即可
 *
 */

public class PCNotiWebsocketMsg<T> {

    /**
     * 参考PCNotiWebsocketMsgTypeEnum
     */
    private String messageCategory;

    /**
     *1-用户消息 2-企业消息 3-站点消息 4-平台消息
     */
    private String messageLevel;

    T data;

    public String getMessageCategory() {
        return messageCategory;
    }

    public void setMessageCategory(String messageCategory) {
        this.messageCategory = messageCategory;
    }

    public String getMessageLevel() {
        return messageLevel;
    }

    public void setMessageLevel(String messageLevel) {
        this.messageLevel = messageLevel;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

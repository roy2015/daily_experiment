package com.roy.miscellaneous.targetObject;


import lombok.Data;

/**
 *
 */

@Data
public class PCNotiWebsocketMsgCopy<L, M extends UserVO, N> {

    /**
     * 参考PCNotiWebsocketMsgTypeEnum
     */
    private String messageCategory;

    /**
     *1-用户消息 2-企业消息 3-站点消息 4-平台消息
     */
    private String messageLevel;

    L data;
    M data1;
    N data2;

    private  void  set1(M data1) {
        this.data1 = data1;
    }


}

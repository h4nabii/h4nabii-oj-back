package com.yupi.h4nabiioj.model.dto.questionsubmit;

import lombok.Data;

/**
 * 判题信息
 */
@Data
public class JudgeInfo {

    /**
     * 程序执行信息
     */
    private Long message;

    /**
     * 消耗内存 KB
     */
    private Long memoryLimit;

    /**
     * 消耗时间 ms
     */
    private Long time;
}

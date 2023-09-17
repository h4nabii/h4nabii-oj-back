package com.yupi.h4nabiioj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yupi.h4nabiioj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.yupi.h4nabiioj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.yupi.h4nabiioj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.h4nabiioj.model.entity.User;
import com.yupi.h4nabiioj.model.vo.QuestionSubmitVO;

/**
* @description 针对表【question_submit(帖子题目提交)】的数据库操作Service
* @createDate 2023-09-16 05:20:51
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {

    /**
     * 题目提交
     * @param questionSubmitAddRequest 提交请求
     * @param loginUser 提交用户
     * @return 对应提交的 id
     */
    Long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

    /**
     * 获取查询条件
     * @param questionSubmitQueryRequest 查询请求
     * @return 查询的条件
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);

    /**
     * 获取题目封装
     * @param questionSubmit 题目提交对象
     * @param loginUser 提交用户
     * @return 提交 VO
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);

    /**
     * 分页获取题目封装
     * @param questionSubmitPage 题目提交的分页
     * @param loginUser 登录用户
     * @return 提交 VO 的分页
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);
}

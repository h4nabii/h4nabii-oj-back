package com.yupi.h4nabiioj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yupi.h4nabiioj.model.dto.question.QuestionQueryRequest;
import com.yupi.h4nabiioj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.yupi.h4nabiioj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.yupi.h4nabiioj.model.entity.Question;
import com.yupi.h4nabiioj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.h4nabiioj.model.entity.User;
import com.yupi.h4nabiioj.model.vo.QuestionSubmitVO;
import com.yupi.h4nabiioj.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author 10367
* @description 针对表【question_submit(帖子题目提交)】的数据库操作Service
* @createDate 2023-09-16 05:20:51
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {

    /**
     * 题目提交
     *
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    Long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

    /**
     * 获取查询条件
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);

    /**
     * 获取题目封装
     *
     * @param questionSubmit
     * @param loginUser
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);

    /**
     * 分页获取题目封装
     *
     * @param questionSubmitPage
     * @param loginUser
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);
}

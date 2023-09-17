package com.yupi.h4nabiioj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yupi.h4nabiioj.model.dto.question.QuestionQueryRequest;
import com.yupi.h4nabiioj.model.entity.Question;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.h4nabiioj.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
* @description 针对表【question(题目)】的数据库操作Service
* @createDate 2023-09-16 05:19:55
*/
public interface QuestionService extends IService<Question> {

    /**
     * 校验
     * @param question 需要校验的问题对象
     * @param add 是否是在创建对象时校验
     */
    void validQuestion(Question question, boolean add);

    /**
     * 获取查询条件
     * @param questionQueryRequest 查询请求
     * @return 查询请求中的查询条件
     */
    QueryWrapper<Question> getQueryWrapper(QuestionQueryRequest questionQueryRequest);

    /**
     * 获取题目封装
     * @param question 题目
     * @param request http 请求
     * @return 题目 VO
     */
    QuestionVO getQuestionVO(Question question, HttpServletRequest request);

    /**
     * 分页获取题目封装
     * @param questionPage 题目分页
     * @param request http 请求
     * @return 分页的题目 VO
     */
    Page<QuestionVO> getQuestionVOPage(Page<Question> questionPage, HttpServletRequest request);
}

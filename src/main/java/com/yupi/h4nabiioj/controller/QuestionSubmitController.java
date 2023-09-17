package com.yupi.h4nabiioj.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yupi.h4nabiioj.common.BaseResponse;
import com.yupi.h4nabiioj.common.ErrorCode;
import com.yupi.h4nabiioj.common.ResultUtils;
import com.yupi.h4nabiioj.exception.BusinessException;
import com.yupi.h4nabiioj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.yupi.h4nabiioj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.yupi.h4nabiioj.model.entity.QuestionSubmit;
import com.yupi.h4nabiioj.model.entity.User;
import com.yupi.h4nabiioj.model.vo.QuestionSubmitVO;
import com.yupi.h4nabiioj.service.QuestionSubmitService;
import com.yupi.h4nabiioj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 题目提交接口
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@RestController
@RequestMapping("/question_submit")
@Slf4j
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

    /**
     * 提交题目
     * @param questionSubmitAddRequest 提交请求
     * @param request http 请求
     * @return 提交后生成的题目 id
     */
    @PostMapping("/")
    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
                                               HttpServletRequest request) {
        if (questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 登录才能点赞
        final User loginUser = userService.getLoginUser(request);
        long questionSubmitId = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);
        return ResultUtils.success(questionSubmitId);
    }

    /**
     * 分页获取题目提交列表（非管理员只能看到公开信息）
     * @param questionSubmitQueryRequest 查询请求
     * @param request http 请求
     * @return 问题提交 VO 的列表
     */
    @PostMapping("/list/page")
    public BaseResponse<Page<QuestionSubmitVO>> listQuestionSubmitByPage(@RequestBody QuestionSubmitQueryRequest questionSubmitQueryRequest,
                                                                         HttpServletRequest request) {
        long current = questionSubmitQueryRequest.getCurrent();
        long size = questionSubmitQueryRequest.getPageSize();
        // 原始信息
        Page<QuestionSubmit> questionSubmitPage = questionSubmitService.page(new Page<>(current, size),
                questionSubmitService.getQueryWrapper( questionSubmitQueryRequest));
        // 脱敏信息
        final User loginUser = userService.getLoginUser(request);
        return ResultUtils.success(questionSubmitService.getQuestionSubmitVOPage(questionSubmitPage, loginUser));
    }

}

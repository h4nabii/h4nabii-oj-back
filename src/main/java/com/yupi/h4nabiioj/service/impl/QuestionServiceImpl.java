package com.yupi.h4nabiioj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.h4nabiioj.model.entity.Question;
import com.yupi.h4nabiioj.service.QuestionService;
import com.yupi.h4nabiioj.mapper.QuestionMapper;
import org.springframework.stereotype.Service;

/**
* @author 10367
* @description 针对表【question(帖子)】的数据库操作Service实现
* @createDate 2023-09-16 05:19:55
*/
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question>
    implements QuestionService{

}





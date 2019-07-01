package com.document.service.impl;

import com.document.mapper.TestMapper;
import com.document.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LM_Code
 * @create 2019-07-01-11:12
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;
    @Override
    public String queryNow() {
        return testMapper.queryNow();
    }
}

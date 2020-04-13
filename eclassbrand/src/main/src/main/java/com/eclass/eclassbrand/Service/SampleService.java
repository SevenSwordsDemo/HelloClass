package com.eclass.eclassbrand.Service;

import com.eclass.eclassbrand.DAO.SampleDAO;
import com.eclass.eclassbrand.Modal.CommonResult;
import com.eclass.eclassbrand.POJO.Administrator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SampleService {
    @Resource
    private SampleDAO sampleDAO;

    public CommonResult sample()
    {
        CommonResult result=new CommonResult();
        try {
            Administrator admin =sampleDAO.getOne(1);
            System.out.println("account:"+admin.getAccount());
            result.setStatus(200);
            if (admin != null) {
                result.setData(admin);
                result.setMsg("获取数据成功");
            } else {
                result.setMsg("暂无数据");
            }
        }
        catch (Exception e)
        {
            result.setStatus(500);
            result.setMsg("服务器错误");
        }
        return result;

    }
}

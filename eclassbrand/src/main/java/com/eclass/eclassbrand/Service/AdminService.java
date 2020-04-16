package com.eclass.eclassbrand.Service;

import com.eclass.eclassbrand.DAO.AdminDAO;
import com.eclass.eclassbrand.Modal.CommonResult;
import com.eclass.eclassbrand.POJO.Administrator;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.net.ConnectException;

@Service
public class AdminService {
    @Resource
    private AdminDAO adminDAO;

    //添加管理员
    public CommonResult addAdmin(Administrator administrator)
    {
        CommonResult result=new CommonResult();
        try {
            adminDAO.save(administrator);
            result.setMsg("添加成功");
            result.setData(administrator.getId());
        }
        catch (Exception e)
        {
            result.setStatus(500);
            result.setMsg("服务器错误");
            result.setResult("fail");
            e.printStackTrace();
        }
        return result;
    }

    //删除管理员
    @Transactional
    public CommonResult delAdmin(String account)
    {
        CommonResult result=new CommonResult();
        try
        {
            adminDAO.deleteByAccount(account);
            result.setMsg("删除成功");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            result.setStatus(500);
            result.setMsg("服务器错误");
            result.setResult("fail");
        }
        return result;
    }
}

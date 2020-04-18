package com.eclass.eclassbrand.Service;

import com.eclass.eclassbrand.DAO.AdminDAO;
import com.eclass.eclassbrand.DAO.ApplyDAO;
import com.eclass.eclassbrand.Modal.CommonResult;
import com.eclass.eclassbrand.POJO.Administrator;
import com.eclass.eclassbrand.POJO.Apply;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.net.ConnectException;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Resource
    private AdminDAO adminDAO;
    @Resource
    private ApplyDAO applyDAO;

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

    //处理申请
    @Transactional
    public CommonResult handleApply(String operate,int id)
    {
        CommonResult result=new CommonResult();
        Apply apply=applyDAO.getOne(Long.valueOf(id));
        if(operate.equals("agree"))
        {
            apply.setState("通过");
            applyDAO.save(apply);
            result.setMsg("申请已同意");
            result.setData(apply.getState());
        }
        else if(operate.equals("deny"))
        {
            applyDAO.delete(apply);
            result.setMsg("已拒绝该申请");
        }
        return result;
    }


}

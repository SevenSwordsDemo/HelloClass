package com.eclass.eclassbrand.Service;

import com.eclass.eclassbrand.DAO.*;
import com.eclass.eclassbrand.Modal.CommonResult;
import com.eclass.eclassbrand.POJO.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentService {
    @Resource
    ApplyDAO applyDAO;

    //保存申请记录
    public CommonResult saveApplyRecord(Apply apply){
        CommonResult result = new CommonResult();
        try {
            applyDAO.save(apply);
            result.setMsg("获取任课成功");
            result.setResult("success");
        }catch (Exception e){
            result.setStatus(500);
            result.setMsg("获取任课失败");
            result.setResult("fail");
            e.printStackTrace();
        }
        return result;
    }

    //查看申请记录
    public CommonResult getRecord(int sid){
        CommonResult result = new CommonResult();
        try {
            List<Apply> applies = applyDAO.findBySid(sid);
            if(applies.size()!=0){
                result.setData(applies);
                result.setMsg("获取申请记录成功");
                result.setResult("success");
            }else{
                result.setMsg("无记录");
                result.setResult("success");
            }

        }catch (Exception e){
            result.setStatus(500);
            result.setMsg("获取申请记录失败");
            result.setResult("fail");
            e.printStackTrace();
        }
        return result;
    }
}

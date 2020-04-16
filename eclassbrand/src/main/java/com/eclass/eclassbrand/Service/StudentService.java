package com.eclass.eclassbrand.Service;

import com.eclass.eclassbrand.DAO.*;
import com.eclass.eclassbrand.POJO.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentService {
    @Resource
    ApplyDAO applyDAO;

    //保存申请记录
    public void saveApplyRecord(Apply apply){
        try {
            applyDAO.save(apply);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

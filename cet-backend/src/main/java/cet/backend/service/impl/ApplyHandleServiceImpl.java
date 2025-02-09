package cet.backend.service.impl;

import cet.backend.entity.apply.ApplyInfo;
import cet.backend.mapper.ApplyInfoMapper;
import cet.backend.service.ApplyHandleService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ApplyHandleServiceImpl implements ApplyHandleService {
    @Mapper
    ApplyInfoMapper mapper;

    @Override
    public String addApplyInfo(int exam_id, int user_id, String payment_status, String application_time, int score, int test_id) {
        int success = mapper.addApplyInfo(exam_id, user_id, payment_status, application_time, score, test_id);
        if(success > 0){
            return "申请考试成功";
        }else {
            return "申请考试失败";
        }
    }

    @Override
    public boolean applyTestByUser(int exam_id, int user_id) {
        String time = LocalDateTime.now().toString();
        return mapper.addApplyInfo(exam_id, user_id, "未支付", time, -1, -1) > 0;
    }

    @Override
    public List<ApplyInfo> showAllApplyInfo() {
        return mapper.findAllApplyInfo();
    }

    @Override
    public boolean deleteApplyInfo(int exam_id, int user_id) {
        return mapper.deleteApplyInfo(exam_id, user_id) > 0;
    }

    @Override
    public boolean payForApply(int exam_id, int user_id) {
        ApplyInfo info = mapper.findApplyInfoByMainKey(exam_id, user_id);
        if (info.getPayment_status().equals("未支付"))
            return mapper.updatePaymentStatus(exam_id, user_id, "已支付") > 0;
        else
            return false;
    }


}

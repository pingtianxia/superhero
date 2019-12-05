package com.next.service.impl;

import com.next.common.DateUtil;
import com.next.common.MD5Utils;
import com.next.idworker.Sid;
import com.next.mapper.UsersMapper;
import com.next.pojo.Users;
import com.next.pojo.bo.RegistLoginUsersBO;
import com.next.pojo.bo.WXMPUserBo;
import com.next.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

/**
 * @路径: com.next.service.impl.UserServiceImpl
 * @描述: UserService
 * @作者: hyp
 * @邮箱: henanyunpingearl@163.com
 * @创建日期: 2019-11-09 15:47
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper usersMapper;
    private final static String USER_DEFAULT_FACE_IMAGE_URL = "http://122.152.205.72:88/group1/M00/00/05/CpoxxFw_8_qAIlFXAAAcIhVPdSg994.png";


    @Autowired
    private Sid sid;

    @Override
    public Users queryUserForLoginByMPWX(String openId) {
        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("mpWxOpenId", openId);
        return usersMapper.selectOneByExample(example);
    }

    @Override
    public Users saveUserMPWX(String openId, WXMPUserBo userBo) {

        Users users = new Users();
        users.setId(sid.nextShort());
        users.setNickname(userBo.getNickName());
        users.setFaceImage(userBo.getAvatarUrl());
        users.setBirthday(DateUtil.dateToString(new Date(), DateUtil.ISO_EXPANDED_DATE_FORMAT));
        users.setIsCertified(0);
        users.setRegistTime(new Date());
        int count = usersMapper.insert(users);
        System.out.println(count);
        return users;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUsernameIsExist(String username) {
        Users users = new Users();
        users.setUsername(username);
        Users result = usersMapper.selectOneByExample(username);

        return result == null ? false : true;
    }

    @Transactional (propagation = Propagation.REQUIRED)
    @Override
    public Users queryUserForLogin(String username, String pwd) {
        Users user = new Users();
        user.setUsername(username);
        user.setPassword(pwd);
        Users result = usersMapper.selectOne(user);
        return result;
    }

    @Transactional (propagation = Propagation.REQUIRED)
    @Override
    public Users saveUser(RegistLoginUsersBO userBO) {
        String userid = sid.nextShort();

        Users user = new Users();
        user.setId(userid);

        user.setUsername(userBO.getUsername());

        try {
            user.setPassword(MD5Utils.getMD5Str(userBO.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        user.setNickname(userBO.getUsername());
        user.setFaceImage(USER_DEFAULT_FACE_IMAGE_URL);

        user.setBirthday("1900-01-01");
        user.setIsCertified(0);
        user.setRegistTime(new Date());

        usersMapper.insert(user);
        return user;
    }

    @Transactional (propagation = Propagation.REQUIRED)
    @Override
    public Users updateUserInfo(Users user) {
        usersMapper.updateByPrimaryKeySelective(user);
        return queryUserInfoById(user.getId());
    }

    @Transactional (propagation = Propagation.SUPPORTS)
    private Users queryUserInfoById(String userId) {
        return usersMapper.selectByPrimaryKey(userId);
    }
}

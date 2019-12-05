package com.next.service;

import com.next.pojo.Users;
import com.next.pojo.bo.RegistLoginUsersBO;
import com.next.pojo.bo.WXMPUserBo;
import com.next.pojo.bo.WXReturnSessionBO;

/**
 * @包 名: com.next.service
 * @类 名:
 * @描 述:
 * @作 者: hyp
 * @邮 箱: henanyunpingearl@163.com
 * @创建日期: 2019/11/9 15:47
 */
public interface UserService {

    /***
     * 根据openId 查询用户信息
     * @param openId
     * @return
     */
    public Users queryUserForLoginByMPWX(String openId);

    /***
     * 微信授权后保存用户信息
     * @param openId
     * @param userBo
     * @return
     */
    public Users saveUserMPWX(String openId, WXMPUserBo userBo);

    /**
     * 查询用户名是否存在
     * @param username
     * @return
     */
    public boolean queryUsernameIsExist(String username);

    /**
     * 用户登录
     * @param username
     * @param pwd
     * @return
     */
    public Users queryUserForLogin(String username, String pwd);

    /**
     * 用户注册
     * @param userBO
     * @return
     */
    public Users saveUser(RegistLoginUsersBO userBO);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    public Users updateUserInfo(Users user);
}

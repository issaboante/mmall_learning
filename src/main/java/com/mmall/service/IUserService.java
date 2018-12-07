package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;

public interface IUserService {
    // 接口名以I开头以方便区分接口和类

    ServerResponse<User> login(String username, String password);

    ServerResponse<String> register(User user);

    ServerResponse<String> checkValid(String value, String type);

    ServerResponse<String> selectQuestion(String username);

    ServerResponse<String> checkAnswer(String username, String question, String answer);

    ServerResponse<String> forgetResetPassword(String username, String passwordNew, String forgetToken);

    ServerResponse<String> resetPassword(String passwordOld, String passwordNew, User user);

    ServerResponse<User> updateInformation(User user);
}

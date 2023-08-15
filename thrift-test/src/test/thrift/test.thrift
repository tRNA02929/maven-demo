namespace java com.ksyun.test.thrift

// 注册请求
struct RegisterReq {
    1: string username,
    2: string password,
}

// 登录请求
struct LoginReq {
    1: string username,
    2: string password,
}

// 登录响应
struct LoginResp {
    1: string token,
}

// 注销请求
struct LogoutReq {
    1: string token,
}

// 注销响应
struct LogoutResp {
    1: bool success,
}


service Service {
    LoginResp login(1: LoginReq req),
    LogoutResp logout(1: LogoutReq req),
    bool register(1: RegisterReq req),
}
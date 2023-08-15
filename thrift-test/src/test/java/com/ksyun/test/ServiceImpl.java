package com.ksyun.test;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.ksyun.test.thrift.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceImpl implements Service.Iface {
    // 已注册用户
    private ConcurrentHashMap<String, String> userMap = new ConcurrentHashMap<>();

    // 已登录用户
    private ConcurrentHashMap<String, String> tokenMap = new ConcurrentHashMap<>();

    public ServiceImpl() {
        // 初始化用户
        Kryo kryo = new Kryo();
        File file = new File("user.dat");
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file);
                 Input input = new Input(fis)) {
                userMap = (ConcurrentHashMap<String, String>) kryo.readClassAndObject(input);
            } catch (KryoException e) {
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public LoginResp login(LoginReq req) {
        if (req != null) {
            System.out.print("login: " + req.getUsername());
            String token = tokenMap.get(req.getUsername());
            if (token != null) {
                return new LoginResp(token);
            } else {
                String pwd = userMap.get(req.getUsername());
                if (pwd != null && pwd.equals(req.getPassword())) {
                    token = req.getUsername() + "@" + System.currentTimeMillis();
                    tokenMap.put(req.getUsername(), token);
                    System.out.println(" success! Login token: " + token);
                    return new LoginResp(token);
                }
            }
        }
        System.out.println(" failed!");
        return new LoginResp("failed");
    }

    @Override
    public LogoutResp logout(LogoutReq req) {
        if (req != null) {
            System.out.println("logout: " + req.getToken());
            String token = tokenMap.get(req.getToken());
            if (token != null) {
                tokenMap.remove(req.getToken());
                return new LogoutResp(true);
            }
        }
        return new LogoutResp(false);
    }

    @Override
    public boolean register(RegisterReq req) {
        if (req != null) {
            String pwd = userMap.get(req.getUsername());
            if (pwd == null) {
                userMap.put(req.getUsername(), req.getPassword());
                save();
                System.out.println("register: " + req.getUsername() + " success!");
                return true;
            }
        }
        return false;
    }

    public void save() {
        Kryo kryo = new Kryo();
        File file = new File("user.dat");
        try (FileOutputStream fos = new FileOutputStream(file);
             Output output = new Output(fos)) {
            kryo.writeClassAndObject(output, userMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

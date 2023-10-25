package com.ksyun.test;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonTest {
    public static void main(String[] args) throws IOException {
        BufferedReader fis = new BufferedReader(new FileReader("Level.json"));
        String str = fis.readLine();
//        System.out.println(str);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(str).get(0).get("curve");
        JsonParser parser = mapper.treeAsTokens(node);

//        System.out.println(node);
        for (int i=0;i<99;i++){
            System.out.println(node.get(i).get("exp").asInt());
//            node.get(i).put("exp",node.get(i).get("exp").asInt()+100);
        }
    }
}

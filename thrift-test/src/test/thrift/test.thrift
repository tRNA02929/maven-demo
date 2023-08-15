namespace java com.ksyun.train.thrift


struct HelloMsg {
    1: string msg;
}

service Service {
    HelloMsg sayHello(),
}
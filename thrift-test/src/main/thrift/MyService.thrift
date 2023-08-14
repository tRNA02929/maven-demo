namespace java com.ksc.thrift


struct HelloMsg {
    1: string msg;
}

struct MyRequestMsg {
    1: i32 no;
    2: string msg;
}

struct MyResponseMsg {
    1: bool status;
    2: optional i32 no;
    3: optional string msg;
}

service Service {
    HelloMsg sayHello(),
    MyResponseMsg ask(1: MyRequestMsg request),
}
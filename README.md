## Webflux + Kotlin 예제 프로젝트

---

#### 1. `Webflux + Kotlin + R2DBC(H2)`로 간단한 로그인 기능 구현
#### 2. `Kafka` 연동하여 회원가입 이후 간단한 이벤트 구현
    ### local kafka 실행 명령어 ###
    
    # zookeeper 실행
    PS E:\tools\kafka_2.13-3.5.1> .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties 
    
    # kafka server 실행 
    PS E:\tools\kafka_2.13-3.5.1> .\bin\windows\kafka-server-start.bat .\config\server.properties

    # create topic 명령어
    PS E:\tools\kafka_2.13-3.5.1> .\bin\windows\kafka-topics.bat --create --bootstrap-server 127.0.0.1:9092 --topic test-topic
    Created topic test-topic.

    # show topic list 명령어
    PS E:\tools\kafka_2.13-3.5.1> .\bin\windows\kafka-topics.bat --list --bootstrap-server 127.0.0.1:9092
    test-topic
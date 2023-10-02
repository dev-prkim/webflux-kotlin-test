## Webflux + Kotlin 예제 프로젝트 

- - -

#### 1. `Webflux + Kotlin + R2DBC(H2)`로 간단한 로그인 기능 구현
#### 2. `Kafka` 연동하여 회원가입 이후 간단한 이벤트 구현

- - -

#### 로컬 kafka 실행 명령어 기록
* zookeeper 실행
```agsl
PS E:\tools\kafka_2.13-3.5.1> .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties 
```

* kafka server 실행
```agsl
PS E:\tools\kafka_2.13-3.5.1> .\bin\windows\kafka-server-start.bat .\config\server.properties
```

* create topic 명령어
```agsl
PS E:\tools\kafka_2.13-3.5.1> .\bin\windows\kafka-topics.bat --create --bootstrap-server 127.0.0.1:9092 --topic test-topic
Created topic test-topic.
```

* show topic list 명령어
```agsl
PS E:\tools\kafka_2.13-3.5.1> .\bin\windows\kafka-topics.bat --list --bootstrap-server 127.0.0.1:9092
test-topic
```

* show consumer group list 명령어
```agsl
PS E:\tools\kafka_2.13-3.5.1> .\bin\windows\kafka-consumer-groups.bat --bootstrap-server localhost:9092 --list
my-group
```

* show consumer group 상태 명령어
```agsl
PS E:\tools\kafka_2.13-3.5.1> .\bin\windows\kafka-consumer-groups.bat --bootstrap-server localhost:9092 --group my-group --describe
```

* show topic message list 명령어
```agsl
PS E:\tools\kafka_2.13-3.5.1> .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic LOGIN-LOG-TOPIC --from-beginning
[2023-09-28 17:49:57] user1 logged in.
Processed a total of 1 messages
```

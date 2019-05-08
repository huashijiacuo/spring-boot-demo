## spring-boot 用例

### 整合kafka
使用了spring-kafka框架，简单的发送和接收见package kafka，接收消息只需要引入
    
    @KafkaListener(topics = {"test"})
    public void listen(ConsumerRecord<?, ?> record, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) { ... }
注解，并指定topics，用例中的topic于sender中的topic一致

### 测试遇到的问题  
Q: bean使用@Autowired无法注入  
A: 在测试类上引入注解：

    @RunWith(SpringRunner.class)    
    @SpringBootTest
    public class KafkaSender2Test { ... }
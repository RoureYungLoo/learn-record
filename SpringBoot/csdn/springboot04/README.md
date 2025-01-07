# 多Profiles配置

application.yml
```yml
spring:
  profiles:
    active: dev
---
# 文档块1
server:
  port: 8084
spring:
  config:
    activate:
      on-profile: dev

---
#文档块2
server:
  port: 8085
spring:
  config:
    activate:
      on-profile: test
```
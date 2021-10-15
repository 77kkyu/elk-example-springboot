# Description
- auth : 77kkyu
- development environment : spring-boot
- technology : elasticsearch, logstash, kibana
- os : windows

> elk 실행 후 코드 실행 시 로그는 Kibana에서 확인 가능하고 <br>
> index 생성 API 및 검색 API를 간단하게 만들었습니다

<br>

---

# ELK (elasticsearch, logstash, kibana)
 - 분석 및 저장을 담당하는 ElasticSearch
 - 수집기능을 하는 Logstash
 - Logstash를 시각화하는 Kibana로 이루어져 있습니다

### ElasticSearch
- ElasticSearch는 Lucene 기반으로 개발한 분산 검색엔진이고 LogStash를 통해 요청된 데이터를 저장소에 저장하는 역할을 합니다.

### LogStash
- LogStash는 수집할 로그를 정해, 해당 서버에 인덱싱 해서 전송하는 역할을 합니다
- 여러 유형의 로그 수집 및 인덱싱이 가능하고, 여러 소스의 데이터를 동시에 가져와 변환 한 다음 ElasticSearch와 같은 stash로 보내는 서버 측으로 보내 줍니다

### Kibana
- Kibana는 분석 결과 및 로그 등의 결과를 사용자에게 보여주기 위해 만들어졌으며, 차트와 그래프로 시각화를 할 수 있습니다

<br>

---
# Data Flow
> Beats ->  LogStash  ->  ElasticSearch  ->  Kibana

<br>

---

# Image
#### ElasticSearch
![](https://github.com/77kkyu/elk-example-springboot/blob/main/assets/000.el.PNG?raw=true)

<br>

#### Kibana
![](https://github.com/77kkyu/elk-example-springboot/blob/main/assets/000.ki.PNG?raw=true)

<br>

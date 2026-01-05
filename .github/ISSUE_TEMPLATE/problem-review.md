---
name: problem review
about: 코테문제 복습을 위한 기록
title: "[사이트] 문제번호. 문제명 (난이도)"
labels: ''
assignees: Taehw

---

## 🔗 문제 링크
- [수 찾기](https://www.acmicpc.net/problem/1920)

## 💡 풀이 전략 (이진 탐색)

- N의 범위와 시간복잡도로 풀이의 범위 좁히기
- 이진탐색이 가능한 경우가 언제인지 생각해보기

## ⚠️ 삽질 

- 종료 조건을 생각하느라 헤맸음(`while(start < end`)
- start <= end인 이유는, start == end인 경우에도 그 위치의 값이 target인지 확인해야 하기 때문임.

## 📝 코드 핵심 요약

```java
int mid_index = (start + end) / 2;
int mid_value = A[mid_index];
```

## ✅ 복습 필요도
- [ ] 1주일 뒤 다시 풀기 (2026-01-12)
- [ ] 완벽히 이해함
- [ ] HashSet 을 이용한 방법으로도 다시 풀어보기

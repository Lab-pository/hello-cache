# Redis Command

## Redis 접속하기

```text
docker exec -it redis bash
redis-cli --raw
```

## String

```redis
set key value [EX seconds|PX milliseconds|EXAT timestamp|PXAT milliseconds-timestamp|KEEPTTL] [NX|XX] [GET]
```

- EX : 남아있을 시간을 초로 지정한다.
- PX : 남아있을 시간을 밀리초로 지정한다.
- EXAT : 지정한 타임스탬프 값 이후에 지워진다.
- PXAT : 지정한 밀리초 타임스탬프 값 이후에 지워진다.
- KEEPTTL : 만료 시간 유지
- NX : 겹쳐쓰기 방지
- XX : 이미 해당 키에 값이 있는 경우에만 저장
- 이 명령의 시간복잡도는 `O(1)`이다.


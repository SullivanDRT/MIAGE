FROM alpine:latest
WORKDIR /app
COPY hello.sh .
RUN chmod +x hello.sh
RUN apk add --no-cache curl && \
    rm -rf /var/cache/apk/*
CMD ["sh", "hello.sh"]
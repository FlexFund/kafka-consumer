FROM ubuntu:latest
LABEL authors="chrisrinaldi"

ENTRYPOINT ["top", "-b"]
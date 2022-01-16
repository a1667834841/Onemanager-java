FROM alpine:3

RUN apk add git

COPY . .

WORKDIR /.github

RUN echo $PWD
RUN  chmod +x ./actions/gitea-commit/entrypoint.sh

ENTRYPOINT ["./actions/gitea-commit/entrypoint.sh"]
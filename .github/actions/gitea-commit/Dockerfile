FROM alpine:3

RUN apk add git

COPY . .

WORKDIR /.github

RUN echo $PWD


RUN  chmod +x .github/actions/gitea-commit/entrypoint.sh

ENTRYPOINT ["/repo/.github/actions/gitea-commit/entrypoint.sh"]
FROM alpine:3

RUN apk add git

RUN mkdir /repo

COPY . /repo

RUN ll

RUN  chmod +x /repo/.github/actions/gitea-commit/entrypoint.sh

ENTRYPOINT ["/repo/.github/actions/gitea-commit/entrypoint.sh"]
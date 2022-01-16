FROM alpine:3

RUN apk add git

COPY . .

WORKDIR /.github/actions/gitea-commit

RUN echo $PWD
RUN chmod +x /.github/actions/gitea-commit/entrypoint.sh

ENTRYPOINT ["entrypoint.sh"]
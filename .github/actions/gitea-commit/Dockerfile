FROM alpine:3

RUN apk add git

COPY . .


RUN echo $ls

RUN  chmod +x .github/actions/gitea-commit/entrypoint.sh

ENTRYPOINT ["/repo/.github/actions/gitea-commit/entrypoint.sh"]
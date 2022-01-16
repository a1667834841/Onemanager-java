#!/usr/bin/env sh

GIT_REPO="${INPUT_REPO}"
GIT_BRANCH="${INPUT_BRANCH:master}"
GIT_USERNAME="${INPUT_USERNAME}"
GIT_EMAIL="${INPUT_EMAIL}"


git config --global user.name "$GIT_USERNAME"
git config --global user.email "$GIT_EMAIL"


git add .
git commit -m "${msg}"
git remote add gitea "$GIT_REPO"
git show-ref
git push gitea master --force # 推送


echo "::set-output name=repo::$GIT_REPO"
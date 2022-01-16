#!/usr/bin/env sh

GIT_REPO="${INPUT_REPO}"
GIT_BRANCH="${INPUT_BRANCH:master}"
GIT_USERNAME="${INPUT_USERNAME}"
GIT_EMAIL="${INPUT_EMAIL}"


git config --global user.name "$GIT_USERNAME"
git config --global user.email "$GIT_EMAIL"

git init
git add .
git commit -m "${msg}"
git push -f https://ggball:bc65cc90c76baba247e753c95ef5721200e97b59@gitea.dongshanxia.top:35000/ggball/onemanager-java.git master


echo "::set-output name=repo::$GIT_REPO"
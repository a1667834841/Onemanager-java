git config --global user.name "ggball"
git config --global user.email "1667834841@qq.com"

codingUrl="https://gitea.dongshanxia.top:35000/ggball/onemanager-java.git"

git init
git add -A
git commit -m "${msg}"
git push -f $codingUrl master # 推送到coding

git config --global user.name "ggball"
git config --global user.email "1667834841@qq.com"

codingUrl="https://gitea.dongshanxia.top:35000/ggball/onemanager-java.git"


git add .
git commit -m "${msg}"
git remote add gitea $codingUrl
git show-ref
git push gitea master --force # 推送

# Geek_Learing

// 进入本地仓库
cd C:/Users/syurai/Geek_Learning
// 查看本地仓库状况
git status
// add修改后的文件
git add .
// commit修改后的文件，需要添加注释
git commit -m ""
// 将本地问价提交到远程仓库分支
git branch -M main
// 将分支上的文件push到主分支上，完成提交
git push -u origin main


// 连接远程仓库
git remote add origin git@github.com:Syurai/Geek_Learing.git
// 验证连接是否成功
git remote
// 生成ssh密钥
ssh-keygen -t rsa -C "dlsyurai@163.com"
// 查找密钥
cd /c/Users/syurai/.ssh
// 获取公私密钥
ls
// 查看公钥内容
cat id_rsa.pub
// 复制公钥信息到setting里，建立连接
ssh -T git@github.com



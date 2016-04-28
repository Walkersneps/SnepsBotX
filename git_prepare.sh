#! /bin/bash

echo "Starting copy process..."
cp -R ~/IdeaProjects/SnepsBotX/. ~/Documents/Sviluppatore/GitHub/SnepsBotX/
echo "Copy done! "

cd ~/Documents/Sviluppatore/GitHub/SnepsBotX
echo "Current directory is: "
pwd

git add .
git status

echo " "
echo "Ready for commit: git commit -S -a -m'Your message here'"



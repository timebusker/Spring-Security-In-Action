color 0a
@echo off & setlocal 
set var=":sun_with_face::sunflower::palm_tree::house_with_garden::office::octocat::guitar::meat_on_bone:"
set d=%date:~0,10%
set t=%time:~0,8%
git add .
git commit -am"%d% %t% ____ %var%"
git push origin master
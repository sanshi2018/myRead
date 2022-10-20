#!/bin/bash
# Program:
# Program creates three files, which named by user's input and date command.
# History:
# 2015/07/16 VBird First release
PATH=/bin:/sbin:/usr/bin:/usr/sbin:/usr/local/bin:/usr/local/sbin:~/bin
export PATH
# 用户输入文件名，并取得 fileuser 这个变量；
echo -e "I will use 'touch' command to create 3 files."
read -p "Please input your filename: " fileuser
# 判断文件是否存在于~/ 下，如果存在则提示用户是否删除，然后删除；
filename=${fileuser:-"filename"}

if [ -e "$HOME/$filename" ]; then
    read -p "$HOME/$filename already exists. Do you want to delete it? [Y/N] " yn
    [ "$yn" == "Y" -o "$yn" == "y" ] && rm -f $HOME/$filename
fi




# region test命令案例


#!/bin/bash
# Program:
# User input a filename, program will check the flowing:
# 1.） exist? 2.） file/directory? 3.） file permissions
# History:
# 2015/07/16 VBird First release
PATH=/bin:/sbin:/usr/bin:/usr/sbin:/usr/local/bin:/usr/local/sbin:~/bin
export PATH
# 1. 让使用者输入文件名，并且判断使用者是否真的有输入字串？
echo -e "Please input a filename, I will check the filename's type and permission. \n\n"
read -p "Input a filename : " filename
test -z ${filename} && echo "You MUST input a filename." && exit 0
# 2. 判断文件是否存在？若不存在则显示讯息并结束脚本
test ! -e ${filename} && echo "The filename '${filename}' DO NOT exist" && exit 0
# 3. 开始判断文件类型与属性
test -f ${filename} && filetype="regulare file"
test -d ${filename} && filetype="directory"
test -r ${filename} && perm="readable"
test -w ${filename} && perm="${perm} writable"
test -x ${filename} && perm="${perm} executable"
# 4. 开始输出信息！
echo "The filename: ${filename} is a ${filetype}"
echo "And the permissions for you are : ${perm}"

# endregion test命令案例


# region [ ] 条件命令案例


name = "VBird Tsai"
[ ${name} == "VBird" ]
[ $? == 0 ] ... == TRUE
[ ${name} == "VBird" ]
[ $? != 0 ] ... == FALSE



#!/bin/bash
# Program:
# Program creates three files, which named by user's input and date command.
# History:
# 2015/07/16 VBird First release
PATH=/bin:/sbin:/usr/bin:/usr/sbin:/usr/local/bin:/usr/local/sbin:~/bin
export PATH
read -p "Please input your filename: " filename
# 判断文件是否存在，若不存在则给予一个“Filename does not exist”的讯息，并中断程序；
# 若这个文件存在，则判断他是个文件或目录，结果输出“Filename is regular file”或 “Filename is directory”
filename=${filename:-"filename"}

if [ ! -e "$filename" ]; then
    echo "The filename '$filename' DO NOT exist"
    exit 1
else
    if [ -f "$filename" ]; then
        filetype="regular file"
    elif [ -d "$filename" ]; then
        filetype="directory"
    else
        filetype="other"
    fi
fi

# 判断一下，执行者的身份对这个文件或目录所拥有的权限，并输出权限数据！
testfile=$filename

if [ -r "$testfile" -a -w "$testfile" ]; then
    permission="full permission"
elif [ -r "$testfile" -a ! -w "$testfile" ]; then
    permission="read permission"
elif [ ! -r "$testfile" -a -w "$testfile" ]; then
    permission="write permission"
else
    permission="cannot do anything"
fi

# if .... then .... fi 的语法处理如下：

#!/bin/bash
# Program:
# Program creates three files, which named by user's input and date command.
# History:
# 2015/07/16 VBird First release
PATH=/bin:/sbin:/usr/bin:/usr/sbin:/usr/local/bin:/usr/local/sbin:~/bin
export PATH

#当执行一个程序的时候，这个程序会让使用者选择 Y 或 N ， 
#若使用者选择了 Y 则执行，若选择了 N 则不执行。如果不是 Y/y/N/n 之内的其他字符，就显示“ I don't know what your choice is ”
read -p "Please input (Y/N): " yn
if [ "$yn" == "Y" ] || [ "$yn" == "y" ]; then
    echo "OK, continue"
    exit 0
elif [ "$yn" == "N" ] || [ "$yn" == "n" ]; then
    echo "Oh, interrupt!"
    exit 0
else
    echo "I don't know what your choice is" && exit 0
fi


# endregion [ ] 条件命令案例

# region Shell script 的默认变量（$0, $1...）

# - 程序的文件名为何？ 
# - 共有几个参数？ 
# - 若参数的个数小于 2 则告知使用者参数数量太少 
# - 全部的参数内容为何？ 
# - 第一个参数为何？ 
# - 第二个参数为何

#!/bin/bash
# Program:
# Program creates three files, which named by user's input and date command.
# History:
# 2015/07/16 VBird First release
PATH=/bin:/sbin:/usr/bin:/usr/sbin:/usr/local/bin:/usr/local/sbin:~/bin
export PATH

echo "The script name is ==> $0"
echo "Total parameter number is ==> $#"
[ "$#" -lt 2 ] && echo "The number of parameter is less than 2. Stop here." && exit 0
echo "Your whole parameter is ==> '$@'"
echo "The 1st parameter ==> $1"
echo "The 2nd parameter ==> $2"

# endregion Shell script 的默认变量（$0, $1...）
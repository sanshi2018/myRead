#VBgrid 出现在log中的次数
VBgrid=`grep -c "VBgrid" /var/log/messages`
#VBgrid 出现在log行数
VBgrid=`grep -n "VBgrid" /var/log/secure | tail -1 | awk -F: '{print $1}'`


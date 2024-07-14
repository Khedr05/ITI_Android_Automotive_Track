#!/bin/bash

username="sherif10"
group_name="khedr"

#Create the user if it does not exist
if [ $(grep -c "$username:" /etc/passwd) -gt 0 ]; then
	echo "- User $username already exists"
else
	sudo useradd $username
	echo "- Added user: $username"
fi

#Create the group if it does not exist
if [ $(grep -c $group_name /etc/group) -gt 0 ]; then
	echo "- Group $group_name already exists"
else
	sudo groupadd $group_name
	echo "- Added group: $group_name"
fi

# Add the user to the group
if [ $(groups $username | grep -c $group_name) -gt 0 ]; then
	echo "- User $username already belongs to group $group_name"
else
	sudo usermod -aG $group_name $username
	echo "- Added the user $username to $group_name group"
fi

#Display user info
echo ""
echo "User Info:"
echo -e "\tUsername          : $username    , UID: $(id -u $username)"
echo -e "\tPrimary Group     : $username    , GID: $(id -G $username | cut -d" " -f1)"
echo -e "\tSecondary Group(s): $(groups $username | cut -d" " -f4)\t, GID: $(id -G $username | cut -d" " -f2)"

#Display group info
echo ""
echo "Group Info:"
echo -e "\tGroup Name: $(getent group $group_name | cut -d":" -f1)"
echo -e "\tGID       : $(getent group $group_name | cut -d":" -f3)" 
echo -e "\tMember(s) : $(getent group $group_name | cut -d":" -f4)"


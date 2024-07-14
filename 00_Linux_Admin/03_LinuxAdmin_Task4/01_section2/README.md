# Linux Admin Task 4


### 1. Create a supplementary (Secondary) group called `pgroup` with group ID of 30000

To create a supplementary group called `pgroup` with a specific group ID (GID), you can use the `groupadd` command with the `-g` option to specify the GID:

```bash
sudo groupadd -g 30000 pgroup
```

### 2. Lock any user created account so they can't log in

To lock a user account and prevent them from logging in, you typically use the `usermod` command with the `-L` option:

```bash
sudo usermod -L username
```

Replace `username` with the actual username of the account you want to lock.

### 3. Delete a user account

To delete a user account, you use the `userdel` command:

```bash
sudo userdel username
```

Replace `username` with the username of the account you want to delete. Note that this command removes the user's home directory and mail spool (if they exist) unless you use the `-r` option to remove the home directory as well.

### 4. Delete a group account

To delete a group, you use the `groupdel` command:

```bash
sudo groupdel groupname
```

Replace `groupname` with the name of the group you want to delete.

### 5. Difference between `adduser` and `useradd` with examples

Both `adduser` and `useradd` are commands used for creating user accounts, but they have some differences in behavior:

- **`adduser`**: This is a higher-level utility that interactively prompts you for user details and creates a user account along with a home directory and sets up the environment. It manages the process of creating a user in a more user-friendly way, handling defaults and prompts.

  Example of using `adduser`:

  ```bash
  sudo adduser newuser
  ```

  This command will prompt you to enter details such as the password, full name, etc., and then create the user account.

- **`useradd`**: This command is a lower-level utility for adding users programmatically or in scripts. It requires more manual specification of options for creating the user and does not set up a home directory or default settings unless explicitly specified. It's more suitable for automated tasks or scenarios where you need precise control over user creation.

  Example of using `useradd`:

  ```bash
  sudo useradd -m -s /bin/bash newuser
  ```

  Here, `-m` creates the user's home directory, and `-s /bin/bash` sets the user's shell to `/bin/bash`. You would need additional commands to set the password and other details if required.

### Summary

- `adduser` is generally preferred for interactive use as it automates the creation process and sets up defaults.
- `useradd` is preferred for scripted or automated user creation where specific configurations need to be set explicitly.








    











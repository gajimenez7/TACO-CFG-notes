# Creating SSH Key

[Checking for SSH Key](https://docs.github.com/en/authentication/connecting-to-github-with-ssh/checking-for-existing-ssh-keys)
[Creating SSH Key](https://docs.github.com/en/authentication/connecting-to-github-with-ssh/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent)
[Adding Key to GitHub](https://docs.github.com/en/authentication/connecting-to-github-with-ssh/adding-a-new-ssh-key-to-your-github-account)

## Checking for SSH Key

1. Enter `ls -al ~/.ssh` to see if any keys are already present:
    - id_rsa.pub
    - id_ecdsa.pub
    - id_ed25519.pub
2. If none are present, generate a new key

## Generating SSH Key

1. Enter `ssh-keygen -t ed25519 -C "your_email@example.com"`
2. Press enter to save key in default file location when asked where to save
3. Enter passphrase/ password

## Adding SSH-Agent

1. Start agent:
   - `eval "$(ssh-agent -s)"`
   - ".ssh/config file will need to be modified:
     - `open ~/.ssh/config` to open config file
     - If it doesn't exist: `touch ~/.ssh/config`
     - Open the file and add:

        ``` Text
        Host github.com
        AddKeysToAgent yes
        UseKeyChain yes
        IdentityFile ~/.ssh/id_ed25519
        ``` (IgnoreUnknown UseKeychain)

## Add key to GitHub

1. Copy key: `pbcopy < ~/.ssh/id_ed25519.pub`
2. Go to GitHub and under settings, click "**Access**" and go to **SSH and GPG Keys**
3. Click "**New SSH Key**" or "**Add SSH Key**"
4. Enter title
5. Select **Authentication Keys**
6. Paste copied key in **Key field**
7. Add Key

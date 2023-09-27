# Git 

O Git é um sistema de controle de versão distribuído, usado para acompanhar as alterações no código-fonte durante o desenvolvimento de software. 

## Comandos Básicos do Git

### Configuração Inicial

- `git config --global user.name "Seu Nome"`: nome do user 
- `git config --global user.email "seuemail@example.com"`:  e-mail do user 

### Inicialização de um Repositório

- `git init`: Inicializa um novo repositório Git local.

### Commits

- `git add <arquivo>`: Adiciona alterações de arquivos ao staging area.
- `git add .`: Adiciona todas as alterações de arquivos ao staging area.
- `git commit -m "Mensagem do Commit"`: Cria um novo commit com as alterações no staging area.

### Status

- `git status`: Exibe o status atual do repositório.
- `git log`: Exibe o histórico de commits.
- `git diff`: Exibe as diferenças entre as alterações no working directory e o último commit.

### Ramificação 

- `git branch`: Lista todas as ramificações.
- `git branch <nome_da_ramificação>`: Cria uma nova ramificação.
- `git checkout <nome_da_ramificação>`: Altera para uma ramificação existente.
- `git merge <nome_da_ramificação>`: Mescla as alterações de uma ramificação em outra.
- `git branch -d <nome_da_ramificação>`: Exclui uma ramificação.

### Clone 

- `git clone <url_do_repositório>`: Clona um repositório Git remoto.
- `git pull`: Puxa as atualizações do repositório remoto.
- `git push`: Empurra os commits locais para o repositório remoto.

### Desfazendo Alterações

- `git reset HEAD <arquivo>`: Remove arquivos do staging area.
- `git checkout -- <arquivo>`: Desfaz as alterações não salvas em um arquivo no working directory.

### .gitignore

- Crie um arquivo chamado `.gitignore` e liste os arquivos ou diretórios a serem ignorados.

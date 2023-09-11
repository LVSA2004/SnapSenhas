# Gerador de Senhas Snap

API da aplicação de geração de senhas

## Endpoints

- Senhas
    - gerar senha
    - listar senha
- login
- perfil

### Gerar Senha

`POST`/snap/api/senhas

| campo | tipo | obrigatorio | descrição
|-------|------|:-------------:|-----
| senha | String | sim | os caracteres da senha
| data | data | sim | a data que a senha foi gerada
| senha_id | inteiro | sim | o id da senha gerada
| descrição | texto | não | um texto com detalhes sobre a senha
|categoria_id| inteiro| sim| o id de uma categoria previamente estabelecida

**Exemplo de corpo de requisição**
    
```js
{
    senha: '3Z@)_/H///$hF6',
    data: '2023-01-27',
    senha_id : 1,
    categoria_id: 1,
    conta_id : 1,
    descricao: 'senha do facebook'
}
```

**respostas**
|código | descrição
|- | -
|201 | senha cadastrada com sucesso
|400 |  a validação dos campos falhou

---
### Listar Senha

`POST`/gestanca/api/senha/{id}


|código | descrição
|- | -
|200 | as senhas foram exibidas
|404 | não existe senha com o id informado

**Exemplo de corpo de requisição**
```js
{
    senha : '3Z@)_/H///$hF6',
    data: '2023-01-27',
    categoria {
        senha_id : 1,
        senha_categoria: 'com caracteres especiais'
              },
        conta_id : 1,
    descricao: 'senha do facebook'
}
```
---

### Login
`POST`/gestanca/api/login

**Exemplo de corpo de requisição**


|código | descrição
|- | -
|200 | login feito com sucesso
|404 | não existe esta conta

```js
{
    Descricao: "Faça Login para Continuar"
    E-mail: "projetosnap@gmail.com",
    Senha: "2uyojux\QehiNMM2|[8g",
}
```

---
### Perfil

## Cadastro com Autenticação e Token ╹Usuário╷ **`/registrar`**:

#### POST ➡️

**Exemplo 👇**
```js
{
     "nome": "Luan Sá",
	 "telefone": "11 959540882",
	 "email": "lvss@gmail.com",
	 "login": "lvss",
	 "senha" : "02072004"
}
```
**Saída 👇**

|  | <font color="#aa31f5">código</font> | <font color="#e0af0d">descrição</font> |
|:------:|:------:|-----------|
✔️ | `201` | Usuário cadastrado com sucesso.
❌ | `403` | Não foi possível cadastrar o usuário.

### Login com validação de Token ╹Usuário╷ **`/login`**:

#### POST ➡️

**Exemplo 👇**
```js
{
	"email": "lvss@gmail.com",
	"senha": "02072004"
}
```

**Saída 👇**

|  | <font color="#aa31f5">código</font> | <font color="#e0af0d">descrição</font> |
|:------:|:------:|-----------|
| ✔️ | `201` | Login validado com sucesso.
| ❌ | `403` | Não foi possivel validar o login.

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

**Exemplo de corpo de requisição**


`POST`/gestanca/api/perfil

|código | descrição
|- | -
|200 | Perfil mostrado
|408 | não pode carregar o perfil


```js
{
    perfil_id: 1,
    Nome: "Henrique Freitas"1,
    E-mail: "projetosnap@gmail.com",
    Telefone: "(11)4002-8922",
}
```
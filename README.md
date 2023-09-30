
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

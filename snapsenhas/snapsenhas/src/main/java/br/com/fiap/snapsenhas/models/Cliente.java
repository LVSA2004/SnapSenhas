package br.com.fiap.snapsenhas.models;

public class Cliente {
    private String Nome_Cliente;
    private String Telefone_Cliente;
    private String Email_cliente;
    private String Login_Cliente;
    private String Senha_Cliente;

    public Cliente(String nome_Cliente, String telefone_Cliente, String email_cliente, String login_Cliente,
            String senha_Cliente) {
        Nome_Cliente = nome_Cliente;
        Telefone_Cliente = telefone_Cliente;
        Email_cliente = email_cliente;
        Login_Cliente = login_Cliente;
        Senha_Cliente = senha_Cliente;
    }

    public String getNome_Cliente() {
        return Nome_Cliente;
    }
    public void setNome_Cliente(String nome_Cliente) {
        Nome_Cliente = nome_Cliente;
    }
    public String getTelefone_Cliente() {
        return Telefone_Cliente;
    }
    public void setTelefone_Cliente(String telefone_Cliente) {
        Telefone_Cliente = telefone_Cliente;
    }
    public String getEmail_cliente() {
        return Email_cliente;
    }
    public void setEmail_cliente(String email_cliente) {
        Email_cliente = email_cliente;
    }
    public String getLogin_Cliente() {
        return Login_Cliente;
    }
    public void setLogin_Cliente(String login_Cliente) {
        Login_Cliente = login_Cliente;
    }
    public String getSenha_Cliente() {
        return Senha_Cliente;
    }
    public void setSenha_Cliente(String senha_Cliente) {
        Senha_Cliente = senha_Cliente;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((Nome_Cliente == null) ? 0 : Nome_Cliente.hashCode());
        result = prime * result + ((Telefone_Cliente == null) ? 0 : Telefone_Cliente.hashCode());
        result = prime * result + ((Email_cliente == null) ? 0 : Email_cliente.hashCode());
        result = prime * result + ((Login_Cliente == null) ? 0 : Login_Cliente.hashCode());
        result = prime * result + ((Senha_Cliente == null) ? 0 : Senha_Cliente.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (Nome_Cliente == null) {
            if (other.Nome_Cliente != null)
                return false;
        } else if (!Nome_Cliente.equals(other.Nome_Cliente))
            return false;
        if (Telefone_Cliente == null) {
            if (other.Telefone_Cliente != null)
                return false;
        } else if (!Telefone_Cliente.equals(other.Telefone_Cliente))
            return false;
        if (Email_cliente == null) {
            if (other.Email_cliente != null)
                return false;
        } else if (!Email_cliente.equals(other.Email_cliente))
            return false;
        if (Login_Cliente == null) {
            if (other.Login_Cliente != null)
                return false;
        } else if (!Login_Cliente.equals(other.Login_Cliente))
            return false;
        if (Senha_Cliente == null) {
            if (other.Senha_Cliente != null)
                return false;
        } else if (!Senha_Cliente.equals(other.Senha_Cliente))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cliente [Nome_Cliente=" + Nome_Cliente + ", Telefone_Cliente=" + Telefone_Cliente + ", Email_cliente="
                + Email_cliente + ", Login_Cliente=" + Login_Cliente + ", Senha_Cliente=" + Senha_Cliente + "]";
    }
}

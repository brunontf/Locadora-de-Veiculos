package model;

public class PessoaJuridica extends Pessoa {

    private Integer cnpj;
    
    public PessoaJuridica(String nome, String telefone, Integer cnpj){
        super(nome, telefone);
        this.cnpj = cnpj;
    }

    public Integer getCnpj() {
        return cnpj;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
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
        PessoaJuridica other = (PessoaJuridica) obj;
        if (cnpj == null) {
            if (other.cnpj != null)
                return false;
        } else if (!cnpj.equals(other.cnpj))
            return false;
        return true;
    }

    
}

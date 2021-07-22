package br.com.udemy.springbootionicbackend.domain.enums;

public enum TipoCliente {

    PESSOA_FISICA(1, "Pessoa Fisica"),
    PESSOA_JURIDICA(2, "Pessoa Juridica");

    private int cod;
    private String desc;

    TipoCliente(int cod, String desc) {
        this.cod = cod;
        this.desc = desc;
    }

    public int getCod(){
        return cod;
    }

    public String getDesc(){
        return desc;
    }

    public static Object toEnum(Integer cod){
        if (cod == null){
            return null;
        }

        for (TipoCliente tipoCliente: TipoCliente.values()){
            if (cod.equals(tipoCliente.getCod())){
                return tipoCliente;
            }
        }

        return new IllegalArgumentException("Id invalido: "+cod);
    }
}

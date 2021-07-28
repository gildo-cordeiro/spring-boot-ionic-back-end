package br.com.udemy.springbootionicbackend.domain.enums;

public enum EstadoPagamento {

    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3,"Cancelado");

    private int cod;
    private String desc;

    EstadoPagamento(int cod, String desc) {
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

        for (EstadoPagamento estadoPagamento: EstadoPagamento.values()){
            if (cod.equals(estadoPagamento.getCod())){
                return estadoPagamento;
            }
        }

        return new IllegalArgumentException("Id invalido: "+cod);
    }
}
